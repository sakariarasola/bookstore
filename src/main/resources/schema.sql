SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS book; 
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE category (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE book (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    pyear BIGINT NOT NULL,
    isbn BIGINT NOT NULL,
    price INT NOT NULL,
    categoryid BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (categoryid) REFERENCES category(id)

);

CREATE
SEQUENCE book_seq START
WITH 3 INCREMENT BY 1;

CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    role VARCHAR(100) NOT NULL
);

INSERT INTO category (name)
VALUES ('Horror'), ('Action'), ('Scifi');

INSERT INTO book (title, author, pyear, isbn, price, categoryid)
VALUES
    ("testi", "test", 2000, 1234567890123, 1234, 1),
    ("sql perusteet", "ada lovelace", 1850, 3210987654321, 4321, 2);

INSERT INTO users (username, password, role)
VALUES
    ("user", "$2a$10$0KjO/Sv1fLDOBXkFuTiRCuAjkhrEn/r8a3jXsCZYT.EmorAuLkHXS", "USER"),
    ("admin", "$2a$10$/IF1J8rB2gFOokEkh22y/u2ixa4YsxRzEztplp3Ft9uJN8GbDZ3GS", "ADMIN");


SELECT * FROM book;
SELECT * FROM category;
SELECT * FROM users;