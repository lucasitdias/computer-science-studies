#include <stdio.h>
#include <string.h>
#include <locale.h>
#include "carta.h"
#include "pilha.h"
#include "utils.h"

int main()
{
    setlocale(LC_ALL, "Portuguese");

    Pilha monte;
    inicializarPilha(&monte); // Inicializa a pilha vazia

    // Criar baralho com 52 cartas 4 naipes e 13 valores
    Carta baralho[52];
    char *naipes[] = {"Ouro", "Espada", "Copas", "Paus"}; // Lista os naipes
    int k = 0;
    for (int i = 0; i < 4; i++)
    {
        for (int v = 1; v <= 13; v++)
        {
            baralho[k].valor = v;                                            // Define o valor da carta
            strcpy_s(baralho[k].naipe, sizeof(baralho[k].naipe), naipes[i]); // Copia o nome do naipe
            k++;
        }
    }

    // Embaralhar o baralho
    embaralhar(baralho, 52);

    // Empilhar todas as cartas embaralhadas no monte
    for (int i = 0; i < 52; i++)
    {
        empilhar(&monte, baralho[i]);
    }

    int opcao;
    do
    {
        // Menu principal
        printf("\n--- MENU ---\n");
        printf("1 - Comprar carta (desempilhar)\n");
        printf("2 - Exibir monte\n");
        printf("3 - Sair\n");
        printf("Escolha: ");
        scanf_s("%d", &opcao);

        if (opcao == 1)
        {
            if (estaVazia(&monte))
            {
                printf("Monte vazio!\n");
            }
            else
            {
                Carta c = desempilhar(&monte);
                printf("Você comprou: ");
                imprimirCarta(c);
            }
        }

        else if (opcao == 2)
        {
            // Exibir todas as cartas restantes no monte
            printf("Cartas no monte:\n");
            exibirPilha(&monte);
        }
    } while (opcao != 3); // Continua até o usuário escolher sair

    return 0;
}