package com.biblioteca.repositories;

import com.biblioteca.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface  ReservaRepository extends JpaRepository<Reserva, Long> {
        Reserva findByDescricao(String descricao);
}
