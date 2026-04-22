// Importa os tipos do Express
import { Request, Response } from 'express';

// Importa o serviço que executa o quiz
import { executeQuiz } from '../services/QuizService';

// Importa o modelo de usuário
import { User } from '../models/User';

// Importa a conexão com o banco
import { AppDataSource } from '../database/data-source';

/**
 * Executa o quiz com base nas respostas do usuário
 * Espera receber: name (string), answers (array de { id, answer })
 */
export const runQuiz = async (req: Request, res: Response) => {
  try {
    const { name, answers } = req.body;

    // Validação básica
    if (!name || !Array.isArray(answers)) {
      return res.status(400).json({ message: 'Nome e respostas são obrigatórios.' });
    }

    // Executa o quiz e calcula a pontuação
    const result = await executeQuiz(answers);

    // Cria e salva o usuário com a pontuação final
    const userRepo = AppDataSource.getRepository(User);
    const user = userRepo.create({ name, score: result.totalScore });
    await userRepo.save(user);

    // Retorna o resultado do quiz e os detalhes da correção
    return res.status(200).json({
      message: 'Quiz finalizado!',
      user: { name, score: result.totalScore },
      corrections: result.corrections,
    });
  } catch (error) {
    return res.status(500).json({ message: 'Erro ao executar o quiz.', error });
  }
};
