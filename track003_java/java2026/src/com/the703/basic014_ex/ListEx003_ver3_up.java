package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////
//1. 아이스크림정보 클래스
class IceCreamDTO{
	private String name;
	private int    price; 
	// 생성자, 필요하다면 추가   , toString , getters/setters  ,  hashCode/equals
	public IceCreamDTO() { super(); }
	public IceCreamDTO(String name) { super(); this.name = name; }  //##
	public IceCreamDTO(String name, int price) { super(); this.name = name; this.price = price; }
	@Override public String toString() { return "- " + name + " (" + price + ")"; }    //##
	
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getPrice() { return price; } public void setPrice(int price) { this.price = price; }
	
	//1. IceCreamDTO 확인   ##
	@Override public int hashCode() { return Objects.hash(name); }
	//2. 값확인 ##
	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		IceCreamDTO other = (IceCreamDTO) obj;
		return Objects.equals(name, other.name);
	}
}  
////////////////////////////////////////////////////////////////////////////
//2. List 사용클래스
public class ListEx003_ver3_up { 
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);  String name="";   int price=0 , choice=-1;  
		 List<IceCreamDTO>  list = new ArrayList<>();
		 
         System.out.println("❄️🍦 Welcome to the Magical IceCream Land 🍦❄️");
         System.out.println("✨ 오늘도 달콤한 하루가 시작됩니다! ✨\n" + "🛎️ 손님~ 어떤 아이스크림을 원하시나요?\n");
		 
		 while( choice != 0) { 
			System.out.print("\n\n\n📋 메뉴판 \n" + "🍧 IceCream Menu 🍧  \n" + "1️ 아이스크림 추가\n" + "2️ 아이스크림 목록 보기\n" + "3️ 아이스크림 제거\n" + "4️ 아이스크림 존재 확인\n" + "5️ 총 아이스크림 개수\n" +      "6️ 총 아이스크림 정렬  1) 이름  2) 가격\n" +  "0️ 종료\n" + "👉 선택:");
			choice = scanner.nextInt();
			
			switch(choice) {
				case 1 : 
					System.out.print("🍓 아이스크림 이름 : "); name = scanner.next();
					System.out.print("💰 가격          : "); price = scanner.nextInt();   
					list.add( new  IceCreamDTO( name , price) );
					System.out.println("✅ "+name+" 추가 완료!  "); 
				break;
				case 2 : // 2.  목록 아이스크림목록  list.get()
					if(  list.size() == 0 ) {  System.out.println("아직 등록된 아이스크림이 없습니다.");  continue;  }
					for(  IceCreamDTO a:  list    ) { System.out.println(a); } 
				break; 
				case 3 : // 3. 제거 아이스크림 이름입력받아서 제거   list.remove()    
					System.out.print("🍓 제거할 아이스크림 이름 : "); name = scanner.next();
					System.out.println(  list.remove(   new IceCreamDTO(name) ) ? " 제거완료" :"제거실패"  ); 
				break; 
				case 4 : // 4. 검색  내가 입력한 아이스크림이 있는지없는지 검색   contains    
					System.out.print("🍓 검색할  아이스크림 이름 : "); name = scanner.next();
					System.out.println(  list.contains( new  IceCreamDTO( name) ) ? "존재합니다" : "존재하지 않습니다." );
				break;   
				case 5 : System.out.println("총 아이스크림 개수 : "  + list.size());        break; // 5. 갯수  아이스크림총갯수  size
            	case 6 : //6. 정렬
            	    System.out.println("정렬 기준 선택: 1) 이름순  2) 가격순");
            	    int sortChoice = scanner.nextInt();
            	    if(sortChoice == 1) {
            	        Collections.sort(list, Comparator.comparing(IceCreamDTO::getName));
            	        System.out.println("🍦 이름순으로 정렬 완료!");
            	    } else if(sortChoice == 2) {
            	        Collections.sort(list, Comparator.comparingInt(IceCreamDTO::getPrice));
            	        System.out.println("🍦 가격순으로 정렬 완료!");
            	    } else {  System.out.println("잘못된 입력입니다.");   }
					for(  IceCreamDTO a:  list    ) { System.out.println(a); } 
            	break;
				case 0 : System.out.println("👋 아이스크림 가게를 닫습니다. 다음에 또 만나요!");  break;
			}
			
		 }
		 
	} 
}


/*

연습문제3)  Collection  Framework
패키지명 :  com.the703.basic014_ex
클래스명 : ListEx003

1. 문제 개요
아래 조건에 맞게 ListEx003.java 파일을 작성하고, 콘솔에서 실행되는 결과를 예측하시오. 
이 프로그램은 아이스크림 가게를 운영하는 시뮬레이션으로, 
사용자의 입력에 따라 아이스크림을 추가, 제거, 확인, 출력하는 기능을 포함한다.

2. 클래스 구조
클래스명   역할   주요 메서드
IceCreamDTO   아이스크림 정보 저장 DTO      / getName(), getPrice(), toString()
ListEx003   메인 실행 클래스   main(), List 활용

- IceCreamDTO는 이름과 가격을 저장하는 데이터 객체
- ListEx003                클래스는 List<IceCreamDTO>를 활용하여 아이스크림을 추가, 출력, 제거, 검색
- add, get, size, remove, contains 메서드를 모두 활용

3. 요구사항
- IceCreamDTO 클래스를 정의하고, 
이름과 가격을 저장할 수 있도록 생성자 및 getter 작성
- ListEx003 클래스에서 List<IceCreamDTO>를 생성하고, add() 메서드로 아이스크림 추가
get() 메서드로 목록 출력, size()로 개수 확인
메뉴는 무한 반복 구조로 구성되어 사용자가 0을 입력할 때까지 계속 실행됨 

4. 콘솔 출력 흐름
🎉 프로그램 시작 시 
❄️🍦 Welcome to the Magical IceCream Land 🍦❄️  
✨ 오늘도 달콤한 하루가 시작됩니다! ✨  
🛎️ 손님~ 어떤 아이스크림을 원하시나요?  
--------------------------------------------------
📋 메뉴판 
🍧 IceCream Menu 🍧  
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택:

5. 각 메뉴 선택 시 출력 메시지
5-1. 아이스크림 추가 
아이스크림 이름: [사용자 입력]  
가격: [사용자 입력]  
[입력한 이름] 추가 완료!

5-2. 아이스크림 목록 보기
리스트가 비어있을 경우:
현재 아이스크림 목록:  
아직 등록된 아이스크림이 없습니다.

아이스크림이 있을 경우:
현재 아이스크림 목록:  
- 초코 (1500원)  
- 바닐라 (1300원)

5-3. 아이스크림 제거 
제거할 아이스크림 이름: [사용자 입력]  
제거 완료!   또는   해당 아이스크림이 존재하지 않습니다.

5-4. 아이스크림 존재 확인

확인할 아이스크림 이름: [사용자 입력]  
존재합니다!   또는   존재하지 않습니다.

5-5. 총 아이스크림 개수
총 아이스크림 개수: [리스트 크기]

5-6. 종료
아이스크림 가게를 닫습니다. 다음에 또 만나요!

6. 추가 조건 (선택 사항)
Scanner를 사용하여 사용자 입력을 처리할 것
ArrayList<IceCreamDTO>를 사용하여 아이스크림 목록을 저장할 것
toString() 메서드를 오버라이드하여 출력 형식을 예쁘게 만들 것
이모지를 활용하여 콘솔 출력이 재미있고 직관적으로 보이도록 할 것


전체출력화면 ) 
❄️🍦 Welcome to the Magical IceCream Land 🍦❄️
✨ 오늘도 달콤한 하루가 시작됩니다! ✨
🛎️ 손님~ 어떤 아이스크림을 원하시나요?
--------------------------------------------------

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 1
🍓 아이스크림 이름: white
💰 가격: 1500
✅ white 추가 완료!

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 1
🍓 아이스크림 이름: choco
💰 가격: 1800
✅ choco 추가 완료!

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 1
🍓 아이스크림 이름: mango
💰 가격: 2000
✅ mango 추가 완료!

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 2
🍨 현재 아이스크림 목록:
- white (1500원)
- choco (1800원)
- mango (2000원)

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 3
🗑️ 제거할 아이스크림 이름: mango
🧹 제거 완료!

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 2
🍨 현재 아이스크림 목록:
- white (1500원)
- choco (1800원)

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 4
🔍 확인할 아이스크림 이름: mango
❌ 없습니다!
 

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 4
🔍 확인할 아이스크림 이름: white
✅ 존재합니다!

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 5
📦 총 아이스크림 개수: 2

🍧 IceCream Menu 🍧
1️ 아이스크림 추가
2️ 아이스크림 목록 보기
3️ 아이스크림 제거
4️ 아이스크림 존재 확인
5️ 총 아이스크림 개수
0️ 종료
👉 선택: 0
👋 아이스크림 가게를 닫습니다. 다음에 또 만나요!

*/