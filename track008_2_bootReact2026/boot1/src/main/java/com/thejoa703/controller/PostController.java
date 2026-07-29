package com.thejoa703.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag( name="Poist Api" , description="게시판 관련 API"  )   //swagger
@RestController       
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@CrossOrigin(origins="*") 
public class PostController {

	private final PostService postService;
	
	@Operation(summary = "게시글작성" , description = "특정유저 ID와 내용을 받아 게시글을 작성합니다.")
	@PostMapping
	public ResponseEntity<PostResponseDto>  createPost(@RequestBody  PostRequestDto requestDto){
		Post createdPost =postService.createPost(requestDto.getUserId(), requestDto.getContent());
		return  ResponseEntity.ok( new PostResponseDto(createdPost));  // 201
	}
 
	@Operation(summary = "전체게시" , description = "전체게시글")
	@GetMapping   //ctrl + shift + o
	public ResponseEntity<List<PostResponseDto>>  getPosts(){
		List<Post> posts =postService.getAllPosts();
		List<PostResponseDto>  lists =   posts.stream()
											  .map(PostResponseDto::new)  //PostResponseDto
											  .collect(Collectors.toList());   // list로 변경
		return  ResponseEntity.ok( lists );  // 200
	} 
	
	@Operation(summary = "단건게시" , description = "단건게시")
	@GetMapping("/{id}")   //ctrl + shift + o
	public ResponseEntity<PostResponseDto>  getPost(@PathVariable("id")  Long id){
		Post post = postService.getPostById(id);
		return  ResponseEntity.ok(  new  PostResponseDto(post) );  // 200
	} 
	
	@Operation(summary = "게시글 수정" , description = "게시글 수정시")   // 수정 put(전체데이트 수정) , patch( 데이터 일부분수정)
	@PutMapping("/{id}")   //ctrl + shift + o
	public ResponseEntity<PostResponseDto>  getUpdatePost(
			@PathVariable("id")  Long id , 
			@RequestBody PostRequestDto requestDto){
		
		Post post = postService.updatePost(id, requestDto.getContent());
		return  ResponseEntity.ok(  new  PostResponseDto(post) );  // 200
	} 
	
	@Operation(summary = "게시글 삭제" , description = "게시글 삭제시")   // 수정 put(전체데이트 수정) , patch( 데이터 일부분수정)
	@DeleteMapping("/{id}")   //ctrl + shift + o
	public ResponseEntity<Long>  deletePost( @PathVariable("id")  Long id ){
		postService.deletePost(id);
		return  ResponseEntity.ok(id);  // 200
	} 
	 
} 
// 요청 : PostRequestDto ,  응답: PostResponseDto
//- DELETE	/api/posts/{id}		게시글 삭제 	  ※기능:  postService.deletePost 
//- PUT		/api/posts/{id}		게시글 수정     ※기능:  postService.updatePost

//- GET		/api/posts/{id}		게시글 단건 조회 ※기능:  postService.getPostById   
//- GET		/api/posts			전체 게시글 조회 ※기능:  postService.getAllPosts (선택)         , getPostPaged
//- POST	/api/posts			게시글 작성     ※기능:  postService.createPost 
