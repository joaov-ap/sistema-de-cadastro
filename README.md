# Sistema de Cadastro CLI - Desafio Java

Este projeto foi desenvolvido para praticar conceitos de **Orientação a Objetos**, **Java IO**, **Streams**, **Lambdas**, **Exceções** e aplicar **boas práticas de código**. O sistema é executado via CLI (linha de comando), permitindo o cadastro e gerenciamento de usuários e perguntas de formulário de maneira simples e eficiente.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Cadastrar um usuário**: O usuário pode cadastrar informações como nome, idade e email de pessoas interessadas.
2. **Listar todos os usuários cadastrados**: Exibe uma lista de todos os usuários registrados no sistema.
3. **Cadastrar uma nova pergunta no formulário**: Permite adicionar novas perguntas que podem ser usadas em questionários ou formulários.
4. **Deletar uma pergunta do formulário**: Permite remover perguntas do formulário existente.
5. **Pesquisar um usuário**: O sistema permite pesquisar usuários por nome, idade ou email.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Java IO**: Para lidar com entradas e saídas de arquivos.
- **Streams e Lambdas**: Para processar e manipular coleções de forma eficiente.
- **Exceções**: Para o tratamento robusto de erros durante a execução.
- **Boas práticas de código**: Como coesão, responsabilidade única e reutilização.

## Requisitos

- **Java 8** ou superior
- **IDE de sua escolha** (recomendado: IntelliJ IDEA, Eclipse ou NetBeans)

## Como Executar

1. Clone este repositório:
    ```bash
    git clone https://github.com/seu-usuario/sistema-cadastro-cli.git
    ```

2. Navegue até a pasta do projeto:
    ```bash
    cd sistema-cadastro-cli
    ```

3. Compile e execute o projeto:
    ```bash
    javac -d bin src/*.java
    java -cp bin Main
    ```

4. Siga as instruções no terminal para interagir com o sistema.
