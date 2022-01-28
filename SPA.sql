create database SPA;
use SPA;
create table vehiculos(
id int(10) not null auto_increment,
placa varchar(6) not null,
propietario varchar(60) not null,
tipovehiculo varchar(30) not null,
horaentrada datetime not null,
horasalida datetime,
valorpagado float,
estado varchar(13) not null,
primary key(id));
