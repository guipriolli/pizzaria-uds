package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {

    private TamanhoDTO tamanho;
    private String sabor;
    private List<AdicionalDTO> adicionais;
    private Double valor;
    private Integer tempo;

    public PedidoDTO(Pedido pedido) {
        this.tamanho = new TamanhoDTO(pedido.getTamanho());
        this.sabor = pedido.getSabor().getDescricao();
        this.valor = pedido.getValor();
        this.tempo = pedido.getTempo();
        if (pedido.getAdicionais() != null)
            this.adicionais.addAll(pedido.getAdicionais().stream().map(AdicionalDTO::new).collect(Collectors.toList()));
        else
            this.adicionais = new ArrayList<>();
    }

    public TamanhoDTO getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoDTO tamanho) {
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public List<AdicionalDTO> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<AdicionalDTO> adicionais) {
        this.adicionais = adicionais;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }
}
