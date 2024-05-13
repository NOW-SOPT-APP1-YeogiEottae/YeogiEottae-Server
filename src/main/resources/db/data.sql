--- 호텔 더미데이터 ---
INSERT INTO hotel (HOTEL_NAME, STAR, LOCATION, REVIEW_RATE, REVIEW_COUNT, IS_LIKED, CREATED_AT, UPDATED_AT)
VALUES  ('그랜드 인터컨티넨탈 파르나스', '5성급', '서울 강남구 테헤란로 521', 9.4, 2183, false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
('서울 신라 호텔', '5성급', '서울 중구 동호로 249', 9.8, 1183, false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
('노보텔 앰버서더 용산', '5성급', '서울 용산구 청파로20길 95', 9.4, 2183, false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
('나인트리 프리미어 로카우스 호텔 서울 용산', '4성급', '서울 용산구 한강대로23길 25', 9.4, 3183, false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
('앰버서더 서울 풀만 호텔', '특1급', '서울 용산구 한강대로23길 25', 9.2, 2003, false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179');

--- 객실 더미데이터 ---
INSERT INTO room(HOTEL_ID, ROOM_NAME, PRICE, ROOM_IMAGE, START_TIME, END_TIME, IS_LIKED, CREATED_AT, UPDATED_AT)
VALUES (1, '클래식 킹', 464640, 'image1', '15:00', '11:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(1, '주니어 스위트 킹', 608679, 'image2', '15:00', '11:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(2, '디럭스 트윈', 497000, 'image3', '14:00', '11:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(2, '디럭스 더블', 503000, 'image4', '14:00', '11:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(3, '주니어 스위트', 287000, 'image5', '15:00', '12:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(3, '디럭스 스위트 2베드', 376200, 'image6', '15:00', '12:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(4, '스탠다드 더블', 159000, 'image7', '15:00', '11:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(4, '패밀리 트윈', 169000, 'image8', '15:00', '11:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(5, '이그제큐티브 킹', 586850, 'image9', '15:00', '12:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179'),
(5, '슈페리어 킹', 326700, 'image10', '15:00', '12:00', false, '2024-05-13 15:48:57.450179', '2024-05-13 15:48:57.450179');