
DROP TABLE IF EXISTS users;
CREATE TABLE users (
                      id INTEGER PRIMARY KEY NOT NULL,
                      username TEXT NOT NULL,
                      password TEXT NOT NULL
);


DROP TABLE IF EXISTS animals;
CREATE TABLE animals (id INTEGER primary key NOT NULL, name text, species text);


INSERT INTO users (id, username, password) VALUES (1, 'first', '$2a$10$5/fmwytdw4KWktAEkIGLOO7tQ2nNbPkJGd93PTERLDwv9HgwxpUKa');
INSERT INTO users (id, username, password) VALUES (2, 'second', '$2a$10$/yMschDjADVD7koTstVrFOQY3rkY6bRbzexs4WUHb5jjVS8Ff/XTC');
INSERT INTO users (id, username, password) VALUES (3, 'third', '$2a$10$5vy6oFRVrY1Or3cBdxYjouLr/CATE41TTCwyBJaavxK3wdXc3UWFi');

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