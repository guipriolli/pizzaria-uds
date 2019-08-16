package br.com.uds.pizzaria.service;

import br.com.uds.pizzaria.model.Adicional;

public interface AdicionaisService {

    Adicional findByDescricao(String descricao);
}
