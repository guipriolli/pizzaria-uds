CREATE TABLE tamanho
(
    id SERIAL,
    descricao character varying(255) NOT NULL UNIQUE,
    tempo integer NOT NULL,
    valor double precision NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE sabor
(
    id SERIAL,
    descricao character varying(255) NOT NULL UNIQUE,
    tempo integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE adicionais
(
    id SERIAL,
    descricao character varying(255) NOT NULL UNIQUE,
    tempo integer NOT NULL,
    valor double precision NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pedido
(
    id SERIAL,
	sabor character varying(255) NOT NULL,
    tamanho character varying(255) NOT NULL,
    adicionais character varying(255),
    tempo integer NOT NULL,
    valor double precision NOT NULL,
    PRIMARY KEY (id)
);