package com.videojuegos.api.services.interfaces;

import com.videojuegos.api.entities.Videojuego;

import java.util.Optional;

public interface VideojuegoService {
    Videojuego crear(Videojuego videojuego);
    Iterable<Videojuego> listarTodos();
    Optional<Videojuego> buscarPorId(Integer id);
    Videojuego actualizar(Integer id, Videojuego videojuego);
    void eliminar(Integer id);
}