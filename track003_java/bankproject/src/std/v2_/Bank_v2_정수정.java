package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_정수정 {

	public static void main(String[] args) {

//		// 변수
		Scanner sc = new Scanner(System.in);

		int menu = -1, price = -1;
		int[] balance = { 0, 0, 0 };
		char[] user_id = { '\u0000', '\u0000', '\u0000' }, 
			   user_pw = { '\u0000', '\u0000', '\u0000' };
		char ch_id = '\u0000', ch_pw = '\u0000';

		System.out.println("WELCOME! 💰 ㈜CODEBANK");

		while (menu != 9) {
			System.out.println(Arrays.toString(user_id));
			System.out.println(Arrays.toString(balance));
			System.out.println("========BANK========");
			System.out.println(
					"*1.➕ 계좌 추가" + "\n*2.🔍 계좌 조회" + "\n*3.💵 입금하기" + "\n*4.💸 출금하기" + "\n*5.🗑️ 계좌 삭제" + "\n*9.✖ 종료");
			System.out.print("입력 >>> ");
			menu = sc.nextInt();

			if (menu == 9) {
				System.out.println("종료합니다.");
				break;
			} else if (menu == 1) {
				// 1. 빈칸 찾기
				int find = -1;
				// 비어있는 배열의 순서를 확인하고 find 값을 할당
				for (int i = 0; i < user_id.length; i++) {
					if (user_id[i] == '\u0000') {
						find = i;
						break;
					}
				}
				// find 값이 -1이라면 값을 추가할 수 없음
				if (find == -1) {
					System.out.println("가입 불가");  continue;
				} 
				//else {
				System.out.print("아이디 입력 : ");
				user_id[find] = sc.next().charAt(0);
				System.out.print("비밀번호 입력 : ");
				user_pw[find] = sc.next().charAt(0);

				System.out.print("잔액 입력 : ");
				balance[find] = sc.nextInt();
				//}

			} else if (menu >= 2 && menu <= 5) {

				int find = -1;

				System.out.print("ID : ");
				ch_id = sc.next().charAt(0);
				System.out.print("PW : ");
				ch_pw = sc.next().charAt(0);

				for (int i = 0; i < user_id.length; i++) {
					if (ch_id == user_id[i] && ch_pw == user_pw[i]) {
						find = i;
						break;
					} else {
						continue;
					}
				} // ID-PW 동일한가? 동일하면 break하고 menu 2~5
					
				if (find == -1) {
					System.out.println("ID/PW를 확인해주세요.");
					continue;
				}

				switch (menu) {
				case 2:
					System.out.println("ID : " + user_id[find]);
					System.out.println("PW : " + user_pw[find]);
					System.out.println("잔액 : " + balance[find]);
					break; // 메뉴 2번 : 조회

				case 3:
					System.out.print("입금 : ");
					price = sc.nextInt();
					balance[find] += price;
					System.out.println("=== 입금 완료 === ");
					System.out.println("잔액 : " + balance[find]);
					break; // 메뉴 3번 : 입금하기

				case 4:
					System.out.print("출금 : ");
					price = sc.nextInt();
					if (balance[find] < price) {
						System.out.println("잔액이 부족합니다.");
						System.out.println("잔액 : " + balance[find]);
					} else {
						balance[find] -= price;
						System.out.println("=== 출금 완료 === ");
						System.out.println("잔액 : " + balance[find]);
					}
					break; // 메뉴 4번 : 출금하기 end

				case 5:
					System.out.print("계좌를 삭제하시겠습니까? (Y/N)");
					char ans = sc.next().charAt(0);
					if (ans == 'n' || ans == 'N') {
						break;
					} else if (ans == 'y' || ans == 'Y') {
						user_id[find] = '\u0000';
						user_pw[find] = '\u0000';
						balance[find] = 0;
					}
					break; // 메뉴 5번 : 계좌 삭제 end
				} // end switch

			} else {
				System.out.println("다시 입력해주세요.");
				break; 
				
			} // 아이디+패스워드 확인, 메뉴 else

		} // end for

	} // end main

} // end class