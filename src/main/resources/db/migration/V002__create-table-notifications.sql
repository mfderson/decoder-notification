create table notifications(
  id uuid default uuid_generate_v4(),
  user_id uuid not null,
  title varchar(255) not null,
  message varchar(255) not null,
  creation_date timestamp without time zone not null,
  status varchar(32) not null,

  primary key (id)
);