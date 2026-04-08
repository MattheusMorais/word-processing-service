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
A backend-driven word processing service designed as a technical sandbox to explore real-world software engineering practices, including layered architecture, data persistence, validation, and containerization.

The application uses a word-based interface as a driver to simulate a processing pipeline, where inputs are validated, transformed, and persisted through well-defined system layers.

Although it includes a word-guessing interaction, the focus of the project is on backend design, business rules, and architectural patterns — not gameplay.  <br />
<br />
<a href="https://github.com/MattheusMorais/word-processing-service/issues?q=state%3Aopen%20label%3Abug">Report Bug</a>
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## 📖 About The Project

**Word Processing Service** is a backend application built to simulate a word-processing pipeline, where user input is validated, transformed, and persisted through a structured architecture.

At its core, the system processes words loaded from a `wordbank.txt` file and applies different transformation strategies based on user-selected difficulty levels:

- **Easy mode:** deterministic transformation (word reversal)
- **Hard mode:** permutation-based scrambling

Although the system is exposed through a terminal-based interface, its core is structured as a backend processing engine.

- Clean separation of concerns (Controller → Service → DAO)
- Encapsulation of business rules
- Data persistence with PostgreSQL
- Soft delete strategies (`deleted = true/false`)
- Testability with JUnit
- Containerized execution with Docker Compose


<div align="center">
    <img src="https://github.com/MattheusMorais/word-processing-service/blob/main/images/running.png?raw=true" alt="Logo" width="50%" height="50%">
</div>

### 🛠️ Built With

<div align="center">

[![Java][Java]][Java-url] [![PostgreSQL][PostgreSQL]][PostgreSQL-url] [![Docker][Docker]][Docker-url] [![Docker-compose][Docker-compose]][Docker-compose-url] [![maven][maven]][maven-url] [![JUnit][JUnit]][JUnit-url] [![Intellij][Intellij]][Intellij-url]
</div>

<!-- FEATURES -->
### ✨ Features

- Layered architecture (Controller, Service, DAO, Model)
- Word processing pipeline with difficulty-based strategies
- PostgreSQL persistence with JDBC
- Soft delete and data recovery mechanism
- Ranking system persisted in PostgreSQL
- Containerized environment with Docker Compose
- Unit testing with JUnit (MenuValidator, GameResults)
- File-based input (`wordbank.txt`)
- Input validation and flow control
- Environment-based configuration

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

## 🧪 Testing

Unit tests were implemented using JUnit to validate core business logic and input validation.

- **GameResultsTest:** score calculation, hits and misses tracking
- **MenuValidatorTest:** menu options, difficulty validation, and player name rules

The tests ensure correct behavior and proper exception handling for invalid inputs.


<!-- GETTING STARTED --> 
## 🚀 Getting Started

### 📋 Prerequisites

* Docker e Docker Compose

    - Windows/Mac: https://www.docker.com/products/docker-desktop/
    - Linux: https://docs.docker.com/desktop/setup/install/linux/
     
* Git
    - Windows/Linux/Mac: https://git-scm.com/install/


  <p align="right">(<a href="#readme-top">back to top</a>)</p>



### ⚙️ Running the Project

💡 Run the following **bold** commands in your terminal in sequence(you can copy and paste them).

1. Open a terminal and paste: **git clone https://github.com/MattheusMorais/word-processing-service.git**
2. Navigate to the project folder: **cd word-processing-service**
3. Start container database: **docker compose up -d db**
4. Run the application: **docker compose run --rm app**

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## 💻 Usage

The application provides a terminal-based interface to interact with the processing system.

Users can:

1. Execute a word processing session (game-driven flow)
2. View persisted results (ranking)
3. Soft reset stored data
4. Restore previously deleted records
5. Exit and persist session results

Each interaction triggers a flow through the system layers, simulating real-world backend processing scenarios.

<div align="center">
    <img src="https://github.com/MattheusMorais/word-processing-service/blob/main/images/usage.png?raw=true" alt="Logo" width="50%" height="50%">
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ROADMAP -->
## 🚧 Roadmap

- [ ] Refactor to Spring Boot architecture
- [ ] Replace DAO with Spring Data JPA
- [ ] Implement REST API endpoints

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## 📄 License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## 🤝 Contact

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
[maven]:https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[maven-url]:https://maven.apache.org/

