ALTER TABLE employee
    ADD username_id int
        AFTER status,
    ADD FOREIGN KEY (username_id) REFERENCES APP_USER (id);

CREATE TABLE APP_USER
(
    id                int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    USER_NAME         VARCHAR(36)  NOT NULL,
    ENCRYTED_PASSWORD VARCHAR(128) NOT NULL,
    ENABLED           BIT          NOT NULL
);

ALTER TABLE APP_USER
    ADD CONSTRAINT APP_USER_UK UNIQUE (USER_NAME);

CREATE TABLE APP_ROLE
(
    id        int         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ROLE_NAME VARCHAR(30) NOT NULL
);

ALTER TABLE APP_ROLE
    ADD CONSTRAINT APP_ROLE_UK UNIQUE (ROLE_NAME);

CREATE TABLE USER_ROLE
(
    ID      int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    USER_ID int NOT NULL,
    ROLE_ID int NOT NULL
);

ALTER TABLE USER_ROLE
    ADD CONSTRAINT USER_ROLE_UK UNIQUE (USER_ID, ROLE_ID);
ALTER TABLE USER_ROLE
    ADD FOREIGN KEY (USER_ID) REFERENCES APP_USER (id);
ALTER TABLE USER_ROLE
    ADD FOREIGN KEY (ROLE_ID) REFERENCES APP_ROLE (id);

CREATE TABLE Persistent_Logins
(
    username  varchar(64) NOT NULL,
    series    varchar(64) NOT NULL,
    token     varchar(64) NOT NULL,
    last_used timestamp   NOT NULL,
    PRIMARY KEY (series)
);


INSERT INTO furama_management_md4.position
VALUES (1, 'Quản Lý'),
       (2, 'Nhân Viên');
INSERT INTO furama_management_md4.academic_level
VALUES (1, 'Trung Cấp'),
       (2, 'Cao Đẳng'),
       (3, 'Đại Học'),
       (4, 'Sau Đại Học');

INSERT INTO furama_management_md4.department
VALUES (1, 'Sale-Marketing'),
       (2, 'Hành chính'),
       (3, 'Phục vụ'),
       (4, 'Quản lý');
INSERT INTO furama_management_md4.employee (id, name, birthday, id_card, salary, phone, email,
                                            address, position_id, academic_id, department_id, status)
VALUES (1, 'Nguyễn Văn An', '1970-11-07', 456231786, 10000000, 0901234121, 'annguyen@gmail.com',
        '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1, TRUE),
       (2, 'Lê Văn Bình', '1997-04-09', 654231234, 7000000, 0934212314, 'binhlv@gmail.com',
        '22 Yên Bái, Đà Nẵng', 1, 2, 2, TRUE),
       (3, 'Hồ Thị Yến', '1995-12-12', 999231723, 14000000, 0412352315, 'thiyen@gmail.com',
        'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2, TRUE),
       (4, 'Võ Công Toản', '1980-04-04', 123231365, 17000000, 0374443232, 'toan0404@gmail.com',
        '77 Hoàng Diệu, Quảng Trị', 1, 4, 4, TRUE),
       (5, 'Nguyễn Bỉnh Phát', '1999-12-09', 454363232, 6000000, 0902341231, 'phatphat@gmail.com',
        '43 Yên Bái, Đà Nẵng', 2, 1, 1, TRUE),
       (6, 'Khúc Nguyễn An Nghi', '2000-11-08', 964542311, 7000000, 0978653213, 'annghi20@gmail.com',
        '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3, TRUE),
       (7, 'Nguyễn Hữu Hà', '1993-01-01', 534323231, 8000000, 0941234553, 'nhh0101@gmail.com',
        '4 Nguyễn Chí Thanh, Huế', 2, 3, 2, TRUE),
       (8, 'Nguyễn Hà Đông', '1989-09-03', 234414123, 9000000, 0642123111, 'donghanguyen@gmail.com',
        '111 Hùng Vương, Hà Nội', 2, 4, 4, TRUE),
       (9, 'Tòng Hoang', '1982-09-03', 256781231, 6000000, 0245144444, 'hoangtong@gmail.com',
        '213 Hàm Nghi, Đà Nẵng', 2, 4, 4, TRUE),
       (10, 'Nguyễn Công Đạo', '1994-01-08', 755434343, 8000000, 0988767111, 'nguyencongdao12@gmail.com',
        '6 Hoà Khánh, Đồng Nai', 2, 3, 2, TRUE);

INSERT INTO furama_management_md4.customer_type
VALUES (1, 'Diamond'),
       (2, 'Platinium'),
       (3, 'Gold'),
       (4, 'Silver'),
       (5, 'Member');

INSERT INTO furama_management_md4.customer (id, customer_type_id, name, birthday, gender, id_card, phone, email,
                                            address, status)
VALUES (1, 5, 'Nguyễn Thị Hào', '1970-11-07', FALSE, 643431213, 0945423362, 'thihao07@gmail.com',
        '23 Nguyễn Hoàng, Đà Nẵng', TRUE),
       (2, 3, 'Phạm Xuân Diệu', '1992-08-08', TRUE, 865342123, 0954333333, 'xuandieu92@gmail.com',
        'K77/22 Thái Phiên, Quảng Trị', TRUE),
       (3, 1, 'Trương Đình Nghệ', '1990-02-27', TRUE, 488645199, 0373213122, 'nghenhan2702@gmail.com',
        'K323/12 Ông Ích Khiêm, Vinh', TRUE),
       (4, 1, 'Dương Văn Quan', '1981-07-08', TRUE, 543432111, 0490039241, 'duongquan@gmail.com',
        'K453/12 Lê Lợi, Đà Nẵng', TRUE),
       (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', FALSE, 795453345, 0312345678, 'nhinhi123@gmail.com',
        '224 Lý Thái Tổ, Gia Lai', TRUE),
       (6, 4, 'Tôn Nữ Mộc Châu', '2005-12-06', FALSE, 732434215, 0988888844, 'tonnuchau@gmail.com',
        '37 Yên Thế, Đà Nẵng', TRUE),
       (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08', FALSE, 856453123, 0912345698, 'kimcuong84@gmail.com',
        'K123/45 Lê Lợi, Hồ Chí Minh', TRUE),
       (8, 3, 'Nguyễn Thị Hào', '1999-04-08', FALSE, 965656433, 0763212345, 'haohao99@gmail.com',
        '55 Nguyễn Văn Linh, Kon Tum', TRUE),
       (9, 1, 'Trần Đại Danh', '1994-07-01', TRUE, 432341235, 0643343433, 'danhhai99@gmail.com',
        '24 Lý Thường Kiệt, Quảng Ngãi', TRUE),
       (10, 2, 'Nguyễn Tâm Đắc', '1989-07-01', TRUE, 344343432, 0987654321, 'dactam@gmail.com',
        '22 Ngô Quyền, Đà Nẵng', TRUE);



INSERT INTO furama_management_md4.rent_type
VALUES (1, 'year'),
       (2, 'month'),
       (3, 'day'),
       (4, 'hour');

INSERT INTO furama_management_md4.facility_type
VALUES (1, 'Villa'),
       (2, 'House'),
       (3, 'Room');

INSERT INTO furama_management_md4.facility (id, name, floor_square, rental_fee, maximum_people,
                                            facility_type_id, rent_type_id, room_standard, description,
                                            pool_square, number_floor, status)
VALUES (1, 'Villa Beach Front', 25000, 10000000, 10, 1, 3, 'vip', 'Có hồ bơi', 500, 4, TRUE),
       (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', NULL, 3, TRUE),
       (3, 'Room Twin 01', 5000, 1000000, 2, 3, 4, 'normal', 'Có tivi', NULL, NULL, TRUE),
       (4, 'Villa No Beach Front', 22000, 9000000, 8, 1, 3, 'normal', 'Có hồ bơi', 300, 3, TRUE),
       (5, 'House Princess 02', 10000, 4000000, 5, 2, 3, 'normal', 'Có thêm bếp nướng', NULL, 2, TRUE),
       (6, 'Room Twin 02', 3000, 900000, 2, 3, 4, 'normal', 'Có tivi', NULL, NULL, TRUE);



INSERT INTO furama_management_md4.contract (id, start_date, end_date, deposit, employee_id, customer_id, facility_id, status)
VALUES (1, '2020-12-08', '2020-12-08', 0, 3, 1, 3, TRUE),
       (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1, TRUE),
       (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2, TRUE),
       (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5, TRUE),
       (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6, TRUE),
       (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6, TRUE),
       (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4, TRUE),
       (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1, TRUE),
       (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3, TRUE),
       (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5, TRUE),
       (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1, TRUE),
       (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1, TRUE);

INSERT INTO furama_management_md4.service_include (id, name, price, unit, detail)
VALUES (1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
       (2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
       (3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
       (4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       (5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       (6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');

INSERT INTO furama_management_md4.contract_detail (id, contract_id, service_include_id, quantity, status)
VALUES (1, 2, 4, 5, TRUE),
       (2, 2, 5, 8, TRUE),
       (3, 2, 6, 15, TRUE),
       (4, 3, 1, 1, TRUE),
       (5, 3, 2, 11, TRUE),
       (6, 1, 3, 1, TRUE),
       (7, 1, 2, 2, TRUE),
       (8, 12, 2, 2, TRUE);

INSERT INTO App_User (id, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
VALUES (1, 'annguyen@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(2, 'binhlv@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(3, 'thiyen@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(4, 'toan0404@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(5, 'phatphat@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(6, 'annghi20@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(7, 'nhh0101@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(8, 'donghanguyen@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(9, 'hoangtong@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(10, 'nguyencongdao12@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

INSERT INTO app_role (id, ROLE_NAME)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO app_role (id, ROLE_NAME)
VALUES (2, 'ROLE_USER');

INSERT INTO user_role (ID, USER_ID, ROLE_ID)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1),
       (4, 4, 1),
       (5, 5, 1),
       (6, 6, 1),
       (7, 7, 1),
       (8, 8, 1),
       (9, 9, 1),
       (10, 10, 1);

