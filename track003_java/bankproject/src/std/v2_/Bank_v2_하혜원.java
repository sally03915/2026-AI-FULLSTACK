package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_하혜원 {

	public static void main(String[] args) {
		int menu = -1;
		int find = -1;
		int tbalance = -1;
		String tid = "", tpass = "";

		String[] id = new String[3]; // 3:개 012
		String[] pass = new String[3];
		double[] balance = new double[3];

		Scanner scanner = new Scanner(System.in);

		while (menu != 9) {
			
			System.out.println(Arrays.toString(id));
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");

			System.out.println("[1] ➕ 계좌 추가");
			System.out.println("[2] 🔍 계좌 조회");
			System.out.println("[3] 💵 입금하기");
			System.out.println("[4] 💸 출금하기");
			System.out.println("[5] 🗑️ 계좌 삭제");
			System.out.println("9.종료");

			System.out.println("번호를 입력하세요");
			menu = scanner.nextInt();

			if (menu == 9) {
				System.out.println("종료");
				break;
			} else if (menu == 1) {
				find = -1;
				// 빈칸인지 검사
				// if(0번이빈칸이라면 ){find는 0}
				// if(balance[0]==0) { find=0; }
				// if(balance[1]==0) { find=1; }
				// if(balance[2]==0) { find=2; }
				for (int i = 0; i <= 2; i++) {
					if (balance[i] == 0) {
						find = i; break;
					}
				}
				//,만약 find가 -1이라면 가입불가
				if(find == -1) {System.out.println("가입불가");continue;}
				
				System.out.println("ID를 입력하세요>");
				id[find] = scanner.next();
				System.out.println("pass를 입력하세요>");
				pass[find] = scanner.next();
				System.out.println("잔액:");
				balance[find] = scanner.nextInt();
			} else {
				System.out.println("ID를 입력하세요>");
				tid = scanner.next();
				System.out.println("pass를 입력하세요>");
				tpass = scanner.next();
				find = -1;
				for (int i = 0; i <= 2; i++) {
					if (tid.equals(id[i])  && tpass.equals(pass[i])) {
						find = i;
						break;
					}

				}
				if (find == -1) {
					System.out.println("아이디를 다시 확인해주세요");
					continue;
				}

				if (menu == 2) {
					System.out.println("ID:" + tid);
					System.out.println("pass:" + tpass);
					System.out.println("잔액은:" + balance[find]);

				} else if (menu == 3) {
					System.out.println("입금 할 잔액 입력: ");
					tbalance = scanner.nextInt();
					balance[find] = balance[find] + tbalance;
					System.out.println("잔액은:" + balance[find]);
				} else if (menu == 4) {
					System.out.println("출금할 금액 입력>");
					tbalance = scanner.nextInt();
					if (balance[find] >= tbalance) {
						balance[find] = balance[find] - tbalance;
						System.out.println("출금 완료");
						System.out.println("잔액은:" + balance[find]);
					} else {
						System.out.println("잔액부족>다시 입력해주세요");
					}
				} else if (menu == 5) {
					id[find] = "";
					pass[find] = "";
					balance[find] = 0;
					System.out.println("삭제완료>");
				} else {
					System.out.println("아이디 비번을 다시 확인해주세요");
				}
			}
		}
	}
}