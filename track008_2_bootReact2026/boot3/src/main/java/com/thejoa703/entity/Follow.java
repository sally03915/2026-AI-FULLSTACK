package com.thejoa703.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="FOLLOWS" , 
	   uniqueConstraints = @UniqueConstraint(columnNames = {"FOLLOWER_ID" , "FOLLOWEE_ID"}))
@Getter @Setter @NoArgsConstructor 
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "follow_seq")
	@SequenceGenerator(name = "follow_seq" , sequenceName ="FOLLOW_SEQ" , allocationSize = 1)
	Long id;
	
	@Column(name="CREATED_AT" , nullable = false)
	LocalDateTime createdAt;
	
	@PrePersist
	void onCreate() {  this.createdAt = LocalDateTime.now(); } 
	
	public Follow(AppUser follower, AppUser followee) {
		super();
		this.follower = follower;
		this.followee = followee;
	} 
	
	
	@ManyToOne(fetch = FetchType.LAZY)  
	@JoinColumn(name="FOLLOWER_ID" , nullable = false) //1. 연관된 엔티티(AppUser) 당장가져오는게 아니고  
	AppUser  follower;    //@ManyToOne  보는사람

	@ManyToOne(fetch = FetchType.LAZY)  //2. 실제 객체사용하는 시점에서 쿼리 실행 , 불필요한 join 줄이기
	@JoinColumn(name="FOLLOWEE_ID" , nullable = false)
	AppUser  followee;   //@ManyToOne  보여지는사람
	
}
 


/* 팔로워 :  나를 구독하는 사람들  ,내팬     / 팔로잉 :  내가 한 구독             ,김우빈/신민아/카리나
		follower	     followee
		1(나)	         2(김우빈)
		1(나)	     	 3(신민아)
		2(김우빈)          3(신민아)	

		1 나	2 김우빈	3신민아	4카리나	 	
 */



