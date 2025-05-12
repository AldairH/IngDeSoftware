package mx.unam.aragon.ico.is.computadoraapi.controllers;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;
import mx.unam.aragon.ico.is.computadoraapi.services.interfaces.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/computadoras")
public class ComputadoraController {

    @Autowired
    private ComputadoraService computadoraService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Computadora>> getComputadoras() {
        // return computadoraService.listarTodas();
        // return new ResponseEntity<>(computadoraService.listarTodas(), HttpStatus.OK);
        return ResponseEntity.ok(computadoraService.listarTodas());
    }

    @PostMapping("/")
    public ResponseEntity<Computadora> createComputadora(@RequestBody Computadora computadora) throws URISyntaxException {
        //return computadoraService.crear(computadora);
        return ResponseEntity.created(new URI("http://localhost:8081")).body(computadoraService.crear(computadora));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computadora> getComputadora(@PathVariable Long id) {
        //return computadoraService.buscarPorId(Math.toIntExact(id)).orElse(null);
        return ResponseEntity.ok(computadoraService.buscarPorId(Math.toIntExact(id)).orElse(null));
    }
}