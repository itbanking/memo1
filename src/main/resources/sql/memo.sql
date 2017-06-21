
drop table memo;


drop sequence memo_mno_seq;
create sequence memo_mno_seq start with 1;
select memo_mno_seq.nextval from dual; 

create table memo (
	mno				number(5) constraint pk_memo primary key,
	title			varchar2(100) not null,
	mcontent 		varchar2(4000),
	mdate 			date,
	membername 		varchar2(15)
);

insert into memo values(memo_mno_seq.nextval, 'title', 'content', sysdate, 'hong');

commit;

set linesize 200
set pagesize 100

select table_name from user_tables;

select * from memo;