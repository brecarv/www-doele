# Especificação de Caso de Uso `Doelê`

# UC: `04 - Anuncio de livros disponiveis na API do google`
	  
## 1. Resumo

`Neste caso de uso o usuario irá anunciar um livro que está disponivel na API que utilizamos para encontrar os livros`

## 2. Atores

`Estão envolvidos neste CDU os atores: Usuario, Sistema e a API`
  
## 3. Precondições

### 3.1 `Conta no Doelê`

` O usuario deve ter uma conta no Doelê`
  
### 3.2 `Login no sistema`
  
` O usuario deve estar logado no sistema`

## 4. Pós-condições

### 4.1 `Anuncio será monstrado`

`O anuncio do livro deverá ser mostrado na tela inicial`

## 5. Pontos de Extensão

### 5.1 `Compartilhamento de Anuncio`

`O caso de uso poderá algum dia ser extendido e compartilhado em redes sociais`  

## 6. Fluxos de Evento

### 6.1 Fluxo Básico
 
1. O usuário loga no sistema 
2. O usuário clica no botão quero doar
3. O usuário busca o livro
4. O sistema retorna livro referente a busca
5. O usuário seleciona o livro que quer doar dentro dos que foram encontrados
6. O sistema preenche parte do formulário
7. O usuário finaliza o preenchimento do formulário
8. O usuário finaliza enviando o formulário
9. O CDU se encerra

### 6.2 `Usuario não tem conta`

1. O usuário tenta logar no sistema mas não possui conta
2. O usuário seleciona o botão para se registrar
3. O usuário preenche o formulário e envia
1. O usuário loga no sistema 
2. O usuário clica no botão quero doar
3. O usuário busca o livro
4. O sistema retorna livro referente a busca
5. O usuário seleciona o livro que quer doar dentro dos que foram encontrados
6. O sistema preenche parte do formulário
7. O usuário finaliza o preenchimento do formulário
8. O usuário finaliza enviando o formulário
9. O CDU se encerra

## 7. Protótipos de Interface do Caso de Uso

`imagem do protótipo, é feita na disciplina de implementação e testes`  

## 8. Diagrama de Atividades do Caso de Uso

`imagem do diagrama, feito na disciplina de análise e projeto`

## 9. Diagrama de Projeto do Caso de Uso

`imagem do diagrama de classes de projeto, feito na disciplina de análise e projeto`

## 10. Diagrama de Sequência do Caso de Uso

![Diagrama de casos de uso](dss-cdu04-anuncioLivro.png)