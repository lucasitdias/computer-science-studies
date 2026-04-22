package repository;

import model.Editora;
import utils.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositório para gerenciar editoras com persistência em arquivo.
 *
 * Cada editora possui:
 * - ID (inteiro)
 * - Nome (String)
 * - Sigla (String)
 * - Observações (String)
 *
 * Operações disponíveis:
 * - Inserir
 * - Alterar
 * - Excluir
 * - Pesquisar
 * - Listar todas
 * - Contar editoras cadastradas
 */
public class EditoraRepository {
  private List<Editora> editoras = new ArrayList<>();
  private final String caminhoArquivo = "SistemaEditoras/dados/editoras.txt";

  /**
   * Construtor que carrega os dados do arquivo na inicialização.
   */
  public EditoraRepository() {
    carregarDoArquivo();
  }

  /**
   * Insere uma nova editora na lista e salva no arquivo.
   * 
   * @param editora objeto Editora válido
   */
  public void inserir(Editora editora) {
    editoras.add(editora);
    salvarNoArquivo();
  }

  /**
   * Altera os dados de uma editora existente com base no ID.
   * 
   * @param id          identificador da editora a ser alterada
   * @param novaEditora objeto com os novos dados
   */
  public void alterar(int id, Editora novaEditora) {
    for (Editora e : editoras) {
      if (e.getId() == id) {
        e.setNome(novaEditora.getNome());
        e.setSigla(novaEditora.getSigla());
        e.setObservacoes(novaEditora.getObservacoes());
        break;
      }
    }
    salvarNoArquivo();
  }

  /**
   * Exclui uma editora com base no ID.
   * 
   * @param id identificador da editora a ser removida
   */
  public void excluir(int id) {
    editoras.removeIf(e -> e.getId() == id);
    salvarNoArquivo();
  }

  /**
   * Pesquisa uma editora pelo ID.
   * 
   * @param id identificador da editora
   * @return objeto Editora ou null se não encontrada
   */
  public Editora pesquisar(int id) {
    for (Editora e : editoras) {
      if (e.getId() == id) {
        return e;
      }
    }
    return null;
  }

  /**
   * Retorna a lista completa de editoras cadastradas.
   * 
   * @return lista de editoras
   */
  public List<Editora> listarTodos() {
    return editoras;
  }

  /**
   * Retorna o número total de editoras cadastradas.
   * 
   * @return quantidade de editoras
   */
  public int contarEditoras() {
    return editoras.size();
  }

  /**
   * Salva os dados da lista de editoras no arquivo.
   */
  private void salvarNoArquivo() {
    List<String> linhas = new ArrayList<>();
    for (Editora e : editoras) {
      String linha = e.getId() + ";" + e.getNome() + ";" + e.getSigla() + ";" + e.getObservacoes();
      linhas.add(linha);
    }
    ArquivoUtil.salvar(caminhoArquivo, linhas);
  }

  /**
   * Carrega os dados do arquivo para a lista de editoras.
   * Linhas com dados inválidos são ignoradas e exibidas como aviso.
   */
  private void carregarDoArquivo() {
    List<String> linhas = ArquivoUtil.carregar(caminhoArquivo);
    for (String linha : linhas) {
      String[] partes = linha.split(";");
      if (partes.length == 4) {
        try {
          int id = Integer.parseInt(partes[0]);
          String nome = partes[1];
          String sigla = partes[2];
          String obs = partes[3];
          Editora e = new Editora(id, nome, sigla, obs);
          editoras.add(e);
        } catch (Exception ex) {
          System.out.println("Linha ignorada por erro de dados: " + linha);
        }
      }
    }
  }
}
