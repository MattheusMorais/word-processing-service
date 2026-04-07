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
    A backend service for processing word-based operations using a layered architecture.
    <br />
    <br />
    <a href="https://github.com/MattheusMorais/word-processing-service/issues?q=state%3Aopen%20label%3Abug">Report Bug</a>    
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## About The Project
A backend application responsible for processing and managing word-based operations, designed with a layered architecture (Controller → Service → DAO).

The system simulates a word-processing pipeline, handling user input, applying game mechanics logic, and persisting results in a PostgreSQL database.

This project focuses on clean architecture, separation of concerns, and containerized execution using Docker.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- FEATURES -->
### ✨ Features

- Layered architecture (Controller, Service, DAO)
- PostgreSQL integration
- Dockerized environment
- Input validation system
- Score persistence and ranking system

### 🏗️ Architecture
The application follows a layered architecture:

- **Controller:** Handles user input and flow control
- **Service:** Contains business logic
- **DAO:** Responsible for database access
- **Model:** Domain objects and core logic
- **Utils:** Shared utilities (input, validation, etc.)

Flow:
<div align="center">

Controller\
↓\
Service\
↓\
DAO\
↓\
PostgreSQL
</div>

### Built With

* [![Java][Java]][Java-url]
* [![PostgreSQL][PostgreSQL]][PostgreSQL-url]
* [![Docker][Docker]][Docker-url]
* [![Docker-compose][Docker-compose]][Docker-compose-url]
* [![JUnit][JUnit]][JUnit-url]
* [![Intellij][Intellij]][Intellij-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- GETTING STARTED --> 
## Getting Started


### Prerequisites

* Docker & Docker compose

    - Link para instalar no windows: https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?utm_source=docker&utm_medium=webreferral&utm_campaign=dd-smartbutton&utm_location=module
    - Link para instalar no linux: https://docs.docker.com/desktop/linux/install/
    - Link para instar no mac:

  <p align="right">(<a href="#readme-top">back to top</a>)</p>



### 🚀 Running the Project


- #### Option 1: Downloading .zip:
1. Clique em <>code -> Download ZIP e selecione a pasta Downloads
2. Extraia o arquivo .zip
3. Abra o terminal
4. Navegue até a pasta do projeto, copie e cole o comando a seguir no terminal: \
   **cd Downloads\word-processing-service-main\word-processing-service-main**
5. Inicie o banco de dados do container, copie e cole o comando a seguir no terminal: \
   **docker compose up -d db**
6. Rode a aplicação, copie e cole o comando a seguir no terminal: \
   **docker compose run --rm app**


- #### Option 2: Using git
1. Abra o terminal e digite: git clone git@github.com:MattheusMorais/word-processing-service.git
2. Navegue até a pasta do projeto, copie e cole o comando a seguir no terminal: \
   **cd word-processing-service**
3. Inicie o banco de dados do container, copie e cole o comando a seguir no terminal: \
   **docker compose up -d db**
4. Rode a aplicação, copie e cole o comando a seguir no terminal: \
   **docker compose run --rm app**

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage

After starting the application, you can:

1. Start a new game session
2. View the ranking of top scores
3. Reset stored scores (soft delete)
4. Restore deleted scores
5. Exit program

The system interacts via terminal and processes user input dynamically.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ROADMAP -->
## Roadmap

- [ ] Refactor to Spring Boot architecture
- [ ] Replace DAO with Spring Data JPA
- [ ] Implement REST API endpoints

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the Unlicense License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Matheus Morais - https://www.linkedin.com/in/mattheus-morais/ - moraism.dev@gmail.com

Project Link: https://github.com/MattheusMorais/word-processing-service

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[issues-shield]: https://img.shields.io/github/issues/MattheusMorais/word-processing-service.svg?style=for-the-badge
[issues-url]: https://github.com/MattheusMorais/word-processing-service/issues
[license-shield]: https://img.shields.io/github/license/MattheusMorais/word-processing-service.svg?style=for-the-badge
[license-url]: https://github.com/MattheusMorais/word-processing-service/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/mattheus-morais/
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/
[Docker]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/
[Docker-compose]: https://img.shields.io/badge/Docker%20Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white
[Docker-compose-url]: https://www.docker.com/
[PostgreSQL]: https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[PostgreSQL-url]: https://www.postgresql.org/
[JUnit]:https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white
[JUnit-url]: https://junit.org/
[Intellij]: https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[Intellij-url]: https://www.jetbrains.com/
[logo-img]: https://github.com/MattheusMorais/word-processing-service/blob/main/images/word-processing-service-logo.png



