
# Especificação de Caso de Uso do Projeto Doelê

# UC03: **Cadastrar Livro**   

## 1. Resumo

O ator logado preenche os dados do livro no **formulário de cadastro**. Nesse formulário deverá conter obrigatoriamente o *Nome do Livro*, *Autor da obra*,* Editora*, *Assunto/ Gênero*, *Quantidade* e o *Estado físico do livro (Excelente, Bom, Usado...)*.

## 2. Atores

 - Usuário Doador (Instituição ou usuário comum/leitor )

## 3. Precondições

###  3.1 Possuir uma conta no sistema

O ator necessita obrigatoriamente de uma conta no sistema para poder realizar o anúncio de doação.

###  3.2 Estar logado

O ator precisa necessariamente está logado no Doelê para ter acesso à esse CDU.

###  3.2 Precisa ter um livro

Para que tudo ocorra bem é desejável que o ator realmente tenha um livro para fazer tal doação.

## 4. Pós-condições
### 4.2 O item deverá está já disponível

Após o cadastro do livro ele já deverá está disponível para os outros usuários.

## 5. Pontos de Extensão

Não identificados.

## 6. Fluxos de Evento

### 6.1 Fluxo Básico

1. O ator seleciona a opção **Doar livro**;
2.  O sistema solicita a entrada de alguns dados (nome do livro, nome do autor, editora, assunto e etc*);
3. O ator insere os dados solicitados;
4. O ator faz o **upload** das fotos do livro;
5. O ator faz uma breve **descrição** da obra a ser doada;
6.  O sistema exibe o formulário cadastrado;
7.  O ator seleciona a opção **Registrar livro**;
8.  O sistema informa que o livro foi **cadastrado com sucesso**;
9. o CDU é finalizado e é exibido na tela do anúncio.


### 6.2 (3A) Campos não preenchidos

1. O sistema informa que ainda há informações não preenchidas;
2. O sistema retorna ao passo **2**;
3. O ator informa as informações necessárias;
4. O sistemas retorna ao passo **7**;
5. O ator seleciona novamente a opção **Registrar livro**;
6. O sistemas retorna ao passo **9**


### 6.3 (4A) Não há foto

1. O sistema informa que não há fotos associadas ao livro;
2. O sistema retorna ao passo **4**;
3. O ator faz o upload da(s) foto(s);
4. O sistema retorna ao passo **7**;
5. O ator seleciona novamente a opção **Registrar livro**;
6. O sistemas retorna ao passo **9**

## 7. Protótipos de Interface do Caso de Uso

*Esperando o merge dos protótipos para colocar*

## 8. Diagrama de Atividades do Caso de Uso

![Diagrama de caso de uso](diagrama-cdu.jpeg)

## 9. Diagrama de Projeto do Caso de Uso

O diagrama ainda não foi feito.

## 10. Diagrama de Sequência do Caso de Uso

![Diagrama de caso de uso](diagrama-cdu.jpeg)

