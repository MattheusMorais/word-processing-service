<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
<div align="center">

[![Issues][issues-shield]][issues-url]
[![license][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

</div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/MattheusMorais/word-processing-service">
    <img src="https://github.com/MattheusMorais/word-processing-service/blob/main/images/word-processing-service-logo.png?raw=true" alt="Logo" width="100%" height="80%">
  </a>

  <h1 align="center">Word Processing Service</h1>

  <p align="center">
Um serviço de processamento de palavras orientado a backend, projetado como um ambiente técnico para explorar práticas reais de engenharia de software, incluindo arquitetura em camadas, persistência de dados, validação e containerização.

A aplicação utiliza uma interface baseada em palavras como motor para simular um pipeline de processamento, onde as entradas são validadas, transformadas e persistidas através de camadas bem definidas do sistema.

Embora inclua uma interação de adivinhação de palavras, o foco do projeto está no design de backend, regras de negócio e padrões arquiteturais — não na jogabilidade. <br />
<br />
<a href="https://github.com/MattheusMorais/word-processing-service/issues?q=state%3Aopen%20label%3Abug">Reportar Bug</a>
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## 📖 Sobre o Projeto

**Word Processing Service** é uma aplicação backend construída para simular um pipeline de processamento de palavras, onde a entrada do usuário é validada, transformada e persistida por meio de uma arquitetura estruturada.

No núcleo do sistema, palavras são carregadas de um arquivo `wordbank.txt` e passam por diferentes estratégias de transformação com base no nível de dificuldade selecionado pelo usuário:

- **Modo Fácil:** transformação determinística (inversão da palavra)
- **Modo Difícil:** embaralhamento baseado em permutação

Embora o sistema seja exposto por uma interface de terminal, seu núcleo funciona como um motor de processamento backend.

- Separação clara de responsabilidades (Controller → Service → DAO)
- Encapsulamento das regras de negócio
- Persistência de dados com PostgreSQL
- Estratégia de soft delete (`deleted = true/false`)
- Testabilidade com JUnit
- Execução containerizada com Docker Compose

A camada de "jogo" atua apenas como um **driver para exercitar a lógica de backend**, tornando este projeto mais próximo de um **motor de processamento com gerenciamento de estado** do que um jogo tradicional.

<div align="center">
    <img src="https://github.com/MattheusMorais/word-processing-service/blob/main/images/running.png?raw=true" alt="Logo" width="50%" height="50%">
</div>

### 🛠️ Tecnologias Utilizadas

<div align="center">

[![Java][Java]][Java-url]
[![PostgreSQL][PostgreSQL]][PostgreSQL-url]
[![Docker][Docker]][Docker-url]
[![Docker-compose][Docker-compose]][Docker-compose-url]
[![JUnit][JUnit]][JUnit-url]
[![Intellij][Intellij]][Intellij-url]

</div>

<!-- FEATURES -->
### ✨ Funcionalidades

- Arquitetura em camadas (Controller, Service, DAO, Model)
- Pipeline de processamento de palavras com estratégias por dificuldade
- Persistência com PostgreSQL utilizando JDBC
- Soft delete e mecanismo de recuperação de dados
- Sistema de ranking persistido no PostgreSQL
- Ambiente containerizado com Docker Compose
- Testes unitários com JUnit (MenuValidator, GameResults)
- Entrada baseada em arquivo (`wordbank.txt`)
- Validação de entrada e controle de fluxo
- Configuração baseada em variáveis de ambiente

### 🏗️ Arquitetura

A aplicação segue uma arquitetura em camadas:

- **Controller:** gerencia entrada do usuário e fluxo
- **Service:** contém a lógica de negócio
- **DAO:** responsável pelo acesso ao banco de dados
- **Model:** objetos de domínio e lógica central
- **Utils:** utilidades compartilhadas (entrada, validação, etc.)

Fluxo:

<div align="center">

Controller\
↓\
Service\
↓\
DAO\
↓\
PostgreSQL

</div>

## 🧪 Testes

Testes unitários foram implementados utilizando JUnit para validar a lógica de negócio e a validação de entradas.

- **GameResultsTest:** cálculo de pontuação, acertos e erros
- **MenuValidatorTest:** opções de menu, validação de dificuldade e regras de nome do jogador

Os testes garantem o comportamento correto e o tratamento adequado de exceções para entradas inválidas.

<!-- GETTING STARTED --> 
## 🚀 Começando

### 📋 Pré-requisitos

* Docker e Docker Compose

- Instalar no Windows: https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe
- Instalar no Linux: https://docs.docker.com/desktop/linux/install/
- Instalar no Mac:
    - Apple Silicon: https://desktop.docker.com/mac/main/arm64/Docker.dmg
    - Intel: https://desktop.docker.com/mac/main/amd64/Docker.dmg

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

### ⚙️ Executando o Projeto

💡 Execute os comandos **em negrito** no terminal em sequência (pode copiar e colar).

#### Opção 1: Download .zip

1. Clique em `<> Code` → Download ZIP
2. Extraia o arquivo
3. Abra um terminal
4. Navegue até a pasta do projeto:  
   **cd Downloads\word-processing-service-main\word-processing-service-main**
5. Inicie o banco de dados:  
   **docker compose up -d db**
6. Execute a aplicação:  
   **docker compose run --rm app**

#### Opção 2: Usando git

1. Abra um terminal e execute:  
   **git clone git@github.com:MattheusMorais/word-processing-service.git**
2. Navegue até a pasta:  
   **cd word-processing-service**
3. Inicie o banco de dados:  
   **docker compose up -d db**
4. Execute a aplicação:  
   **docker compose run --rm app**

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- USAGE EXAMPLES -->
## 💻 Uso

A aplicação fornece uma interface via terminal para interação com o sistema.

O usuário pode:

1. Executar uma sessão de processamento de palavras (fluxo baseado em jogo)
2. Visualizar resultados persistidos (ranking)
3. Resetar dados (soft reset)
4. Restaurar registros deletados
5. Encerrar e persistir resultados da sessão

Cada interação percorre as camadas do sistema, simulando cenários reais de processamento backend.

<div align="center">
    <img src="https://github.com/MattheusMorais/word-processing-service/blob/main/images/usage.png?raw=true" alt="Logo" width="50%" height="50%">
</div>

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- ROADMAP -->
## 🚧 Roadmap

- [ ] Refatorar para arquitetura Spring Boot
- [ ] Substituir DAO por Spring Data JPA
- [ ] Implementar endpoints REST

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- LICENSE -->
## 📄 Licença

Distribuído sob a licença MIT. Veja `LICENSE.txt` para mais informações.

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- CONTACT -->
## 🤝 Contato

Matheus Morais  
LinkedIn: https://www.linkedin.com/in/mattheus-morais/  
Email: moraism.dev@gmail.com

Link do Projeto: https://github.com/MattheusMorais/word-processing-service

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
[issues-shield]: https://img.shields.io/github/issues/MattheusMorais/word-processing-service.svg?style=for-the-badge
[issues-url]: https://github.com/MattheusMorais/word-processing-service/issues
[license-shield]: https://img.shields.io/github/license/MattheusMorais/word-processing-service.svg?style=for-the-badge
[license-url]: https://github.com/MattheusMorais/word-processing-service/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/mattheus-morais/
[Java-url]: https://www.java.com/
[Docker-url]: https://www.docker.com/
[Docker-compose-url]: https://www.docker.com/
[PostgreSQL-url]: https://www.postgresql.org/
[JUnit-url]: https://junit.org/
[Intellij-url]: https://www.jetbrains.com/
