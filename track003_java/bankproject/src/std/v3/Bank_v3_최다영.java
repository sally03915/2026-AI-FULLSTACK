package std.v3;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v3_최다영 {
	static String[] id = new String[3]; // one two three
	static String[] pass = new String[3]; // 1111 2222 3333
	static double[] balance = new double[3];// 1100 2200 3300
	static int menu = -1;
	static Scanner scanner = new Scanner(System.in);

	////////////////////////////////////////////////////
	//1. 메뉴판을 기능
    //2. 유저 빈칸찾기 기능
    //3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
    //4. 계좌추가기능
    //5. 조회기능
    //6. 입금기능
    //7. 출금기능
    //8. 삭제기능
	////////////////////////////////////////////////////
      
	// ※ 옵션
	public static void main(String[] args) {
		// 변수 0 1 2
		while (menu != 9) {//
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(pass));
			System.out.println(Arrays.toString(balance));
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n" + "👉 번호를 선택하세요:");
			menu = scanner.nextInt();
			if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
			} else if (menu == 1) {
				// -빈칸인 번호 찾기
				// 1. 0번째가 빈칸이라면 - 빈칸인 번호 찾기 find 빈칸번호 0 넣기
				int find = -1;
				for (int i = 0; i < id.length; i++) {  if (id[i] == null) { find = 0;  break;}  }
				if (find == -1) { System.out.println("가입불가"); continue; }
				System.out.print("아이디  입력 > ");
				id[find] = scanner.next();
				System.out.print("비밀번호 입력 > ");
				pass[find] = scanner.next();
				System.out.print("잔액    입력 > ");
				balance[find] = scanner.nextDouble();

				// 처리 x 출력 x
			} else if (menu >= 2 && menu <= 5) {
				// 2-1. 사용자가 맞는지 여부
				String tempid, temppass;
				System.out.print("아이디  입력 > ");
				tempid = scanner.next();
				System.out.print("비밀번호 입력 > ");
				temppass = scanner.next();
				int find = -1;

				for (int i = 0; i < id.length; i++) {
					if (id[i] != null && id[i].equals(tempid) && pass[i].equals(temppass)) {
						find = i;
						break;
					}
				}
				if (find == -1) {
					System.out.println("정보확인해주세요.");
					continue;
				} // 아이디 다르거나 비번이 다르다면 continue

				// 2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금 , 계좌삭제라면 y,n입력받아서 계좌삭제
				switch (menu) {
				case 2: // System.out.printf("ID : %d\nPASS: %d\nBALANCE: %d\n" ,id,pass, balance);
					System.out.println("ID : " + id[find]);
					System.out.println("PASS : " + pass[find]);
					System.out.println("balance : " + balance[find]);
					break;
				case 3:
					System.out.print("입금할 금액 > ");
					double money = scanner.nextDouble();
					balance[find] += money;
					break;
				case 4:
					System.out.print("출금할 금액 > ");
					double tempbalance = scanner.nextDouble();
					System.out.println(tempbalance > balance[find] ? "잔액부족! 출금불가"
							: "출금완료! 현재잔액 : " + (balance[find] -= tempbalance));
					break;

				case 5:
					System.out.print("계좌삭제 (Y/N) > ");
					char again = scanner.next().charAt(0);
					if (again == 'Y' || again == 'y') {
						id[find] = null;
						pass[find] = null;
						balance[find] = 0;
					}
					break;
				}

			}

		}

	}
}
