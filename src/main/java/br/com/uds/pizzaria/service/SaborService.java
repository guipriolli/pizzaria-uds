package br.com.uds.pizzaria.service;

import br.com.uds.pizzaria.model.Sabor;

public interface SaborService {

    Sabor findByDescricao(String descricao);
}
