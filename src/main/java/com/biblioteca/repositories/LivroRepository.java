package com.biblioteca.repositories;

import com.biblioteca.models.Cidade;
import com.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Livro findByNome(String nome);
}

