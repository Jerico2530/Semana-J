
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
        Categoria categoria1 = new Categoria("Instrumentos ");

        categoriaRepository.save(categoria1);

        Instrumento instrumento1 = new Instrumento("Guitarra", categoria1);

        
        instrumentoRepository.save(instrumento1);
	}
}