
--
-- INSERT INTO registration_event (end_date, start_date) VALUES (DATE("2022-02-05 12:59:11"), DATE("2022-02-15 12:59:11")) RETURNING id AS registration_event_id;
INSERT INTO registration_event (end_date, start_date) VALUES ('2022-02-05 12:59:11', '2022-02-15 12:59:11') RETURNING id AS registration_event_id;

-- INSERT INTO academic_block (code, name, start_date, end_date, semester) VALUES ('2022-12A-12D','December 2022' '2022/11/25', '2022/12/22', 'Fall') RETURNING id AS academic_block_id;
INSERT INTO address (city, country, state, street, zip) VALUES ('Fairfield', 'USA', 'IA', '1000 N 4th st', '10001') RETURNING id AS address_id;
-- INSERT INTO course (code, course_name, description) VALUES ('CS-544', 'Enterprise Architecture', 'this course is Enterprise Architecture ') RETURNING id AS course_id;
-- INSERT INTO faculty (first_name, last_name, email, title, address_id) VALUES ('John', 'Doe', 'john_doe@miu.edu', 'Professor', $address_id) RETURNING id AS faculty_id;
INSERT INTO student ( first_name, last_name, email, home_address_id, mailing_address_id) VALUES ('Mubarek', 'Ali', 'mjali@miu.edu', 1, 1) RETURNING id AS student_id;
-- INSERT INTO course_offering (code, academic_block_id, faculty_id) VALUES ('CS-544', $academic_block_id, $faculty_id) RETURNING id AS course_offering_id;

