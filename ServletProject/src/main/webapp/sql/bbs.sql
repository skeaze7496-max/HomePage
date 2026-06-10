select * from tab;

-- 방명록 테이블 작성
create table visit(
no number(5)not null,
writer varchar2(20)not null,
memo varchar2(4000)not null,
regdate date not null,
constraint VISIT_PK primary key(no)
);

select * from visit;

-- 시퀀스 작성
create sequence visit_seq
start with 1
increment by 1
nomaxvalue
nocache
nocycle;
