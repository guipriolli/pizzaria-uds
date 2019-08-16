package br.com.uds.pizzaria.rest;

import br.com.uds.pizzaria.dto.PedidoDTO;
import br.com.uds.pizzaria.form.AdicionaisForm;
import br.com.uds.pizzaria.form.PizzaForm;
import br.com.uds.pizzaria.model.Pedido;
import br.com.uds.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class PedidoREST {

    @Autowired
    PedidoService pedidoService;

    @PostMapping(path = "/montar-pizza")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PedidoDTO> montarPizza(@RequestBody @Valid PizzaForm pizza, UriComponentsBuilder uriBuilder) {
        Pedido pedido = pedidoService.montaPizza(pizza.getTamanho(), pizza.getSabor());
        URI uri = uriBuilder.path("/api/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
    }

    @PutMapping(path = "/personalizar-pizza/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PedidoDTO> personalizarPizza(@PathVariable Long id, @RequestBody AdicionaisForm adicionais) {
        Pedido pedido = pedidoService.personalizaPizza(id, adicionais.getAdicionais());
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }

    @GetMapping(path = "/pedido/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PedidoDTO> montarPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.montaPedido(id);
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }
}
