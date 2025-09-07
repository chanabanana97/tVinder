CREATE TABLE movies
(
    id                INT PRIMARY KEY,
    title             VARCHAR(255),
    overview          TEXT,
    poster_path       VARCHAR(255),
    backdrop_path     VARCHAR(255),
    release_date      DATE,
    original_language VARCHAR(50),
    popularity        DOUBLE PRECISION,
    vote_average      DOUBLE PRECISION,
    vote_count        INT,
    adult             BOOLEAN
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100),
    email    VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE sessions
(
    id         INT PRIMARY KEY,
    created_at TIMESTAMP,
    is_active  BOOLEAN,
    code       VARCHAR(255)
);

CREATE TABLE user_swipes
(
    user_id    INT,
    movie_id   INT,
    session_id INT,
    added_at   TIMESTAMP,
    PRIMARY KEY (user_id, movie_id, session_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (session_id) REFERENCES sessions (id)
);