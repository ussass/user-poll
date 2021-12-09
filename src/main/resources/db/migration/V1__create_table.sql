CREATE TABLE poll
(
    id          BIGSERIAL    NOT NULL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    start_date  BIGINT       NOT NULL,
    end_date    BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS questions
(
    id          BIGSERIAL    NOT NULL PRIMARY KEY,
    text        VARCHAR(255) NOT NULL,
    type        VARCHAR(255) NOT NULL,
    "poll_id"   BIGINT REFERENCES poll (id)
);

CREATE TABLE answers
(
    id            BIGSERIAL    NOT NULL PRIMARY KEY,
    user_id       BIGINT       NOT NULL,
    text          VARCHAR(255) NOT NULL,
    type          VARCHAR(255) NOT NULL,
    "poll_id"     BIGINT REFERENCES poll (id),
    "question_id" BIGINT REFERENCES questions (id)
);
