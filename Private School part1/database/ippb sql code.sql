-- DROP DATABASE `individualprojectpartb`;
CREATE DATABASE IF NOT EXISTS`individualprojectpartb`;
USE `individualprojectpartb`;

-- TABLES CREATION--

CREATE TABLE IF NOT EXISTS `individualprojectpartb`.`course` 
(
`id` INTEGER AUTO_INCREMENT NOT NULL,
`title` VARCHAR(50),
`stream` VARCHAR(50),
`type` VARCHAR(50),
`startdate` DATE,
`enddate` DATE,
 PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `individualprojectpartb`.`trainer` 
(
`id` INTEGER AUTO_INCREMENT NOT NULL,
`firstname` VARCHAR(50),
`lastname` VARCHAR(50),

 PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `individualprojectpartb`.`student` 
(
`id` INTEGER AUTO_INCREMENT NOT NULL,
`firstname` VARCHAR(50),
`lastname` VARCHAR(50),
`dateofbirth` DATE,
`tuitionfees` DECIMAL(8,2),
 PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `individualprojectpartb`.`assigment` 
(
`id` INTEGER AUTO_INCREMENT NOT NULL,
`title` VARCHAR(50),
`description` VARCHAR(50),
`subdatetime` DATE,
`oralmark` INTEGER,
`totalmark` INTEGER,
`course` INT,
 PRIMARY KEY (`id`),
 CONSTRAINT `fk_assigment_course_course_id` -- WE HAVE CREATED A 1-N RELATION BETWEEN COURSES AND ASSIGMENTS
 FOREIGN KEY(`course`)
 REFERENCES `individualprojectpartb`.`course` (`id`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION
);





-- ADDING DATA TO TABLES --
-- trainers
INSERT INTO `individualprojectpartb`.`trainer`
(`firstname`,`lastname`)
VALUES
('Giorgos','Pasparakis'),
('Anastasios', 'Lelakis'),
('Spyridon','Mavros'),
('Panagiotis','Bozas'),
('Argiris','Pagidas'),
('Kostantinos','Minaidis'),
('Nerina','Pyrovolikou');


-- students
INSERT INTO `individualprojectpartb`.`student`
(`firstname`,`lastname`, `dateofbirth`,`tuitionfees`)
VALUES
(Petros,'Papadakis','2000-01-20',1500),
('Giannis','Balokas','1988-03-10',1600),
('Maria','Karra','1985-03-16',1500),
('Anna','Nene','1998-05-15',2000),
('Dimitris','Raptis','1988-03-10',2000),
('Anna','Kiroudi','1978-03-10',2000),
('Antonis','Maimaris','1998-05-06',1600),
('Konstantinos','Aggelakis','1977-11-10',2000),
('Petros','Nakos','1985-11-10',1500),
('Giorgos','Bantekas','1988-11-10',1500),
('Maria','Papadopoulou','1982-10-17',1500),
('Panos','Sykas','1984-11-12',1500),
('Petros','Soursos','1987-11-10',1500),
('Giorgos','Mitros','1986-11-10',2000),
('Maria','Deligianni','1975-03-14',1500),
('Dimitra','Kapsali','1987-01-05',2000),
('Alex','Pavlis','1985-11-10',1500),
('Giannis','Makos','1990-12-10',2000);


-- courses
INSERT INTO `individualprojectpartb`.`course` 
(`title`, `stream`, `type`, `startdate`, `enddate`)
VALUES
('CB12','Java','Full time','2020-10-10', '2021-02-10'),
('CB12','Python','Full time','2020-10-10', '2021-02-10'),
('CB12','C#','Full time','2020-10-10', '2021-02-10'),
('CB12','JavaScript','Full time','2020-10-10', '2021-02-10'),
('CB12','Java','Part time','2020-10-10', '2021-06-12'),
('CB12','Python','Part time','2020-10-10', '2021-06-12'),
('CB12','C#','Part time','2020-10-10', '2021-06-12'),
('CB12','JavaScript','Part time','2020-10-10', '2021-06-12');

-- assigments

INSERT INTO `individualprojectpartb`.`assigment`
(`title`, `description`,`subdatetime`,`oralmark`,`totalmark`,`course`)
VALUES
('Individual project CB2021 FT', 'Java', '2021/10/05', 20, 100,1),
('Individual project CB2021 FT', 'C#', '2021/10/05', 20, 100,2),
('Individual project CB2021 FT', 'Python', '2021/10/05', 20, 100,3),
('Individual project CB2021 FT', 'JavaScrpit', '2021/10/05', 20, 100,4),
('Group project CB2021 FT', 'Java', '2021/10/05', 20, 100,1),
('Group project CB2021 FT', 'C#', '2021/10/05', 20, 100,2),
('Group project CB2021 FT', 'Python', '2021/10/05', 20, 100,3),
('Group project CB2021 FT', 'JavaScrpit', '2021/10/05', 20, 100,4),
('Individual project CB2021 PT', 'Java', '2021/10/05', 20, 100,1),
('Individual project CB2021 PT', 'C#', '2021/10/05', 20, 100,2),
('Individual project CB2021 PT', 'Python', '2021/10/05', 20, 100,3),
('Individual project CB2021 PT', 'JavaScrpit', '2021/10/05', 20, 100,4),
('Group project CB2021 PT', 'Java', '2021/10/05', 20, 100,1),
('Group project CB2021 PT', 'C#', '2021/10/05', 20, 100,2),
('Group project CB2021 PT', 'Python', '2021/10/05', 20, 100,3),
('Group project CB2021 PT', 'JavaScrpit', '2021/10/05', 20, 100,4);



-- COMBINE TABLES TO CREATE RELATIONAL DATA--

-- COMBINE TABLE STUDENTS WITH COURSES WE NEED A RELATION M-N MANY STUDENTS TO MANY COURSES SO WE NEED A NEW TABLE IN BETWEEN

CREATE TABLE IF NOT EXISTS `individualprojectpartb`.`studentscourses` (
`id` INTEGER NOT NULL AUTO_INCREMENT,
`stid` INTEGER NOT NULL,
`cid` INTEGER NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_studentscourses_stid_student_id`
FOREIGN KEY(`stid`)
REFERENCES `individualprojectpartb`.`student`(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
-- --------------
CONSTRAINT `fk_studentscourses_cid_course_id`
FOREIGN KEY(`cid`)
REFERENCES `individualprojectpartb`.`course`(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
);

-- ADDING DATA TO COMBINATION TABLE--

INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('1', '1');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('2', '1');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('3', '1');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('4', '1');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('5', '1');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('6', '1');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('7', '2');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('8', '2');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('9', '2');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('10', '3');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('11', '3');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('12', '3');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('13', '3');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('14', '4');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('15', '4');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('16', '4');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('17', '4');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('18', '5');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('5', '5');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('6', '5');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('4', '5');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('7', '5');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('8', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('9', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('10', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('11', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('12', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('13', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('14', '6');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('1', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('2', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('3', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('4', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('5', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('6', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('7', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('8', '7');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('9', '8');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('1', '8');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('7', '8');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('4', '8');
INSERT INTO `individualprojectpartb`.`studentscourses` (`stid`, `cid`) VALUES ('2', '8');


-- COMBINE TABLE TRAINER WITH COURSES WE NEED A RELATION M-N MANY TRAINERS TO MANY COURSES SO WE NEED A NEW TABLE IN BETWEEN

CREATE TABLE IF NOT EXISTS `individualprojectpartb`.`trainerscourses` (
`id` INTEGER NOT NULL AUTO_INCREMENT,
`trid` INTEGER NOT NULL,
`cid` INTEGER NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_trainerscourses_trid_trainer_id`
FOREIGN KEY(`trid`)
REFERENCES `individualprojectpartb`.`trainer`(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
-- --------------
CONSTRAINT `fk_trainerscourses_cid_course_id`
FOREIGN KEY(`cid`)
REFERENCES `individualprojectpartb`.`course`(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
);


INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('1', '1');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('3', '1');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('4', '1');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('5', '2');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('1', '2');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('5', '2');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('4', '2');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('7', '3');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('2', '3');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('5', '4');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('3', '4');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('1', '4');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('4', '5');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('6', '5');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('1', '5');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('7', '6');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('5', '6');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('1', '6');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('2', '6');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('7', '6');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('4', '6');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('5', '7');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('6', '7');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('7', '7');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('4', '8');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('7', '8');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('5', '8');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('6', '8');
INSERT INTO `individualprojectpartb`.`trainerscourses` (`trid`, `cid`) VALUES ('2', '8');

-- QUERIES -- 

-- A list of all the courses
SELECT * FROM `individualprojectpartb`.`course`;

-- A list of all the trainers
SELECT * FROM `individualprojectpartb`.`trainer`;

-- A list of all the students
SELECT * FROM `individualprojectpartb`.`student`;

-- A list of all the assignments
SELECT * FROM `individualprojectpartb`.`assigment`;

-- All the students per course
SELECT `course`.`title`, `course`.`stream`, `course`.`type`,  `student`.`firstname`, `student`.`lastname`
FROM `student`
JOIN `studentscourses` ON `studentscourses`.`stid`=`student`.`id`
JOIN `course` ON `studentscourses`.`cid` = `course`.`id`
ORDER BY `course`.`stream`, `course`.`type`;

-- All the trainers per course
SELECT `course`.`title`, `course`.`stream`, `course`.`typse`,  `trainer`.`firstname`, `trainer`.`lastname`
FROM `trainer`
JOIN `trainerscourses` ON `trainerscourses`.`trid`=`trainer`.`id`
JOIN `course` ON `trainerscourses`.`cid` = `course`.`id`
ORDER BY `course`.`stream`, `course`.`type`;

-- All the assignments per course
SELECT `course`.`title`, `course`.`stream`, `course`.`type`,  `assigment`.`title`
FROM `assigment`
JOIN `course` ON `assigment`.`course`=`course`.`id`
ORDER BY `course`.`stream`, `course`.`type`;


-- All the assignments per course per student
SELECT student.firstname, student.lastname, CONCAT(`course`.`title`," ", `course`.`stream`," ", `course`.`type`) AS course, assigment.title 
FROM course
INNER JOIN assigment ON assigment.course=course.id
INNER JOIN studentscourses ON studentscourses.id=stid
INNER JOIN student ON studentscourses.stid=student.id
ORDER BY student.firstname, student.lastname;

-- A list of students that belong to more than one courses
SELECT * FROM (
SELECT COUNT(`cid`) AS 'number of courses', `student`.`firstname`, `student`.`lastname`
FROM `student`
INNER JOIN `studentscourses` ON `student`.`id`=`studentscourses`.`stid`
INNER JOIN `course` ON `course`.`id`=`studentscourses`.`cid` 
GROUP BY `student`.`firstname`, `student`.`lastname`
) AS TEMPRESULT
WHERE  `number of courses`>1;
