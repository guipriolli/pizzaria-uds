package br.com.uds.pizzaria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tamanho")
public class Tamanho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer tempo;

    @OneToMany(mappedBy = "tamanho")
    private List<Pedido> pedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return String.format("Tamanho [id=%d, descricao='%s', valor=%.2f, tempo=%d]", id, descricao, valor, tempo);
    }
}
