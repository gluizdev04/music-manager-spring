#  ScreenMatch Músicas (Desafio Alura)

Aplicação Backend desenvolvida para o desafio final do curso de Persistência Java da Alura. O objetivo é modelar um sistema de gerenciamento de músicas e artistas, aplicando conceitos avançados de Banco de Dados Relacional e Orientação a Objetos.

##  Sobre o Projeto

O **ScreenMatch Músicas** permite o cadastro e organização de uma discografia. O foco principal foi trabalhar o relacionamento **Um-para-Muitos** (Um Artista tem várias Músicas) e aprofundar o conhecimento em JPA (Java Persistence API).

O sistema roda via terminal (console), oferecendo um menu interativo para o usuário.

##  Funcionalidades

- **Cadastro de Artistas:**
  - Registro de nome e classificação do tipo (Solo, Dupla ou Banda) via Enum.
- **Cadastro de Músicas:**
  - Associação direta de músicas a um artista existente.
- **Listagem de Músicas:**
  - Visualização de todas as faixas cadastradas no banco.
- **Buscas Avançadas (JPQL):**
  - Busca de músicas por artista.
  - (Futuro) Pesquisa de dados sobre artistas.

##  Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Data JPA**
- **PostgreSQL** (Banco de Dados)
- **Hibernate** (ORM)
- **Maven**

##  Como rodar o projeto

### Pré-requisitos
- Java 17 ou superior instalado.
- PostgreSQL instalado e rodando.

### Passo a passo

1. Clone o repositório:
```bash
git clone [https://github.com/gluizdev04/music-manager-spring.git](https://github.com/gluizdev04/music-manager-spring.git)
