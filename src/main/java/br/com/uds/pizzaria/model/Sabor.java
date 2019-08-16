package br.com.uds.pizzaria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sabor")
public class Sabor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descricao;

    @Column(nullable = false)
    private Integer tempo;

    @OneToMany(mappedBy = "sabor")
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

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return String.format("Sabor [id=%d, descricao='%s', tempo=%d]", id, descricao, tempo);
    }
}
