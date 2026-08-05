package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{ //Entity , PK
	List<Post>  findByDeletedFalse();  // List<Post> - 결과 여러개 일때 : List
	
	// 해쉬태그이름으로 게시글 검색 → findBy   (해쉬태그이름: List<Hashtag>  hashtags 필드 name)
	List<Post> findByHashtags_NameAndDeletedFalse(String name);
	
	//비교- 결과값이 1개거나 없을때(null) - Optional
	//Optional<AppUser>  findByEmail(String email);
	@Query(
			value="SELECT * FROM ( " +
	                "SELECT p.*, ROWNUM AS rnum " +
	                "FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
	               ") " +
	               "WHERE rnum BETWEEN :start AND :end" , 
			nativeQuery=true
	)
	List<Post>  findPostsWithPaging(@Param("start")  int start,  @Param("end") int end);
	
	// 특정유저가 좋아요한 게시물
	@Query(value="SELECT * FROM ( " +
                    "SELECT p.*, ROWNUM AS rnum " +
                    "FROM ( " +
                    "   SELECT po.* " +
                    "   FROM POSTS po " +
                    "   WHERE po.ID IN ( " +
                    "       SELECT DISTINCT pl.POST_ID " +
                    "       FROM POST_LIKES pl " +
                    "       WHERE pl.APP_USER_ID = :userId " +
                    "   ) AND po.DELETED = 0 " +  
                    "   ORDER BY po.CREATED_AT DESC " +  
                    ") p " +
                    ") " +
                    "WHERE rnum BETWEEN :start AND :end"	,
          nativeQuery = true          
	) List<Post>  findLikedPostsWithPaging(@Param("userId") Long userId,
									       @Param("start")  int start,  @Param("end") int end);
	
    // 내가 쓴글 + 내가 리트윗한 글 (합쳐서 조회)
	@Query(value="SELECT * FROM ( " +
            "SELECT p.*, ROWNUM AS rnum " +
            "FROM ( " +
            "   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID " +  
            "   FROM POSTS po " +
            "   WHERE po.APP_USER_ID = :userId AND po.DELETED = 0 " +
            "   UNION ALL " +
            "   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID " + 
            "   FROM POSTS po " +
            "   WHERE po.ID IN ( " +
            "       SELECT DISTINCT r.ORIGINAL_POST_ID " +
            "       FROM RETWEETS r " +
            "       WHERE r.APP_USER_ID = :userId " +
            "   ) AND po.DELETED = 0 " +
            "   ORDER BY CREATED_AT DESC " +  
            ") p " +
            ") " +
            "WHERE rnum BETWEEN :start AND :end" , 
            nativeQuery = true)
	List<Post>  findMyPostsAndRetweetsWithPaging(@Param("userId") Long userId,
		       @Param("start")  int start,  @Param("end") int end); 
} 
/*
 (1) 사용할수 있는 기본 SQL
	1. CREATE : save       - insert into  posts ( 컬럼1, 컬럼2,,,)  values (?,?,,,,)
	2. READ   : findAll    - select * from posts
	            findById   - select * from posts  where id=?
	3. UPDATE : save       - update 테이블명  set  컬럼1=?,,,,  where  id=?
	4. DELETE : deleteById - delete from posts  where id=?
 
(2) 삭제 안 된 게시글찾기  findBy필드명   
(3) 복잡한 sql - @Query
*/
