
-- Academic Block----------------

INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('2022-09A-09D','September 2022', '2022-09-05 12:59:11', '2022-09-29 12:59:11', 'Fall') RETURNING id AS academic_block_id;
INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('2022-10A-10D','October 2022', '2022-10-03 12:59:11', '2022-10-27 12:59:11', 'Fall') RETURNING id AS academic_block_id;
-- INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('2022-11A-11D','November 2022', '2022-10-31 12:59:31', '2022-11-22 12:59:11', 'Fall') RETURNING id AS academic_block_id;
-- INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('2022-12A-12D','December 2022', '2022-11-23 12:59:11', '2022-12-27 12:59:11', 'Fall') RETURNING id AS academic_block_id;
-- INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('2023-01A-01D','January 2023', '2023-01-16 12:59:11', '2023-02-09 12:59:11', 'Fall') RETURNING id AS academic_block_id;
-- INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('12A-12D-CS435','March 2023', '2023-02-27 12:59:11', '202-03-23 12:59:11', 'Fall') RETURNING id AS academic_block_id;

-- Address  ----------------
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '1000 N 4th st', '10001') RETURNING id AS address_id;
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '123 N 2th st', '123') RETURNING id AS address_id_2;
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '456 N 3th st', '4561') RETURNING id AS address_id_3;
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '789 N 6th st', '789') RETURNING id AS address_id_4;
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '1011 N 8th st', '1011') RETURNING id AS address_id_5;
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '1112 N 9th st', '1112') RETURNING id AS address_id_6;

-- Course ----------------
INSERT INTO course (code, course_name, description) VALUES ('CS-544', 'Enterprise Architecture', 'this course is Enterprise Architecture ') RETURNING id AS course_id;
INSERT INTO course (code, course_name, description) VALUES ('CS-390', 'Fundamental programming practice', 'this course is FPP') RETURNING id AS course_id;
INSERT INTO course (code, course_name, description) VALUES ('CS-401', 'Modern programming practice', 'this course is MPP ') RETURNING id AS course_id;
INSERT INTO course (code, course_name, description) VALUES ('CS-425', 'Software engineering', 'this course is SE ') RETURNING id AS course_id;
INSERT INTO course (code, course_name, description) VALUES ('CS-435', 'Algorithms', 'this course is Enterprise Algo ') RETURNING id AS course_id;
INSERT INTO course (code, course_name, description) VALUES ('CS-590', 'Software Architecture', 'this course is SA ') RETURNING id AS course_id;
INSERT INTO course (code, course_name, description) VALUES ('CS-523', 'Big data technology', 'this course is Big data technology') RETURNING id AS course_id;

-- Faculty ----------------
INSERT INTO faculty (first_name, last_name, email, title, address_id) VALUES ('Renuka', 'Mohanraj', 'renuka@miu.edu', 'Professor', 1) RETURNING id AS faculty_id;
INSERT INTO faculty (first_name, last_name, email, title, address_id) VALUES ('Simak', 'Tavakoli', 'simak@miu.edu', 'Professor', 2) RETURNING id AS faculty_id;
INSERT INTO faculty (first_name, last_name, email, title, address_id) VALUES ('Mohammed', 'Elmatary', 'muhammed@miu.edu', 'Professor', 3) RETURNING id AS faculty_id;
INSERT INTO faculty (first_name, last_name, email, title, address_id) VALUES ('Payman', 'Salek', 'payman@miu.edu', 'Professor', 4) RETURNING id AS faculty_id;
INSERT INTO faculty (first_name, last_name, email, title, address_id) VALUES ('Rene', 'de Jong', 'rene@miu.edu', 'Professor', 4) RETURNING id AS faculty_id;

-- -- store the faculty id in a variable
-- SET faculty_id = (SELECT id FROM faculty WHERE first_name = 'Renuka' AND last_name = 'Mohanraj');




-- Course Offering ----------------
-- for each block create multiple course offering


--  FPP is offered in 2 blocks, 2 course offering with the same block with different faculty
--  FPP and Mpp, first and second block
--
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-390', 'RM', 1, 2, 2, 1, 1) RETURNING id AS course_offering_id;
INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-390', 'MA', 1, 1, 1, 1, 3) RETURNING id AS course_offering_id;
INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-401', 'ST', 1, 1, 2, 1, 2) RETURNING id AS course_offering_id;

-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-390', 'MA', 1, 1, 3, 2, 3) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-390', 'ST', 1, 1, 4, 2, 2) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-390', 'RM', 1, 2, 3, 2, 1) RETURNING id AS course_offering_id;


--  other courses
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-425', 'MA', 1, 2, 4, 3, 3) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-435', 'ST', 1, 2, 5, 3, 2) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-523', 'PS', 1, 2, 7, 3, 4) RETURNING id AS course_offering_id;
--
--
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-435', 'MA', 1, 2, 5, 4, 3) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-590', 'RD', 1, 2, 6, 4, 5) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-544', 'PS', 1, 2, 1, 4, 4) RETURNING id AS course_offering_id;
--
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-590', 'RD', 1, 2, 6, 5, 5) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-544', 'PS', 1, 2, 1, 5, 4) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-425', 'ST', 1, 2, 4, 5, 2) RETURNING id AS course_offering_id;
--
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-544', 'PS', 1, 2, 1, 6, 4) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-523', 'PS', 1, 2, 7, 6, 4) RETURNING id AS course_offering_id;
-- INSERT INTO course_offering (code, faculty_initials, capacity, available_seats, course_id, academic_block_id, faculty_id) VALUES ('CS-435', 'MA', 1, 2, 5, 6, 3) RETURNING id AS course_offering_id;



-- registration event
-- two registration events for each entry(1st for fpp and mpp) the other for the rest of the courses
INSERT INTO registration_event (end_date, start_date) VALUES ('2022-08-15 12:59:11', '2022-08-25 12:59:11') RETURNING id AS registration_event_id;

INSERT INTO registration_event (end_date, start_date) VALUES ('2022-09-05 12:59:11', '2022-09-15 12:59:11') RETURNING id AS registration_event_id;


-- registration group
-- Mpp
INSERT INTO registration_group (semester, track, year) VALUES ('Fall', 'MPP', 2022);
-- Fpp
INSERT INTO registration_group (semester, track, year) VALUES ('Fall', 'FPP', 2022);


-- Student ----------------
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id, registration_group_id) VALUES ('Mubarek', 'Ali', 'mjali@miu.edu', 1, 1, 1) RETURNING id AS student_id;
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id, registration_group_id) VALUES ('youcef', 'Ben Cheikh', 'youcef@miu.edu', 2, 2, 1) RETURNING id AS student_id;
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id, registration_group_id) VALUES ('Genene', 'Mekonnen', 'genene@miu.edu', 3, 3, 2) RETURNING id AS student_id;
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id, registration_group_id) VALUES ('Selamawit', 'Arefaine', 'selam@miu.edu', 4, 4, 2) RETURNING id AS student_id;
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id, registration_group_id) VALUES ('Eman', 'Mohammed', 'eman@miu.edu', 5, 5, 2) RETURNING id AS student_id;
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id, registration_group_id) VALUES ('John', 'Doe', 'john@miu.edu', 1, 5, 2) RETURNING id AS student_id;

-- join table registration group and student
-- 2 students belong to Mpp and four students belong to Fpp
-- INSERT INTO registration_group_students (registration_group_id, students_id) VALUES (1, 1);
-- INSERT INTO registration_group_students (registration_group_id, students_id) VALUES (1, 2);
--
-- INSERT INTO registration_group_students (registration_group_id, students_id) VALUES (2, 3);
-- INSERT INTO registration_group_students (registration_group_id, students_id) VALUES (2, 4);
-- INSERT INTO registration_group_students (registration_group_id, students_id) VALUES (2, 5);
-- INSERT INTO registration_group_students (registration_group_id, students_id) VALUES (2, 6);


-- join table registration group and academic block
-- mpp group has 5 blocks including Mpp, and fpp group has 6 blocks including Fpp
INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (1, 1);
INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (1, 2);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (1, 3);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (1, 4);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (1, 5);

INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (2, 1);
INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (2, 2);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (2, 3);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (2, 4);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (2, 5);
-- INSERT INTO registration_group_academic_blocks (registration_group_id, academic_blocks_id) VALUES (2, 6);


-- insert into join table of registration group and registration event
-- mpp group has 2 events and fpp group has 2 events
INSERT INTO registration_group_registration_events (registration_groups_id, registration_events_id) VALUES (1, 1);
INSERT INTO registration_group_registration_events (registration_groups_id, registration_events_id) VALUES (2, 2);

-- INSERT INTO registration_group_registration_events (registration_groups_id, registration_events_id) VALUES (2, 1);
-- INSERT INTO registration_group_registration_events (registration_groups_id, registration_events_id) VALUES (2, 2);


INSERT INTO registration_request (priority_number, course_offering_id) VALUES (1, 1);
INSERT INTO registration_request (priority_number, course_offering_id) VALUES (2, 2);
-- INSERT INTO registration_request (priority_number, course_offering_id) VALUES (3, 3);
-- INSERT INTO registration_request (priority_number, course_offering_id) VALUES (4, 4);
-- INSERT INTO registration_request (priority_number, course_offering_id) VALUES (5, 5);

INSERT INTO registration_request (priority_number, course_offering_id) VALUES (1, 1);
INSERT INTO registration_request (priority_number, course_offering_id) VALUES (2, 2);
-- INSERT INTO registration_request (priority_number, course_offering_id) VALUES (3, 3);
-- INSERT INTO registration_request (priority_number, course_offering_id) VALUES (4, 4);
-- INSERT INTO registration_request (priority_number, course_offering_id) VALUES (5, 5);

INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (1, 1);
INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (1, 2);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (1, 3);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (1, 4);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (1, 5);

INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (2, 3);
INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (2, 4);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (2, 8);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (2, 9);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (2, 10);
--
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (3, 1);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (3, 2);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (3, 3);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (3, 4);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (3, 5);
--
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (4, 1);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (4, 2);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (4, 3);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (4, 4);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (4, 5);
--
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (5, 1);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (5, 2);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (5, 3);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (5, 4);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (5, 5);
--
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (6, 1);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (6, 2);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (6, 3);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (6, 4);
-- INSERT INTO student_registration_requests (student_id, registration_requests_id) VALUES (6, 5);


