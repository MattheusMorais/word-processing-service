copy .env.example .env
.\mvnw.cmd clean package
docker compose up -d db
docker compose build app
docker compose run app
