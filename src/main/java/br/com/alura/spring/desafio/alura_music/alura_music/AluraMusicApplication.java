package br.com.alura.spring.desafio.alura_music.alura_music;

import br.com.alura.spring.desafio.alura_music.alura_music.main.Principal;
import br.com.alura.spring.desafio.alura_music.alura_music.services.ArtistaService;
import br.com.alura.spring.desafio.alura_music.alura_music.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistaService artistaService;

	@Autowired
	private MusicaService musicaService;

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistaService, musicaService);
		principal.exibeMenu();
	}
}
