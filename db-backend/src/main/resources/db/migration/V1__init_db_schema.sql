CREATE TABLE IF NOT EXISTS users
(
    id              SERIAL PRIMARY KEY,
    first_name      VARCHAR(255),
    last_name       VARCHAR(255),
    email           VARCHAR(255) UNIQUE,
    password        VARCHAR(255),
    date_of_birth   DATE,
    profile_picture TEXT
);

CREATE TABLE IF NOT EXISTS courses
(
    id            SERIAL PRIMARY KEY,
    title         VARCHAR(255),
    description   TEXT,
    price         VARCHAR(255),
    language      VARCHAR(255),
    created_date  TIMESTAMP,
    modified_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS modules
(
    id          SERIAL PRIMARY KEY,
    course_id   BIGINT REFERENCES courses (id),
    title       VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS materials
(
    id        SERIAL PRIMARY KEY,
    module_id BIGINT REFERENCES modules (id),
    step      VARCHAR(255),
    title     VARCHAR(255),
    content   TEXT,
    type      VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS quizzes
(
    id          SERIAL PRIMARY KEY,
    module_id   BIGINT REFERENCES modules (id),
    duration    timestamp,
    title       VARCHAR(255),
    instruction TEXT
);

CREATE TABLE IF NOT EXISTS questions
(
    id       SERIAL PRIMARY KEY,
    quiz_id  BIGINT REFERENCES quizzes (id),
    question VARCHAR(255),
    image    TEXT,
    answer   VARCHAR(255),
    option1  VARCHAR(255),
    option2  VARCHAR(255),
    option3  VARCHAR(255),
    option4  VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS reviews
(
    id        SERIAL PRIMARY KEY,
    course_id BIGINT REFERENCES courses (id),
    user_id   BIGINT REFERENCES users (id),
    rating    INTEGER,
    review    TEXT
);

CREATE TABLE IF NOT EXISTS enrollments
(
    id              SERIAL PRIMARY KEY,
    user_id         BIGINT REFERENCES users (id),
    course_id       BIGINT REFERENCES courses (id),
    enrollment_date DATE
);
