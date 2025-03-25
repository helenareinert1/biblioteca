package com.biblioteca.repositories;

import com.biblioteca.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Cidade findByEstado(String estado);

    Cidade findByNome(String nome);
}

