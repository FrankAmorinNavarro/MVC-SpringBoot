package com.lta.sistemaencuestas.services;

import com.lta.sistemaencuestas.model.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    Pregunta agregarPreguntaAEncuesta(Long encuestaId,String contenido);

    List<Pregunta> obtenerPreguntasPorEncuesta(Long encuestaId);

    Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId);

    Pregunta actualizarPregunta(Long preguntaId,String nuevoContenido,Long encuestaId);

    void eliminarPregunta(Long preguntaId);

}
