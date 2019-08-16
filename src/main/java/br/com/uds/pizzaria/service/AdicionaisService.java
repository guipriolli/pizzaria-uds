package br.com.uds.pizzaria.service;

import br.com.uds.pizzaria.model.Adicionais;

public interface AdicionaisService {

    Adicionais findByDescricao(String descricao);
}
