CREATE DATABASE BIBLIOTECA;
USE BIBLIOTECA; 




CREATE TABLE FUNCIONARIOS (
ID INT PRIMARY KEY AUTO_INCREMENT, 
NOME VARCHAR (200)


);

INSERT INTO FUNCIONARIOS (
NOME)
VALUES (
"RODOLFO");

SELECT * FROM FUNCIONARIOS;

CREATE TABLE LIVROS (
ID INT AUTO_INCREMENT PRIMARY KEY,
NOME VARCHAR(255) NOT NULL,
CATEGORIA VARCHAR(50) NOT NULL
);
DROP TABLE LIVROS;
SELECT * FROM LIVROS;

INSERT INTO LIVROS (
NOME, CATEGORIA )
VALUES (
"A Cadeira de Cristal", "Fantasia"
); 
DROP TABLE LIVROS;

CREATE TABLE USER_COMUM (
ID INT AUTO_INCREMENT PRIMARY KEY,
NOME VARCHAR(255) NOT NULL,
DATA_NASCIMENTO DATE,
RUA VARCHAR(255) NOT NULL,
NUMERO INT NOT NULL,
BAIRRO VARCHAR(100) NOT NULL,
EMAIL VARCHAR(100) NOT NULL,
TELEFONE VARCHAR(14)
);

INSERT INTO USER_COMUM (
NOME, DATA_NASCIMENTO, RUA, NUMERO, BAIRRO, EMAIL, TELEFONE )
VALUES 
("SABRINA", "1999-03-05" , "Rua da Goiaba", 42, "Bairro do Limoeiro", "sabriinag_silva@hotmail.com", "1196478-8902"), 
("SILAS", "2000-01-30", "Rua dos Girassóis", 59, "Bairro Jardim Helena", "silas-rodrigues2010@bol.com.br", "119382-64191");

DELETE FROM PESSOAS WHERE ID=4;
UPDATE PESSOAS SET ID=2 WHERE ID=5;

CREATE TABLE AVALIACOES (
ID INT AUTO_INCREMENT PRIMARY KEY,
AVALIACAO INT NOT NULL,  
ID_LIVRO INT NOT NULL,
ID_USUARIO INT NOT NULL
);
ALTER TABLE AVALIACOES ADD ID INT AUTO_INCREMENT PRIMARY KEY;

INSERT INTO AVALIACOES (
AVALIACAO, ID_LIVRO, ID_USUARIO)
VALUES (8, 2, 1), (2, 1, 2);

SELECT * FROM USER_COMUM;
SELECT * FROM LIVROS;
SELECT * FROM AVALIACOES;