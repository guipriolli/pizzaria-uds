package br.com.uds.pizzaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tamanho", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tamanho tamanho;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sabor", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sabor sabor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_adicionais", joinColumns = @JoinColumn(name = "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_adicional"))
    private Set<Adicional> adicionais;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer tempo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Set<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(Set<Adicional> adicionais) {
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
        return String.format("Pedido [id=%d, tamanho='%s', sabor='%s', adicionais='%s', valor=%.2f, tempo=%d]", id, tamanho, sabor, adicionais, valor, tempo);
    }
}
