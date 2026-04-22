---

# 📚 Aplicação de Cadastro de Alunos com PostgreSQL

Este projeto foi desenvolvido como parte de um exercício prático para armazenar dados de alunos e calcular médias de matérias usando TypeScript e PostgreSQL. A aplicação roda via terminal e salva os dados diretamente em um banco de dados PostgreSQL hospedado em um contêiner Docker.

---

## 🎯 Objetivo do Projeto

A aplicação tem o propósito de:

1. **Conectar-se** a um banco PostgreSQL em execução (preferencialmente via Docker)  
2. **Receber dados do usuário** (nome, série, idade e notas)  
3. **Executar comandos SQL** para inserir as informações na tabela `alunos`  
4. **Calcular médias** por matéria e média geral  
5. **Encerrar a conexão** de forma segura após a operação  

---

## 🚀 Funcionalidades

- Cadastro de aluno: nome, série e idade  
- Entrada de 8 notas por matéria:
  - Matemática
  - Geografia
  - História
- Cálculo automático da média de cada matéria  
- Cálculo da média geral  
- Salvamento completo no banco de dados  
- Criação automática da tabela `alunos` se não existir  

---

## 🧰 Ferramentas Necessárias

Antes de iniciar, garanta que você tenha instalado:

- [Node.js](https://nodejs.org/en/)  
- [TypeScript](https://www.typescriptlang.org/)  
- [Docker](https://www.docker.com/)  
- [PGAdmin 4](https://www.pgadmin.org/)  
- [VSCode](https://code.visualstudio.com/)  
- [Git Bash](https://gitforwindows.org/)  
- [PostgreSQL](https://www.postgresql.org/)  
- [readline-sync](https://www.npmjs.com/package/readline-sync)  
- [pg](https://www.npmjs.com/package/pg)

---

## 🛠️ Tecnologias Utilizadas

- Node.js  
- TypeScript  
- PostgreSQL  
- Docker  
- readline-sync  
- pg

---

## 📦 Pré-requisitos

Antes de iniciar, você precisa ter instalado:

- [Node.js](https://nodejs.org/en/download/) (versão recomendada: 18+)  
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)  
- [Git](https://git-scm.com/downloads)  
- [Visual Studio Code](https://code.visualstudio.com/)

---

## 🐳 Subindo o banco PostgreSQL com Docker

Abra o terminal e execute:

```bash
docker run --name postgres-aluno -e POSTGRES_USER=aluno -e POSTGRES_PASSWORD=102030 -e POSTGRES_DB=db_profedu -p 5432:5432 -d postgres:15
```

> Isso cria um contêiner com o banco de dados `db_profedu`, usuário `aluno` e senha `102030`.

---

## 📂 Estrutura do Projeto

Ao clonar ou descompactar o projeto, você encontrará algo semelhante a:

```
ExercicioBancoDeDados-main/
├── ExercicioBancoDeDados.ts       # Código-fonte principal
├── package.json                   # Metadados e dependências
├── package-lock.json              # Controle de versões
├── tsconfig.json                  # Configurações do TypeScript
└── README.md                      # Este arquivo
```

---

## 📥 Instalação das dependências

Navegue até a pasta do projeto:

```bash
cd ExercicioBancoDeDados-main
```

Instale as dependências:

```bash
npm install
npm install --save-dev ts-node @types/node
```

---

## ⚙️ Configuração do TypeScript

Certifique-se de que o arquivo `tsconfig.json` contenha:

```json
{
  "compilerOptions": {
    "target": "ES2020", // Suporte moderno de JavaScript
    "module": "Node16", // Compatível com import/export no Node.js
    "moduleResolution": "Node16", // Resolve módulos como o Node faz
    "outDir": "./dist", // Pasta de saída para arquivos compilados
    "esModuleInterop": true, // Permite importar pacotes CommonJS com 'import'
    "forceConsistentCasingInFileNames": true, // Evita erros em sistemas com case-sensitive
    "strict": true, // Ativa todas as verificações de tipo
    "skipLibCheck": true, // Ignora verificação de tipos em dependências
    "resolveJsonModule": true, // Permite importar arquivos JSON
    "typeRoots": ["./node_modules/@types"] // Diretório onde os tipos estão instalados
  }
}

```

---

## 🚀 Como Executar o Projeto

### Opção 1 — Executar direto com ts-node

```bash
npx ts-node ExercicioBancoDeDados.ts
```

### Opção 2 — Compilar e executar com Node.js

```bash
npx tsc
node dist/ExercicioBancoDeDados.js
```

Durante a execução, o terminal solicitará:

- Nome do aluno  
- Série  
- Idade  
- 8 notas para cada matéria (Matemática, Geografia, História)

Após confirmar, os dados serão salvos no banco. Você pode verificar no pgAdmin ou via terminal.

---

## 🧾 Verificando os Dados no Banco

Acesse o contêiner:

```bash
docker exec -it postgres-aluno psql -U aluno -d db_profedu
```

Dentro do psql:

```sql
SELECT * FROM alunos;
```

---

## ✅ Testes Manuais

- Execute o script e insira dados fictícios  
- Verifique se os dados aparecem corretamente no terminal  
- Confirme que os dados foram salvos no banco com `SELECT * FROM alunos`  
- Teste diferentes valores para garantir o cálculo correto das médias

---

## 📌 Observações

- O projeto não possui interface web — é uma aplicação de terminal conforme solicitado no exercício.  
- A tabela `alunos` é criada automaticamente se não existir.

---

## ⚠️ Aviso de Segurança

No arquivo principal da aplicação, as credenciais do banco estão visíveis:

```ts
const dbConfig = {
  user: 'aluno',
  host: 'localhost',
  database: 'db_profedu',
  password: '102030', // ⚠️ Atenção: prática insegura!
  port: 5432,
};
```
---

## 📚 Exercício Original

> “Crie uma API que peça:  
> - Nome do aluno  
> - Série  
> - Idade  
> - Matérias: Matemática, Geografia, História  
>
> Os dados devem ser armazenados em um banco de dados.  
> O cálculo da média das matérias também deve ser salvo.  
> Calcule a média considerando 8 provas de cada matéria.”

---

## 🔗 Repositório

[https://github.com/Allan210/Aplicacao_API_Postgres.git](https://github.com/Allan210/Aplicacao_API_Postgres.git)

---

## 👨‍💻 Autores

- RA: 2502913 — Allan Keiji Kimura  
- RA: 2500298 — Evillyn Ghiovana de Oliveira Galvão  
- RA: 2502267 — Lucas Luigi Dias Custodio

---
