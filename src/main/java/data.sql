create table writer
(
    id        serial primary key,
    name      varchar(60) not null,
    last_name varchar(60) not null,
    age       int         not null,
    book      varchar[]
);
create table BOOK
(
    id        serial primary key,
    title      varchar(60) not null,
    author varchar(60) not null,
    year_of_publish int not null
);