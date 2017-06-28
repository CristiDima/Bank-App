create database banca;
use banca;
CREATE TABLE admin
(
cnp varchar(13),
nume varchar(30),
prenume varchar(30),
parola varchar(4),
oras varchar(30),
telefon varchar(10)
);
INSERT INTO admin (cnp, nume, prenume, parola, oras, telefon)
VALUES (1940524282513, 'Dima','Cristian', 'abcd', 'Craiova', '0746123456');
CREATE TABLE client
(
cnp varchar(13),
nume varchar(30),
prenume varchar(30),
parola varchar(4),
oras varchar(30),
telefon varchar(10),
id int primary key auto_increment,
sold double
);
use banca;
select * from client;

