// Autores
// RA: 2502913 Nome: Allan Keiji Kimura
// RA: 2500298 Nome: Evillyn Ghiovana de Oliveira Galvão
// RA: 2502267 Nome: Lucas Luigi Dias Custodio

// Importa o Pool do pacote 'pg' para conectar ao PostgreSQL
import { Pool } from "pg";

// Importa o readline-sync para entrada de dados via terminal
import readlineSync from "readline-sync";

// Configurações de acesso ao banco de dados PostgreSQL
const dbConfig = {
  user: "aluno", // usuário do banco
  host: "localhost", // endereço do banco (Docker local)
  database: "db_profedu", // nome do banco
  password: "102030", // senha definida no Docker
  port: 5432, // porta padrão do PostgreSQL
};

// Cria uma instância de conexão com o banco
const pool = new Pool(dbConfig);

// Função principal que executa o cadastro do aluno
async function cadastrarAluno() {
  console.log("\n--- Cadastro de Aluno ---");

  // Coleta os dados básicos do aluno
  const nome = readlineSync.question("Nome do aluno: ");
  const serie = readlineSync.question("Serie (sem acento): ");
  const idade = readlineSync.questionInt("Idade: ");

  // Cria a tabela 'alunos' se ela ainda não existir
  const createTableQuery = `
    CREATE TABLE IF NOT EXISTS alunos (
      id SERIAL PRIMARY KEY,
      nome TEXT NOT NULL,
      serie TEXT NOT NULL,
      idade INT NOT NULL,
      media_matematica NUMERIC(5,2),
      media_geografia NUMERIC(5,2),
      media_historia NUMERIC(5,2),
      media_geral NUMERIC(5,2)
    );
  `;
  await pool.query(createTableQuery);

  // Função para calcular a média de uma matéria com 8 notas
  function calcularMedia(nomeMateria: string): number {
    console.log(`\n--- ${nomeMateria} ---`);
    let soma = 0;
    for (let i = 1; i <= 8; i++) {
      const nota = readlineSync.questionFloat(`Digite a nota ${i}: `);
      soma += nota;
    }
    const media = soma / 8;
    console.log(`Média de ${nomeMateria}: ${media.toFixed(2)}`);
    return media;
  }

  // Calcula as médias individuais
  const mediaMatematica = calcularMedia("Matemática");
  const mediaGeografia = calcularMedia("Geografia");
  const mediaHistoria = calcularMedia("História");

  // Calcula a média geral com base nas três matérias
  const mediaGeral = parseFloat(
    ((mediaMatematica + mediaGeografia + mediaHistoria) / 3).toFixed(2)
  );

  try {
    console.log("\nSalvando dados no banco...");

    // Query para inserir os dados do aluno no banco
    const insertQuery = `
      INSERT INTO alunos (
        nome, serie, idade,
        media_matematica, media_geografia, media_historia, media_geral
      ) VALUES ($1, $2, $3, $4, $5, $6, $7)
    `;

    // Valores que serão inseridos
    const values = [
      nome,
      serie,
      idade,
      mediaMatematica,
      mediaGeografia,
      mediaHistoria,
      mediaGeral,
    ];

    // Executa a inserção
    await pool.query(insertQuery, values);

    // Exibe os dados cadastrados
    console.log("\n-----------------------------------");
    console.log("Aluno cadastrado com sucesso!");
    console.log(`Nome: ${nome}`);
    console.log(`Série: ${serie}`);
    console.log(`Idade: ${idade}`);
    console.log(
      `Médias => Matemática: ${mediaMatematica.toFixed(
        2
      )}, Geografia: ${mediaGeografia.toFixed(
        2
      )}, História: ${mediaHistoria.toFixed(2)}`
    );
    console.log(`Média Geral: ${mediaGeral}`);
    console.log("-----------------------------------");
  } catch (error) {
    // Caso ocorra erro na inserção
    console.error("Erro ao salvar no banco:", error);
  } finally {
    // Encerra a conexão com o banco
    await pool.end();
    console.log("\nConexão com o banco encerrada.");
  }
}

// Executa a função principal
cadastrarAluno();
