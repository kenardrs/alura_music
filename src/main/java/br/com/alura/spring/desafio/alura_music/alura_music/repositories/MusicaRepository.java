package br.com.alura.spring.desafio.alura_music.alura_music.repositories;

import br.com.alura.spring.desafio.alura_music.alura_music.entities.Artista;
import br.com.alura.spring.desafio.alura_music.alura_music.entities.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    List<Musica> findByArtista(Artista artista);
}