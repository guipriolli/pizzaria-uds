CREATE TABLE tamanho
(
    id SERIAL,
    descricao character varying(255),
    tempo integer,
    valor double precision,
    PRIMARY KEY (id)
);

CREATE TABLE sabor
(
    id SERIAL,
    descricao character varying(255),
    tempo integer,
    PRIMARY KEY (id)
);

CREATE TABLE adicionais
(
    id SERIAL,
    descricao character varying(255),
    tempo integer,
    valor double precision,
    PRIMARY KEY (id)
);

CREATE TABLE pedido
(
    id SERIAL,
    adicionais character varying(255),
    sabor character varying(255),
    tamanho character varying(255),
    tempo integer,
    valor double precision,
    PRIMARY KEY (id)
);