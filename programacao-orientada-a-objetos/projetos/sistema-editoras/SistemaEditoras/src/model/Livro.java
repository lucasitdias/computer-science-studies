package model;

/**
 * Representa um livro publicado por uma editora.
 */
public class Livro {
  private int id;
  private String nome;
  private int anoPublicacao;
  private long isbn;
  private String observacoes;
  private Editora editora;

  public Livro(int id, String nome, int anoPublicacao, long isbn, String observacoes, Editora editora) {
    this.id = id;
    this.nome = nome;
    this.anoPublicacao = anoPublicacao;
    this.isbn = isbn;
    this.observacoes = observacoes;
    this.editora = editora;
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAnoPublicacao() {
    return anoPublicacao;
  }

  public void setAnoPublicacao(int anoPublicacao) {
    this.anoPublicacao = anoPublicacao;
  }

  public long getIsbn() {
    return isbn;
  }

  public void setIsbn(long isbn) {
    this.isbn = isbn;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public Editora getEditora() {
    return editora;
  }

  public void setEditora(Editora editora) {
    this.editora = editora;
  }
}
