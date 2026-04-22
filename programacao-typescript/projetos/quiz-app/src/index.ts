//RA: 2502913 — Allan Keiji Kimura
//RA: 2500298 — Evillyn Ghiovana de Oliveira Galvão
//RA: 2502267 — Lucas Luigi Dias Custodio
//RA: 2411833 — Luiz Diego Pavan
//RA: 2502501 — Gustavo Nascimento Teixeira

// Importa o Express para criar o servidor HTTP
import express from "express";

// Importa o dotenv para carregar variáveis de ambiente do arquivo .env
import dotenv from "dotenv";
dotenv.config();

// Importa as rotas definidas na aplicação
import router from "./routes";

// Importa a conexão com o banco de dados
import { AppDataSource } from "./database/data-source";

// Cria a instância do servidor Express
const app = express();

// Configura o Express para aceitar JSON no corpo das requisições
app.use(express.json());

// Usa as rotas definidas no arquivo de rotas
app.use(router);

// Inicializa a conexão com o banco de dados
AppDataSource.initialize()
  .then(() => {
    console.log("Banco de dados conectado com sucesso");

    // Inicia o servidor na porta 3000
    app.listen(3000, () => {
      console.log("Servidor rodando na porta 3000");
    });
  })
  .catch((error) => {
    console.error("Erro ao conectar com o banco de dados:", error);
  });
