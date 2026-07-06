package com.the703.llmrag;

import java.util.List;
import lombok.Value;

@Value
public class LlmRagRequest {
	String model;
	List<Message> messages;
}
 

