package br.com.uds.pizzaria.service.impl;

import br.com.uds.pizzaria.model.Adicional;
import br.com.uds.pizzaria.repository.AdicionaisRepository;
import br.com.uds.pizzaria.service.AdicionaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adicionaisService")
public class AdicionaisServiceImpl implements AdicionaisService {

    @Autowired
    AdicionaisRepository adicionaisRepository;

    @Override
    public Adicional findByDescricao(String descricao) {
        return adicionaisRepository.findAdicionaisByDescricao(descricao);
    }
}
