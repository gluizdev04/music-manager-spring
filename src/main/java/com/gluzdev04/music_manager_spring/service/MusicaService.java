package com.gluzdev04.music_manager_spring.service;

import com.gluzdev04.music_manager_spring.model.Artista;
import com.gluzdev04.music_manager_spring.model.Musica;
import com.gluzdev04.music_manager_spring.repository.MusicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {
    private MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public void cadastrarMusica(String nome, Artista artista) {
        Musica musica = new Musica(nome, artista);
        musicaRepository.save(musica);
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
