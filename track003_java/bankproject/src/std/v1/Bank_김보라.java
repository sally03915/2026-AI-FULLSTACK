package std.v1;

import java.util.Scanner;

public class Bank_김보라 {

	public static void main(String[] args) {
		//변수
				int num1=-1;
				int id = -1, pass = -1 , balance=-1 ,in=-1,out=-1;
				Scanner sc = new Scanner(System.in);
				//입력
				for(;;) {		
					System.out.println("👌WELCOME TO BANK SYSTEM👌");
					System.out.println("[1] ➕계좌 추가");
					System.out.println("[2] 🔎계좌 조회");
					System.out.println("[3] 💶입금 하기");
					System.out.println("[4] 💸출금 하기");
					System.out.println("[5] ❌계좌 삭제");
					System.out.println("[9] 🖐종료\n");
					
					System.out.print("👉번호를 입력해주세요.>"); num1 = sc.nextInt();
					
					if     ( num1==1 ) {
						System.out.println("1.추가 \n"); 
						//입력    int id = -1, pass = -1 , balance=-1 ;
						System.out.print("[1]ID   입력> "); id = sc.nextInt();
						System.out.print("[2]PASS 입력> "); pass = sc.nextInt();
						System.out.print("[3]금액  입력> "); balance = sc.nextInt();				
						} // if( num1==1 ) end
					
					else if ( num1==2 || num1==3 || num1==4 || num1==5 ) {
						
	
						int tid =-1,tpass =-1;
						//입력
						System.out.print("[1]ID   입력> "); tid = sc.nextInt();
						System.out.print("[2]PASS 입력> "); tpass = sc.nextInt();
						//처리+출력
						
						if(tid==id && tpass==pass) { 
						
							if      (num1==2) { System.out.println("잔액 : " + balance + "\n"); }
							
							else if (num1==3) { System.out.print("입금 : "); in = sc.nextInt();
		                    					System.out.println("==입금완료");
		                    					System.out.print("잔액 : " + (balance+in) ); }
							
							else if (num1==4)  { System.out.print("출금 : "); out = sc.nextInt();
												 System.out.println("==출금완료");
												 System.out.println("잔액 : " + (balance-out)); }
							
							else if (num1==5) { id = -1;   pass = -1; } } // end tid==id && tpass==pass 
								
						else                       { System.out.println("다시 확인해주세요."); }	
						 					
					}
					
		}
	}

}



//Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
//1을 입력하면 추가기능입니다. 출력구문까지만
//2를 입력하면 조회기능입니다. 출력구문까지만
//3을 입력하면 입금기능입니다. 출력구문까지만
//4를 입력하면 출금기능입니다. 출력구문까지만
//5를 입력하면 삭제기능입니다. 출력구문까지만
//9를 입력하면 종료합니다.    출력구문까지만
//
//Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
//■ 힌트
//for(;;) { 
//System.out.println("숫자1을 입력하세요.");
//int a = scanner.nextInt();
//if(a == 1) { break;}
//}