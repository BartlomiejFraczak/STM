-- test users:
INSERT INTO users (
    NAME,
    LAST_NAME,
    EMAIL,
    PASSWORD,
    STATUS)
VALUES (
    'Bartek',
    'Fraczak',
    'bartekfraczak@gmail.com',
    '123',
    true);

INSERT INTO users (
    NAME,
    LAST_NAME,
    EMAIL,
    PASSWORD)
VALUES (
    'Marcin',
    'Kaczmarek',
    'marcinkaczmarek@o2.pl',
    '321');

-- test tasks:
INSERT INTO tasks (
    TITLE,
    DESCRIPTION,
    TYPE,
    STATUS,
    USER_ID)
VALUES (
    'pranie',
    'zrobic pranie',
    'TASK',
    'NEW',
    1);

INSERT INTO tasks (
    TITLE,
    DESCRIPTION,
    TYPE,
    STATUS,
    USER_ID)
VALUES (
    'obiad',
    'ugotuj obiad',
    'TASK',
    'INPROGRESS',
    2);

SCRIPT TO 'src/main/resources/DDL.sql'