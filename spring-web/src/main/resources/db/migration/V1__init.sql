create table if not exists products (id bigserial primary key, title varchar(255), cost int);

insert into products (title, cost)
values
    ('Apple', 100),
    ('Jus', 80),
    ('Banana', 903),
    ('Milk', 100);