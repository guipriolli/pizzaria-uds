package br.com.uds.pizzaria.service.impl;

import br.com.uds.pizzaria.model.Tamanho;
import br.com.uds.pizzaria.repository.TamanhoRepository;
import br.com.uds.pizzaria.service.TamanhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tamanhoService")
public class TamanhoServiceImpl implements TamanhoService {

    @Autowired
    TamanhoRepository tamanhoRepository;

    @Override
    public Tamanho findByDescricao(String descricao) {
        return tamanhoRepository.findTamanhoByDescricao(descricao);
    }
}
