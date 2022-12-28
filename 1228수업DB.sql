SELECT * from member;

DELETE notice
WHERE notice_id = '1028';

commit;


UPDATE notice
set notice_writer =  case mod(notice_id, 4) when 1 then 'user1'
                                            when 2 then 'user2'
                                            when 3 then 'user3'
                                            else 'user4'
                     end
where notice_id > 1;


insert into member
values('admin', '1234', '010-1234-1234', '', 'Admin', null, '관리자');

ALTER table Member modify member_rank default 'User';


SELECT * FROM(SELECT ROWNUM rn, a. * FROM member a WHERE a.member_rank = 'User') WHERE rn between 1 and 5;


CREATE TABLE tbl_book(
book_code varchar2(10) primary key,
book_title varchar2(100) not null,
book_author varchar2(100)not null,
book_press varchar2(100)not null,
book_price number default 0
);

DESC tbl_book;

SELECT *
FROM tbl_book;

SELECT * FROM tbl_book ORDER BY book_code;

INSERT INTO tbl_book VALUES ('B0001', '김자바', '이것은자바다', '자바출판사', 1000);
commit;


SELECT * FROM tbl_book WHERE book_code = 'B0001';
