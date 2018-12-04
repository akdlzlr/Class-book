테이블, 시퀀스 생성

DROP TABLE GALLERY;

CREATE TABLE GALLERY(
    GALLERY_ID NUMBER PRIMARY KEY,
    TITLE VARCHAR2(256 CHAR),
    OWNER VARCHAR2(10 CHAR),
    DESCRIPTION VARCHAR2(1024 CHAR),
    READ_CNT NUMBER DEFAULT(0),
    REG_DATE DATE DEFAULT SYSDATE,
    UPDATE_DATE DATE DEFAULT SYSDATE
);

DROP SEQUENCE GALLERY_SEQ;
CREATE SEQUENCE GALLERY_SEQ;


DROP TABLE GALLERY_IMAGE;

CREATE TABLE GALLERY_IMAGE(
    IMAGE_ID NUMBER PRIMARY KEY,
    GALLERY_ID NUMBER REFERENCES GALLERY(GALLERY_ID),
    FILE_NAME VARCHAR2(256 CHAR) NOT NULL,
    TITLE VARCHAR2(256 CHAR) NOT NULL,
    SERVER_FILE_NAME VARCHAR2(256 CHAR),
    SOURCE VARCHAR2(1024 CHAR),
    REG_DATE DATE DEFAULT(SYSDATE),
    UPDATE_DATE DATE DEFAULT(SYSDATE)
    );
DROP SEQUENCE GALLERY_IMAGE_SEQ;
CREATE SEQUENCE GALLERY_IMAGE_SEQ;

commit;
    
------------------------------------------------------------------------  
    
조인으로 연결?


select *
from gallery g,gallery_image i
where g.gallery_id = i.gallery_id(+)
order by g.gallery_id desc;


-------------------------------------------------------------------------
뷰로 만들기
create or replace view gallery_detail
as
select 
    g.gallery_id, g.title, g.owner,
    g.description, g.reg_date, g.update_date,
    i.image_id, i.title image_title,
    i.file_name, i.server_file_name, i.source,
    i.reg_date image_reg_date, i.update_date image_update_date
from gallery g,gallery_image i
where g.gallery_id = i.gallery_id(+)
order by g.gallery_id desc;

----------------------------------------------------------------------------

select * from gallery;


-----------------------------------------------------------------------------

ALTER TABLE GALLERY
ADD (READ_CNT NUMBER DEFAULT(0));

UPDATE GALLERY SET
READ_CNT=0;


------------------------------------------------------------------------------
------------------------------------------------------------------------------
- 게시판 
- 보드 테이블

DROP TABLE BOARD;
CREATE TABLE BOARD(
    BOARD_ID NUMBER PRIMARY KEY,
    TITLE VARCHAR2(256) NOT NULL,
    WRITER VARCHAR2(50) NOT NULL,
    PASSWORD VARCHAR(20) NOT NULL,
    READ_CNT NUMBER,
    CONTENT CLOB,
    REG_DATE DATE DEFAULT(SYSDATE),
    UPDATE_DATE DATE DEFAULT(SYSDATE)
    );

DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ;


- 첨부 파일 테이블 정의

DROP TABLE ATTACHMENT;

CREATE TABLE ATTACHMENT(
    ATTACHMENT_ID NUMBER PRIMARY KEY,
    FILE_NAME       VARCHAR2(256),
    LOCATION        VARCHAR2(1024),
    BOARD_ID        NUMBER,
    REG_DATE        DATE DEFAULT(SYSDATE),
    CONSTRAINT      F_ATTACHMENT_BOARD FOREIGN KEY(BOARD_ID)
           REFERENCES board(BOARD_ID)
    );
DROP SEQUENCE ATTACHMENT_SEQ;
CREATE SEQUENCE ATTACHMENT_SEQ; 

COMMIT;


---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------
- AVATA 테이블 정의
 
DROP TABLE AVATA;

CREATE TABLE AVATA(
    user_id VARCHAR2(20) PRIMARY KEY,
    image BLOB
    );


