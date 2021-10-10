create table authors (
    id mediumint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    resume text,
    birthday date not null,
    primary key (id)
)