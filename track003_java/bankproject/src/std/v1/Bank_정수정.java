package std.v1;

import java.util.Scanner;

public class Bank_정수정 {
	public static void main(String[] args) {

		//변수
		//아이디, 비밀번호, 나이, 잔액
		
		Scanner sc = new Scanner(System.in);
		int num = -1, age = -1, balance = -1;
		char user_id = '\u0000', user_pw = '\u0000', 
				ch_id = '\u0000', ch_pw = '\u0000';
		
		// Q1. 메뉴판 나오게 만들고 사용자가 메뉴 선택시 출력구문까지
		// Q2. 무한반복으로 메뉴 나오게, 9 나오면 종료
		//1을 입력하면 추가기능입니다. 출력구문까지만
		//2를 입력하면 조회기능입니다. 출력구문까지만
		//3을 입력하면 입금기능입니다. 출력구문까지만
		//4를 입력하면 출금기능입니다. 출력구문까지만
		//5를 입력하면 삭제기능입니다. 출력구문까지만
		//9를 입력하면 종료합니다.    출력구문까지만
		
		System.out.println("WELCOME! 💰 ㈜CODEBANK");
		
		for(;;) {
		System.out.println("========BANK========");
		System.out.println("* 1.➕ 계좌 추가");
		System.out.println("* 2.🔍 계좌 조회");
		System.out.println("* 3.💵 입금하기");
		System.out.println("* 4.💸 출금하기");
		System.out.println("* 5.🗑️ 계좌 삭제");
		System.out.println("* 9.✖ 종료");
		System.out.print("입력 >>> ");
		num = sc.nextInt();
	
		
		// 1을 입력하면 아이디, 비밀번호, 나이, 잔액을 입력받음
		if(num == 1) {
			System.out.print("아이디 입력 : ");
			user_id = sc.next().charAt(0);
			System.out.print("비밀번호 입력 : ");
			user_pw = sc.next().charAt(0);
			System.out.print("나이 입력 : ");
			age = sc.nextInt();
			System.out.print("잔액 입력 : ");
			balance = sc.nextInt();
		}
		
		
		// 생각해볼것 > id를 등록하지 않은 상태로 2~5를 입력했을때 id 확인단계로 들어가지 않게 하려면...
		// 아이디/패스워드가 String일때 값을 비교하는 방법??
				
		// 2를 입력하면
		// 2-1) 아이디와 패스워드를 입력하고 추가했던 기존값과 같은지 비교함 
		// 2-2) 다를 경우 재확인요청 > 다시 아이디와 패스워드 입력(반복)
		// 2-3) 값이 동일할 경우 아이디, 패스워드, 나이, 잔액 값을 출력
		else if(num == 2) {
			
			// 2~5에서 for 들어가기 전에 계좌 등록 여부를 먼저 확인해야하나??
			/////////////////////////////////////////////////////
			for(;;) {
				System.out.print("ID : ");
				ch_id = sc.next().charAt(0);
				System.out.print("PW : ");
				ch_pw = sc.next().charAt(0);
				
				if(ch_id != user_id || ch_pw != user_pw ) {
					System.out.println("다시 확인해주세요.");
				/////////////////////////////////////////////////////
				} else {
					System.out.println("ID : " + user_id);
					System.out.println("PW : " + user_pw);
					System.out.println("나이 : " + age);
					System.out.println("잔액 : " + balance);
					break;
				}
			}
		}
		
		// 3을 입력하면
		// 3-1) 아이디와 패스워드를 입력하고 추가했던 기존값과 같은지 비교함 
		// 3-2) 다를 경우 재확인요청 > 다시 아이디와 패스워드 입력(반복)
		// 3-3) 동일한 경우 입금할 금액과 입금 완료 메시지, 입금 후 잔액을 출력.
		else if(num == 3) {
			/////////////////////////////////////////////////////
			for(;;) {
				System.out.print("ID : ");
				ch_id = sc.next().charAt(0);
				System.out.print("PW : ");
				ch_pw = sc.next().charAt(0);
				
				if(ch_id !=user_id || ch_pw != user_pw ) {
					System.out.println("다시 확인해주세요.");
					/////////////////////////////////////////////////////
				} else {
					System.out.print("입금 : ");
					balance = sc.nextInt() + balance;
					System.out.println("=== 입금 완료 === ");
					System.out.println("잔액 : " + balance);
					break;
				}
			}
		}
		
		//4를 입력하면
		//4-1) 아이디와 패스워드를 입력하고 추가했던 기존값과 같은지 비교함 
		//4-2) 다를 경우 재확인요청 > 다시 아이디와 패스워드 입력(반복)
		//4-3) 동일한 경우 출금할 금액, 출금 완료 메시지, 출금 후 잔액 출력.
		else if(num == 4) {
			/////////////////////////////////////////////////////
			for(;;) {
				System.out.print("ID : ");
				ch_id = sc.next().charAt(0);
				System.out.print("PW : ");
				ch_pw = sc.next().charAt(0);
				
				if(ch_id !=user_id || ch_pw != user_pw ) {
					System.out.println("다시 확인해주세요.");
					/////////////////////////////////////////////////////
				} else {
					System.out.print("출금 : ");
					balance = balance - sc.nextInt();
					System.out.println("=== 출금 완료 === ");
					System.out.println("잔액 : " + balance);
					break;
				}
			} 
		} 
		
		//5를 입력할 경우
		//5-1) 아이디와 패스워드를 입력하고 추가했던 기존값과 같은지 비교함 
		//5-2) 다를 경우 재확인요청 > 다시 아이디와 패스워드 입력(반복)
		//5-3) 동일하다면 계좌 삭제 여부(Y/N) 확인 > Y라면 값을 모두 초기화? / N : 빠져나가기
		else if(num == 5) {
			/////////////////////////////////////////////////////
			for(;;) {
				System.out.print("ID : ");
				ch_id = sc.next().charAt(0);
				System.out.print("PW : ");
				ch_pw = sc.next().charAt(0);
				
				if(ch_id !=user_id || ch_pw != user_pw ) {
					System.out.println("다시 확인해주세요.");
					/////////////////////////////////////////////////////
				} else {
					System.out.print("계좌를 삭제하시겠습니까? (Y/N)");
					char ans = sc.next().charAt(0);
					
					if(ans == 'n' || ans == 'N') { break; }
					else if (ans == 'y' || ans == 'N') {
						user_id = '\u0000';
						user_pw = '\u0000';
						age = 0;
						balance = 0;
						break;
					}
				}
			} 
		}
		
		// 9를 입력하면 반복을 종료함
				else if(num == 9) {System.out.println("종료합니다."); break; }
		
	} // 뱅크시스템 for end
	
	} // end main
		
} // end class
		
		
//Q. 2~5번의 메뉴 반복되는 코드 줄이기	