package br.com.alura.spring.desafio.alura_music.alura_music.services;

import br.com.alura.spring.desafio.alura_music.alura_music.entities.Artista;
import br.com.alura.spring.desafio.alura_music.alura_music.entities.TipoArtista;
import br.com.alura.spring.desafio.alura_music.alura_music.repositories.ArtistaRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista salvarArtista(@NonNull Artista artista) {
        if(artista.getNome() == null || artista.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do não pode ser vazio");
        }
        if(!TipoArtista.validaTipo(artista.getTipo().name())){
            throw new IllegalArgumentException("Tipo de artista inválido");
        }
        return artistaRepository.save(artista);
    }

    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }
}
