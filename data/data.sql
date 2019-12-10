
DROP TABLE IF EXISTS users;
CREATE TABLE users (
                      id INTEGER PRIMARY KEY NOT NULL,
                      username TEXT NOT NULL,
                      password TEXT NOT NULL
);


DROP TABLE IF EXISTS animals;
CREATE TABLE animals (id INTEGER primary key NOT NULL, name text, species text);


INSERT INTO users (id, username, password) VALUES (1, 'userEntity', '$2a$10$.vqKeONK..aJ1Dy1P6z5peftRXek8S0dBC4hJmiIUe8lezmO4t9nu');
INSERT INTO users (id, username, password) VALUES (2, 'admin', '$2a$10$.vqKeONK..aJ1Dy1P6z5peftRXek8S0dBC4hJmiIUe8lezmO4t9nu');
INSERT INTO users (id, username, password) VALUES (3, 'superadmin', '$2a$10$.vqKeONK..aJ1Dy1P6z5peftRXek8S0dBC4hJmiIUe8lezmO4t9nu');

INSERT INTO animals VALUES
(1, 'Bob', 'Llama'),
(2, 'Jim', 'Lemur'),
(3, 'Franklin', 'Donkey'),
(4, 'Tim', 'Mouse'),
(5, 'Joe', 'Elephant'),
(6, 'Matt', 'Monkey'),
(7, 'Mark', 'Lemur'),
(8, 'Roscoe', 'Lemur'),
(9, 'Laurel', 'Llama'),
(10, 'David', 'Monkey');