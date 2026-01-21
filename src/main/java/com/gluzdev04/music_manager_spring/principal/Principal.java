package com.gluzdev04.music_manager_spring.principal;

import com.gluzdev04.music_manager_spring.model.Artista;
import com.gluzdev04.music_manager_spring.model.Musica;
import com.gluzdev04.music_manager_spring.model.TipoArtista;
import com.gluzdev04.music_manager_spring.repository.MusicaRepository;
import com.gluzdev04.music_manager_spring.service.ArtistaService;
import com.gluzdev04.music_manager_spring.service.MusicaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class Principal {
    private final MusicaRepository musicaRepository;
    private ArtistaService artistaService;
    private MusicaService musicaService;

    public Principal(ArtistaService artistaService, MusicaService musicaService, MusicaRepository musicaRepository) {
        this.artistaService = artistaService;
        this.musicaService = musicaService;
        this.musicaRepository = musicaRepository;
    }

    Scanner entrada = new Scanner(System.in);

    public void exibirMenu() {
        var sistemaRodando = true;
        while (sistemaRodando) {
            var menu = """
                    \n
                            *** Screen Sound Músicas ***
                    
                            1 - Cadastrar artistas
                            2 - Cadastrar músicas
                            3 - Listar músicas
                            4 - Buscar músicas por artistas
                            5 - Pesquisar dados sobre um artista
                    
                            0 - Sair
                    """;
            System.out.println(menu);
            var opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    //buscarMusicaPorArtista();
                    break;
                case 5:
                    //pesquisarDadosSobreUmArtista();
                    break;
                case 0:
                    sistemaRodando = false;
                    break;
            }
        }
    }

    public void cadastrarArtista() {
        System.out.print("Nome do artista: ");
        var nomeArtista = entrada.nextLine();
        System.out.print("Tipo de artista (solo, dupla ou banda): ");
        var tipoArtista = entrada.nextLine();

        try {
            TipoArtista tipoArtistaFromEnum = TipoArtista.fromEnum(tipoArtista);
            artistaService.cadastrarArtista(nomeArtista, tipoArtistaFromEnum);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Tipo inválido! Digite apenas: solo, dupla ou banda.");
        }
    }

    private void cadastrarMusica() {
        System.out.print("Nome da música: ");
        var nomeMusica = entrada.nextLine();
        System.out.print("Artista: ");
        var artistaNome = entrada.nextLine();

        try {
            Artista artistaMusicaBuscado = artistaService.buscarArtistaPorNome(artistaNome);
            musicaService.cadastrarMusica(nomeMusica, artistaMusicaBuscado);
        } catch (NoSuchElementException e) {
            System.out.println("Usuário não encontrado");
        }
    }

    private void listarMusicas() {
        List<Musica> todasAsMusicas = musicaService.listarTodasAsMusicas();
        todasAsMusicas.forEach(m -> {
            System.out.println("Música: " + m.getNome() + " | Artista: " + m.getArtista().getNome());
        });
    }
}
