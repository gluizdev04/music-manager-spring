package com.gluzdev04.music_manager_spring.service;

import com.gluzdev04.music_manager_spring.model.Artista;
import com.gluzdev04.music_manager_spring.model.Musica;
import com.gluzdev04.music_manager_spring.repository.MusicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MusicaService {
    private MusicaRepository musicaRepository;
    private ArtistaService artistaService;

    public MusicaService(MusicaRepository musicaRepository, ArtistaService artistaService) {
        this.musicaRepository = musicaRepository;
        this.artistaService = artistaService;
    }

    public void cadastrarMusica(String nome, Artista artista) {
        List<Musica> musicaEncontrada = musicaRepository.buscarMusicasPeloNome(nome);
        if(!musicaEncontrada.isEmpty()){
            throw new IllegalArgumentException("Música já cadastrada");
        }

        try {
            Artista artistaEncontrado = artistaService.buscarArtistaPorNome(artista.getNome());
            Musica musica = new Musica(nome, artista);
            musicaRepository.save(musica);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro: " + e.getMessage());
        }

    }

    public List<Musica> listarTodasAsMusicas() {
        List<Musica> musicasEncontradas = musicaRepository.findAll();
        return musicasEncontradas;
    }

    public List<Musica> buscarMusicasPorNomeDoArtista(String nomeArtista) {
        List<Musica> musicasEncontrada = musicaRepository.buscarMusicasPeloNomeDoArtista(nomeArtista);
        return musicasEncontrada;
    }

    @Transactional
    public boolean deletarMusica(String nomeDaMusica) {
        int linhasAfetadasPeloDelete = musicaRepository.deletarMusicaPeloNome(nomeDaMusica);

        return linhasAfetadasPeloDelete > 0;
    }
}
