package std.v1;

import java.util.Scanner;

public class Bank_이일두 {
	public static void main(String[] args) {
		// 불필요한 ID PW 재확인 등 삭제 ★ 
		// 변수
		Scanner scanner = new Scanner(System.in);
		int menu = -1, id = -1, pass = -1, balance = -1;
		int a = -1, tid = -1, tpass = -1;

//			 - 제어문 : if , switch
//			 - 반복문 : for(시작;  종료; 변화;), while(조건), do while(한번은 무조건 실행 맨끝에 조건)

		while (menu != 9) {
			System.out.print("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" + "[1] ➕ 계좌 추가\n" + "[2] 🔍 계좌 조회\n" + "[3] 💵 입금하기\n"
					+ "[4] 💸 출금하기\n" + "[5] 🗑️ 계좌 삭제\n" + "[9] ※ 서비스 종료\n" + "\n" + "👉 번호를 선택하세요:");

			menu = scanner.nextInt();

			if (menu == 1) {
				System.out.println("가입하실 ID와 PW를 입력하세요");
				System.out.print("ID: ");
				id = scanner.nextInt();
				System.out.print("PW: ");
				pass = scanner.nextInt();
				System.out.print("금액: ");
				balance = scanner.nextInt();
				System.out.println(balance + "원이 입급되었습니다!");
			} // m1

			else if (menu >= 2 && menu <= 5) {
				System.out.println("조회하실 ID와 PW를 입력하세요");
				System.out.print("ID: ");
				tid = scanner.nextInt();
				System.out.print("PW: ");
				tpass = scanner.nextInt();
				if (!(id == tid && pass == tpass)) {
					System.out.println("없는 정보이니, 다시 입력해주세요");
					continue;
				}

				switch (menu) {
				case 2:
					System.out.println("잔액:" + balance + "원입니다");
					break;
				case 3:
					System.out.print("입금할 금액을 입력하세요");
					a = scanner.nextInt();
					balance = balance + a;
					System.out.println("잔액:" + balance + "원입니다");
					break;
				case 4:
					System.out.print("출금할 금액을 입력하세요");
					a = scanner.nextInt();
					balance = balance - a;   // 마이너스
					System.out.println("잔액:" + balance + "원입니다");
					break;
				case 5:
					id = -1;
					pass = -1;
					balance = -1;
					System.out.println("계좌 삭제되었습니다");
					break;

				} // switch

			} // else if m2~5

		} // while
		System.out.print("은행 서비스가 종료되었습니다");

	} // main

} // class