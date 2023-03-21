-- Seed test data

INSERT INTO departments VALUES (1, 'cs');

INSERT INTO
    users (
        `id`,
        `email`,
        `password`,
        `firstName`,
        `lastName`,
        `departmentId`
    )
VALUES (
        1,
        'admin@algomau.ca',
        '12345678',
        'Admin',
        'Algoma',
        1
    );