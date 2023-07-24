
package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final CategoriaRepository categoriaRepository;
	private final InstrumentoRepository instrumentoRepository;

	@Autowired
	public DatabaseLoader(CategoriaRepository categoriaRepository,InstrumentoRepository instrumentoRepository ) {
		this.instrumentoRepository = instrumentoRepository;
        this.categoriaRepository = categoriaRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear categorías
        Categoria categoria1 = new Categoria("Instrumentos de Viento");

        // Guardar las categorías en la base de datos
        categoriaRepository.save(categoria1);

        // Crear instrumentos y asignarles una categoría
        Instrumento instrumento1 = new Instrumento("Flauta", categoria1);

        // Guardar los instrumentos en la base de datos
        instrumentoRepository.save(instrumento1);
	}
}