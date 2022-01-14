insert into exam (code, name) 
values (10001, 'Criminological Theory'), 
	   (10002, 'Comprehensive Exam'),
       (10003, 'Crime and Justice');

select @ct:=id from exam where code = 10001;
select @ce:=id from exam where code = 10002;
select @caj:=id from exam where code = 10003;

insert into student_exam (student_id, exam_id, passed, mark)
values (1, @ct, 1, 8),
       (1, @ce, 1, 9),
       (1, @caj, 0, 0);

insert into student_exam (student_id, exam_id, passed, mark)
values (2, @ct, 1, 8),
       (2, @ce, 1, 9),
       (2, @caj, 0, 0);

insert into student_exam (student_id, exam_id, passed, mark)
values (3, @ct, 1, 8),
       (3, @ce, 1, 9),
       (3, @caj, 0, 0);