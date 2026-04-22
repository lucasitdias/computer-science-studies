#include <stdio.h>
#include "pilha.h"

// Inicializa a pilha
void inicializarPilha(Pilha *p)
{
    p->topo = -1;
}

// Verifica se a pilha está vazia
int pilhaVazia(Pilha *p)
{
    return p->topo == -1;
}

// Verifica se a pilha está cheia
int pilhaCheia(Pilha *p)
{
    return p->topo == MAX - 1;
}

// Empilha uma carta no topo
void empilhar(Pilha *p, Carta c)
{
    if (!pilhaCheia(p))
    {
        p->cartas[++p->topo] = c;
    }
    else
    {
        printf("Pilha cheia!\n");
    }
}

// Desempilha uma carta do topo
Carta desempilhar(Pilha *p)
{
    if (!pilhaVazia(p))
    {
        return p->cartas[p->topo--];
    }
    else
    {
        printf("Pilha vazia!\n");
        Carta c = {0, "Nenhum"}; // Retorna carta vazia
        return c;
    }
}

// Exibe todas as cartas da pilha do topo até o inicio da base
void exibirPilha(Pilha *p)
{
    if (pilhaVazia(p))
    {
        printf("Monte vazio!\n");
        return;
    }
    for (int i = p->topo; i >= 0; i--)
    {
        imprimirCarta(p->cartas[i]);
    }
}