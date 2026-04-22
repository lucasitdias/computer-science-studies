---
# 🎲 Jogo da Sorte

## Resumo
Projeto desenvolvido como atividade prática de Estruturas de Dados, com foco na implementação de pilha em C. A interface web foi criada como complemento para visualização e interação com o baralho.  

---

## 📖 Descrição
A aplicação simula um **baralho de 52 cartas** (4 naipes × 13 valores), permitindo operações de **empilhar (sortear)**, **desempilhar (comprar)** e **exibir o monte**.  
O projeto foi construído em duas camadas:  

- **Backend em C** → responsável pela lógica da pilha, sorteio aleatório e manipulação das cartas.  
- **Frontend Web (HTML, CSS, JS)** → responsável pela interface gráfica, exibição das cartas e interação com o usuário.  

---

## 🎯 Cenário

1. Considere 52 cartas (4 naipes: Ouro ♦, Espada ♠, Copas ♥, Paus ♣).  
2. Cada naipe contém valores de 1 a 13 (Ás, 2–10, Valete, Dama, Rei).  
3. A aplicação deve conter as operações:  
   - **Sortear/Empilhar cartas** → gerar e embaralhar as 52 cartas.  
   - **Comprar/Desempilhar carta** → retirar a carta do topo e exibir.  
   - **Exibir monte** → mostrar todas as cartas restantes no baralho.  
4. Ao final do sorteio, as cartas devem estar aleatórias.  

---

##  Realizado
- Implementação de **pilha sobre estrutura linear (vetor)** com **structs** em C.  
- Utilização do algoritmo **Fisher-Yates** para sorteio aleatório.  
- Integração com frontend para visualização dinâmica.  

---

## 🛠️ Tecnologias e Ferramentas
### 🔹 Backend
  - Linguagem C.
  - Estrutura `struct Carta { int valor; char naipe; }`  
  - Vetor para representar a pilha de cartas.  
  - Makefile e CMake para automação de build.
  - Funções modularizadas:
    - `criarBaralho()`  
    - `embaralhar()`  
    - `comprarCarta()`  
    - `exibirMonte()`  

### 🔹 Frontend
- **HTML5** → estrutura da página.  
- **CSS3** → estilização, DOM/Grid/Flexbox/Pilha, efeitos visuais.
- **JavaScript** → lógica de interação:
  - Criação e embaralhamento do baralho.  
  - Exibição de carta escolhida com sombra.  
  - Atualização dinâmica do contador.
  
---

## 📂 Estrutura do Projeto
```
/BaralhoPilha
 ├── include/              # Cabeçalhos e definições
 │    ├── carta.h          # Estrutura e funções da carta
 │    ├── pilha.h          # Estrutura da pilha e operações
 │    └── utils.h          # Funções utilitárias
 │
 ├── src/                  # Código-fonte em C
 │    ├── carta.c          # Implementação das funções da carta
 │    ├── pilha.c          # Implementação das operações da pilha
 │    ├── utils.c          # Implementação das funções auxiliares
 │    └── main.c           # Função principal (menu e execução)
 │
 ├── build/                # Saída da compilação (binários/objetos)
 │
 ├── Makefile              # Automação de build
 ├── CMakeLists.txt        # Configuração alternativa de build com CMake
 │
 ├── web/                  # Parte frontend (interface gráfica)
 │    ├── index.html       # Estrutura da aplicação web
 │    ├── style.css        # Estilos visuais (mesa, cartas, botões)
 │    ├── script.js        # Lógica do jogo (sorteio, contador)
 │    └── img/             # Imagens das cartas (SVG)
 │
 └── README.md             # Documentação completa do projeto
```

---

## ⚖️ Licença
Este projeto está licenciado sob a **Apache License 2.0**.  
Você pode usar, modificar e distribuir livremente, desde que mantenha os termos da licença.  

---

## 📸 Resultado Final!
- **Comprar carta** → carta aparece centralizada com borda e sombra.  
- **Exibir monte** → baralho virado para baixo (grid ou pilha sobreposta).  
- **Reiniciar** → mensagem “Baralho reiniciado!” acima da carta branca e contador atualizado.  

---
