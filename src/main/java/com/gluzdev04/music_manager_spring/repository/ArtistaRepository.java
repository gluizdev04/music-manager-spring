package com.gluzdev04.music_manager_spring.repository;

import com.gluzdev04.music_manager_spring.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository <Artista, Long> {
}
