// Importa o modelo de pergunta
import { Question } from "../models/Question";

// Importa a conexão com o banco de dados
import { AppDataSource } from "../database/data-source";

/**
 * Executa o quiz com base nas respostas do usuário
 * @param userAnswers - Array de objetos com id da pergunta e resposta do usuário
 * @returns pontuação total e perguntas corrigidas
 */
export const executeQuiz = async (
  userAnswers: { id: number; answer: string }[]
) => {
  // Repositório de perguntas
  const repo = AppDataSource.getRepository(Question);

  // Busca todas as perguntas do banco
  const questions = await repo.find();

  // Inicializa a pontuação
  let totalScore = 0;

  // Array para armazenar correções
  const corrections = [];

  // Percorre as respostas do usuário
  for (const userAnswer of userAnswers) {
    // Encontra a pergunta correspondente
    const question = questions.find((q) => q.id === userAnswer.id);

    if (question) {
      // Verifica se a resposta está correta (case-insensitive)
      const isCorrect =
        question.answer.trim().toLowerCase() ===
        userAnswer.answer.trim().toLowerCase();

      // Soma os pontos se estiver correta
      if (isCorrect) {
        totalScore += question.points;
      }

      // Adiciona a correção ao array
      corrections.push({
        question: question.text,
        correctAnswer: question.answer,
        userAnswer: userAnswer.answer,
        isCorrect,
        points: isCorrect ? question.points : 0,
      });
    }
  }

  // Retorna o resultado final
  return {
    totalScore,
    corrections,
  };
};
