package model;

/**
 * Representa a associação entre um autor e um livro.
 */
public class AutorLivro {
  private Livro livro;
  private Autor autor;

  public AutorLivro(Livro livro, Autor autor) {
    this.livro = livro;
    this.autor = autor;
  }

  // Getters e Setters
  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }
}
