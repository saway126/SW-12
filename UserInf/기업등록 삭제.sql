START TRANSACTION;

-- 관련 데이터 삭제
DELETE FROM reservation WHERE user_idx = 2;

-- 관리자 정보 삭제
DELETE FROM manager WHERE idx = 2 AND user_idx = 'pfairpool5';


delete from hospital where manager_id = (select idx from manager where (지우고싶은조건));



COMMIT;

alter table hospital drop foreign key manager_id;

alter TABLE hospital
ADD CONSTRAINT fk_manager
FOREIGN KEY (manager_id) REFERENCES manager(idx)
ON DELETE CASCADE;