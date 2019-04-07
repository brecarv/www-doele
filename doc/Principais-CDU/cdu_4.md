
# Especificação de Caso de Uso do Projeto Doelê

# UC04: **Buscar Livro**   

## 1. Resumo

O ator *logado* ou *não* acessa a lista de anúncios e pode realizar uma busca por obras no sistema;
## 2. Atores

 - Usuário logado (Instituição ou usuário comum/leitor )
 - Ator não logado (visitante)

## 3. Precondições

###  3.1 O ator deve inserir os dados na busca
O ator deve informar no campo de busca o nome da obra ou do autor que deseja buscar.

## 4. Pós-condições
### 4.2 A lista de anúncios aparece
Deverá aparecer para o ator a lista de anúncios referente à sua busca.

## 5. Pontos de Extensão

Não identificados.

## 6. Fluxos de Evento

### 6.1 Fluxo Básico

1. O ator seleciona a opção de **Busca**;
2. O sistema solicita a entrada de um texto (*Nome da obra ou Autor*);
3. O ator insere os dados solicitados;
4. O ator selecionar a opção de **Buscar**;
5. O sistema exibe a lista de anúncios referentes à pesquisa;

### 6.2 (5A) Item não encontrado

1. O sistema informa que ainda não há anúncios referentes à essa pesquisa;
2. O sistema retorna ao passo **2**;
3. O ator informa as informações necessárias;
4. O ator volta ao passo **4**;
5. O sistemas retorna ao passo **5**

## 7. Protótipos de Interface do Caso de Uso

*Esperando o merge dos protótipos para colocar*

## 8. Diagrama de Atividades do Caso de Uso


## 9. Diagrama de Projeto do Caso de Uso

O diagrama ainda não foi feito.

## 10. Diagrama de Sequência do Caso de Uso

![Diagrama de caso de uso](diagrama-cdu.jpeg)

