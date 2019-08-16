package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.model.Tamanho;

public class TamanhoDTO {

    private String descricao;
    private Double valor;

    public TamanhoDTO(Tamanho tamanho) {
        this.descricao = tamanho.getDescricao();
        this.valor = tamanho.getValor();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
