---

## 📚 Sistema de Editoras

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos, com foco em estrutura modular, persistência de dados e menus interativos. O sistema permite gerenciar informações de editoras, livros e autores, aplicando os conceitos fundamentais de POO, refatoração, validação de dados e organização de código.

---

## 🧠 Objetivo da Entrega

Entregar um CRUD completo e validado para a entidade **Editora**, conforme as seguintes orientações:

### Regras obrigatórias:

- **Conteúdo entregue**:
  - Classe base (`Editora`)
  - Classe banco (`EditoraRepository`)
  - Menu interativo (`Menu`)
  - Método principal (`Main`)

- **Operações implementadas**:
  - Inserir
  - Alterar
  - Excluir
  - Pesquisar
  - Imprimir todos
  - Contar itens cadastrados

- **Validações aplicadas**:
  - O ID da editora não pode ser negativo ou zero
  - O nome da editora não pode ser nulo, vazio ou com menos de 3 caracteres

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Terminal Linux (ZSH ou Git Bash)
- Visual Studio Code
- Estrutura de dados: `List<T>`
- Persistência em arquivos `.txt`

---

## 📁 Estrutura do Projeto

```
SistemaEditoras/
├── bin/                      # Arquivos compilados (.class)
│   ├── model/                # Autor.class, Livro.class, Editora.class
│   ├── repository/           # Repositórios compilados
│   ├── utils/                # ArquivoUtil.class
│   ├── view/                 # Menu.class
│   └── SistemaEditoras/      # Main.class
├── dados/                    # Arquivos de persistência (.txt)
│   ├── editoras.txt
│   ├── livros.txt
│   └── autores.txt
├── src/                      # Código-fonte
│   ├── model/                # Editora.java, Livro.java, Autor.java
│   ├── repository/           # EditoraRepository.java, etc.
│   ├── utils/                # ArquivoUtil.java
│   ├── view/                 # Menu.java
│   └── SistemaEditoras/      # Main.java
└── README.md                 # Documentação do projeto
```

---

## 🚀 Como Executar

### 1. Compilar o projeto

```bash
find SistemaEditoras/src -name "*.java" > sources.txt
javac -d bin @sources.txt
rm sources.txt
```

### 2. Executar o sistema

```bash
java -cp bin SistemaEditoras.Main
```

---

## 📋 Funcionalidades

### Menu Principal

```
=== MENU PRINCIPAL ===
1. Editoras
2. Livros
3. Autores
0. Sair
```

### Submenu: Editoras

```
--- MENU EDITORAS ---
1. Inserir
2. Alterar
3. Excluir
4. Pesquisar
5. Imprimir todas
6. Contar editoras
```

### Submenu: Livros

```
--- MENU LIVROS ---
1. Inserir
2. Alterar
3. Excluir
4. Pesquisar
```

### Submenu: Autores

```
--- MENU AUTORES ---
1. Inserir
2. Alterar
3. Excluir
4. Pesquisar
```

---

## 💾 Persistência

Os dados são salvos automaticamente em arquivos `.txt`:

```
SistemaEditoras/dados/editoras.txt
SistemaEditoras/dados/livros.txt
SistemaEditoras/dados/autores.txt
```

Formato de cada linha:

```
id;nome;sigla;observacoes
```

Exemplo:

```
1;Editora Lucas;EL;Editora técnica
```

Ao reiniciar o sistema, os dados são carregados automaticamente. Linhas inválidas são ignoradas com aviso no terminal.

---

## ✅ Requisitos

- Projeto individual e modular
- Aplicação de POO com refatoração
- Menus interativos com dois níveis
- Persistência em memória e arquivos
- Métodos de inserção, alteração, exclusão e pesquisa
- Estrutura compatível com modelo relacional
- Validação de regras de negócio na classe base
- Tratamento de exceções ao carregar dados inválidos

---

## 🔧 Dicas Úteis para Execução

### 💻 Comandos de Terminal

- **Limpar o terminal antes de compilar ou executar**
  ```bash
  clear
  ```

- **Verificar se há arquivos `.class` antigos**
  ```bash
  ls bin/**/*.class
  ```

- **Apagar arquivos `.class` antes de recompilar (limpeza total)**
  ```bash
  rm -rf bin/*
  ```

- **Visualizar conteúdo dos arquivos `.txt` com paginação**
  ```bash
  less SistemaEditoras/dados/editoras.txt
  ```

- **Buscar rapidamente por uma editora no arquivo**
  ```bash
  grep "Editora Lucas" SistemaEditoras/dados/editoras.txt
  ```

- **Verificar se há erros de compilação**
  ```bash
  javac -d bin src/**/*.java
  ```

- **Abrir o projeto no VS Code via terminal**
  ```bash
  code .
  ```

---

### 🧪 Criar script de execução automática

Crie um arquivo `run.sh` com:

```bash
#!/bin/bash
find src -name "*.java" > sources.txt
javac -d bin @sources.txt
rm sources.txt
java -cp bin SistemaEditoras.Main
```

Torne o script executável:

```bash
chmod +x run.sh
./run.sh
```
---

### 🧩 Extensões recomendadas para VS Code

- **Java Extension Pack** (Microsoft)
- **Code Runner** (executa trechos de código)
- **Error Lens** (destaca erros em tempo real)
- **GitLens** (controle de versão avançado)

---

## 📌 Observações

- A tabela associativa `tblautoreslivros` será implementada em fases futuras.
- O projeto está pronto para evoluir para banco de dados relacional ou interface gráfica.
- O menu de livros e autores está funcional.
- Foco da entrega é o CRUD completo da entidade `Editora`.

---

## 👨‍💻 Autor

- **Lucas Luigi Dias Custodio**
- RA: 2502267
- Desenvolvedor Java | Estudante de Ciência da Computação
- GitHub: [@lucasitdias](https://github.com/lucasitdias)

---

