

CREATE DATABASE MERCADO;

flush privileges;


USE MERCADO;


/***** TABELA LOGIN *****/
CREATE TABLE tb_login (
  
  usuario varchar(100),
  senha varchar (30)
  );

/***** TABELA PRODUTOS *****/


/***** TABELA FORNECEDORES *****/
CREATE TABLE tb_fornecedores (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar (100),
  email varchar(200),
  cpf varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2)
);
/*****************/

CREATE TABLE tb_produtos (
  id int auto_increment primary key,
  nome varchar(100),
  descricao varchar(100),
  preco decimal (10,2),
  qtd_estoque int,
  for_id int,

  FOREIGN KEY (for_id) REFERENCES tb_fornecedores(id)
);
/*****************/

USE MERCADO;
INSERT INTO tb_login(usuario,senha) values ("admin", "123");

USE MERCADO;

SELECT * FROM tb_login WHERE usuario = "Admin" and senha = "123";
USE MERCADO;
update tb_produtos set nome="feijao" where id=6