-- Default organization

INSERT INTO organization (
    id,
    name
)
VALUES (
           '00000000-0000-0000-0000-000000000001',
           'InterviewOS Demo'
       );


-- Default admin user
-- password: admin123
-- BCrypt hash потрібно згенерувати через PasswordEncoder

INSERT INTO app_user (
    id,
    organization_id,
    email,
    password_hash,
    first_name,
    last_name,
    enabled
)
VALUES (
           '00000000-0000-0000-0000-000000000010',
           '00000000-0000-0000-0000-000000000001',
           'admin@interviewos.local',
           '$2a$10$jP3jhjBaaeimR2CUhRvT7O2lJTrqjx/96oCv2FvNFMmYgQ16wP73m',
           'System',
           'Administrator',
           true
       );


-- Assign ADMIN role

INSERT INTO user_role (
    user_id,
    role_id
)
SELECT
    '00000000-0000-0000-0000-000000000010',
    id
FROM app_role
WHERE name = 'ADMIN';