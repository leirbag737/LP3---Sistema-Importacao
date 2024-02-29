# Sistema Importação - Backend

## Descrição
Este repositório contém o código para um sistema de importação de Clientes desenvolvido para a disciplina LP3 (Linguagem de Programação 3). O sistema permite a importação de um arquivo txt para um banco de dados MySQL.

## Funcionalidades
- Leitura de arquivo txt.
- Importação dos dados para o banco de dados MySQL.

## Instalação
1. Clone o repositório para o seu computador:
```
git clone https://github.com/leirbag737/LP3---Sistema-Importacao.git
```
2. Acesse o diretório do projeto:
```
cd LP3---Sistema-Importacao
```
3. Instale as dependências do projeto:
```
mvn install
```
4. Crie o banco de dados MySQL e configure a conexão no arquivo `application.properties`.

## Execução
1. Inicie o servidor de banco de dados.
2. Execute o comando:
```
mvn spring-boot:run
```
3. Acesse a aplicação na URL  `http://localhost:8080/clientes`.
- Essa URL irá mostrar os clientes cadastrados no banco de dados.

## Uso
1. Para realizar a importação de Clientes é preciso acessar a URL:  `http://localhost:8080/clientes/importar?path=` e em seguida adicionar o caminho do arquivo txt.
   
### Observações:
- O arquivo txt deve estar formatado de acordo com a estrutura do banco de dados.

## Melhorias
- Tratar as exceções com mensagens especificas.
- Criar uma interface gráfica.
