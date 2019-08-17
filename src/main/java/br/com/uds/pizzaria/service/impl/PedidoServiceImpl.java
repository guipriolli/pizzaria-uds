package br.com.uds.pizzaria.service.impl;

import br.com.uds.pizzaria.model.Adicional;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    @Transactional
    public Pedido montaPizza(String tamanho, String sabor) {

        Double valor = 0.0;
        Integer tempo = 0;

        Tamanho tamanhoObj = tamanhoService.findByDescricao(tamanho);

        if (tamanhoObj == null) {
            throw new RuntimeException("Tamanho não encontrado.");
        }

        valor += tamanhoObj.getValor();
        tempo += tamanhoObj.getTempo();

        Sabor saborObj = saborService.findByDescricao(sabor);

        if (saborObj == null) {
            throw new RuntimeException("Sabor não encontrado.");
        }

        tempo += saborObj.getTempo();

        Pedido pedido = new Pedido();
        pedido.setTamanho(tamanhoObj);
        pedido.setSabor(saborObj);
        pedido.setValor(valor);
        pedido.setTempo(tempo);

        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public Pedido personalizaPizza(Long id, List<String> adicionais) {

        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

        if (!optionalPedido.isPresent()) {
            throw new RuntimeException("Pedido não encotrado.");
        }

        Pedido pedido = optionalPedido.get();

        Double valor = pedido.getValor();
        Integer tempo = pedido.getTempo();
        Set<Adicional> adicionaisSet = new HashSet<>();

        for (String adicional : adicionais) {
            Adicional adicionalObj = adicionaisService.findByDescricao(adicional);

            if (adicionalObj == null) {
                throw new RuntimeException("Sabor não encontrado.");
            }

            valor += adicionalObj.getValor();
            tempo += adicionalObj.getTempo();
            adicionaisSet.add(adicionalObj);
        }

        pedido.setValor(valor);
        pedido.setTempo(tempo);
        pedido.setAdicionais(adicionaisSet);

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido montaPedido(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

        if (!optionalPedido.isPresent()) {
            throw new RuntimeException("Pedido não encotrado.");
        }

        return optionalPedido.get();
    }
}
