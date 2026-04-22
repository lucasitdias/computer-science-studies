#ifndef CARTA_H
#define CARTA_H

// Struct que representa uma carta
typedef struct
{
    int valor;      // 1 a 13 Ás até o Rei
    char naipe[10]; // Nome do naipe Ouro, Espada, Copas, Paus
} Carta;

// Função para imprimir uma carta
void imprimirCarta(Carta c);

#endif
