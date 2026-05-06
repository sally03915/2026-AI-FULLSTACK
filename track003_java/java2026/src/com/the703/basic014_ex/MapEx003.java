package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BookDTO {
    private String title;
    private String author;
    public BookDTO(){}
    public BookDTO(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return title + " | " + author;
    }
}

public class MapEx003 {
    public static void main(String[] args) {
        // 중첩 Map: 지점 → (ISBN → BookDTO)
        Map<String, Map<String, BookDTO>> library = new HashMap<>();

        // ver-1
        // // 서울점 도서관
        // Map<String, BookDTO> seoulBooks = new HashMap<>();
        // seoulBooks.put("978-11111", new BookDTO("자바의 정석", "남궁성"));
        // seoulBooks.put("978-22222", new BookDTO("파이썬 기초", "홍길동"));

        // // 부산점 도서관
        // Map<String, BookDTO> busanBooks = new HashMap<>();
        // busanBooks.put("978-33333", new BookDTO("자료구조와 알고리즘", "이순신"));
        // busanBooks.put("978-44444", new BookDTO("파이썬 심화", "홍길동"));

        // library.put("서울점", seoulBooks);
        // library.put("부산점", busanBooks);

        
        // ver-2
        // 그룹이 없으면 새로 생성 
        // 초기 데이터 배열 (지점, ISBN, 제목, 저자)
        String[][] data = {
            {"서울점", "978-11111", "자바의 정석", "남궁성"},
            {"서울점", "978-22222", "파이썬 기초", "홍길동"},
            {"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
            {"부산점", "978-44444", "파이썬 심화", "홍길동"}
        };

        // 배열 데이터를 Map에 넣기 (putIfAbsent 없이)
        for (String[] row : data) {
            String branch = row[0];
            String isbn = row[1];
            String title = row[2];
            String author = row[3];

            // 그룹이 없으면 새로 생성
            if (!library.containsKey(branch)) {
                library.put(branch, new HashMap<>());
            }
            library.get(branch).put(isbn, new BookDTO(title, author));
        }


        // 출력
        System.out.println("=== 도서관 전체 목록 ===");
        for (Map.Entry<String, Map<String, BookDTO>> branch : library.entrySet()) {
            System.out.println("📚 " + branch.getKey());
            for (Map.Entry<String, BookDTO> book : branch.getValue().entrySet()) {
                System.out.println(book.getKey() + " | " + book.getValue());
            }
            System.out.println("---------------------");
        }

        // 사용자 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("지점 이름 입력> ");
        String branchInput = sc.nextLine();
        System.out.print("ISBN 입력> ");
        String isbnInput = sc.nextLine();

        if (library.containsKey(branchInput)) {
            BookDTO result = library.get(branchInput).get(isbnInput);
            if (result != null) {
                System.out.println("📖 선택한 도서 정보: " + result.getTitle() + " / 저자: " + result.getAuthor());
            } else {
                System.out.println("⚠️ 해당 ISBN은 존재하지 않습니다.");
            }
        } else {
            System.out.println("⚠️ 해당 지점은 존재하지 않습니다.");
        }

        sc.close();
    }
}
 
/*
## 📘 연습문제3) Collection Framework + 중첩 HashMap
패키지명 : com.company.basic014_ex
클래스명 : MapEx003

### 요구사항
1. 중첩 Map 구조 만들기  
   - Map<String, Map<String, BookDTO>> library = new HashMap<>();  
   - 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
   - 두 번째 Key : ISBN  
   - Value : BookDTO 객체  
   - 다음의 데이터 이용할것
    String[][] data = {
        {"서울점", "978-11111", "자바의 완성", "가길동"},
        {"서울점", "978-22222", "파이썬 기초", "홍길동"},
        {"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
        {"부산점", "978-44444", "파이썬 심화", "홍길동"}
    };


2. DTO 클래스  
   java
   class BookDTO {
       private String title;
       private String author;
       // 생성자, getter/setter, toString()
   }
   

3. 출력하기  
   - 각 지점별 도서 목록 출력  

4. 사용자 입력받기  
   - 지점 이름과 ISBN을 입력받아 해당 도서 정보 출력  

### 📌 실행 예시 
=== 도서관 전체 목록 ===
📚 서울점
978-11111 | 자바의 완성 | 가길동
978-22222 | 파이썬 기초 | 홍길동
---------------------
📚 부산점
978-33333 | 자료구조와 알고리즘 | 이순신
978-44444 | 파이썬 심화 | 홍길동
---------------------
지점 이름 입력> 서울점
ISBN 입력> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동
*/
 