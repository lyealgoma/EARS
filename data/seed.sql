-- Seed test data

INSERT INTO departments VALUES (2, 'math');
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
        2,
        'user@algomau.ca',
        '12345678',
        'Regular',
        'Centennial',
        2
    );




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



INSERT INTO
    facultySearches (
        `id`,
        `title`,
        `password`,
        `firstName`,    
        `lastName`,
        `departmentId`
    )
VALUES (
        2,
        'user@algomau.ca',
        '12345678',
        'Regular',
        'Centennial',
        2
    );

