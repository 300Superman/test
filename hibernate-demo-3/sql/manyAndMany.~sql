
drop table t_student;
drop table t_course;
drop table t_studentAndCourse;

drop sequence sq_student;
drop sequence sq_course;
drop sequence sq_studentAndCourse;

create table t_student(
  s_id number(4) primary key,
  s_name varchar2(30)
);
create table t_course(
  c_id number(4) primary key,
  c_name varchar2(30)
);
create table t_studentAndCourse(
  sc_id number(8) primary key,
  sc_studentId number(4),
  sc_courseId number(4)
);

create sequence sq_student start with 1001;
create sequence sq_course start with 1001;
create sequence sq_studentAndCourse start with 10000001;

/*
       select * from t_student;
       select * from t_course;
       select * from t_studentAndCourse;
*/
