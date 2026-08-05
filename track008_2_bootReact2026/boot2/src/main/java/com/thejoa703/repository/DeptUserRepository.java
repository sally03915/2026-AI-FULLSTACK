package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.domain.DeptUser;

@Repository
public interface DeptUserRepository  extends JpaRepository<DeptUser,Long>{  // Entity , PK(★기본키)
}
/*
create  - save      : insert
read    - findAll   : select * from 테이블명
          findById  : select * from 테이블명  where id=?
update  - save      : update 테이블명  set 컬럼1=? ,,,   where id=?  
delete  - delete    : delete from 테이블명  where id=?
*/