create table estudante(
	id int PRIMARY KEY auto_increment,
    nomeCompleto varchar(80) not null,
    idade int not null,
    email varchar(80) not null,
    endereco varchar(100) not null,
    cep varchar(9),
    telefone varchar(11),
    usuario varchar(80) not null,
    senha varchar(100) not null,
	curso varchar(50) not null,
    observacoes varchar(255),
    ativo bool not null
);