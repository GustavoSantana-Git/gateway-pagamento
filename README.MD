# Fintech Gateway Pagamentos 🚀

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/technologies/downloads/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.x-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue?style=for-the-badge&logo=docker)](https://www.docker.com/)

Um Gateway de Pagamentos robusto e escalável, desenvolvido com foco em alta performance e segurança (PCI-DSS compliance principles). O projeto simula o processamento de transações financeiras, integração com múltiplos provedores e gestão de lojistas (merchants).

## 🛠 Tecnologias e Stack
* **Linguagem:** Java 21 (LTS) utilizando **Virtual Threads** para alta concorrência.
* **Framework:** Spring Boot 3.2+
* **Banco de Dados:** PostgreSQL 16 (via Docker).
* **Migração de Dados:** Flyway (Versionamento de schema).
* **Segurança:** Spring Security + JWT para autenticação de Merchants.
* **Performance:** Oracle GraalVM para otimização de runtime.
* **Testes:** JUnit 5, Mockito e **Testcontainers** (Postgres Real nos testes).

## 🏗 Arquitetura
O projeto segue os princípios da **Clean Architecture** e **SOLID**, dividido em:
- **Controllers:** Endpoints REST documentados com Swagger/OpenAPI.
- **Services:** Lógica de negócio e orquestração de pagamentos.
- **Providers:** Abstração para integração com diferentes adquirentes (Strategy Pattern).
- **Security:** Filtros JWT e proteção de dados sensíveis (Mascaramento de cartões).

  Desenvolvido por Gustavo Mateus - [https://www.linkedin.com/in/gustavom-santana/]