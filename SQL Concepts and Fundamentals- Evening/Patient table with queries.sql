
/* PATIENT TABLE CREATION*/
CREATE TABLE PATIENT( PID INTEGER PRIMARY KEY UNIQUE NOT NULL , PNAME VARCHAR(255) NOT NULL , PADDRESS VARCHAR(255), SEX VARCHAR(10), doc_Id INTEGER, FOREIGN KEY(doc_Id) REFERENCES DOCTOR(doc_Id));
ALTER TABLE PATIENT ADD ARRIVAL DATE;

INSERT INTO PATIENT VALUES(201, "JAWAHAR", "JAWAHAR BHAWAN", "MALE", 102, '2020-07-04');
INSERT INTO PATIENT VALUES(202,"KAMLESH", "KAMLESH BHAWAN", "MALE", 103, "2020-07-14");
INSERT INTO PATIENT VALUES(203, "LOVE", "LOVE BHAWAN", "FEMALE", 103, '2020-07-04');
INSERT INTO PATIENT VALUES(204,"KAMLI", "KAMLI BHAWAN", "FEMALE", 105, "2020-07-17");
INSERT INTO PATIENT VALUES(205, "JORAWAR", "JORAWAR BHAWAN", "MALE", 101, '2020-07-16');
INSERT INTO PATIENT VALUES(206,"DURGA", "DURGA BHAWAN", "FEMALE", 110, "2020-07-15");
INSERT INTO PATIENT VALUES(207, "KUSH", "KUSH BHAWAN", "MALE", 106, '2020-07-14');
INSERT INTO PATIENT VALUES(208,"DIVYA", "DICYA BHAWAN", "FEMALE", 107, "2020-07-13");
INSERT INTO PATIENT VALUES(209, "KASTURBA", "KASTURBA BHAWAN", "FEMALE", 108, '2020-07-16');
INSERT INTO PATIENT VALUES(210,"SUPRIYA", "SUPRIYA BHAWAN", "FEMALE", 103, "2020-07-16");
INSERT INTO PATIENT VALUES(211, "RINKU", "RINKU BHAWAN", "FEMALE", 108, '2020-07-14');
INSERT INTO PATIENT VALUES(212,"VAIBHAV", "VAIBHAV BHAWAN", "MALE", 109, "2020-07-09");

ALTER TABLE PATIENT ADD DISCHARGE DATE;
UPDATE PATIENT SET DISCHARGE= "2020--07-19" WHERE PID=201;
UPDATE PATIENT SET DISCHARGE= "2020--07-15" WHERE PID=202;
UPDATE PATIENT SET DISCHARGE= "2020--07-05" WHERE PID=203;
UPDATE PATIENT SET DISCHARGE= "2020--07-18" WHERE PID=204;
UPDATE PATIENT SET DISCHARGE= "2020--07-19" WHERE PID=205;
UPDATE PATIENT SET DISCHARGE= "2020--07-16" WHERE PID=206;
UPDATE PATIENT SET DISCHARGE= "2020--07-16" WHERE PID=207;
UPDATE PATIENT SET DISCHARGE= "2020--07-15" WHERE PID=208;
UPDATE PATIENT SET DISCHARGE= "2020--07-19" WHERE PID=209;
UPDATE PATIENT SET DISCHARGE= "2020--07-19" WHERE PID=210;
UPDATE PATIENT SET DISCHARGE= "2020--07-15" WHERE PID=211;
UPDATE PATIENT SET DISCHARGE= "2020--07-10" WHERE PID=212;

ALTER TABLE PATIENT RENAME COLUMN doc_Id TO DOCID;

SELECT * FROM PATIENT;


/* task 2 query*/
SELECT DOCTOR.DOCID, DOCTOR.DOCNAME, DOCTOR.DEPTNAME, PATIENT.PID, PATIENT.PNAME 
FROM DOCTOR 
JOIN PATIENT ON DOCTOR.DOCID=PATIENT.DOCID;


/*task 3 query*/
SELECT DISCHARGE, count(DISCHARGE) FROM PATIENT WHERE DISCHARGE  BETWEEN '2020-07-13' AND '2020-07-19'  GROUP BY DISCHARGE ORDER BY DISCHARGE DESC;

