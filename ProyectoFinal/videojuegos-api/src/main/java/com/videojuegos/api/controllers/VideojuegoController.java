package com.videojuegos.api.controllers;

import jakarta.validation.Valid;
import com.videojuegos.api.entities.Videojuego;
import com.videojuegos.api.services.interfaces.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Videojuego>> getVideojuegos() {
        return ResponseEntity.ok(videojuegoService.listarTodos());
    }

    @PostMapping("/")
    public ResponseEntity<Videojuego> createVideojuego(@Valid @RequestBody Videojuego videojuego) throws URISyntaxException {
        return ResponseEntity.created(new URI("http://localhost:8080")).body(videojuegoService.crear(videojuego));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> getVideojuego(@PathVariable Integer id) {
        return ResponseEntity.ok(videojuegoService.buscarPorId(id).orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> updateVideojuego(@PathVariable Integer id, @RequestBody Videojuego videojuego) {
        return ResponseEntity.ok(videojuegoService.actualizar(id, videojuego));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Videojuego> patchVideojuego(@PathVariable Integer id, @RequestBody Videojuego videojuego) {
        Optional<Videojuego> tmp = videojuegoService.buscarPorId(id);
        if (tmp.isPresent()) {
            Videojuego actual = tmp.get();
            if (videojuego.getTitulo() != null) actual.setTitulo(videojuego.getTitulo());
            if (videojuego.getGenero() != null) actual.setGenero(videojuego.getGenero());
            if (videojuego.getPlataforma() != null) actual.setPlataforma(videojuego.getPlataforma());
            if (videojuego.getDesarrollador() != null) actual.setDesarrollador(videojuego.getDesarrollador());
            if (videojuego.getFechaLanzamiento() != null) actual.setFechaLanzamiento(videojuego.getFechaLanzamiento());
            if (videojuego.getPrecio() != null) actual.setPrecio(videojuego.getPrecio());
            if (videojuego.getClasificacion() != null) actual.setClasificacion(videojuego.getClasificacion());
            if (videojuego.getDescripcion() != null) actual.setDescripcion(videojuego.getDescripcion());
            if (videojuego.getUrlPortada() != null) actual.setUrlPortada(videojuego.getUrlPortada());
            return ResponseEntity.ok(videojuegoService.actualizar(id, actual));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteVideojuego(@PathVariable Integer id) {
        videojuegoService.eliminar(id);
    }
}