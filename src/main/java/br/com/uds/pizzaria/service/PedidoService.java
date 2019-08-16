package br.com.uds.pizzaria.service;

import br.com.uds.pizzaria.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido montaPizza(String tamanho, String sabor);

    Pedido personalizaPizza(Long id, List<String> adicionais);

    Pedido montaPedido(Long id);
}
