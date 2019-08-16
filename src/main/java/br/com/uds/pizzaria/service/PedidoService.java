package br.com.uds.pizzaria.service;

import br.com.uds.pizzaria.model.Pedido;

public interface PedidoService {

    Pedido montaPizza(Pedido pedido);

    Pedido personalizaPizza(Pedido pedido);

    Pedido montaPedido();

    Pedido findById(Long id);
}
