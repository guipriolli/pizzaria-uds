package br.com.uds.pizzaria.model;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho;
    private String sabor;
    private String adicionais;
    private Double valor;
    private Integer tempo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
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

    @Override
    public String toString() {
        return String.format("Adicionais [id=%d, tamanho='%s', sabor='%s', adicionais='%s', valor=%d, tempo=%d]", id, tamanho, sabor, adicionais, valor, tempo);
    }
}
