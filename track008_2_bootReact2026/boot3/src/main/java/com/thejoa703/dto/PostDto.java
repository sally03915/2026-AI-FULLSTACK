package com.thejoa703.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.thejoa703.entity.Hashtag;
import com.thejoa703.entity.Image;
import com.thejoa703.entity.Post;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PostDto {
	// 작성/수정 요청 Dto
	
	@Setter  @Getter  @AllArgsConstructor  @NoArgsConstructor
	public static class PostRequestDto{
		@NotBlank
		private String content;
		private String hashtags;   //#tag1, #tag2 형태의 문자열
	} 
	// 게시글응답 Dto
	@Getter   @Setter  @NoArgsConstructor
	public static class PostResponseDto{
		private Long id;
		private String content;
		private List<String>  imageUrls;
		private List<String>  hashtags;
		private LocalDateTime  createdAt;
		private String  userNickname;
	
		public static PostResponseDto  from(Post post) {
			PostResponseDto  dto = new PostResponseDto();
			dto.setId(  post.getId());
			dto.setContent(  post.getContent());
			
			if(post.getUser()  != null) {  dto.setUserNickname(  post.getUser().getNickname() ); }
			dto.setImageUrls(   post.getImages().stream().map(Image::getSrc).collect(Collectors.toList()) );
			dto.setHashtags(    post.getHashtags().stream().map(Hashtag::getName).collect(Collectors.toList()) );
			dto.setCreatedAt(post.getCreatedAt());
			return dto;
		} 
		public PostResponseDto(Post post) {
			this.id = post.getId();
			this.content = post.getContent();
			this.createdAt = post.getCreatedAt();
			if(post.getUser()  != null) { this.userNickname = post.getUser().getNickname(); }
		} 
	} 
}







