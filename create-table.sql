CREATE TABLE results(
                        id SERIAL PRIMARY KEY,
                        playerName VARCHAR(30) NOT NULL,
                        hits INTEGER,
                        misses INTEGER,
                        score INTEGER,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        deleted BOOLEAN NOT NULL DEFAULT FALSE
);