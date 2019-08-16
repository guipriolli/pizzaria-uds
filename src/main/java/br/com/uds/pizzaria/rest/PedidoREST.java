package br.com.uds.pizzaria.rest;

import br.com.uds.pizzaria.model.Pedido;
import br.com.uds.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PedidoREST {

    @Autowired
    PedidoService pedidoService;

    @PostMapping(path = "/montar-pizza")
    @ResponseStatus(HttpStatus.OK)
    public Pedido montarPizza(@RequestBody Pedido pedido) {
        pedido = pedidoService.montaPizza(pedido);
        return pedido;
    }


}
