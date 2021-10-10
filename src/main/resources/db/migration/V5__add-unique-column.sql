alter table books add isbn varchar(100);
alter table books add unique (isbn);