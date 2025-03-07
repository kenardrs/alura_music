package br.com.alura.spring.desafio.alura_music.alura_music;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AluraMusicApplicationTests {

	@Test
	void contextLoads() {
	}

}
