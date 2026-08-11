package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.entity.PostLike;

@Repository
public interface PostLikeRepository   extends JpaRepository<PostLike, Long>{
	//특정 게시글의 좋아요 수 집계 (countBy)  
	long  countByPostId(Long postId);
	
	//특정유저가 특정게시글에 좋아요 했는지 집계 AppUser  user 필드와 Post post 각각의 id가 있는지 확인
	// 엔티티(AppUser)와 필드명(user)이 다를때   찾을꺼는 id값 찾아야함.
	long  countByUser_IdAndPost_Id(Long userId, Long postId);

	//특정유저가 특정게시글에 좋아요 했는지  조회
	Optional<PostLike> findByUser_IdAndPost_Id(Long userId, Long postId);
	
	//좋아요취소
	//방법1: long deleteByUser_IdAndPost_Id(Long userId, Long postId);     → select (데이터베이스 조회) delete(개별삭제)
	//방법2: @Query (select 조회용도)    →  db 가서 바로 delete
	// Insert/Update/Delete  @Modifying  @Transactionl
	// DELETE FROM PostLike p1  WHERE  pl.user.id=:userId  AND  pl.post.id=:postId
	@Modifying      // select 조회가 아니라 update/delete 용도
	@Transactional  // 안전장치
	@Query("DELETE FROM PostLike pl  WHERE   pl.user.id=:userId  AND   pl.post.id=:postId")  
	void  deleteByUser_IdAndPost_Id(@Param("userId") Long userId,  @Param("postId")  Long postId);
}
