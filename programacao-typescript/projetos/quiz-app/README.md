
---

# 📚 Quiz App — Sistema de Perguntas e Respostas com Pontuação

Este projeto é uma API REST desenvolvida com Node.js, TypeScript e PostgreSQL (via Docker), que permite cadastrar perguntas, executar quizzes e registrar pontuação de usuários. Todos os testes foram validados com sucesso via Insomnia.

---

## 🎯 Objetivo do Projeto

A aplicação tem o propósito de:

- Criar um sistema de perguntas e respostas com pontuação
- Cadastrar perguntas e respostas
- Executar quizzes e validar respostas
- Registrar nome e pontuação do usuário
- Persistir dados com PostgreSQL via Docker
- Testar endpoints com Insomnia

---

## 📦 Pré-requisitos

Antes de iniciar, você precisa ter instalado:

- [Node.js](https://nodejs.org/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop) (Windows/Linux)
- [Insomnia](https://insomnia.rest/download)
- Git (opcional, para clonar o projeto)
- Visual Studio Code (VS Code)

---

## 🧩 Extensões Recomendadas para VS Code

Para facilitar o desenvolvimento e manutenção do projeto, recomenda-se instalar:

| Extensão                         | Descrição                                                                 |
|----------------------------------|---------------------------------------------------------------------------|
| **ESLint**                       | Identifica e corrige problemas de estilo e erros de código                |
| **Prettier - Code formatter**    | Formata automaticamente o código                                          |
| **Docker**                       | Gerencia containers e imagens Docker                                     |
| **DotENV**                       | Destaque de sintaxe para arquivos `.env`                                 |
| **TypeScript Hero**              | Melhora navegação e organização de imports                               |
| **GitLens**                      | Potencializa o Git com histórico e insights                              |
| **REST Client** ou **Thunder Client** | Testa APIs diretamente no VS Code                                 |
| **Path Intellisense**            | Autocompleta caminhos de arquivos                                        |
| **npm Intellisense**             | Autocompleta nomes de pacotes do `package.json`                          |

---

## 🧪 Tecnologias Utilizadas

Este projeto foi desenvolvido com foco em escalabilidade, organização e boas práticas modernas de desenvolvimento backend. Abaixo estão as tecnologias utilizadas, suas versões reais e os motivos para escolhê-las:

| Tecnologia             | Versão instalada     | Justificativa de uso                                                                 |
|------------------------|----------------------|--------------------------------------------------------------------------------------|
| **Node.js**            | `v20.19.5`           | Plataforma leve e eficiente para aplicações escaláveis com I/O intensivo            |
| **npm**                | `10.8.2`             | Gerenciador de pacotes para dependências e scripts                                  |
| **TypeScript**         | `5.9.3`              | Tipagem estática, melhor organização e segurança no código                          |
| **Express**            | `5.1.0`              | Framework minimalista e flexível para criação de APIs REST                          |
| **TypeORM**            | `0.3.27`             | ORM robusto com suporte a decorators e integração nativa com TypeScript             |
| **PostgreSQL**         | `18.0`               | Banco de dados relacional confiável e seguro (via Docker)                           |
| **Docker**             | `28.5.1`             | Containerização do banco de dados para facilitar setup e portabilidade              |
| **dotenv**             | `17.2.3`             | Gerenciamento seguro de variáveis de ambiente                                       |
| **pg**                 | `8.16.3`             | Driver oficial para conexão com PostgreSQL                                          |
| **reflect-metadata**   | `0.2.2`              | Necessário para funcionamento de decorators com TypeORM                             |
| **ts-node-dev**        | `2.0.0`              | Execução automática de código TypeScript com hot reload durante desenvolvimento     |
| **@types/node**        | `24.9.2`             | Tipagens para recursos nativos do Node.js                                           |
| **@types/express**     | `5.0.5`              | Tipagens para o Express, garantindo compatibilidade com TypeScript                  |

---

## 📂 Estrutura do Projeto

```
QUIZ-APP/
├── src/
│   ├── controllers/
│   │   ├── QuestionController.ts
│   │   ├── QuizController.ts
│   │   └── UserController.ts
│   ├── database/
│   │   └── data-source.ts
│   ├── models/
│   │   ├── Question.ts
│   │   └── User.ts
│   ├── routes/
│   │   └── index.ts
│   ├── services/
│   │   ├── QuizService.ts
│   │   └── index.ts
│   └── index.ts
├── .env
├── .gitignore
├── docker-compose.yml
├── package-lock.json
├── package.json
├── tsconfig.json
├── README.md

```

---

## 📥 Instalação das Dependências

```bash
npm install
```

---

## ⚙️ Configuração do TypeScript

```json
{
  "compilerOptions": {
    "target": "ES2020",
    "module": "CommonJS",
    "rootDir": "./src",
    "outDir": "./dist",
    "strict": true,
    "esModuleInterop": true,
    "experimentalDecorators": true,
    "emitDecoratorMetadata": true
  }
}
```

---

## 🐳 Instalação do Docker e PostgreSQL

### Linux Mint

```bash
sudo apt update
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
```

### Windows

1. Baixe e instale o [Docker Desktop](https://www.docker.com/products/docker-desktop)
2. Reinicie o sistema se necessário
3. Verifique com `docker --version`

---

## 📄 Arquivos de Configuração

### `.env`

```env
DB_HOST=localhost
DB_PORT=5432
DB_USER=quizuser
DB_PASSWORD=123@Mudar
DB_NAME=quizdb
```

### `docker-compose.yml`

```yaml
version: "3.8"

services:
  postgres:
    image: postgres:latest
    container_name: quiz-db
    restart: always
    environment:
      POSTGRES_USER: quizuser
      POSTGRES_PASSWORD: 123@Mudar
      POSTGRES_DB: quizdb
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
```

### `package.json`

```json
{
  "name": "quiz-app",
  "version": "1.0.0",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC",
  "description": "",
  "dependencies": {
    "dotenv": "^17.2.3",
    "express": "^5.1.0",
    "pg": "^8.16.3",
    "reflect-metadata": "^0.2.2",
    "typeorm": "^0.3.27"
  },
  "devDependencies": {
    "@types/express": "^5.0.5",
    "@types/node": "^24.9.2",
    "ts-node-dev": "^2.0.0",
    "typescript": "^5.9.3"
  }
}
```

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/lucasitdias/quiz-app.git
cd quiz-app
```

2. Configure o `.env` conforme acima

3. Inicie o servidor:

```bash
npx ts-node-dev src/index.ts
```

---

## 🧾 Verificando os Dados no Banco

```bash
docker exec -it quiz-db psql -U quizuser -d quizdb
```

Comandos úteis:

```sql
SELECT * FROM question;
SELECT * FROM user;
```

---

## ✅ Testes Manuais com Insomnia

### Instalação

- Baixe em: [https://insomnia.rest/download](https://insomnia.rest/download)

### Endpoints para testar

| Método | Endpoint     | Descrição                        |
|--------|--------------|----------------------------------|
| POST   | `/questions` | Cadastra pergunta                |
| GET    | `/questions` | Lista perguntas                  |
| POST   | `/users`     | Cadastra usuário com pontuação   |
| GET    | `/users`     | Lista usuários                   |
| POST   | `/quiz`      | Executa quiz e calcula pontuação |

### Exemplos de requisição

**Cadastrar pergunta:**

```json
{
  "text": "Qual a capital do Brasil?",
  "answer": "Brasília",
  "points": 10
}
```

**Executar quiz:**

```json
{
  "name": "Lucas",
  "answers": [
    { "id": 1, "answer": "Brasília" },
    { "id": 2, "answer": "Maurício" }
  ]
}
```

<img width="1901" height="1077" alt="image" src="https://github.com/user-attachments/assets/8e2749a7-698f-4af4-86b4-8756809fa59b" />

---

## 📌 Observações

- Certifique-se de que o contêiner PostgreSQL esteja ativo antes de iniciar o servidor
- O projeto utiliza TypeORM para abstração do banco
- Os testes foram realizados com sucesso e validados via Insomnia
- As imagens dos testes estão incluídas no repositório para referência

---

## 🔗 Repositório

https://github.com/lucasitdias/quiz-app

---

## 👥 Autores

- RA: 2502913 — Allan Keiji Kimura
- RA: 2500298 — Evillyn Ghiovana de Oliveira Galvão
- RA: 2502267 — Lucas Luigi Dias Custodio
- RA: 2411833 — Luiz Diego Pavan
- RA: 2502501 — Gustavo Nascimento Teixeira

---
