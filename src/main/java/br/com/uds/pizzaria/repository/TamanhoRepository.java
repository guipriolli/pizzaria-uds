package br.com.uds.pizzaria.repository;

import br.com.uds.pizzaria.model.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {

    Tamanho findTamanhoByDescricao(String descricao);
}
