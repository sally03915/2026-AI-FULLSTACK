package com.thejoa703.repository;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.AppUser;

@Repository											  // Entity , PK-자료형
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	Optional<AppUser>  findByEmail(String email);
}

// create - save	   : insert into app_user (컬럼,,,)  values (?,?,?,,,)
// read   - findAll    : select * from app_user
//			findById   : select * from app_user where id=?
// update - save	   : update  테이블명  set  컬럼1=?  where  id=? 
// delete - deleteById : delete from 테이블명  where id=?

//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
/*
1.   검색 : findBy필드명
*/


