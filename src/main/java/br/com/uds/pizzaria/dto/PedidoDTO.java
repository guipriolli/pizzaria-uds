package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {

    private PizzaDTO pizza;
    private List<AdicionalDTO> adicionais = new ArrayList<>();
    private Integer tempo;
    private Double valor;

    public PedidoDTO(Pedido pedido) {
        this.pizza = new PizzaDTO(pedido.getTamanho(), pedido.getSabor());
        this.tempo = pedido.getTempo();
        this.valor = pedido.getValor();
        if (pedido.getAdicionais() != null)
            this.adicionais.addAll(pedido.getAdicionais().stream().map(AdicionalDTO::new).collect(Collectors.toList()));
    }

    public PizzaDTO getPizza() {
        return pizza;
    }

    public void setPizza(PizzaDTO pizza) {
        this.pizza = pizza;
    }

    public List<AdicionalDTO> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<AdicionalDTO> adicionais) {
        this.adicionais = adicionais;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
