package std.v1;

import java.util.Scanner;

public class Bank_임채연 {

	public static void main(String[] args) {

		//변수
		Scanner sc = new Scanner(System.in);
		int num = -1, age = -1, balance = -1, price=-1;
		char user_id = '\u0000', user_pw = '\u0000', 
			 ch_id = '\u0000', ch_pw = '\u0000';
				
		System.out.println("WELCOME! 💰 ㈜CODEBANK");
				
		for(;;) {
			System.out.println("ID : " + user_id + "/" + "PW : " + user_pw);
			System.out.println("========BANK========");
			System.out.println("* 1.➕ 계좌 추가");
			System.out.println("* 2.🔍 계좌 조회");
			System.out.println("* 3.💵 입금하기");
			System.out.println("* 4.💸 출금하기");
			System.out.println("* 5.🗑️ 계좌 삭제");
			System.out.println("* 9.✖ 종료");
			
			System.out.print("입력 >>> ");
			num = sc.nextInt();
			
			if(num == 9) { System.out.println("종료합니다."); break; }
			
			else if(num == 1) {
				System.out.print("아이디 입력 : "); user_id = sc.next().charAt(0);
				System.out.print("비밀번호 입력 : "); user_pw = sc.next().charAt(0);
				System.out.print("나이 입력 : "); age = sc.nextInt();
				System.out.print("잔액 입력 : "); balance = sc.nextInt(); } 
			
			else { 
				if(user_id =='\u0000') {
					System.out.println("등록된 계좌가 없습니다.");
					continue; } // 계좌 유무 확인
									
				System.out.print("ID : ");
				ch_id = sc.next().charAt(0);
				System.out.print("PW : ");
				ch_pw = sc.next().charAt(0);
				
				if(ch_id !=user_id || ch_pw != user_pw ) {
					System.out.println("ID/PW를 다시 확인해주세요.");
					continue; }
					
				switch (num) {
					case 2: System.out.println("ID : " + user_id);
					System.out.println("PW : " + user_pw);
					System.out.println("나이 : " + age);
					System.out.println("잔액 : " + balance); break; // 메뉴 2번 : 조회
					
					case 3: System.out.print("입금 : ");
					price = sc.nextInt(); 
					balance += price;
					System.out.println("=== 입금 완료 === ");
					System.out.println("잔액 : " + balance); break; // 메뉴 3번 : 입금하기
					
					case 4: System.out.print("출금 : "); 
						price = sc.nextInt();
						if(balance < price) {  System.out.println("잔액이 부족합니다.");
							System.out.println("잔액 : " + balance); }
						else { balance -= price;
							System.out.println("=== 출금 완료 === ");
							System.out.println("잔액 : " + balance); } break; // 메뉴 4번 : 출금하기 end
							
					case 5: System.out.print("계좌를 삭제하시겠습니까? (Y/N)");
							char ans = sc.next().charAt(0);
							if(ans == 'n' || ans == 'N') { break; }
							else if (ans == 'y' || ans == 'Y') {
								user_id = '\u0000'; user_pw = '\u0000'; 
								age = 0; balance = 0; } break; // 메뉴 5번 : 계좌 삭제 end
				} // switch
				
			} // 아이디+패스워드 확인, 메뉴
			
		} // bank for
		
	} // end main
	
} // end class