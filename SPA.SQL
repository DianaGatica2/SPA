create database SPA;
use SPA;
create table usuario( clave int primary key, nombre varchar(15) not null, ap varchar(15) not null,
 am varchar(15) not null, direccion varchar(30) not null, telefono varchar(10) not null,
 usuario varchar(15) not null, contraseña varchar(15) not null, tipo_user varchar(15) not null);
 
 create table configuracion( idCon int primary key auto_increment, tarifa_auto int not null, tarifa_camioneta int not null, 
 cupo int not null, pensionA int not null, pensionC int not null);
 
 create table Entrada(placa varchar(15) not null primary key, marca varchar(30) not null, modelo int not null,
 propietario varchar(25) not null, tipo_V varchar(20) not null, totalPagar int , horaE time not null, fechaE date not null);
 
  create table Salida(placa varchar(15) not null primary key, marca varchar(30) not null, modelo int not null,
 tipo_V varchar(20) not null, totalPagar int not null, horaS time not null, fechaS date not null);
 
 DROP TABLE configuracion;
 
 insert into usuario (clave,nombre,ap,am,direccion,telefono,usuario,contraseña,tipo_user)
 values ("SORA610505L610506","Waldo","Solano","Vazquez","jardin de niños","7571465211","Waldo","1234","Administrador");
 select * from usuario;