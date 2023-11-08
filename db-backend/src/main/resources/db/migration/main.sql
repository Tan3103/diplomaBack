CREATE TABLE IF NOT EXISTS users
(
    id              SERIAL PRIMARY KEY,
    first_name      VARCHAR(255),
    last_name       VARCHAR(255),
    email           VARCHAR(255) UNIQUE,
    password        VARCHAR(255),
    date_of_birth   DATE,
    profile_picture TEXT,
    role            VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS courses
(
    id            SERIAL PRIMARY KEY,
    title         VARCHAR(255),
    description   TEXT,
--     user_id     BIGINT REFERENCES users (id),
    language      VARCHAR(255),
    created_date  TIMESTAMP,
    modified_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS enrollments
(
    id              SERIAL PRIMARY KEY,
    user_id         BIGINT REFERENCES users (id),
    course_id       BIGINT REFERENCES courses (id),
    enrollment_date DATE
);

CREATE TABLE IF NOT EXISTS materials
(
    id        SERIAL PRIMARY KEY,
    course_id BIGINT REFERENCES courses (id),
    title     VARCHAR(255),
    content   TEXT,
    type      VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS reviews
(
    id        SERIAL PRIMARY KEY,
    course_id BIGINT REFERENCES courses (id),
    user_id   BIGINT REFERENCES users (id),
    rating    INTEGER,
    review    TEXT
);
