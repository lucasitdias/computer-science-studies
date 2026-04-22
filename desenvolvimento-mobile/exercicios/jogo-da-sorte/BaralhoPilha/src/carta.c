#include <stdio.h>
#include "carta.h"

// Exibe uma carta valor + naipe
void imprimirCarta(Carta c)
{
    char *nomeValor; // armazenar o nome do valor da carta

    // Verifica valores
    switch (c.valor)
    {
    case 1:
        nomeValor = "Ás";
        break;
    case 11:
        nomeValor = "Valete";
        break;
    case 12:
        nomeValor = "Dama";
        break;
    case 13:
        nomeValor = "Rei";
        break;
    default:
    {
        static char buffer[3];
        sprintf_s(buffer, sizeof(buffer), "%d", c.valor);
        nomeValor = buffer;
    }
    }

    // Exibe a carta
    printf("%s de %s\n", nomeValor, c.naipe);
}