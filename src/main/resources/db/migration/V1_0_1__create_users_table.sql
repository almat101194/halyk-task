create table if not exists users
(
    id              bigserial    not null primary key,
    per_num         bigint       not null,
    fio             varchar(150) not null,
    birth_date      timestamptz  not null default now(),
    role            varchar(50) not null,
    password        varchar(255) not null
)

