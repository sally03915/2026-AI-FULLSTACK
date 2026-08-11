package com.thejoa703.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(  name="RETWEETS"  ,
	uniqueConstraints = @UniqueConstraint(
			name="UK_RETWEET_USER_ORIG" ,  columnNames = {"APP_USER_ID" , "ORIGINAL_POST_ID"}
	)
)
@Getter @Setter @NoArgsConstructor 
public class Retweet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "retweet_seq")
	@SequenceGenerator(name = "retweet_seq" , sequenceName ="RETWEET_SEQ" , allocationSize = 1)
	Long id;
	
	@Column(name="CREATED_AT" , nullable = false)
	LocalDateTime  createdAt;
	
	@PrePersist
	void onCreate() {  this.createdAt = LocalDateTime.now();  }
	public Retweet(AppUser user, Post originalPost) {
		super();
		this.user = user;
		this.originalPost = originalPost;
	} 
	@ManyToOne
	@JoinColumn(name="APP_USER_ID"  ,  nullable = false )
	AppUser  user;      //리트윗한 사람    @ManyToOne

	@ManyToOne
	@JoinColumn(name="ORIGINAL_POST_ID"  ,  nullable = false )  // ORIGINAL_POST_ID  라는 외래키 (FK)
	Post  originalPost;  //리트윗한글번호 @ManyToOne
}
 





