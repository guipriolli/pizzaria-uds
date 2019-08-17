package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.model.Sabor;
import br.com.uds.pizzaria.model.Tamanho;

public class PizzaDTO {

    private String tamanho;
    private String sabor;
    private Double valor;

    public PizzaDTO(Tamanho tamanho, Sabor sabor) {
        this.tamanho = tamanho.getDescricao();
        this.sabor = sabor.getDescricao();
        this.valor = tamanho.getValor();
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
