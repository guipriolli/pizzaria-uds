package br.com.uds.pizzaria.service.impl;

import br.com.uds.pizzaria.model.Sabor;
import br.com.uds.pizzaria.repository.SaborRepository;
import br.com.uds.pizzaria.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("saborService")
public class SaborServiceImpl implements SaborService {

    @Autowired
    SaborRepository saborRepository;

    @Override
    public Sabor findByDescricao(String descricao) {
        return saborRepository.findSaborByDescricao(descricao);
    }
}
