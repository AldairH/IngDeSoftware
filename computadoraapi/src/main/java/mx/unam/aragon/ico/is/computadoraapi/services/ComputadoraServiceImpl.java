package mx.unam.aragon.ico.is.computadoraapi.services;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;
import mx.unam.aragon.ico.is.computadoraapi.repositories.ComputadoraRepository;
import mx.unam.aragon.ico.is.computadoraapi.services.interfaces.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputadoraServiceImpl implements ComputadoraService {
    @Autowired
    private ComputadoraRepository computadoraRepository;

    @Override
    public Computadora crear(Computadora computadora) {
        return computadoraRepository.save(computadora);
    }

    @Override
    public Iterable<Computadora> listarTodas() {
        return computadoraRepository.findAll();
    }

    @Override
    public Optional<Computadora> buscarPorId(int clave) {
        return computadoraRepository.findById(clave);
    }

    @Override
    public Computadora actualizar(Long clave, Computadora computadora) {
        Optional<Computadora> computadoraActual = computadoraRepository.findById(Math.toIntExact(clave));
        if (computadoraActual.isPresent()) {
            Computadora tmp = computadoraActual.get();
            tmp.setModelo(computadora.getModelo());
            tmp.setClave(Math.toIntExact(clave));
            tmp.setFoto(computadora.getFoto());
            tmp.setMarca(computadora.getMarca());
            tmp.setPrecio(computadora.getPrecio());
            return computadoraRepository.save(tmp);
        }else{
            return null;
        }
    }

    @Override
    public Computadora eliminar(Long clave) {
        return computadoraRepository.deleteByClave(clave);
    }
}
