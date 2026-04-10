package std.v1;

import java.util.Scanner;

public class Back_김주엽 {


	public static void main(String[] args) {
		
		int num = 0;
		int age = 0;
		int money = 0;
		int id = 0;
		int id_ck = 0;
		int pw = 0;
		int pw_ck = 0;
		boolean login = false;
		char sl = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("💲💲  WELCOME TO BANK SYSTEM  💲💲");
			System.out.print("==============================\n"
							+"[1] ➕ 계좌 추가\n"
							+"[2] 🔍 계좌 조회\n"
							+"[3] 📈 입금하기\n"
							+"[4] 📉 출금하기\n"
							+"[5] ❌ 계좌 삭제\n"
							+"[9] ‼ 종료 ‼\n"
							+"=============================\n"
							+"번호 입력 > ");
			
			num = sc.nextInt();
			System.out.println();
			
			if(num == 1) {
				
				System.out.println("아이디를 입력해주세요 > ");
				id = sc.nextInt();
				
				System.out.println("비밀번호를 입력해주세요 > ");
				pw = sc.nextInt();
				
				System.out.println("나이를 입력해주세요 > ");
				age = sc.nextInt();
				
				System.out.println("잔액 입력 > ");
				money = sc.nextInt();
				
				login = true;
				
			} // 계좌 추가 문단 끝
			
//			else if(num == 2) {
//				
//				System.out.println("아이디를 입력해주세요 > ");
//				id_ck = sc.nextInt();
//				
//				System.out.println("비밀번호를 입력해주세요 > ");
//				pw_ck = sc.nextInt();
//				
//				if(id == id_ck && pw == pw_ck) {
//					
//					System.out.println(id +" 접속 확인");
//					login = true;
//				}
//				else {System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");}
//			} // 로그인 문단 끝
			
			else if(login == false && num != 9) {
				
				System.out.println("아이디를 입력해주세요 > ");
				id_ck = sc.nextInt();
				
				System.out.println("비밀번호를 입력해주세요 > ");
				pw_ck = sc.nextInt();
				
				if(id == id_ck && pw == pw_ck) {
					
					System.out.println(id +" 접속 확인");
					login = true;
				}
				
				else {System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");}
				}
			// 비로그인시 접근 제한 및 아이디확인
			
			else if(num == 2) {
				
					System.out.println("\n아이디	 : " + id
									+"\n비밀번호	 : " + pw
									+"\n나이	 : " + age + " 세"
									+"\n잔액 	 : " + money + " 원 \n");		
			} // 계좌 조회 문단 끝
			else if(num == 3) {
				
					System.out.println("\n입금하실 금액 > ");
					num = sc.nextInt();
					
					money += num;
					
					System.out.println(num + " 원 입금\n"
									  +"==========================\n"
						              +"현재 잔액 : " + money + " 원\n" );
			} // 입금 문단 끝
			
			else if(num == 4) {		
				
					System.out.println("\n출금하실 금액 > ");
					num = sc.nextInt();
				
					if(num<money) {
					money -= num;
					
					System.out.println(num + " 원 출금\n"
									  +"==========================\n"
						              +"현재 잔액 : " + money + " 원\n" );}
					
					else {System.out.println("잔액이 부족합니다.");}
			} // 출금 문단 끝
			
			else if(num == 5) {

					System.out.println("계좌를 삭제하시겠습니까?\n"
									  + " Y/N ");
					sl = sc.next().charAt(0);
					
					if(sl == 'Y' || sl == 'y') {
						id = 0;
						pw = 0;
						money = 0;
						age = 0;
						login = false;
						System.out.println("계좌를 삭제합니다.");
					}
					else if (sl == 'N' || sl == 'n') {
						System.out.println("취소 합니다.");
					}
					else {System.out.println("정확한 값을 적어주세요.\n");}

				
			} // 삭제 문단 끝
			
			else if(num == 9) {
				System.out.println("종료");
				break;
				} // 종료 문단 끝
			
			else {
				System.out.println("정상적인 값을 입력하세요.");
			}
			
			
		}
		
		/*
		Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
			1을 입력하면 추가기능입니다. 출력구문까지만
			2를 입력하면 조회기능입니다. 출력구문까지만
			3을 입력하면 입금기능입니다. 출력구문까지만
			4를 입력하면 출금기능입니다. 출력구문까지만
			5를 입력하면 삭제기능입니다. 출력구문까지만
			9를 입력하면 종료합니다.	 출력구문까지만
			
			
		Q2. 무한반복으로 메뉴나오게, 9나오면 종료	
			■ 힌트
	   for(;;) { 
	      System.out.println("숫자1을 입력하세요.");
	      int a = scanner.nextInt();
	      if(a == 1) { break;}
   		}
		 */
		
	}

}
