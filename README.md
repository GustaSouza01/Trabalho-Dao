# Sistema de Compra e Venda em Java

Projeto Java com interface gráfica em Swing e estrutura orientada a entidades para sistema de compra e venda, com tela de login, menu principal e base de dados com JDBC/DBeaver.

## Estrutura

- `src/main/java/com/trabalho/Main.java`: tela de login inicial
- `src/main/java/com/trabalho/ui/MenuPrincipalFrame.java`: menu principal do sistema
- `src/main/java/com/trabalho/SistemaCompraVenda.java`: regras de negócio
- `src/main/java/com/trabalho/Usuario.java`: usuário do sistema
- `src/main/java/com/trabalho/Cliente.java`: cliente
- `src/main/java/com/trabalho/Fornecedor.java`: fornecedor
- `src/main/java/com/trabalho/Produto.java`: produto
- `src/main/java/com/trabalho/FormaPagamento.java`: forma de pagamento
- `src/main/java/com/trabalho/Venda.java`: venda
- `src/main/java/com/trabalho/Compra.java`: compra
- `db/schema.sql`: script SQL para criação das tabelas

## Como executar

1. Abra o terminal na pasta do projeto.
2. Execute:

```bash
javac -d out -sourcepath src\main\java src\main\java\com\trabalho\Main.java
java -cp out com.trabalho.Main
```

## Credenciais padrão

- E-mail: `admin@empresa.com`
- Senha: `123`

## Observações

- O projeto foi montado em arquitetura MVC/DAO com foco em Swing + JDBC.
- A conexão com o banco pode ser feita pelo DBeaver usando o script em `db/schema.sql`.
- O projeto usa padrão Java 17 e é compatível com MySQL/PostgreSQL, ajustando a URL de conexão em uma classe de utilidade de banco.
