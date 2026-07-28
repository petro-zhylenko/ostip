ALTER TABLE app_user
    ADD COLUMN password_hash VARCHAR(255);

ALTER TABLE app_user
    ADD COLUMN enabled BOOLEAN NOT NULL DEFAULT true;


CREATE TABLE app_role (
                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                          name VARCHAR(50) NOT NULL UNIQUE
);


CREATE TABLE user_role (
                           user_id UUID NOT NULL,
                           role_id UUID NOT NULL,

                           PRIMARY KEY(user_id, role_id),

                           CONSTRAINT fk_user_role_user
                               FOREIGN KEY(user_id)
                                   REFERENCES app_user(id),

                           CONSTRAINT fk_user_role_role
                               FOREIGN KEY(role_id)
                                   REFERENCES app_role(id)
);