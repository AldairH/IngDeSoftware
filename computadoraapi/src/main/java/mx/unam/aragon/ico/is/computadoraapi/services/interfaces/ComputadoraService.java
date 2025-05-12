package mx.unam.aragon.ico.is.computadoraapi.services.interfaces;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;

import java.util.Optional;

public interface ComputadoraService {
    public abstract Computadora crear(Computadora computadora);
    public abstract Iterable<Computadora> listarTodas();
    public abstract Optional<Computadora> buscarPorId(int clave);
    public abstract Computadora actualizar(Long clave, Computadora computadora);
    public abstract Computadora eliminar(Long clave);
}
