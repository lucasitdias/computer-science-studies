package model;

/**
 * Representa uma editora de livros.
 * Regras de negócio:
 * - ID deve ser > 0.
 * - Nome (descrição) deve ter no mínimo 3 caracteres e não pode ser nulo ou
 * vazio.
 */
public class Editora {
  private int id;
  private String nome;
  private String sigla;
  private String observacoes;

  /**
   * Construtor da classe Editora com validações.
   * 
   * @param id          Identificador único da editora (deve ser > 0)
   * @param nome        Nome da editora (mínimo 3 caracteres)
   * @param sigla       Sigla da editora
   * @param observacoes Observações adicionais
   */
  public Editora(int id, String nome, String sigla, String observacoes) {
    if (id <= 0) {
      throw new IllegalArgumentException("O ID deve ser maior que zero.");
    }
    if (nome == null || nome.trim().length() < 3) {
      throw new IllegalArgumentException("O nome deve ter no mínimo 3 caracteres.");
    }
    this.id = id;
    this.nome = nome;
    this.sigla = sigla;
    this.observacoes = observacoes;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getSigla() {
    return sigla;
  }

  public String getObservacoes() {
    return observacoes;
  }

  // Setters com validação
  public void setId(int id) {
    if (id <= 0) {
      throw new IllegalArgumentException("O ID deve ser maior que zero.");
    }
    this.id = id;
  }

  public void setNome(String nome) {
    if (nome == null || nome.trim().length() < 3) {
      throw new IllegalArgumentException("O nome deve ter no mínimo 3 caracteres.");
    }
    this.nome = nome;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }
}
