# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table grade (
  id                            integer auto_increment not null,
  title                         varchar(255),
  score                         double not null,
  student                       varchar(255),
  constraint pk_grade primary key (id)
);


# --- !Downs

drop table if exists grade;

