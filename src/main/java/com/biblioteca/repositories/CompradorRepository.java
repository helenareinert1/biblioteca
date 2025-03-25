package com.biblioteca.repositories;


import com.biblioteca.models.Cidade;
import com.biblioteca.models.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {
    Comprador findByEmail(String email);
    Comprador findByNome(String nome);
}