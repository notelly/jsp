SELECT *
FROM notice;

INSERT INTO notice(notice_id, notice_writer, notice_title, notice_subject, notice_date)
VALUES(notice_seq.nextval, '������', '������ ����', '5�� ����', sysdate);

commit;

Delete notice;

INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
VALUES(notice_seq.nextval, 'ȫ�浿', '�Խû����Դϴ�.', '������ �ſ� ����ϴ�.', sysdate);

INSERT INTO notice (notice_id, notice_writer, notice_title, notice_subject, notice_date)
SELECT notice_seq.nextval, notice_writer||notice_seq.currval, notice_title||notice_seq.currval,
notice_subject||notice_seq.currval, sysdate
FROM notice;

SELECT *
FROM member;

ALTER TABLE member
ADD member_name varchar2(100);

commit;

