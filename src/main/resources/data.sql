INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Jérôme', 'Du Camp d''Orgas');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Quentin', 'Malaviel');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Marc', 'Grondin');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Loïc', 'Barbado');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Loïc', 'Chenuet');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Nicolas', 'Flichy');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Clément', 'Piquenet');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Daniel', 'Thibaut');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Mehdi', 'Hueber');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Jordan', 'Anicet');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Kévin', 'Piriou');
INSERT INTO STUDENT (id, first_name, last_name) VALUES (nextval('STUDENT_SEQ'), 'Patrick', 'Rabourdin');

INSERT INTO SPEECH(id, date_time, student_id) VALUES (nextval('SPEECH_SEQ'), now(), 1);