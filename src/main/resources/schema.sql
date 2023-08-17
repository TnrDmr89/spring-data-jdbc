create table if not exists Actor(
      id serial primary key,
      first_name varchar(100) not null,
      last_name varchar(100) not null,
      last_update timestamp
);

create table if not exists Category(
         id serial primary key,
         name varchar(100) not null,
         last_update timestamp
);


create table if not exists Language(
     id serial primary key,
     name varchar(50) not null,
     updated_on timestamp
);

create table if not exists Film(
    id Serial primary key,
    title varchar(255) not null,
    release_year int not null,
    language int not null,
    updated_on timestamp,
    foreign key (language) references Language(id)
);

create table if not exists Film_category(
    film int not null,
    category int not null,
    updated_on timestamp,
    foreign key (film) references film(id),
    foreign key (category) references category(id)
);

create table if not exists Film_actor(
    actor int not null,
    film int not null,
    updated_on timestamp,
    foreign key (actor) references actor(id),
    foreign key (film) references film(id)
);


