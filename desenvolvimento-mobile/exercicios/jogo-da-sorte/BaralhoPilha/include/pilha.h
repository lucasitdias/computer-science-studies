#ifndef PILHA_H
#define PILHA_H

#include "carta.h"

#define MAX 52 // tamanho máximo da pilha baralho

// Struct que representa a pilha de cartas
typedef struct
{
  Carta cartas[MAX];
  int topo; // índice do topo da pilha
} Pilha;

// Funções da pilha
void inicializarPilha(Pilha *p);
int pilhaVazia(Pilha *p);
int pilhaCheia(Pilha *p);
void empilhar(Pilha *p, Carta c);
Carta desempilhar(Pilha *p);
void exibirPilha(Pilha *p);

#endif