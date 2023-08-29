-- myapp_member 테이블 예제 데이터
insert into myapp_member(member_no, name, email, password, gender) 
  values(1, 'aaa', 'aaa@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender) 
  values(2, 'bbb', 'bbb@test.com', sha1('1111'), 'M');
insert into myapp_member(member_no, name, email, password, gender) 
  values(3, 'ccc', 'ccc@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender) 
  values(4, 'ddd', 'ddd@test.com', sha1('1111'), 'M');
insert into myapp_member(member_no, name, email, password, gender) 
  values(5, 'eee', 'eee@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender) 
  values(6, 'fff', 'fff@test.com', sha1('1111'), 'M');
  

-- myapp_patient 테이블 예제 데이터 
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(1, 1, '하루', '고양이', 3, '서울시 동작구', 11112222, 'M');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(2, 1, '하돌', '고양이', 3, '서울시 동작구', 33334444, 'W');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(3, 2, '초코', '사자', 3, '서울시 강남구', 55556666, 'M');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(4, 4, '여름', '팬더', 3, '서울시 중랑구', 77778888, 'W');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(5, 5, '개똥이', '강아지', 3, '서울시 양천구', 99991111, 'W');
insert into myapp_patient(patient_no, parent_no, name, breeds, age, address, phone, gender)
  values(6, 6, '앵무', '조류', 3, '서울시 강서구', 22223333, 'M');
  
  
-- myapp_board 테이블 예제 데이터
insert into myapp_board(board_no, title, content, writer, password, category)
  values(11, '제목1', '내용', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(12, '제목2', '내용', 1, sha1('1111'), 1);
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
  
  


  
  
  
  
  
  
  