/*Criacao do banco de dados*/
drop database if exists pentagono;
create database if not exists pentagono;

/*Entra no contexto de banco de dados*/
use pentagono;

/*Criacao das tabelas do banco de dados*/

/*tb_solicitacao_status*/
drop table if exists tb_solicitacao_status;
create table tb_solicitacao_status
(
 id int primary key not null auto_increment
,descricao varchar(16) not null
);
insert into tb_solicitacao_status (descricao) values ('Novo');
insert into tb_solicitacao_status (descricao) values ('Em execução');
insert into tb_solicitacao_status (descricao) values ('Finalizado');

/*tb_usuario*/
drop table if exists tb_usuario;
create table tb_usuario
(
 id int primary key not null auto_increment
,racf varchar (8) not null
,nome varchar(48) not null
,funcional char(9) not null
,email varchar(64) not null
);

/*tb_sistema_operacional*/
drop table if exists tb_sistema_operacional;
create table tb_sistema_operacional
(
 id int primary key not null auto_increment
,nome varchar (32) not null
,versao varchar (16) not null
,preco decimal(18,2) not null
);
insert into tb_sistema_operacional (nome, versao, preco) values ('Windows Server 2019', 'Enterprise', 250.00);
insert into tb_sistema_operacional (nome, versao, preco) values ('Windows Server 2019', 'Standard', 100.00);
insert into tb_sistema_operacional (nome, versao, preco) values ('Ubuntu', '20.04 LTS', 150.00);
insert into tb_sistema_operacional (nome, versao, preco) values ('Ubuntu', '18.10', 60.00);

/*tb_hardware*/
drop table if exists tb_hardware;
create table tb_hardware
(
 id int primary key not null auto_increment
,tipo varchar(32) not null
,preco decimal (18,2) not null
);
insert into tb_hardware (tipo, preco) values ('CPU INTEL', 180.00);
insert into tb_hardware (tipo, preco) values ('CPU AMD', 155.00);
insert into tb_hardware (tipo, preco) values ('MEMORIA 32 GB', 90.00);
insert into tb_hardware (tipo, preco) values ('MEMORIA 16 GB', 60.00);
insert into tb_hardware (tipo, preco) values ('SSD 250 GB', 80.00);
insert into tb_hardware (tipo, preco) values ('SSD 500 GB', 150.00);
insert into tb_hardware (tipo, preco) values ('SSD 1 TB', 250.00);

/*tb_solicitacao*/
drop table if exists tb_solicitacao;
create table tb_solicitacao
(
 id int primary key not null auto_increment
,descricao varchar(16) not null
,data_solicitacao datetime not null
,id_usuario int not null
,id_solicitacao_status int not null
,id_sistema_operacional int not null
,foreign key (id_usuario) references tb_usuario(id)
,foreign key (id_solicitacao_status) references tb_solicitacao_status(id)
,foreign key (id_sistema_operacional) references tb_sistema_operacional(id)
);
insert into tb_solicitacao (descricao, data_solicitacao, id_usuario, id_solicitacao_status, id_sistema_operacional)
values ('teste nr 1', '2020-05-26', 1, 1, 1);
insert into tb_solicitacao (descricao, data_solicitacao, id_usuario, id_solicitacao_status, id_sistema_operacional)
values ('teste nr 2', '2020-05-24', 2, 3, 4);

/*tb_software*/
drop table if exists tb_software;
create table tb_software
(
 id int primary key not null auto_increment
,nome varchar (32) not null
,preco_core decimal(18,2) not null
,preco_call decimal(18,2) not null
,preco_memoria decimal(18,2) not null
,preco_licenca decimal(18,2) not null
,descricao varchar(32) not null
,id_sistema_operacional int not null
,foreign key (id_sistema_operacional) references tb_sistema_operacional(id)

);
insert into tb_software (nome, preco_core, preco_call, preco_memoria, preco_licenca, descricao, id_sistema_operacional)
values ('SQL Server 2019', 150.00, 0.00, 0.00, 0.00, 'Enterprise Edition', 1);
insert into tb_software (nome, preco_core, preco_call, preco_memoria, preco_licenca, descricao, id_sistema_operacional)
values ('SQL Server 2019', 50.00, 0.00, 0.00, 0.00, 'Standard Edition', 1);

/*tb_solicitacao_hardware*/
drop table if exists tb_solicitacao_hardware;
create table tb_solicitacao_hardware
(
 id int primary key not null auto_increment
,custo decimal(18,2) not null
,quantidade int not null
,id_hardware int not null
,id_solicitacao int not null
,foreign key (id_hardware) references tb_hardware(id)
,foreign key (id_solicitacao) references tb_solicitacao(id)
);
insert into tb_solicitacao_hardware (custo, quantidade, id_hardware, id_solicitacao)
values (1500.00, 2, 1, 1);
insert into tb_solicitacao_hardware (custo, quantidade, id_hardware, id_solicitacao)
values (500.00, 3, 2, 2);

/*tb_solicitacao_software*/
drop table if exists tb_solicitacao_software;
create table tb_solicitacao_software
(
 id int primary key not null auto_increment
,custo decimal(18,2) not null
,descricao varchar(32) not null
,id_software int not null
,id_solicitacao int not null
,foreign key (id_software) references tb_software(id)
,foreign key (id_solicitacao) references tb_solicitacao(id)
);
insert into tb_solicitacao_software (custo, descricao, id_software, id_solicitacao) 
values (150.00, 'Servidor de Banco de Dados', 1, 1);
insert into tb_solicitacao_software (custo, descricao, id_software, id_solicitacao) 
values (50.00, 'Servidor de Banco de Dados', 2, 2);