-- board 테이블 생성
create table myapp_board(
board_no int not null,
title varchar(255) not null,
content text null,
writer int not null,
password varchar(100) null,
view_count int default 0,
created_date datetime default now(),
category int not null
);

alter table myapp_board
  add constraint primary key (board_no),
  modify column board_no int not null auto_increment;

-- member 테이블 생성
create table myapp_member(
  member_no int not null,
  name varchar(20) not null,
  email varchar(50) not null,
  password varchar(100) not null,
  gender char(1) not null,
  created_date date default (current_date())
);
alter table myapp_member
  add constraint primary key (member_no),
  modify column member_no int not null auto_increment;
  
alter table myapp_member
  add constraint myapp_member_uk unique (email);
  
-- 게시판 작성자에 대해 외부키 설정
alter table myapp_board
  add constraint myapp_board_fk foreign key (writer) references myapp_member (member_no);
  
-- patient 테이블 생성
  create table myapp_patient(
  patient_no int not null,
  parent_no int not null,
  name varchar(20) not null,
  breeds varchar(50) not null,
  age int not null,
  phone int not null,
  address varchar(50) not null,
  gender char(1) not null,
  created_date date default (current_date())
);
alter table myapp_patient
  add constraint primary key (patient_no),
  modify column patient_no int not null auto_increment;

  /*
alter table myapp_patient
  add constraint myapp_patient_fk foreign key () references myapp_board ();
  */
  
  
  
  
  
  
  
  
  
  
  
  