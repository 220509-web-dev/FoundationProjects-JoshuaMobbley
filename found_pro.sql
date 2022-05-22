create schema foundation_app;

set search_path to foundation_app;
create table app_users (
    id       int generated always as identity primary key,
    username varchar unique not null check (length(username) >= 5),
    password varchar unique not null check (length(password) >= 8)
);

INSERT INTO app_users (username, password),
Values ('Jmobbley', 'savefile1'), ( 'JoshMobbley', 'revature1');

select * from app_users;