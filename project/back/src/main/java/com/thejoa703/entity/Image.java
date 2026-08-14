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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="IMAGES")
@Getter @Setter 
public class Image {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "image_seq" )
	@SequenceGenerator(name="image_seq" , sequenceName = "IMAGE_SEQ" , allocationSize = 1)
	private Long id;
	
	@Column(length=200, nullable = false)
	private String src;
	 
	@ManyToOne // 한 글은 여러 이미지를 갖는다
	@JoinColumn(name="POST_ID" , nullable = false)   // POST_ID 외래키 (FK)   POST엔티티의 PK(ID) 참조
	private Post post;
}



