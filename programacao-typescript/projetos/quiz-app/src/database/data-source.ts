// Importa os decoradores necessários para o TypeORM funcionar
import "reflect-metadata";

// Importa o DataSource, que é a configuração principal de conexão
import { DataSource } from "typeorm";

// Importa os modelos que serão usados como tabelas no banco
import { Question } from "../models/Question";
import { User } from "../models/User";

// Importa as variáveis de ambiente do arquivo .env
import dotenv from "dotenv";
dotenv.config();

// Cria e exporta a instância de conexão com o banco de dados
export const AppDataSource = new DataSource({
  type: "postgres", // Tipo do banco
  host: process.env.DB_HOST, // Host do banco (localhost)
  port: Number(process.env.DB_PORT), // Porta padrão do PostgreSQL
  username: process.env.DB_USER, // Usuário do banco
  password: process.env.DB_PASSWORD, // Senha do banco
  database: process.env.DB_NAME, // Nome do banco
  entities: [Question, User], // Entidades que viram tabelas
  synchronize: true, // Cria as tabelas automaticamente (ideal só para dev)
});
