package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilitário para leitura e escrita de arquivos.
 */
public class ArquivoUtil {

  public static void salvar(String caminho, List<String> linhas) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
      for (String linha : linhas) {
        writer.write(linha);
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao salvar arquivo: " + e.getMessage());
    }
  }

  public static List<String> carregar(String caminho) {
    List<String> linhas = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        linhas.add(linha);
      }
    } catch (IOException e) {
      System.out.println("Arquivo não encontrado ou erro ao ler: " + e.getMessage());
    }
    return linhas;
  }
}
