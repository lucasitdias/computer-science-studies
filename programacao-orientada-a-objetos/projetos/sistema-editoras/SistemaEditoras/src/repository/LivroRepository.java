package repository;

import model.Editora;
import model.Livro;
import utils.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositório para gerenciar livros com persistência em arquivo.
 */
public class LivroRepository {
  private List<Livro> livros = new ArrayList<>();
  private final String caminhoArquivo = "SistemaEditoras/dados/livros.txt";
  private EditoraRepository editoraRepo;

  public LivroRepository(EditoraRepository editoraRepo) {
    this.editoraRepo = editoraRepo;
    carregarDoArquivo();
  }

  public void inserir(Livro livro) {
    livros.add(livro);
    salvarNoArquivo();
  }

  public void alterar(int id, Livro novoLivro) {
    for (Livro l : livros) {
      if (l.getId() == id) {
        l.setNome(novoLivro.getNome());
        l.setAnoPublicacao(novoLivro.getAnoPublicacao());
        l.setIsbn(novoLivro.getIsbn());
        l.setObservacoes(novoLivro.getObservacoes());
        l.setEditora(novoLivro.getEditora());
        break;
      }
    }
    salvarNoArquivo();
  }

  public void excluir(int id) {
    livros.removeIf(l -> l.getId() == id);
    salvarNoArquivo();
  }

  public Livro pesquisar(int id) {
    for (Livro l : livros) {
      if (l.getId() == id) {
        return l;
      }
    }
    return null;
  }

  public List<Livro> listar() {
    return livros;
  }

  private void salvarNoArquivo() {
    List<String> linhas = new ArrayList<>();
    for (Livro l : livros) {
      String linha = l.getId() + ";" + l.getNome() + ";" + l.getAnoPublicacao() + ";" +
          l.getIsbn() + ";" + l.getObservacoes() + ";" + l.getEditora().getId();
      linhas.add(linha);
    }
    ArquivoUtil.salvar(caminhoArquivo, linhas);
  }

  private void carregarDoArquivo() {
    List<String> linhas = ArquivoUtil.carregar(caminhoArquivo);
    for (String linha : linhas) {
      String[] partes = linha.split(";");
      if (partes.length == 6) {
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        int ano = Integer.parseInt(partes[2]);
        long isbn = Long.parseLong(partes[3]);
        String obs = partes[4];
        int editoraId = Integer.parseInt(partes[5]);

        Editora editora = editoraRepo.pesquisar(editoraId);
        if (editora != null) {
          livros.add(new Livro(id, nome, ano, isbn, obs, editora));
        }
      }
    }
  }
}
