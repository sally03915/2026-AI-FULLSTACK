package com.the703.llmrag;
import lombok.Value; 
@Value
public class Message {
	String role;      // 역할
	String content;   // 질문
}
//@Getter 
//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) 
//  - 모든필드를 private final 변경
//@AllArgsConstructor 
//@ToString 
//@EqualsAndHashCode. 