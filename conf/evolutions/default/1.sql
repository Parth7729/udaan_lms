# --- !Ups

CREATE TABLE IF NOT EXISTS restaurants(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ,
    status TEXT NOT NULL,
    last_contacted_at TIMESTAMPTZ,
    max_call_per_week INTEGER
);


CREATE TABLE IF NOT EXISTS points_of_contact(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(255),
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ,
    role TEXT NOT NULL,
    restaurant_id BIGINT NOT NULL REFERENCES restaurants(id) ON DELETE SET NULL,
    last_contacted_at TIMESTAMPTZ
);


CREATE TABLE IF NOT EXISTS interactions(

    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    interaction_type TEXT NOT NULL,
    poc_id BIGINT NOT NULL REFERENCES points_of_contact(id) ON DELETE SET NULL,
    restaurant_id BIGINT NOT NULL REFERENCES restaurants(id) ON DELETE SET NULL,
    call_recording_url VARCHAR(255)

);

CREATE INDEX IF NOT EXISTS lms_poc_restaurant_id ON points_of_contact(restaurant_id);

CREATE INDEX IF NOT EXISTS lms_interactions_poc_id_restaurant_id ON interactions(poc_id, restaurant_id);

# --- !Downs

DROP TABLE IF EXISTS interactions;

DROP TABLE IF EXISTS points_of_contact;

DROP TABLE IF EXISTS restaurants;