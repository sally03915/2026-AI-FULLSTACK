package com.thejoa703.entity;
 
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter; 
import lombok.Setter;

@Entity
@Table(name="HASHTAGS")
@Getter @Setter 
public class Hashtag {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "hashtag_seq" )
	@SequenceGenerator(name="hashtag_seq" , sequenceName = "HASHTAG_SEQ" , allocationSize = 1)
	private Long id;
	
	@Column(length=200, nullable = false , unique=true)
	private String name;
	
	@ManyToMany(mappedBy = "hashtags")
	private List<Post>  posts = new ArrayList<>();
}
