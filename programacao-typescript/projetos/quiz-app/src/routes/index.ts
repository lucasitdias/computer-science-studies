import { Router } from "express";
import {
  createQuestion,
  getQuestions,
} from "../controllers/QuestionController";
import { createUser, getUsers } from "../controllers/UserController";
import { runQuiz } from "../controllers/QuizController"; // ✅ Importa o controller do quiz

const router = Router();

/**
 * Rotas de perguntas
 */
router.post("/questions", createQuestion);
router.get("/questions", getQuestions);

/**
 * Rotas de usuários
 */
router.post("/users", createUser);
router.get("/users", getUsers);

/**
 * Rota do quiz
 */
router.post("/quiz", runQuiz); // ✅ Registra a rota do quiz

export default router;
