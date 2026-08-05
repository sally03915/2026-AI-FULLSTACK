package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; 
import com.thejoa703.entity.Hashtag; 

@Repository
public interface HashtagRepository  extends JpaRepository<Hashtag, Long> {
	// @Query 원하는 sql   -   	@ManyToMany(mappedBy = "hashtags")
	@Query("SELECT    h     FROM    Hashtag  h  JOIN  FETCH  h.posts WHERE h.name= :name")
	Optional<Hashtag> findByNameWithPosts(@Param("name")  String name);
	// jpa 쿼리 메서드 사용 - findBy필드명
	Optional<Hashtag>   findByName(String name);
}
/*
create  - save      : insert
read    - findAll   : select * from 테이블명
          findById  : select * from 테이블명  where id=?
update  - save      : update 테이블명  set 컬럼1=? ,,,   where id=?  
delete  - delete    : delete from 테이블명  where id=?
*/