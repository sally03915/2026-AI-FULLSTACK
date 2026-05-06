package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ContactDTO {
    private String name;
    private String phone;

    public ContactDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return name + " | " + phone;
    }
}

public class MapEx004 {
    public static void main(String[] args) {
        Map<String, Map<String, ContactDTO>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== 전화번호부 메뉴 ======");
            System.out.println("1. 연락처 추가");
            System.out.println("2. 전체 출력");
            System.out.println("3. 연락처 검색");
            System.out.println("4. 종료");
            System.out.println("===========================");

            System.out.print("메뉴 선택> ");
            int choice = Integer.parseInt(sc.nextLine()); // int로 처리

            switch (choice) {
                case 1: // 연락처 추가
                    System.out.print("그룹 입력 (가족/회사/친구/기타)> ");
                    String group = sc.nextLine();
                    System.out.print("이름 입력> ");
                    String name = sc.nextLine();
                    System.out.print("전화번호 입력> ");
                    String phone = sc.nextLine();

                    // 그룹이 없으면 새로 생성
                    if (!phoneBook.containsKey(group)) {
                        phoneBook.put(group, new HashMap<>());
                    }
                    phoneBook.get(group).put(name, new ContactDTO(name, phone));
                    System.out.println("✅ 연락처 추가 완료!");
                    break;

                case 2: // 전체 출력
                    System.out.println("\n=== 전체 전화번호부 ===");
                    for (String g : phoneBook.keySet()) {
                        System.out.println("📂 그룹: " + g);
                        for (ContactDTO contact : phoneBook.get(g).values()) {
                            System.out.println(contact);
                        }
                        System.out.println("---------------------");
                    }
                    break;

                case 3: // 연락처 검색
                    System.out.print("검색할 그룹 입력> ");
                    String searchGroup = sc.nextLine();
                    System.out.print("검색할 이름 입력> ");
                    String searchName = sc.nextLine();

                    Map<String, ContactDTO> groupMap = phoneBook.get(searchGroup);
                    if (groupMap != null) {
                        ContactDTO result = groupMap.get(searchName);
                        if (result != null) {
                            System.out.println("📞 검색 결과: " + result.getName() + " / " + result.getPhone());
                        } else {
                            System.out.println("⚠️ 해당 이름은 존재하지 않습니다.");
                        }
                    } else {
                        System.out.println("⚠️ 해당 그룹은 존재하지 않습니다.");
                    }
                    break;

                case 4: // 종료
                    System.out.println("프로그램을 종료합니다. 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("⚠️ 잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }
}

/* 
## 📘 연습문제4) Collection Framework + 중첩 HashMap (전화번호부)
패키지명 : com.company.basic014_ex
클래스명 : MapEx004

### 요구사항
1. 중첩 Map 구조 만들기  
   - Map<String, Map<String, ContactDTO>> phoneBook = new HashMap<>();  
   - 첫 번째 Key : 그룹 이름 ("가족", "회사", "친구", "기타")  
   - 두 번째 Key : 이름  
   - Value : ContactDTO 객체  

2. DTO 클래스   
   class ContactDTO {
       private String name;
       private String phone;
       // 생성자, getter/setter, toString()
   }

3. 메뉴 기능 구현
====== 전화번호부 메뉴 ======
1. 연락처 추가 (그룹, 이름, 전화번호 입력 → Map에 저장)
→ 그룹이 없으면 자동으로 생성 후 추가
2. 전체 출력 (그룹별 연락처 출력)
3. 연락처 검색 (그룹과 이름 입력 → 해당 연락처 출력)
4. 종료

📌 실행 예시
====== 전화번호부 메뉴 ======
1. 연락처 추가
2. 전체 출력
3. 연락처 검색
4. 종료
===========================
메뉴 선택> 1
그룹 입력 (가족/회사/친구/기타)> 가족
이름 입력> 홍길동
전화번호 입력> 010-1234-5678
✅ 연락처 추가 완료!

메뉴 선택> 2
=== 전체 전화번호부 ===
📂 그룹: 가족
홍길동 | 010-1234-5678
📂 그룹: 회사
가길동 | 010-1111-1111
📂 그룹: 친구
나길동 | 010-2222-2222
📂 그룹: 기타 
다길동 | 010-3333-3333
*/