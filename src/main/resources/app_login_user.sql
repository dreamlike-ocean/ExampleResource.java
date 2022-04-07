create table login_user
(
    user_id  int auto_increment
        primary key,
    username varchar(10)          not null,
    password varchar(25)          null,
    banned   tinyint(1) default 0 null,
    constraint login_user_username_uindex
        unique (username)
);

INSERT INTO app.login_user (user_id, username, password, banned) VALUES (31, 'username', 'p1', 0);
INSERT INTO app.login_user (user_id, username, password, banned) VALUES (32, 'user', 'password', 0);
INSERT INTO app.login_user (user_id, username, password, banned) VALUES (33, 'scx', 'abc', 0);
INSERT INTO app.login_user (user_id, username, password, banned) VALUES (34, 'vertx', 'password', 0);
INSERT INTO app.login_user (user_id, username, password, banned) VALUES (35, 'mode', 'ps', 0);
INSERT INTO app.login_user (user_id, username, password, banned) VALUES (36, 'us', 'pass', 0);
INSERT INTO app.login_user (user_id, username, password, banned) VALUES (37, 'use', 'pass', 1);
