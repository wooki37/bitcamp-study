-- 보호자
DROP TABLE IF EXISTS animal_parents RESTRICT;

-- 동물
DROP TABLE IF EXISTS animal RESTRICT;

-- 수의사
DROP TABLE IF EXISTS animal_veterinarian RESTRICT;

-- 병실
DROP TABLE IF EXISTS animal_ward RESTRICT;

-- 동물병원
DROP TABLE IF EXISTS animal_hospital RESTRICT;

-- 수술
DROP TABLE IF EXISTS animal_surgery RESTRICT;

-- 동물보호자
DROP TABLE IF EXISTS animal_protector RESTRICT;

-- 진료
DROP TABLE IF EXISTS animal_diagnosis RESTRICT;

-- 입원
DROP TABLE IF EXISTS animal_admission RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS animal_announcement RESTRICT;

-- 문의게시판
DROP TABLE IF EXISTS animal_board RESTRICT;

-- 병실사진
DROP TABLE IF EXISTS animal_ward_picture RESTRICT;

-- 보호자
CREATE TABLE animal_parents (
  protector_no INTEGER      NOT NULL COMMENT '보호자ID', -- 보호자ID
  pt_name      VARCHAR(50)  NOT NULL COMMENT '보호자성명', -- 보호자성명
  pt_email     VARCHAR(40)  NOT NULL COMMENT '보호자이메일', -- 보호자이메일
  pt_pw        VARCHAR(255) NOT NULL COMMENT '비밀번호', -- 비밀번호
  pt_tel       VARCHAR(30)  NOT NULL COMMENT '보호자전화', -- 보호자전화
  pt_addr      VARCHAR(255) NOT NULL COMMENT '보호자주소', -- 보호자주소
  pt_post      VARCHAR(20)  NULL     COMMENT '우편번호', -- 우편번호
  bas_addr     VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  det_addr     VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  ah_no        INTEGER      NOT NULL COMMENT '동물병원번호' -- 동물병원번호
)
COMMENT '보호자';

-- 보호자
ALTER TABLE animal_parents
  ADD CONSTRAINT PK_animal_parents -- 보호자 기본키
  PRIMARY KEY (
  protector_no -- 보호자ID
  );

ALTER TABLE animal_parents
  MODIFY COLUMN protector_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '보호자ID';

-- 동물
CREATE TABLE animal (
  ani_no     INTEGER      NOT NULL COMMENT '동물ID', -- 동물ID
  ani_name   VARCHAR(50)  NOT NULL COMMENT '동물이름', -- 동물이름
  breeds     VARCHAR(50)  NOT NULL COMMENT '품종', -- 품종
  age        INTEGER      NOT NULL COMMENT '나이', -- 나이
  weight     FLOAT        NOT NULL COMMENT '몸무게', -- 몸무게
  blood_type VARCHAR(255) NULL     COMMENT '혈액형', -- 혈액형
  content    MEDIUMTEXT   NULL     COMMENT '설명' -- 설명
)
COMMENT '동물';

-- 동물
ALTER TABLE animal
  ADD CONSTRAINT PK_animal -- 동물 기본키
  PRIMARY KEY (
  ani_no -- 동물ID
  );

ALTER TABLE animal
  MODIFY COLUMN ani_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '동물ID';

-- 수의사
CREATE TABLE animal_veterinarian (
  v_no    INTEGER     NOT NULL COMMENT '수의사ID', -- 수의사ID
  ah_no   INTEGER     NOT NULL COMMENT '동물병원번호', -- 동물병원번호
  v_name  VARCHAR(50) NOT NULL COMMENT '의사이름', -- 의사이름
  v_intro MEDIUMTEXT  NULL     COMMENT '의사소개' -- 의사소개
)
COMMENT '수의사';

-- 수의사
ALTER TABLE animal_veterinarian
  ADD CONSTRAINT PK_animal_veterinarian -- 수의사 기본키
  PRIMARY KEY (
  v_no -- 수의사ID
  );

ALTER TABLE animal_veterinarian
  MODIFY COLUMN v_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '수의사ID';

-- 병실
CREATE TABLE animal_ward (
  ward_no  INTEGER NOT NULL COMMENT '병실번호', -- 병실번호
  capicity INTEGER NOT NULL COMMENT '수용인원' -- 수용인원
)
COMMENT '병실';

-- 병실
ALTER TABLE animal_ward
  ADD CONSTRAINT PK_animal_ward -- 병실 기본키
  PRIMARY KEY (
  ward_no -- 병실번호
  );

ALTER TABLE animal_ward
  MODIFY COLUMN ward_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '병실번호';

-- 동물병원
CREATE TABLE animal_hospital (
  ah_no          INTEGER      NOT NULL COMMENT '동물병원번호', -- 동물병원번호
  ah_name        VARCHAR(50)  NOT NULL COMMENT '동물병원명', -- 동물병원명
  ah_location    VARCHAR(255) NOT NULL COMMENT '동물병원위치', -- 동물병원위치
  ah_license     VARCHAR(20)  NOT NULL COMMENT '동물병원허가번호', -- 동물병원허가번호
  ah_tel         VARCHAR(30)  NOT NULL COMMENT '동물병원전화', -- 동물병원전화
  ah_opening     DATETIME     NOT NULL COMMENT '동물병원영업시간', -- 동물병원영업시간
  ah_explanation MEDIUMTEXT   NOT NULL COMMENT '동물병원설명' -- 동물병원설명
)
COMMENT '동물병원';

-- 동물병원
ALTER TABLE animal_hospital
  ADD CONSTRAINT PK_animal_hospital -- 동물병원 기본키
  PRIMARY KEY (
  ah_no -- 동물병원번호
  );

ALTER TABLE animal_hospital
  MODIFY COLUMN ah_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '동물병원번호';

-- 수술
CREATE TABLE animal_surgery (
  surgery_no   INTEGER    NOT NULL COMMENT '수술번호', -- 수술번호
  v_no         INTEGER    NOT NULL COMMENT '수의사ID', -- 수의사ID
  ani_no       INTEGER    NOT NULL COMMENT '동물ID', -- 동물ID
  surgery_cont MEDIUMTEXT NOT NULL COMMENT '수술내용', -- 수술내용
  ssdt         DATE       NOT NULL COMMENT '수술일자', -- 수술일자
  sg_insurance BOOLEAN    NOT NULL COMMENT '보험적용여부' -- 보험적용여부
)
COMMENT '수술';

-- 수술
ALTER TABLE animal_surgery
  ADD CONSTRAINT PK_animal_surgery -- 수술 기본키
  PRIMARY KEY (
  surgery_no -- 수술번호
  );

ALTER TABLE animal_surgery
  MODIFY COLUMN surgery_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '수술번호';

-- 동물보호자
CREATE TABLE animal_protector (
  protector_no INTEGER NOT NULL COMMENT '보호자ID', -- 보호자ID
  ani_no       INTEGER NOT NULL COMMENT '동물ID' -- 동물ID
)
COMMENT '동물보호자';

-- 동물보호자
ALTER TABLE animal_protector
  ADD CONSTRAINT PK_animal_protector -- 동물보호자 기본키
  PRIMARY KEY (
  protector_no, -- 보호자ID
  ani_no        -- 동물ID
  );

-- 진료
CREATE TABLE animal_diagnosis (
  diagnosis_no INTEGER      NOT NULL COMMENT '진료번호', -- 진료번호
  ani_no       INTEGER      NOT NULL COMMENT '동물ID', -- 동물ID
  v_no         INTEGER      NOT NULL COMMENT '수의사ID', -- 수의사ID
  symptom      MEDIUMTEXT   NOT NULL COMMENT '증상', -- 증상
  prescription VARCHAR(255) NOT NULL COMMENT '처방내역', -- 처방내역
  expense      INTEGER      NOT NULL COMMENT '진료비', -- 진료비
  dsdt         DATE         NOT NULL COMMENT '진료일자', -- 진료일자
  dn_insurance BOOLEAN      NOT NULL COMMENT '보험적용여부' -- 보험적용여부
)
COMMENT '진료';

-- 진료
ALTER TABLE animal_diagnosis
  ADD CONSTRAINT PK_animal_diagnosis -- 진료 기본키
  PRIMARY KEY (
  diagnosis_no -- 진료번호
  );

ALTER TABLE animal_diagnosis
  MODIFY COLUMN diagnosis_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '진료번호';

-- 입원
CREATE TABLE animal_admission (
  admi_no INTEGER NOT NULL COMMENT '입원번호', -- 입원번호
  ani_no  INTEGER NOT NULL COMMENT '동물ID', -- 동물ID
  ward_no INTEGER NOT NULL COMMENT '병실번호', -- 병실번호
  asdt    DATE    NOT NULL COMMENT '입원일', -- 입원일
  aedt    DATE    NULL     COMMENT '퇴원일' -- 퇴원일
)
COMMENT '입원';

-- 입원
ALTER TABLE animal_admission
  ADD CONSTRAINT PK_animal_admission -- 입원 기본키
  PRIMARY KEY (
  admi_no -- 입원번호
  );

ALTER TABLE animal_admission
  MODIFY COLUMN admi_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '입원번호';

-- 공지사항
CREATE TABLE animal_announcement (
  anno_no      INTEGER      NOT NULL COMMENT '공지사항번호', -- 공지사항번호
  ah_no        INTEGER      NULL     COMMENT '동물병원번호', -- 동물병원번호
  anno_title   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  anno_content LONGTEXT     NOT NULL COMMENT '내용', -- 내용
  anno_cdt     DATE         NULL     COMMENT '등록일' -- 등록일
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE animal_announcement
  ADD CONSTRAINT PK_animal_announcement -- 공지사항 기본키
  PRIMARY KEY (
  anno_no -- 공지사항번호
  );

ALTER TABLE animal_announcement
  MODIFY COLUMN anno_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항번호';

-- 문의게시판
CREATE TABLE animal_board (
  board_no      INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
  ah_no         INTEGER      NOT NULL COMMENT '동물병원번호', -- 동물병원번호
  protector_no  INTEGER      NOT NULL COMMENT '보호자ID', -- 보호자ID
  board_title   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  board_content LONGTEXT     NOT NULL COMMENT '내용', -- 내용
  board_cdt     DATE         NOT NULL COMMENT '등록일', -- 등록일
  answer        VARCHAR(255) NULL     COMMENT '답변' -- 답변
)
COMMENT '문의게시판';

-- 문의게시판
ALTER TABLE animal_board
  ADD CONSTRAINT PK_animal_board -- 문의게시판 기본키
  PRIMARY KEY (
  board_no -- 게시글번호
  );

ALTER TABLE animal_board
  MODIFY COLUMN board_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 병실사진
CREATE TABLE animal_ward_picture (
  ward_picture_no INTEGER      NOT NULL COMMENT '병실사진번호', -- 병실사진번호
  ward_no         INTEGER      NOT NULL COMMENT '병실번호', -- 병실번호
  filename        VARCHAR(255) NULL     COMMENT '병실사진명' -- 병실사진명
)
COMMENT '병실사진';

-- 병실사진
ALTER TABLE animal_ward_picture
  ADD CONSTRAINT PK_animal_ward_picture -- 병실사진 기본키
  PRIMARY KEY (
  ward_picture_no -- 병실사진번호
  );

-- 보호자
ALTER TABLE animal_parents
  ADD CONSTRAINT FK_animal_hospital_TO_animal_parents -- 동물병원 -> 보호자
  FOREIGN KEY (
  ah_no -- 동물병원번호
  )
  REFERENCES animal_hospital ( -- 동물병원
  ah_no -- 동물병원번호
  );

-- 수의사
ALTER TABLE animal_veterinarian
  ADD CONSTRAINT FK_animal_hospital_TO_animal_veterinarian -- 동물병원 -> 수의사
  FOREIGN KEY (
  ah_no -- 동물병원번호
  )
  REFERENCES animal_hospital ( -- 동물병원
  ah_no -- 동물병원번호
  );

-- 수술
ALTER TABLE animal_surgery
  ADD CONSTRAINT FK_animal_TO_animal_surgery -- 동물 -> 수술
  FOREIGN KEY (
  ani_no -- 동물ID
  )
  REFERENCES animal ( -- 동물
  ani_no -- 동물ID
  );

-- 수술
ALTER TABLE animal_surgery
  ADD CONSTRAINT FK_animal_veterinarian_TO_animal_surgery -- 수의사 -> 수술
  FOREIGN KEY (
  v_no -- 수의사ID
  )
  REFERENCES animal_veterinarian ( -- 수의사
  v_no -- 수의사ID
  );

-- 동물보호자
ALTER TABLE animal_protector
  ADD CONSTRAINT FK_animal_parents_TO_animal_protector -- 보호자 -> 동물보호자
  FOREIGN KEY (
  protector_no -- 보호자ID
  )
  REFERENCES animal_parents ( -- 보호자
  protector_no -- 보호자ID
  );

-- 동물보호자
ALTER TABLE animal_protector
  ADD CONSTRAINT FK_animal_TO_animal_protector -- 동물 -> 동물보호자
  FOREIGN KEY (
  ani_no -- 동물ID
  )
  REFERENCES animal ( -- 동물
  ani_no -- 동물ID
  );

-- 진료
ALTER TABLE animal_diagnosis
  ADD CONSTRAINT FK_animal_TO_animal_diagnosis -- 동물 -> 진료
  FOREIGN KEY (
  ani_no -- 동물ID
  )
  REFERENCES animal ( -- 동물
  ani_no -- 동물ID
  );

-- 진료
ALTER TABLE animal_diagnosis
  ADD CONSTRAINT FK_animal_veterinarian_TO_animal_diagnosis -- 수의사 -> 진료
  FOREIGN KEY (
  v_no -- 수의사ID
  )
  REFERENCES animal_veterinarian ( -- 수의사
  v_no -- 수의사ID
  );

-- 입원
ALTER TABLE animal_admission
  ADD CONSTRAINT FK_animal_TO_animal_admission -- 동물 -> 입원
  FOREIGN KEY (
  ani_no -- 동물ID
  )
  REFERENCES animal ( -- 동물
  ani_no -- 동물ID
  );

-- 입원
ALTER TABLE animal_admission
  ADD CONSTRAINT FK_animal_ward_TO_animal_admission -- 병실 -> 입원
  FOREIGN KEY (
  ward_no -- 병실번호
  )
  REFERENCES animal_ward ( -- 병실
  ward_no -- 병실번호
  );

-- 공지사항
ALTER TABLE animal_announcement
  ADD CONSTRAINT FK_animal_hospital_TO_animal_announcement -- 동물병원 -> 공지사항
  FOREIGN KEY (
  ah_no -- 동물병원번호
  )
  REFERENCES animal_hospital ( -- 동물병원
  ah_no -- 동물병원번호
  );

-- 문의게시판
ALTER TABLE animal_board
  ADD CONSTRAINT FK_animal_hospital_TO_animal_board -- 동물병원 -> 문의게시판
  FOREIGN KEY (
  ah_no -- 동물병원번호
  )
  REFERENCES animal_hospital ( -- 동물병원
  ah_no -- 동물병원번호
  );

-- 문의게시판
ALTER TABLE animal_board
  ADD CONSTRAINT FK_animal_parents_TO_animal_board -- 보호자 -> 문의게시판
  FOREIGN KEY (
  protector_no -- 보호자ID
  )
  REFERENCES animal_parents ( -- 보호자
  protector_no -- 보호자ID
  );

-- 병실사진
ALTER TABLE animal_ward_picture
  ADD CONSTRAINT FK_animal_ward_TO_animal_ward_picture -- 병실 -> 병실사진
  FOREIGN KEY (
  ward_no -- 병실번호
  )
  REFERENCES animal_ward ( -- 병실
  ward_no -- 병실번호
  );