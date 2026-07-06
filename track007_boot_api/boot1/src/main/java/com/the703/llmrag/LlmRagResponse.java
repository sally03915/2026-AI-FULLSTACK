package com.the703.llmrag;

import java.util.List; 

public record LlmRagResponse(
	List<Choice> choices
) {}
