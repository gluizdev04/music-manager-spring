package com.gluzdev04.music_manager_spring.principal;

import com.gluzdev04.music_manager_spring.model.TipoArtista;
import com.gluzdev04.music_manager_spring.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {
    @Autowired
    ArtistaService artistaService;
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
                    //cadastrarMusica();
                    break;
                case 3:
                    //listarMusicas();
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

    public void cadastrarArtista(){
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

}
