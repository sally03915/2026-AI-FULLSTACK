package com.thejoa703.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name="COMMENTS" )
@Getter @Setter 
public class Comment {
	@Id   // jakarta.persistence.Id;
	@GeneratedValue(strategy = GenerationType.SEQUENCE  , generator = "comment_seq" )
	@SequenceGenerator(name = "comment_seq" , sequenceName = "COMMENT_SEQ" , allocationSize = 1)
	Long id;
	
	@Lob
	@Column(nullable = false)
	String content;      //게시글내용 ( 긴텍스트 )

	@Column
	boolean  deleted=false;
	
	@Column( name="CREATED_AT" ,  nullable = false)
	LocalDateTime  createdAt;
	
	@Column( name="UPDATED_AT" ,  nullable = false)
	LocalDateTime  updatedAt; 
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() { this.updatedAt = LocalDateTime.now(); }
	
	@ManyToOne
	@JoinColumn( name = "APP_USER_ID" , nullable = false)
	AppUser user;        // @ManyToOne		/ @OneToMany	AppUser		
	
	@ManyToOne
	@JoinColumn( name = "POST_ID" , nullable = false)
	Post  post;          // @ManyToOne      / @OneToMany     Post
}
