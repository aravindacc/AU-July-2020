CREATE TABLE DOCTOR(doc_Id integer, doc_Name varchar(255), 
					doc_Add varchar(255), dept_Id integer,
                    dept_Name varchar(255));
ALTER TABLE DOCTOR ADD PRIMARY KEY (doc_Id);
ALTER TABLE DOCTOR MODIFY doc_Id integer NOT NULL;
ALTER TABLE DOCTOR ADD UNIQUE (doc_Id);
insert into DOCTOR values(101, "Neeraj", "Jamnagar", 1, "ENT");
INSERT INTO DOCTOR VALUES(102, "Kuldeep", "Jamnagar", 2, "Cardiologists"),
						(103, "Rahul", "Jhansi", 3, "Dermatologists"),
                        (104, "Tulsi", "Jammu", 4, "Neurologists"),
                        (105, "Kavita", "Bikaner", 5, "Pediatricians" ),
                        (106, "Shriya", "Ludhiana", 6, "Dentist"),
                        (107, "Bhavya", "Delhi", 7, "Plastic Surgeon"),
                        (108, "Deepti", "Ajmer", 8, "Psychiatrists"),
                        (109, "Simran", "Meerut", 9, "Immunologist"),
                        (110, "Bhism", "Indore", 10, "Oncologist"),
                        (111, "Deepak", "Bangalore", 11, "Anesthesiologist");
SELECT * FROM DOCTOR;

ALTER TABLE DOCTOR RENAME COLUMN doc_Id TO DOCID;
ALTER TABLE DOCTOR RENAME COLUMN doc_Name TO DOCNAME;
ALTER TABLE DOCTOR RENAME COLUMN doc_Add TO DOCADD;
ALTER TABLE DOCTOR RENAME COLUMN dept_Id TO DEPTID;
ALTER TABLE DOCTOR RENAME COLUMN dept_Name TO DEPTNAME;



