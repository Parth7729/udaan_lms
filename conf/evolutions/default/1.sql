# --- !Ups

create table counts(
id BIGSERIAL PRIMARY key
);

# --- !Downs

drop table counts;