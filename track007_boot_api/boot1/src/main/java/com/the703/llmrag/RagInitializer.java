package com.the703.llmrag;

import static org.hamcrest.CoreMatchers.is;
import java.io.InputStream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class RagInitializer {

    @Bean
    public ApplicationRunner initializePdfData(ResourceLoader resourceLoader, AiService aiService ) {
        return args -> { 
            var pdfResource = resourceLoader.getResource("classpath:docs/company.pdf");
            
            if (pdfResource.exists()) { 
                try (InputStream is = pdfResource.getInputStream()) {
                    String context = aiService.extractTextFromPdf(is); 
                    System.out.println(" [RAG] 기본 PDF 로드 완료! (글자 수: " + context.length() + "자)");
                } catch (Exception e) {
                    System.out.println("[RAG] 기본 PDF 파싱 중 오류 발생: " + e.getMessage());
                }
            } else {
                System.out.println(" [RAG] 'src/main/resources/docs/company.pdf' 파일이 없습니다. 경로를 확인해주세요.");
            }
        };
    }
}