package br.com.uds.pizzaria.service;

import br.com.uds.pizzaria.model.Tamanho;

public interface TamanhoService {

    Tamanho findByDescricao(String descricao);
}
