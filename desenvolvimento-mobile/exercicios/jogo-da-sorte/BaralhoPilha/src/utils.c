#include <stdlib.h>
#include <time.h>
#include "utils.h"

// Função que embaralha o vetor de cartas
void embaralhar(Carta baralho[], int tamanho)
{
    srand((unsigned)time(NULL)); // Inicializa o gerador de números aleatórios
    for (int i = tamanho - 1; i > 0; i--)
    {
        int j = rand() % (i + 1); // Sorteia uma posição aleatória
        // Troca a carta da posição
        Carta temp = baralho[i];
        baralho[i] = baralho[j];
        baralho[j] = temp;
    }
}