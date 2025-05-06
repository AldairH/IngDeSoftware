package mx.unam.aragon.ico.is.computadoraapi;
import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;
import mx.unam.aragon.ico.is.computadoraapi.repositories.ComputadoraRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputadoraapiApplicationTests {
	private ComputadoraRepository computadora;
    @Autowired
    private ComputadoraRepository computadoraRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void insertarComputadora() {
		Computadora computadora = new Computadora(0, "HP", "Pavillion", null, "13000");
		computadoraRepository.save(computadora);
	}

	@Test
	public void leerComputadora() {
		Long claveTemp = 2l;
		Computadora tmp = computadoraRepository.findComputadoraByClave(claveTemp);
		System.out.println(tmp);
	}

	@Test
	public void eliminarComputadora() {
		int claveTemp = 2;
		computadoraRepository.deleteById(claveTemp);
	}

	@Test
	public void actualizarComputadora() {
		Long claveTemp = 3l;
		Computadora tmp = computadoraRepository.findComputadoraByClave(claveTemp);
		tmp.setModelo("Pavillion25");
		computadoraRepository.save(tmp);
	}
}
