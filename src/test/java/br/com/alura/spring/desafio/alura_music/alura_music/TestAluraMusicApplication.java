package br.com.alura.spring.desafio.alura_music.alura_music;

import org.springframework.boot.SpringApplication;

public class TestAluraMusicApplication {

	public static void main(String[] args) {
		SpringApplication.from(AluraMusicApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
