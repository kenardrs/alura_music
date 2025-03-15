package br.com.alura.spring.desafio.alura_music.alura_music.repositories;

import br.com.alura.spring.desafio.alura_music.alura_music.entities.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}