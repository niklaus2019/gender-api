drop table if exists gender;
create table gender(
    id bigint auto_increment primary key,
    count int,
    gender varchar(25),
    name varchar(25),
    probability double
);