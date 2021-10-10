create table books (
    id mediumint not null auto_increment,
    title varchar(100) not null,
    release_date date not null,
    pages int not null,
    primary key (id)
)