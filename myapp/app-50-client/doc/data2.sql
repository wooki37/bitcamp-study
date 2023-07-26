-- myapp_member 테이블 예제 데이터 
insert into myapp_member(member_no, name, email, password, gender)
  values(1,'aaa', 'aaa@tett.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender)
  values(2,'bbb', 'bbb@tett.com', sha1('1111'), 'M');
insert into myapp_member(member_no, name, email, password, gender)
  values(3,'ccc', 'ccc@tett.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender)
  values(4,'ddd', 'ddd@tett.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender)
  values(5,'eee', 'eee@tett.com', sha1('1111'), 'M');
insert into myapp_member(member_no, name, email, password, gender)
  values(6,'fff', 'fff@tett.com', sha1('1111'), 'M');
  
  -- myapp_board 테이블 예제 데이터 
insert into myapp_board(board_no, title, content, writer, password, category)
  values(11, '제목1', '내용', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(12, '제목2', '내용', 2, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(13, '제목3', '내용', 3, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(14, '제목4', '내용', 4, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(15, '제목5', '내용', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(16, '제목6', '내용', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(17, '제목7', '내용', 5, sha1('1111'), 2);
  
  
-- myapp_patient 테이블 예제 데이터 
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(21, 1, '하루', '고양이', 3, '서울시 동작구', 11112222, 'M');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(22, 2, '하돌', '고양이', 3, '서울시 동작구', 33334444, 'W');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(23, 2, '초코', '사자', 3, '서울시 강남구', 55556666, 'M');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(24, 4, '여름', '팬더', 3, '서울시 중랑구', 77778888, 'W');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(25, 5, '개똥이', '강아지', 3, '서울시 양천구', 99991111, 'W');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(26, 6, '앵무', '조류', 3, '서울시 강서구', 22223333, 'M');

  
  
  
  
  
  
  