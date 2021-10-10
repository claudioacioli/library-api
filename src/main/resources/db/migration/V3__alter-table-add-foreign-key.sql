alter table books add author_id mediumint not null;

alter table books add foreign key fk_author_books (author_id) references authors(id);