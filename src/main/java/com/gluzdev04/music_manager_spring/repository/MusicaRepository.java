package com.gluzdev04.music_manager_spring.repository;

import com.gluzdev04.music_manager_spring.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    @Query("SELECT m FROM Musica m JOIN m.artista a WHERE a.nome ILIKE :nomeArtista")
    List<Musica> buscarMusicasPeloNomeDoArtista(String nomeArtista);

    @Modifying
    @Query("DELETE FROM Musica m WHERE m.nome ILIKE :nomeDaMusica")
    int deletarMusicaPeloNome(String nomeDaMusica);
}
