CREATE TABLE PERSONS
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    age     INT          NOT NULL
);

INSERT INTO PERSONS(name, surname, city, age)
VALUES ('Olga', 'Sidorova', 'Tokio', '25'),
       ('Ivan', 'Ivanov', 'Kirov', '28'),
       ('Alexey', 'Petrov', 'Belgorod', '29'),
       ('Anna', 'Petrova',  'Moscow', '19'),
       ('Pavel', 'Smirnov',  'Belgorod', '28'),
       ('Alexey', 'Kovrov',  'Moscow', '30');