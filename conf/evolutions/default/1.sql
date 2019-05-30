# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table anuncios (
  id_anuncio                    varchar(255) not null,
  livro                         varchar(255),
  doador_email                  varchar(255) not null,
  quantidade                    integer not null,
  estado_livro                  varchar(255),
  descricao_anuncio             varchar(255),
  disponivel                    boolean default false not null,
  constraint pk_anuncios primary key (id_anuncio)
);

create table doacao (
  id_doacao                     varchar(255) not null,
  concluida                     boolean default false not null,
  constraint pk_doacao primary key (id_doacao)
);

create table livros (
  isbn                          varchar(255) not null,
  titulo                        varchar(255),
  autor                         varchar(255),
  ano                           integer not null,
  thumb_cover                   varchar(255),
  constraint pk_livros primary key (isbn)
);

create table usuarios (
  email                         varchar(255) not null,
  cpf                           varchar(255),
  nome                          varchar(255),
  senha                         varchar(255),
  constraint pk_usuarios primary key (email)
);

create index ix_anuncios_doador_email on anuncios (doador_email);
alter table anuncios add constraint fk_anuncios_doador_email foreign key (doador_email) references usuarios (email) on delete restrict on update restrict;


# --- !Downs

alter table anuncios drop constraint if exists fk_anuncios_doador_email;
drop index if exists ix_anuncios_doador_email;

drop table if exists anuncios;

drop table if exists doacao;

drop table if exists livros;

drop table if exists usuarios;

