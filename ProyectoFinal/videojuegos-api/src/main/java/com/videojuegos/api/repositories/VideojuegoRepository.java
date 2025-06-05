package com.videojuegos.api.repositories;

import com.videojuegos.api.entities.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
    Optional<Videojuego> findById(Integer id);
    void deleteById(Integer id);
}