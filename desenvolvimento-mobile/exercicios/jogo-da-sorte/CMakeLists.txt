cmake_minimum_required(VERSION 3.10)

# Nome do projeto
project(BaralhoPilha C)

# Definir padrão do C
set(CMAKE_C_STANDARD 99)

# Incluir cabeçalhos da pasta include
include_directories(${PROJECT_SOURCE_DIR}/BaralhoPilha/include)

# Lista de arquivos
set(SOURCES
    BaralhoPilha/src/main.c
    BaralhoPilha/src/carta.c
    BaralhoPilha/src/pilha.c
    BaralhoPilha/src/utils.c
)

# Gera o executável
add_executable(BaralhoPilha ${SOURCES})