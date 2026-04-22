// api_aluno_completo.js
// ----------------------------------------------------
// Exercício completo:
// - Solicita nome, série, idade
// - Solicita 8 notas de cada matéria (Matemática, Geografia, História)
// - Calcula média de cada matéria
// - Armazena tudo no PostgreSQL
// ----------------------------------------------------
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g = Object.create((typeof Iterator === "function" ? Iterator : Object).prototype);
    return g.next = verb(0), g["throw"] = verb(1), g["return"] = verb(2), typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
// Importação das bibliotecas
var Pool = require('pg').Pool;
var readlineSync = require('readline-sync');
// ----------------------------------------------------
// CONFIGURAÇÕES DO BANCO DE DADOS
// ----------------------------------------------------
var dbConfig = {
    user: 'aluno',
    host: 'localhost',
    database: 'db_profedu',
    password: '102030',
    port: 5432,
};
// ----------------------------------------------------
// CONEXÃO
// ----------------------------------------------------
var pool = new Pool(dbConfig);
// ----------------------------------------------------
// FUNÇÃO PRINCIPAL
// ----------------------------------------------------
function cadastrarAluno() {
    return __awaiter(this, void 0, void 0, function () {
        // ----------------------------------------------------
        // Função auxiliar para ler notas e calcular média
        // ----------------------------------------------------
        function calcularMedia(nomeMateria) {
            console.log("\n--- ".concat(nomeMateria, " ---"));
            var soma = 0;
            for (var i = 1; i <= 8; i++) {
                var nota = readlineSync.questionFloat("Digite a nota ".concat(i, ": "));
                soma += nota;
            }
            var media = soma / 8;
            console.log("M\u00E9dia de ".concat(nomeMateria, ": ").concat(media.toFixed(2)));
            return media;
        }
        var nome, serie, idade, createTableQuery, mediaMatematica, mediaGeografia, mediaHistoria, insertQuery, values, error_1;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    console.log("\n--- Cadastro de Aluno ---");
                    nome = readlineSync.question('Nome do aluno: ');
                    serie = readlineSync.question('Série: ');
                    idade = readlineSync.questionInt('Idade: ');
                    createTableQuery = "\n    CREATE TABLE IF NOT EXISTS alunos (\n      id SERIAL PRIMARY KEY,\n      nome TEXT NOT NULL,\n      serie TEXT NOT NULL,\n      idade INT NOT NULL,\n      media_matematica NUMERIC(5,2),\n      media_geografia NUMERIC(5,2),\n      media_historia NUMERIC(5,2)\n    );\n  ";
                    return [4 /*yield*/, pool.query(createTableQuery)];
                case 1:
                    _a.sent();
                    mediaMatematica = calcularMedia("Matemática");
                    mediaGeografia = calcularMedia("Geografia");
                    mediaHistoria = calcularMedia("História");
                    _a.label = 2;
                case 2:
                    _a.trys.push([2, 4, 5, 7]);
                    console.log("\nSalvando dados no banco...");
                    insertQuery = "\n      INSERT INTO alunos (nome, serie, idade, media_matematica, media_geografia, media_historia)\n      VALUES ($1, $2, $3, $4, $5, $6)\n    ";
                    values = [nome, serie, idade, mediaMatematica, mediaGeografia, mediaHistoria];
                    return [4 /*yield*/, pool.query(insertQuery, values)];
                case 3:
                    _a.sent();
                    console.log("\n-----------------------------------");
                    console.log("Aluno cadastrado com sucesso!");
                    console.log("Nome: ".concat(nome));
                    console.log("S\u00E9rie: ".concat(serie));
                    console.log("Idade: ".concat(idade));
                    console.log("M\u00E9dias => Matem\u00E1tica: ".concat(mediaMatematica.toFixed(2), ", Geografia: ").concat(mediaGeografia.toFixed(2), ", Hist\u00F3ria: ").concat(mediaHistoria.toFixed(2)));
                    console.log("-----------------------------------");
                    return [3 /*break*/, 7];
                case 4:
                    error_1 = _a.sent();
                    console.error("Erro ao salvar no banco:", error_1);
                    return [3 /*break*/, 7];
                case 5: return [4 /*yield*/, pool.end()];
                case 6:
                    _a.sent();
                    console.log("\nConexão com o banco encerrada.");
                    return [7 /*endfinally*/];
                case 7: return [2 /*return*/];
            }
        });
    });
}
// ----------------------------------------------------
// EXECUÇÃO
// ----------------------------------------------------
cadastrarAluno();
