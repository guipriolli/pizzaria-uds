package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.model.Adicional;

public class AdicionalDTO {

    private String descricao;
    private Double valor;

    public AdicionalDTO(Adicional adicional) {
        this.descricao = adicional.getDescricao();
        this.valor = adicional.getValor();
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
