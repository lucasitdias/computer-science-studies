// Importa os tipos para lidar com requisições e respostas HTTP
import { Request, Response } from "express";

// Importa a conexão com o banco de dados
import { AppDataSource } from "../database/data-source";

// Importa o modelo de pergunta
import { Question } from "../models/Question";

/**
 * Cadastra uma nova pergunta no banco de dados
 * Espera receber: text, answer, points
 */
export const createQuestion = async (req: Request, res: Response) => {
  try {
    const { text, answer, points } = req.body;

    // Validação simples dos campos
    if (!text || !answer || points === undefined) {
      return res
        .status(400)
        .json({ message: "Todos os campos são obrigatórios." });
    }

    // Cria e salva a pergunta
    const repo = AppDataSource.getRepository(Question);
    const question = repo.create({ text, answer, points });
    await repo.save(question);

    return res.status(201).json(question);
  } catch (error) {
    return res
      .status(500)
      .json({ message: "Erro ao cadastrar pergunta.", error });
  }
};

/**
 * Lista todas as perguntas cadastradas
 */
export const getQuestions = async (_: Request, res: Response) => {
  try {
    const repo = AppDataSource.getRepository(Question);
    const questions = await repo.find();

    return res.status(200).json(questions);
  } catch (error) {
    return res
      .status(500)
      .json({ message: "Erro ao buscar perguntas.", error });
  }
};
