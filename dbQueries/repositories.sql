CREATE SCHEMA codeSage;

CREATE TABLE codeSage.repositories (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    url VARCHAR(250) NOT NULL,
    branch VARCHAR(25) DEFAULT 'main',
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE IF NOT EXISTS codesage.repositories_id_seq;

ALTER TABLE codesage.repositories ALTER COLUMN id SET DEFAULT nextval('codesage.repositories_id_seq');

ALTER SEQUENCE codesage.repositories_id_seq OWNED BY codesage.repositories.id;
