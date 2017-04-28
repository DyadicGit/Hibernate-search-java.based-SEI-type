CREATE TABLE book (
   id VARCHAR(37) NOT NULL PRIMARY KEY,
   title VARCHAR(128) NOT NULL,
   description VARCHAR(256) NOT NULL,
   author VARCHAR(64) NOT NULL,
   createdate DATE NOT NULL,
   updatedate date NOT NULL
);

ALTER TABLE book ADD (
  CONSTRAINT book_pk PRIMARY KEY (ID));

CREATE SEQUENCE book_seq START WITH 1;

--Trigger definition:
CREATE OR REPLACE TRIGGER book_trig 
BEFORE INSERT ON book 
FOR EACH ROW

BEGIN
  SELECT book_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

-----------------------------------------
SELECT * FROM book;

BEGIN
  FOR i IN 6..7 loop
      dbms_output.put_line('i='||i);
          INSERT INTO book (author,createdate,description,title,updatedate) VALUES ('Dyadic', SYSDATE, 'Test_'||i,'Test nr.'||i, SYSTIMESTAMP - i);
  END loop;
END;
INSERT INTO book (ID,author,createdate,description,title,updatedate) VALUES ('3', 'Dyadic2', SYSDATE, 'Test_2','Test nr. 2', SYSTIMESTAMP - 5);
INSERT INTO book (author,createdate,description,title,updatedate) VALUES ('Dyadic2', SYSDATE, 'Test_2','Test nr. 2', SYSTIMESTAMP-10);
alter trigger "SDMX2"."BOOK_TRIG" DISABLE;
delete from book where author = 'Dyadic'