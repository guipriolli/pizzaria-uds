package br.com.uds.pizzaria.rest;

import br.com.uds.pizzaria.model.Pedido;
import br.com.uds.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class PedidoREST {

    @Autowired
    PedidoService pedidoService;

    @PostMapping(path = "/montar-pizza")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido montarPizza(@RequestBody Map<String, String> pizza) {

        String tamanho = pizza.get("tamanho");
        String sabor = pizza.get("sabor");

        return pedidoService.montaPizza(tamanho, sabor);
    }

    @PutMapping(path = "/personalizar-pizza/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido personalizarPizza(@PathVariable Long id, @RequestBody Map<String, List<String>> adicionais) {

        List<String> adicionaisList = adicionais.get("adicionais");

        return pedidoService.personalizaPizza(id, adicionaisList);
    }

    @GetMapping(path = "/montar-pedido/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido montarPedido(@PathVariable Long id) {
        return pedidoService.montaPedido(id);
    }
}
