package repository;

import model.Autor;
import utils.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositório para gerenciar autores com persistência em arquivo.
 */
public class AutorRepository {
  private List<Autor> autores = new ArrayList<>();
  private final String caminhoArquivo = "SistemaEditoras/dados/autores.txt";

  public AutorRepository() {
    carregarDoArquivo();
  }

  public void inserir(Autor autor) {
    autores.add(autor);
    salvarNoArquivo();
  }

  public void alterar(int id, Autor novoAutor) {
    for (Autor a : autores) {
      if (a.getId() == id) {
        a.setNome(novoAutor.getNome());
        a.setPseudonimo(novoAutor.getPseudonimo());
        a.setObservacoes(novoAutor.getObservacoes());
        break;
      }
    }
    salvarNoArquivo();
  }

  public void excluir(int id) {
    autores.removeIf(a -> a.getId() == id);
    salvarNoArquivo();
  }

  public Autor pesquisar(int id) {
    for (Autor a : autores) {
      if (a.getId() == id) {
        return a;
      }
    }
    return null;
  }

  public List<Autor> listar() {
    return autores;
  }

  private void salvarNoArquivo() {
    List<String> linhas = new ArrayList<>();
    for (Autor a : autores) {
      String linha = a.getId() + ";" + a.getNome() + ";" + a.getPseudonimo() + ";" + a.getObservacoes();
      linhas.add(linha);
    }
    ArquivoUtil.salvar(caminhoArquivo, linhas);
  }

  private void carregarDoArquivo() {
    List<String> linhas = ArquivoUtil.carregar(caminhoArquivo);
    for (String linha : linhas) {
      String[] partes = linha.split(";");
      if (partes.length == 4) {
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String pseudonimo = partes[2];
        String obs = partes[3];
        autores.add(new Autor(id, nome, pseudonimo, obs));
      }
    }
  }
}
