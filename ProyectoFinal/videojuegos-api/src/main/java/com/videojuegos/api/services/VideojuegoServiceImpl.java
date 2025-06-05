package com.videojuegos.api.services;

import com.videojuegos.api.entities.Videojuego;
import com.videojuegos.api.repositories.VideojuegoRepository;
import com.videojuegos.api.services.interfaces.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Override
    public Videojuego crear(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    @Override
    public Iterable<Videojuego> listarTodos() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Optional<Videojuego> buscarPorId(Integer id) {
        return videojuegoRepository.findById(id);
    }

    @Override
    public Videojuego actualizar(Integer id, Videojuego videojuego) {
        Optional<Videojuego> videojuegoActual = videojuegoRepository.findById(id);
        if (videojuegoActual.isPresent()) {
            Videojuego tmp = videojuegoActual.get();
            tmp.setId(id);
            tmp.setTitulo(videojuego.getTitulo());
            tmp.setGenero(videojuego.getGenero());
            tmp.setPlataforma(videojuego.getPlataforma());
            tmp.setDesarrollador(videojuego.getDesarrollador());
            tmp.setFechaLanzamiento(videojuego.getFechaLanzamiento());
            tmp.setPrecio(videojuego.getPrecio());
            tmp.setClasificacion(videojuego.getClasificacion());
            tmp.setDescripcion(videojuego.getDescripcion());
            tmp.setUrlPortada(videojuego.getUrlPortada());
            return videojuegoRepository.save(tmp);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        videojuegoRepository.deleteById(id);
    }
}