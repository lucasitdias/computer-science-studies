package model;

/**
 * Representa um autor de livros.
 */
public class Autor {
  private int id;
  private String nome;
  private String pseudonimo;
  private String observacoes;

  public Autor(int id, String nome, String pseudonimo, String observacoes) {
    this.id = id;
    this.nome = nome;
    this.pseudonimo = pseudonimo;
    this.observacoes = observacoes;
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

  public String getPseudonimo() {
    return pseudonimo;
  }

  public void setPseudonimo(String pseudonimo) {
    this.pseudonimo = pseudonimo;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }
}
