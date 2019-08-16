package br.com.uds.pizzaria.service.impl;

import br.com.uds.pizzaria.model.Pedido;
import br.com.uds.pizzaria.model.Sabor;
import br.com.uds.pizzaria.model.Tamanho;
import br.com.uds.pizzaria.repository.PedidoRepository;
import br.com.uds.pizzaria.service.PedidoService;
import br.com.uds.pizzaria.service.SaborService;
import br.com.uds.pizzaria.service.TamanhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    TamanhoService tamanhoService;

    @Autowired
    SaborService saborService;

    @Override
    public Pedido montaPizza(Pedido pedido) {

        Double valor = 0.0;
        Integer tempo = 0;

        Tamanho tamanho = tamanhoService.findByDescricao(pedido.getTamanho());

        valor += tamanho.getValor();
        tempo += tamanho.getTempo();

        Sabor sabor = saborService.findByDescricao(pedido.getSabor());

        tempo += sabor.getTempo();

        pedido.setValor(valor);
        pedido.setTempo(tempo);

        pedido = pedidoRepository.save(pedido);

        return pedido;
    }

    @Override
    public Pedido personalizaPizza(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido montaPedido() {
        return null;
    }

    @Override
    public Pedido findById(Long id) {
        return null;
    }
}
