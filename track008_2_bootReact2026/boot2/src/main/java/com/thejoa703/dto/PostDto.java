package com.thejoa703.dto;

import java.time.LocalDateTime; 
import com.thejoa703.entity.Post; 
import lombok.Getter;
import lombok.Setter;

public class PostDto {
	// 작성/수정 요청 Dto
	@Setter  @Getter
	public static class PostRequestDto{
		private Long userId;
		private String content;
	} 
	// 게시글응답 Dto
	@Getter
	public static class PostResponseDto{
		private Long id;
		private String content;
		private LocalDateTime  createdAt;
		private String  userNickname;
	
		public PostResponseDto(Post post) {
			this.id = post.getId();
			this.content = post.getContent();
			this.createdAt = post.getCreatedAt();
			if(post.getUser()  != null) {
				this.userNickname = post.getUser().getNickname();
			}
		} 
	} 
}







