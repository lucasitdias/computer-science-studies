package view;

import model.*;
import repository.*;

import java.util.Scanner;
import java.util.List;

/**
 * Menu interativo para o sistema de editoras, livros e autores.
 */
public class Menu {
  private Scanner scanner = new Scanner(System.in);

  private EditoraRepository editoraRepo = new EditoraRepository();
  private LivroRepository livroRepo = new LivroRepository(editoraRepo);
  private AutorRepository autorRepo = new AutorRepository();

  /**
   * Exibe o menu principal do sistema.
   */
  public void exibirMenuPrincipal() {
    int opcao;
    do {
      System.out.println("\n=== MENU PRINCIPAL ===");
      System.out.println("1. Editoras");
      System.out.println("2. Livros");
      System.out.println("3. Autores");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1 -> menuEditoras();
        case 2 -> menuLivros();
        case 3 -> menuAutores();
        case 0 -> System.out.println("Encerrando o sistema...");
        default -> System.out.println("Opção inválida.");
      }
    } while (opcao != 0);
  }

  // ===================== MENU EDITORAS =====================

  /**
   * Exibe o menu de operações para editoras.
   */
  private void menuEditoras() {
    System.out.println("\n--- MENU EDITORAS ---");
    System.out.println("1. Inserir");
    System.out.println("2. Alterar");
    System.out.println("3. Excluir");
    System.out.println("4. Pesquisar");
    System.out.println("5. Imprimir todas");
    System.out.println("6. Contar editoras");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();

    switch (opcao) {
      case 1 -> inserirEditora();
      case 2 -> alterarEditora();
      case 3 -> excluirEditora();
      case 4 -> pesquisarEditora();
      case 5 -> imprimirEditoras();
      case 6 -> contarEditoras();
      default -> System.out.println("Opção inválida.");
    }
  }

  /**
   * Cadastra uma nova editora com validação.
   */
  private void inserirEditora() {
    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // limpar buffer
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Sigla: ");
    String sigla = scanner.nextLine();
    System.out.print("Observações: ");
    String obs = scanner.nextLine();

    try {
      Editora e = new Editora(id, nome, sigla, obs);
      editoraRepo.inserir(e);
      System.out.println("Editora inserida com sucesso!");
    } catch (IllegalArgumentException ex) {
      System.out.println("Erro ao inserir editora: " + ex.getMessage());
    }
  }

  /**
   * Altera os dados de uma editora existente.
   */
  private void alterarEditora() {
    System.out.print("ID da editora a alterar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Novo nome: ");
    String nome = scanner.nextLine();
    System.out.print("Nova sigla: ");
    String sigla = scanner.nextLine();
    System.out.print("Novas observações: ");
    String obs = scanner.nextLine();

    try {
      Editora nova = new Editora(id, nome, sigla, obs);
      editoraRepo.alterar(id, nova);
      System.out.println("Editora alterada com sucesso!");
    } catch (IllegalArgumentException ex) {
      System.out.println("Erro ao alterar editora: " + ex.getMessage());
    }
  }

  /**
   * Exclui uma editora pelo ID.
   */
  private void excluirEditora() {
    System.out.print("ID da editora a excluir: ");
    int id = scanner.nextInt();
    editoraRepo.excluir(id);
    System.out.println("Editora excluída com sucesso!");
  }

  /**
   * Pesquisa uma editora pelo ID.
   */
  private void pesquisarEditora() {
    System.out.print("ID da editora a pesquisar: ");
    int id = scanner.nextInt();
    Editora e = editoraRepo.pesquisar(id);
    if (e != null) {
      System.out.println("Nome: " + e.getNome());
      System.out.println("Sigla: " + e.getSigla());
      System.out.println("Observações: " + e.getObservacoes());
    } else {
      System.out.println("Editora não encontrada.");
    }
  }

  /**
   * Imprime todas as editoras cadastradas.
   */
  private void imprimirEditoras() {
    System.out.println("\n--- LISTA DE EDITORAS ---");
    for (Editora e : editoraRepo.listarTodos()) {
      System.out.println("ID: " + e.getId() + " | Nome: " + e.getNome() + " | Sigla: " + e.getSigla());
    }
  }

  /**
   * Exibe o número total de editoras cadastradas.
   */
  private void contarEditoras() {
    int total = editoraRepo.contarEditoras();
    System.out.println("Total de editoras cadastradas: " + total);
  }
  // ===================== MENU LIVROS =====================

  /**
   * Exibe o menu de operações para livros.
   */
  private void menuLivros() {
    System.out.println("\n--- MENU LIVROS ---");
    System.out.println("1. Inserir");
    System.out.println("2. Alterar");
    System.out.println("3. Excluir");
    System.out.println("4. Pesquisar");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();

    switch (opcao) {
      case 1 -> inserirLivro();
      case 2 -> alterarLivro();
      case 3 -> excluirLivro();
      case 4 -> pesquisarLivro();
      default -> System.out.println("Opção inválida.");
    }
  }

  /**
   * Insere um novo livro vinculado a uma editora existente.
   */
  private void inserirLivro() {
    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Ano de publicação: ");
    int ano = scanner.nextInt();
    System.out.print("ISBN: ");
    long isbn = scanner.nextLong();
    scanner.nextLine();
    System.out.print("Observações: ");
    String obs = scanner.nextLine();

    System.out.print("ID da editora: ");
    int editoraId = scanner.nextInt();
    Editora editora = editoraRepo.pesquisar(editoraId);

    if (editora != null) {
      Livro l = new Livro(id, nome, ano, isbn, obs, editora);
      livroRepo.inserir(l);
      System.out.println("Livro inserido com sucesso!");
    } else {
      System.out.println("Editora não encontrada.");
    }
  }

  /**
   * Altera os dados de um livro existente.
   */
  private void alterarLivro() {
    System.out.print("ID do livro a alterar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Novo nome: ");
    String nome = scanner.nextLine();
    System.out.print("Novo ano de publicação: ");
    int ano = scanner.nextInt();
    System.out.print("Novo ISBN: ");
    long isbn = scanner.nextLong();
    scanner.nextLine();
    System.out.print("Novas observações: ");
    String obs = scanner.nextLine();
    System.out.print("ID da nova editora: ");
    int editoraId = scanner.nextInt();
    Editora editora = editoraRepo.pesquisar(editoraId);

    if (editora != null) {
      Livro novo = new Livro(id, nome, ano, isbn, obs, editora);
      livroRepo.alterar(id, novo);
      System.out.println("Livro alterado com sucesso!");
    } else {
      System.out.println("Editora não encontrada.");
    }
  }

  /**
   * Exclui um livro pelo ID.
   */
  private void excluirLivro() {
    System.out.print("ID do livro a excluir: ");
    int id = scanner.nextInt();
    livroRepo.excluir(id);
    System.out.println("Livro excluído com sucesso!");
  }

  /**
   * Pesquisa um livro pelo ID.
   */
  private void pesquisarLivro() {
    System.out.print("ID do livro a pesquisar: ");
    int id = scanner.nextInt();
    Livro l = livroRepo.pesquisar(id);
    if (l != null) {
      System.out.println("Nome: " + l.getNome());
      System.out.println("Ano: " + l.getAnoPublicacao());
      System.out.println("ISBN: " + l.getIsbn());
      System.out.println("Observações: " + l.getObservacoes());
      System.out.println("Editora: " + l.getEditora().getNome());
    } else {
      System.out.println("Livro não encontrado.");
    }
  }

  // ===================== MENU AUTORES =====================

  /**
   * Exibe o menu de operações para autores.
   */
  private void menuAutores() {
    System.out.println("\n--- MENU AUTORES ---");
    System.out.println("1. Inserir");
    System.out.println("2. Alterar");
    System.out.println("3. Excluir");
    System.out.println("4. Pesquisar");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();

    switch (opcao) {
      case 1 -> inserirAutor();
      case 2 -> alterarAutor();
      case 3 -> excluirAutor();
      case 4 -> pesquisarAutor();
      default -> System.out.println("Opção inválida.");
    }
  }

  /**
   * Insere um novo autor.
   */
  private void inserirAutor() {
    System.out.print("ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Pseudônimo: ");
    String pseudonimo = scanner.nextLine();
    System.out.print("Observações: ");
    String obs = scanner.nextLine();

    Autor a = new Autor(id, nome, pseudonimo, obs);
    autorRepo.inserir(a);
    System.out.println("Autor inserido com sucesso!");
  }

  /**
   * Altera os dados de um autor existente.
   */
  private void alterarAutor() {
    System.out.print("ID do autor a alterar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Novo nome: ");
    String nome = scanner.nextLine();
    System.out.print("Novo pseudônimo: ");
    String pseudonimo = scanner.nextLine();
    System.out.print("Novas observações: ");
    String obs = scanner.nextLine();

    Autor novo = new Autor(id, nome, pseudonimo, obs);
    autorRepo.alterar(id, novo);
    System.out.println("Autor alterado com sucesso!");
  }

  /**
   * Exclui um autor pelo ID.
   */
  private void excluirAutor() {
    System.out.print("ID do autor a excluir: ");
    int id = scanner.nextInt();
    autorRepo.excluir(id);
    System.out.println("Autor excluído com sucesso!");
  }

  /**
   * Pesquisa um autor pelo ID.
   */
  private void pesquisarAutor() {
    System.out.print("ID do autor a pesquisar: ");
    int id = scanner.nextInt();
    Autor a = autorRepo.pesquisar(id);
    if (a != null) {
      System.out.println("Nome: " + a.getNome());
      System.out.println("Pseudônimo: " + a.getPseudonimo());
      System.out.println("Observações: " + a.getObservacoes());
    } else {
      System.out.println("Autor não encontrado.");
    }
  }
}
