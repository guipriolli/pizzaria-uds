package br.com.uds.pizzaria.repository;

import br.com.uds.pizzaria.model.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdicionaisRepository extends JpaRepository<Adicional, Long> {

    Adicional findAdicionaisByDescricao(String descricao);
}
