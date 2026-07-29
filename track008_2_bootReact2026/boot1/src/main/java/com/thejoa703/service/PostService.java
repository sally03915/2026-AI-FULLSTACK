package com.thejoa703.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true) //##
public class PostService { 
	private final PostRepository     postRepository; 
	private final AppUserRepository  appUserRepository;
	
	//1. 전체게시글조회
	public List<Post>  getAllPosts(){
		return    postRepository.findByDeletedFalse();
	}
	
	//2. 단건조회
	public Post   getPostById(Long id) {
		Post post = postRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글입니다 ID:" + id));
		
		if(post.isDeleted()) {
			throw new IllegalArgumentException("삭제된 게시글 입니다.");
		}
		return post;
	}
	
	//3. 오라클 네이티브페이징조회
	public List<Post>  getPostPaged(int start, int end){
		return    postRepository.findPostsWithPaging(start, end);
	}
	
	//4. 게시글생성 ( save )
	@Transactional
	public Post createPost( Long  userId,  String content) {
		AppUser  user = appUserRepository.findById(userId)
				.orElseThrow( ()-> new IllegalArgumentException("존재하지 않는 사용자입니다. ID : " + userId));
		
		Post post = new Post();
		post.setContent(content);
		post.setUser(user);
		
		return  postRepository.save(post);
	}
	
	//5. 게시글수정 ( save  안쓰고 update 쿼리 반영 )
	@Transactional
	public Post   updatePost(Long postId , String content) {
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글입니다 ID:" + postId));
		
		if(post.isDeleted()) {
			throw new IllegalArgumentException("삭제된 게시글은 수정할 수 없습니다.");
		}
		post.setContent(content);   // 저장메서드를 따로 호출하지 않아도 update 쿼리 반영
		return post; // 더티체킹( Dirty Checking )으로 자동으로 update
	}
	
	//6. 게시글삭제
	@Transactional
	public void   deletePost(Long postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글입니다 ID:" + postId));
		
		post.setDeleted(true);   // 저장메서드를 따로 호출하지 않아도 update 쿼리 반영 
	} 
}

/*   @Transactional(readOnly=true)   더티체킹
더티 체킹(Dirty Checking)은 JPA에서 트랜잭션이 끝나는 시점에 조회했던 엔티티의 값이 변경되었다면, 
별도의 save()나 update() 쿼리 없이 알아서 데이터베이스에 UPDATE 쿼리를 날려주는 기능입니다.

동작 방식  
1. postRepository.findById(postId)로 엔티티를 조회하면, 
   JPA는 이 시점의 최초 상태를 스냅샷으로 만들어 영속성 컨텍스트에 저장합니다.
2. post.setContent(content)로 엔티티의 값을 수정합니다.
3. 메서드가 정상 종료되어 @Transactional 트랜잭션이 커밋될 때, 
   JPA는 최초 스냅샷과 현재 엔티티의 상태를 비교(체킹)합니다. 
4. 값이 다르면 변경된 부분을 감지하고 자동으로 
   UPDATE 쿼리를 생성해서 데이터베이스에 반영합니다.
*/






