CREATE TABLE player (
    id serial primary key,
    name VARCHAR(20),
    surnames varchar(50),
    create_date date,
    update_date date
);

create table club (
    id serial primary key,
    street varchar(100),
    name varchar(50),
    short_name varchar(10),
    logo varchar(200),
    city varchar(50),
    country varchar(50),
    create_date date,
    update_date date
);

create table player_club (
    id serial primary key,
    player_id bigint,
    club_id bigint,
    year int,
    create_date date,
    update_date date,
    foreign key (player_id) references player(id),
    foreign key (club_id)  references club(id)
);

create table tournament (
    id serial primary key,
    name varchar(200),
    end_registration_date date,
    start_date date,
    end_date date,
    create_date date,
    update_date date
);

create table category (
    id serial primary key,
    name varchar(50),
    short_name varchar(10),
    create_date date,
    update_date date
);

create table tournament_category(
    tournament_id bigint,
    category_id bigint,
    foreign key (tournament_id) references tournament(id),
    foreign key (category_id) references category(id)
);
