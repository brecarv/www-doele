# Documento de visão
# www-doele
## 1. Introdução
### 1.1 Resumo

    Texto resumindo o documento.

### 1.2 Escopo

    Texto explicando qual o escopo do projeto

## 2. Requisitos

### 2.1 Requisitos Funcionais

| Cod. | Nome | Descrição | Categoria |
| -------- | -------- | -------- | -------- |
| F01 | Cadastro de usuário | O sistema deverá permitir que os usuários possam cadastrar-se no site como doador e/ou donatário. |	Evidente|
| F02 | Cadastro institucional | O sistema deverá permitir que instituições possam cadastrar-se no site como organização doadora e/ou donatária. |	Evidente|
| F03 | Atualização de cadastro de usuário | O sistema deverá permitir que os usuários possam atualizar seus dados de cadastro. |	Evidente|
| F04 | Cadastro de campanha | O sistema deverá permitir que os usuários institucionais possam solicitar a criação de campanhas de doação/arrecadação. |	Evidente|
| F05 | Atualização de campanha cadastrada| O sistema deverá permitir que os usuários institucionais possam atualizar os dados de campanhas de doação/arrecadação cadastradas. |	Evidente|
| F06 | Cadastro de livro | O sistema deverá permitir que os usuários possam cadastrar livros no site | Evidente|
| F07 | Atualização de livro cadastrado | O sistema deverá permitir que os usuários possam atualizar informações de livros cadastrados. | Evidente|
| F08 | Buscar livros | O sistema deverá permitir que os usuários possam buscar livros no site. | Evidente|
| F09 | Confirmar interesse em um livro | O sistema deverá permitir que os usuários possam 'confirmar interesse' em um livro disponível para doação | Evidente|
| F10 | Confirmar interesse em uma campanha | O sistema deverá permitir que os usuários possam 'confirmar interesse' em colaborar para uma campanha institucional de arrecadação/doação | Evidente|
| F11 | Confirmação de transação concluída | O sistema deverá permitir que os usuários envolvidos em uma doação possam confirmar que a transação foi concluída com sucesso | Evidente|
| F12 | Avaliar transação concluída | O sistema deverá permitir usuários envolvidos em uma doação possam avaliar a transação | Evidente|
| F13 | Avaliar livro | O sistema deverá permitir que os usuários possam avaliar(review) livros | Evidente|
| F14 | Remoção de livro cadastrado | O sistema deverá permitir que os usuários possam excluir um livro já cadastrado no sistema | Evidente|


### 2.2 Requisitos não funcionais

| Cod. | Nome | Descrição | Categoria |
| -------- | -------- | -------- | -------- |
| NF01 | Aplicação Web | O sistema será  inicialmente desenvolvida para plataforma Web. | Obrigatório|
| NF02 | Play Framework | O sistema deverá ser desenvolvida utilizando o Play Framework. | Obrigatório|
| NF03 | Envio de e-mails | O Sistema poderá utilizar emails de confirmação para funções como cadastro de usuário e livros, etc. | Desejável|
| NF04 | Banco de dados | O Sistema deverá utilizar um SGBD  | Obrigatório|
| NF05 | Google Books API | O Sistema poderá utilizar a API do Google Books | Desejável|
| NF06 | Login com Redes Sociais | O Sistema poderá utilizar redes sociais como forma de login  | Desejável|


### 2.3 Tabela de Referência - Requisitos

| | NF01 | NF02 | NF03 |
| -------- | -------- | -------- | -------- |
| F01 | X | X |	|
| F02 |  | | X |

### 2.4 Diagrama Geral de Casos de Uso

![Diagrama de casos de uso](diagrama-cdu.jpeg)

### 2.5. Casos de Uso

| Cod. | Caso de Uso | Descrição | Classificação |
| -------- | -------- | -------- | -------- |
| UC01 | Cadastrar Usuário | O usuário preenche os dados solicitados no formulário de registro e recebe uma confirmação do cadastro | Primário |
| UC02 | Logar Usuário | O usuário preenche o formulário de login com o email e a senha e é autenticado no sistema | Secundário |
| UC03 | Cadastrar Livro | O usuário logado preenche os dados do livro no formulário de cadastro e recebe a confirmação de que o livro foi cadastrado com sucesso no sistema | Primário |
| UC04 | Buscar Livro | O usuário digita o nome de um livro no campo de busca | Primário |
| UC05 | Solicitar Livro | O usuário logado busca por um livro e confirma seu interesse em receber a doação | Primário |
| UC06 | Confirmar Solicitação de Livro | O usuário doador recebe uma notificação informando que um usuário demonstrou interesse em seu livro anunciado | Primário |

### 2.6. Tabela de Referência - Casos de uso & Requisitos

| | NF01 | NF02 | NF03 | F01 | F02 | F03 |
| -------- | -------- | -------- | -------- | -------- | -------- | -------- |
| UC01 | X | X | | | X | X |

### 2.7. Atores

| Ator | Descrição |
| -------- | -------- |
| | |  

## 3. Clientes

    Texto explicando quem é o cliente
