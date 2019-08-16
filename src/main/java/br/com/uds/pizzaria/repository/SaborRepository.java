package br.com.uds.pizzaria.repository;

import br.com.uds.pizzaria.model.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaborRepository extends JpaRepository<Sabor, Long> {

    Sabor findSaborByDescricao(String descricao);
}
