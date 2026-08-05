package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository  extends JpaRepository<Follow,Long>{  // Entity , PK(★기본키)
	
	// 팔로우 단건조회  - 팔로워/ 팔로위 findBy   ※ Optional<Follow>
	Optional<Follow>  findByFollower_IdAndFollowee_Id(Long followerId  , Long followeeId);
	
	// 팔로잉 목록 조회   findBy     →  AppUser(엔티티)  follower(필드)   id찾기  ※ List<Follow>
	// 1) 쿼리1개     :  findByFollower_Id(1L) 팔로잉 목록 10명   1
	// 2) 추가춰리10개 :  각각의 정보를 가져올려면 쿼리 10번더          N   (11번의 쿼리)  →  11번위 쿼리실행 x
	//-------------------
	// 3) @EntityGraph(attributePaths = {"followee"})     쿼리실행할때 Followee 데이터까지 한꺼번에 조회
	@EntityGraph(attributePaths = {"followee"})
	List<Follow> findByFollower_Id(Long followerId); 
	
	// 팔로워 목록 조회   findBy     →   AppUser(엔티티)  followee(필드)   id찾기  ※ List<Follow>
	@EntityGraph(attributePaths = {"follower"})  
	List<Follow> findByFollowee_Id(Long followeeId); 
	
	// 팔로잉 수 집계     countBy    →  AppUser(엔티티)  follower(필드)   id찾기  ※ long
	long countByFollower_Id( Long followerId );
	
	// 팔로워 수 집계	   countBy    →  AppUser(엔티티)  followee(필드)   id찾기   ※ long
	long countByFollowee_Id( Long followeeId );
}
/*
create  - save      : insert
read    - findAll   : select * from 테이블명
          findById  : select * from 테이블명  where id=?
update  - save      : update 테이블명  set 컬럼1=? ,,,   where id=?  
delete  - delete    : delete from 테이블명  where id=?
*/