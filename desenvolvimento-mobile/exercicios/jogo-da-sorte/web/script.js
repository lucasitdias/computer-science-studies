// Lista de naipes
let naipes = ["S", "H", "D", "C"]; // Espadas, Copas, Ouros, Paus
let baralho = [];

// Função para criar baralho de 52 cartas
function criarBaralho() {
  baralho = [];
  for (let n of naipes) {
    for (let v = 1; v <= 13; v++) {
      baralho.push({ valor: v, naipe: n });
    }
  }
  embaralhar(baralho); // embaralha ao criar
}

// Algoritmo de Fisher-Yates para embaralhar
function embaralhar(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
}

// Função que retorna o nome do arquivo da carta
function arquivoCarta(c) {
  let mapa = { 1: "A", 11: "J", 12: "Q", 13: "K" };
  let valor = mapa[c.valor] || c.valor;
  return `${valor}${c.naipe}.svg`;
}

// Atualiza contador de cartas restantes
function atualizarContador() {
  document.getElementById("contador").innerText =
    `Cartas restantes: ${baralho.length}`;
}

// Comprar carta do topo
function comprarCarta() {
  if (baralho.length === 0) {
    document.getElementById("saida").className = "single";
    document.getElementById("saida").innerHTML = `<p>Monte vazio!</p>
       <div class="carta"><img src="img/cartabranca.svg"></div>`;
    atualizarContador();
    return;
  }
  let c = baralho.pop();
  document.getElementById("saida").className = "single";
  document.getElementById("saida").innerHTML =
    `<div class="carta escolhida"><img src="img/${arquivoCarta(c)}"></div>`;
  atualizarContador();
}

// Exibir monte como um baralho sobreposto
function exibirMonte() {
  if (baralho.length === 0) {
    document.getElementById("saida").className = "single";
    document.getElementById("saida").innerHTML = `<p>Monte vazio!</p>
       <div class="carta"><img src="img/cartabranca.svg"></div>`;
    atualizarContador();
    return;
  }

  // Classe monte para sobreposição
  document.getElementById("saida").className = "monte";

  // Cria várias cartas viradas para baixo
  document.getElementById("saida").innerHTML = baralho
    .map(
      (_, i) =>
        `<div class="carta" style="top:${i * 2}px; left:${i * 2}px;">
         <img src="img/cartabranca.svg">
       </div>`,
    )
    .join("");

  atualizarContador();
}

// Reiniciar baralho cria e embaralha novamente
function reiniciar() {
  criarBaralho();
  document.getElementById("saida").className = "single";
  document.getElementById("saida").innerHTML = `<p>Baralho Reiniciado!</p>
     <div class="carta"><img src="img/cartabranca.svg"></div>`;
  atualizarContador();
}

// Inicializa ao carregar a página
criarBaralho();
document.getElementById("saida").className = "single";
document.getElementById("saida").innerHTML =
  `<div class="carta"><img src="img/cartabranca.svg"></div>`;
atualizarContador();
