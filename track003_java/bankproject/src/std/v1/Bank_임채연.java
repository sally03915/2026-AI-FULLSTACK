package std.v1;

import java.util.Scanner;

public class Bank_임채연 {

	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		int num = -1, id = -1, pw = -1, balance = -1, money = -1;
		String answer;
		
		// 입력
		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		for(;;) {
			System.out.println("\n======BANK======");
			System.out.println("[1] ➕ 계좌 추가");
			System.out.println("[2] 🔍 계좌 조회");
			System.out.println("[3] 💵 입금하기");
			System.out.println("[4] 💸 출금하기");
			System.out.println("[5] 🗑️ 계좌 삭제");
			System.out.println("[9] 💀 종료\n");
			System.out.print("👉 번호를 선택하세요: ");
			num = sc.nextInt();
			
			// 처리
			if (num == 9) { // [9] 💀 종료
				break;
				
			} else if (num == 1) { // [1] ➕ 계좌 추가
				System.out.print("아이디 입력: ");
				id = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				pw = sc.nextInt();
				System.out.print("잔액 입력: ");
				balance = sc.nextInt();
				
			} else if (num == 2) { // [2] 🔍 계좌 조회
				/////////////////////////////////////////////////
				int tid = -1, tpw = -1;
				
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					//continue;   //1. continue 빼기
				} else if (tid == id && tpw == pw) {
					/////////////////////////////////////////////////	
					System.out.println("🔍 계좌 조회");
					System.out.println("아이디: " + id);
					System.out.println("비밀번호: " + pw);
					System.out.println("잔액: " + balance);
				}
				
			} else if (num == 3) { // [3] 💵 입금하기
				/////////////////////////////////////////////////	
				int tid = -1, tpw = -1;
				
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					//continue; 
				} else if (tid == id && tpw == pw) {
					/////////////////////////////////////////////////	
					System.out.print("입금: ");
					money = sc.nextInt();
					balance += money;
					System.out.println("💵 입금완료");
					System.out.println("잔액: " + balance);
				}
				
			} else if (num == 4) { // [4] 💸 출금하기
				/////////////////////////////////////////////////	
				int tid = -1, tpw = -1;
				
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					//continue;
				} else if (tid == id && tpw == pw) {
					/////////////////////////////////////////////////	
					System.out.print("출금: ");
					money = sc.nextInt();
					balance -= money;
					System.out.println("💵 출금완료");
					System.out.println("잔액: " + balance);
				}
				
			} else if (num == 5) { // [5] 🗑️ 계좌 삭제
				/////////////////////////////////////////////////	
				int tid = -1, tpw = -1;
				
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					//continue;
				} else if (tid == id && tpw == pw) {
					/////////////////////////////////////////////////	
					System.out.println("계좌를 삭제하시겠습니까? (y/n)");
					answer = sc.next();
					
					if (answer.equals("y")) {
						id = -1;
						pw = -1;
						balance = -1;
						System.out.println("🗑️ 계좌 삭제 완료");
					} else if (answer.equals("n")) {
						continue;
					} else {
						System.out.println("(y/n)을 입력해주세요.");
					}
				}
				
			} else {
				System.out.println("1 ~ 5 숫자를 입력해주세요. (9. 종료)");
				continue;
			}
		}
		
	}

}

//2~5메뉴사이에 겹치는 부분 줄이기- 도전~!
