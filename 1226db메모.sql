
CREATE TABLE notice(
notice_id number primary key,
notice_writer varchar2(100) not null,
notice_title varchar2(100) not null,
notice_subject varchar2(500) not null,
notice_date date,
hit_count number default 0,
attach_file varchar2(100)
);

CREATE SEQUENCE notice_seq;


INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
VALUES(notice_seq.nextval, '홍길동', '게시사항입니다.', '날씨가 매우 춥습니다.', sysdate);

INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
VALUES(notice_seq.nextval, '홍길동', '게시사항입니다.2', '영하 4도 입니다.', sysdate);

SELECT *
FROM notice;

commit;


select * from notice order by notice_id;


-- 2의 제곱으로 값을 넣어주는거 같은데...?
--
INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
SELECT notice_seq.nextval, notice_writer||notice_seq.currval, notice_title||notice_seq.currval,
notice_subject||notice_seq.currval, sysdate
FROM notice;


-- 1page: 1~10, 2page:11~20

SELECT * FROM
(SELECT ROWNUM rn, a.*
FROM(SELECT * FROM notice order by notice_id DESC) a
WHERE ROWNUM <= 4*10) b
WHERE b.rn >= (4*10-9);
