package br.com.uds.pizzaria.service.impl;

import br.com.uds.pizzaria.model.Adicionais;
import br.com.uds.pizzaria.model.Pedido;
import br.com.uds.pizzaria.model.Sabor;
import br.com.uds.pizzaria.model.Tamanho;
import br.com.uds.pizzaria.repository.PedidoRepository;
import br.com.uds.pizzaria.service.AdicionaisService;
import br.com.uds.pizzaria.service.PedidoService;
import br.com.uds.pizzaria.service.SaborService;
import br.com.uds.pizzaria.service.TamanhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    TamanhoService tamanhoService;

    @Autowired
    SaborService saborService;

    @Autowired
    AdicionaisService adicionaisService;

    @Override
    public Pedido montaPizza(String tamanho, String sabor) {

        Double valor = 0.0;
        Integer tempo = 0;

        Tamanho tamanhoObj = tamanhoService.findByDescricao(tamanho);

        valor += tamanhoObj.getValor();
        tempo += tamanhoObj.getTempo();

        Sabor saborObj = saborService.findByDescricao(sabor);

        tempo += saborObj.getTempo();

        Pedido pedido = new Pedido();
        pedido.setTamanho(tamanho);
        pedido.setSabor(sabor);
        pedido.setValor(valor);
        pedido.setTempo(tempo);

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido personalizaPizza(Long id, List<String> adicionais) {

        Pedido pedido = pedidoRepository.findById(id).get();

        Double valor = pedido.getValor();
        Integer tempo = pedido.getTempo();
        String adicionaisStr = "";

        for (String adicional : adicionais) {
            Adicionais adicionalObj = adicionaisService.findByDescricao(adicional);
            valor += adicionalObj.getValor();
            tempo += adicionalObj.getTempo();
            adicionaisStr += adicional + ", ";
        }

        int length = adicionaisStr.length();
        if (length > 2) {
            adicionaisStr = adicionaisStr.substring(0, length - 2);
        }

        pedido.setValor(valor);
        pedido.setTempo(tempo);
        pedido.setAdicionais(adicionaisStr);

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido montaPedido(Long id) {
        return pedidoRepository.findById(id).get();
    }
}
