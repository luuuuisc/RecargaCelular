## Projeto de Simulação de Recarga de Celular com Spring Boot e RabbitMQ
# Visão Geral
Este projeto simula um sistema de recarga de celular integrando uma API REST criada com Spring Boot e mensageria com RabbitMQ. O fluxo completo abrange desde a recepção de uma solicitação de recarga via Postman até o processamento da mesma através de serviços de mensageria.

## Fluxo do Sistema
# Recepção da Solicitação:

O usuário envia uma solicitação de recarga via Postman, fornecendo os detalhes necessários como o valor da recarga e o número do telefone em formato JSON.

# Processamento pelo Controller:

O RechargeController recebe a solicitação, transforma os dados de JSON para um DTO (Data Transfer Object) que é então passado para o serviço de processamento.
Integração com RabbitMQ:

Após o processamento inicial, o serviço envia a recarga para uma fila do RabbitMQ usando RabbitTemplate, que depois é consumida por um RabbitListener.
Consumo e Finalização:

O consumidor (RabbitListener) processa a recarga, verifica a validade dos dados e atualiza o banco de dados com o resultado da operação.
Tecnologias Utilizadas

Spring Boot: Para criar a API REST e gerenciar a inversão de controle e injeção de dependências.
RabbitMQ: Para gerenciar a comunicação assíncrona entre diferentes partes do serviço.
H2 Database: Banco de dados em memória para fácil teste e demonstração.
Hibernate: Para ORM e interação com o banco de dados.

## Como Executar
# Para testar este projeto:

- Clone o repositório.
- Configure o RabbitMQ local ou use uma instância cloud.
- Execute o projeto através do Spring Boot.
- Envie solicitações de recarga através do Postman para o endpoint definido.
  
## Contribuições
Contribuições são bem-vindas! Se você tem ideias para melhorar a aplicação ou correções de bugs, sinta-se à vontade para criar um pull request ou abrir uma issue.
