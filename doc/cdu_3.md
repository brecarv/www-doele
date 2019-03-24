# Especificação de Caso de Uso do Projeto Doelê

# CDU03: **Cadastrar Livro**   

## 1. Resumo

O usuário logado preenche os dados do livro no formulário de cadastro e recebe a confirmação de que o livro foi cadastrado com sucesso no sistema.

## 2. Atores

* Doador

## 3. Precondições

###  3.1 Estar logado  

O usuário precisa ter passado pelo processo de login.

## 4. Pós-condições
### 4.1 Livros e quantidades associadas ao doador

Os itens e suas respectivas quantidades serão associadas ao histórico do doador.

## 5. Pontos de Extensão

Não identificados.

## 6. Fluxos de Evento

### 6.1 Fluxo Básico

1. o ator seleciona a opção "cadastrar livros";
1. o sistema solicita a entrada de alguns dados (nome do livro, nome do autor, edição, ano e etc);
1. o ator insere os dados solicitados;
1. o sistema exibe o formulário cadastrado e pergunta se o ator deseja adicionar mais itens;
1. o ator informa que **NÃO**;
1. o CDU é finalizado e é exibido na tela principal.


### 6.2 (4A) Há um livro registrado 

1. o sistema informa que há um livro com esse nome já registrado;
1. o ator informa que deseja cadastrar;
1. o sistema retorna ao passo 4 do fluxo principal.


### 6.3 (4B) Há um livro registrado

1. o sistema informa que há um livro com esse nome já registrado;
1. o ator informa que **NÃO** deseja cadastrar;
1. o sistema retorna ao passo 6 do fluxo principal.

### 6.4 (11A) O ator deseja cadastrar mais livros

1. o ator informa que **SIM** - deseja cadastrar mais livros;
1. o sistema retorna ao passo 2 do fluxo principal.

## 7. Protótipos de Interface do Caso de Uso

`imagem do protótipo, é feita na disciplina de implementação e testes`

## 8. Diagrama de Atividades do Caso de Uso

`imagem do diagrama, feito na disciplina de análise e projeto`

## 9. Diagrama de Projeto do Caso de Uso

`imagem do diagrama de classes de projeto, feito na disciplina de análise e projeto`

## 10. Diagrama de Sequência do Caso de Uso

`imagem do diagrama, feito na disciplina de análise e projeto`
