// Importa os tipos para lidar com requisições e respostas HTTP
import { Request, Response } from "express";

// Importa a conexão com o banco de dados
import { AppDataSource } from "../database/data-source";

// Importa o modelo de usuário
import { User } from "../models/User";

/**
 * Cadastra um novo usuário com pontuação
 * Espera receber: name, score
 */
export const createUser = async (req: Request, res: Response) => {
  try {
    const { name, score } = req.body;

    // Validação simples dos campos
    if (!name || score === undefined) {
      return res
        .status(400)
        .json({ message: "Nome e pontuação são obrigatórios." });
    }

    // Cria e salva o usuário
    const repo = AppDataSource.getRepository(User);
    const user = repo.create({ name, score });
    await repo.save(user);

    return res.status(201).json(user);
  } catch (error) {
    return res
      .status(500)
      .json({ message: "Erro ao cadastrar usuário.", error });
  }
};

/**
 * Lista todos os usuários cadastrados
 */
export const getUsers = async (_: Request, res: Response) => {
  try {
    const repo = AppDataSource.getRepository(User);
    const users = await repo.find();

    return res.status(200).json(users);
  } catch (error) {
    return res.status(500).json({ message: "Erro ao buscar usuários.", error });
  }
};
