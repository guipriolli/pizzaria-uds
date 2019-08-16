package br.com.uds.pizzaria.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PizzaForm {

    @NotNull
    @NotEmpty
    private String tamanho;

    @NotNull
    @NotEmpty
    private String sabor;

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
}
