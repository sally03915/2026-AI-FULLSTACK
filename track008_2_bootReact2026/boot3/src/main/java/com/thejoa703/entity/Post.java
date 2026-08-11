package com.thejoa703.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="POSTS")
@Getter  @Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "post_seq")
	@SequenceGenerator(name = "post_seq" , sequenceName ="POST_SEQ" , allocationSize = 1)
	private Long id;
	
	@Column
	private boolean  deleted=false;
	
	@Column(nullable = false,  name = "CREATED_At")
	private LocalDateTime createdAt;
	
	@Column(nullable = false,  name = "UPDATED_At")
	private LocalDateTime updatedAt;
	
	@Lob // 대용량데이터처리 - CLOB(문자열) , BLOB(이미지, 파일, 오디오, 영상,,,,)
	@Column(nullable = false)
	private String content;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	 
	// 한 사람이 ★여러 글을 쓸수 있다.   (Post)
	@ManyToOne   //1. 다대일
	@JoinColumn(name="APP_USER_ID" , nullable = false)
	private AppUser user;
	
	// 한 글은 여러 이미지를 갖는다
	@OneToMany( mappedBy= "post",   cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Image>  images = new ArrayList<>();
	
	@OneToMany( mappedBy= "post",   cascade = CascadeType.ALL , orphanRemoval = true)
	private List<PostLike>  likes = new ArrayList<>();

	@OneToMany( mappedBy= "post",   cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Comment>  comments = new ArrayList<>();
	
	@OneToMany( mappedBy= "originalPost",   cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Retweet>  retweets = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name="POST_HASHTAG" ,
		joinColumns = @JoinColumn(name="POST_ID") ,
		inverseJoinColumns =  @JoinColumn(name="HASHTAG_ID") 
	)
	private List<Hashtag>  hashtags = new ArrayList<>();
}
