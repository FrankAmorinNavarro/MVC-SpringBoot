package com.lta.sistemaencuestas.repository;

import com.lta.sistemaencuestas.model.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta,Long> {
}
