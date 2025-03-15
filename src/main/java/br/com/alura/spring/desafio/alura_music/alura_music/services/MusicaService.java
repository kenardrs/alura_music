package br.com.alura.spring.desafio.alura_music.alura_music.services;

import br.com.alura.spring.desafio.alura_music.alura_music.entities.Artista;
import br.com.alura.spring.desafio.alura_music.alura_music.entities.Musica;
import br.com.alura.spring.desafio.alura_music.alura_music.repositories.ArtistaRepository;
import br.com.alura.spring.desafio.alura_music.alura_music.repositories.MusicaRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    public Musica salvarMusica(@NonNull Musica musica, @NonNull Long artistaId) {
        if(musica.getTitulo() == null || musica.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("Nome da Música não pode ser vazio");
        }
        Artista artista = artistaRepository.findById(artistaId)
                .orElseThrow(() -> new IllegalArgumentException("Artista não encontrado"));
        musica.setArtista(artista);
        return musicaRepository.save(musica);
    }

    public List<Musica> listarMusicas() {
        return musicaRepository.findAll();
    }

    public List<Musica> listarMusicasPorArtista(@NonNull Long artistaId) {
        Artista artista = artistaRepository.findById(artistaId)
                .orElseThrow(() -> new IllegalArgumentException("Artista não encontrado"));
        return musicaRepository.findByArtista(artista);
    }
}
