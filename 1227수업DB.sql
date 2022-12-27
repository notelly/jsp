SELECT *
FROM notice;

INSERT INTO notice(notice_id, notice_writer, notice_title, notice_subject, notice_date)
VALUES(notice_seq.nextval, '이일이', '오늘의 날씨', '5도 맑음', sysdate);

commit;

Delete notice;

INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
VALUES(notice_seq.nextval, '홍길동', '게시사항입니다.', '날씨가 매우 춥습니다.', sysdate);

INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
SELECT notice_seq.nextval, notice_writer||notice_seq.currval, notice_title||notice_seq.currval,
notice_subject||notice_seq.currval, sysdate
FROM notice;

SELECT *
FROM member;

ALTER TABLE member
ADD member_name varchar2(100);

commit;

