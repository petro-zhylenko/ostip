ALTER TABLE app_user
    ADD CONSTRAINT uk_user_email
        UNIQUE (email);

ALTER TABLE app_user
    ADD CONSTRAINT uk_user_org_nickname
        UNIQUE (
                organization_id,
                nickname
            );