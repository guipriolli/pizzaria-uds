package br.com.uds.pizzaria.test;

import br.com.uds.pizzaria.dto.PedidoDTO;
import br.com.uds.pizzaria.form.AdicionaisForm;
import br.com.uds.pizzaria.form.PizzaForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ApplicationTest {

    @Autowired
    MockMvc mockMvc;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    @Test
    public void testeSuccesso() throws Exception {

        PizzaForm pizzaForm = new PizzaForm();
        pizzaForm.setTamanho("pequena");
        pizzaForm.setSabor("calabresa");

        String requestJson = mapToJson(pizzaForm);

        mockMvc.perform(
                post("/api/montar-pizza")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().is2xxSuccessful());

        AdicionaisForm adicionaisForm = new AdicionaisForm();
        adicionaisForm.setAdicionais(Arrays.asList("extra bacon", "borda recheada"));

        requestJson = mapToJson(adicionaisForm);

        mockMvc.perform(
                put("/api/personalizar-pizza/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().isOk());

        MvcResult mvcResult = mockMvc.perform(
                get("/api/pedido/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String jsonString = mvcResult.getResponse().getContentAsString();
        PedidoDTO pedidoDTO = mapFromJson(jsonString, PedidoDTO.class);

        Assert.assertTrue(pedidoDTO.getAdicionais().size() == 2);
        Assert.assertEquals("extra bacon", pedidoDTO.getAdicionais().get(0).getDescricao());
        Assert.assertEquals("borda recheada", pedidoDTO.getAdicionais().get(1).getDescricao());
        Assert.assertTrue(pedidoDTO.getValor() == 28.0);
        Assert.assertTrue(pedidoDTO.getTempo() == 20);
    }

    @Test
    public void testeErroTamanho() throws Exception {
        PizzaForm pizzaForm = new PizzaForm();
        pizzaForm.setTamanho("gigante");
        pizzaForm.setSabor("calabresa");

        String requestJson = mapToJson(pizzaForm);

        mockMvc.perform(
                post("/api/montar-pizza")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void testeErroSabor() throws Exception {
        PizzaForm pizzaForm = new PizzaForm();
        pizzaForm.setTamanho("grande");
        pizzaForm.setSabor("frango");

        String requestJson = mapToJson(pizzaForm);

        mockMvc.perform(
                post("/api/montar-pizza")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void testeErroAdicionais() throws Exception {
        AdicionaisForm adicionaisForm = new AdicionaisForm();
        adicionaisForm.setAdicionais(Arrays.asList("catupiry"));

        String requestJson = mapToJson(adicionaisForm);

        mockMvc.perform(
                put("/api/personalizar-pizza/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void testeErroNaoEncontrado() throws Exception {
        mockMvc.perform(
                get("/api/pedido/{id}", 9)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().is4xxClientError());
    }
}
