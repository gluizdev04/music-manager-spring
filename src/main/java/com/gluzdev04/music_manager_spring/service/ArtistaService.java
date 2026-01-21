package com.gluzdev04.music_manager_spring.service;

import com.gluzdev04.music_manager_spring.model.Artista;
import com.gluzdev04.music_manager_spring.model.TipoArtista;
import com.gluzdev04.music_manager_spring.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    ArtistaRepository artistaRepository;

    public void cadastrarArtista(String nome, TipoArtista tipoArtista){
        Artista artista = new Artista(nome, tipoArtista);
        artistaRepository.save(artista);
    }

    public Artista buscarArtistaPorNome(String artistaMusica) {
        Optional<Artista> artistaBuscado = artistaRepository.buscarArtistaPorNome(artistaMusica);
        if (artistaBuscado.isPresent()) {
            return artistaBuscado.get();
        } else {
            throw new NoSuchElementException("Usuário não cadastrado");
        }
    }
}
