package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_김현미 {

	public static void main(String[] args) {
//		- Bank ver2 :  array ( 3명짜리 ) 배열
//		※ 옵션
//		변수                          		0   1    2
		String[] id = new String[3]; // one two three
		String[] pass = new String[3]; // 1111 2222 3333
		double[] balance = new double[3];// 0 0 0
		int menu = -1;
		int find = -1;
//		int id = -1, pass = -1, balance = -1;
		Scanner scanner = new Scanner(System.in);

		// 입력 // 처리 // 출력
		// for( ;menu!=9; ) {
		while (menu != 9) {
			System.out.println(Arrays.toString(id)); // 현재상태확인
			System.out.println(Arrays.toString(balance));
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n" + "[1] ➕ 계좌 추가\n" + "[2] 🔍 계좌 조회\n"
					+ "[3] 💵 입금하기\n" + "[4] 💸 출금하기\n" + "[5] 🗑️ 계좌 삭제\n" + "[9] ⊙ 종료\r\n" + "👉 번호를 선택하세요: \n");
			menu = scanner.nextInt();

			// 처리 + 출력

			if (menu == 9) { // [9] ⊙ 종료
				System.out.println("프로그램을 종료합니다.\n");
				break;
			} else if (menu == 1) {

				System.out.println("[1] ➕ 계좌 추가 \n");

				// ========================================================================

//				- Bank ver2 :  array ( 3명짜리 ) 배열
//				※ 옵션
//				   public static void main(String[] args) {
//				      //변수                          0   1    2
//				      String []id=new String[3];       //  one two three
//				      String []pass = new String[3];   // 1111 2222 3333
//				      double []balance = new double[3];// 1100 2200 3300   
//				      int menu=-1;  
//				      Scanner scanner = new Scanner(System.in);
//				    }	

				// 1. 빈칸 찾기
				// 만약 balance 0번째가 빈칸이라면 find는 찾은번호 인덱스는
				// if(balance 0번째가 빈칸이라면){ find는 0 }
				// if(balance 1번째가 빈칸이라면){ find는 1 }
				// if(balance 2번째가 빈칸이라면){ find는 2 }

				for (int i = 0; i < id.length; i++) {
					if (balance[i] == 0) {
						find = i;
						break;
					}
				}
				
				if (find == -1) { System.out.println("가입불가!"); continue; }

				// 2. 해당값 입력받기

				System.out.print("ID 입력 > \n");
				id[find] = scanner.next();
				System.out.print("PASS 입력 > \n");
				pass[find] = scanner.next();
				System.out.print("금액 입력 > \n");
				balance[find] = scanner.nextDouble();
				// 처리 x 출력 x
//				for(int i=0; i<id.length; i++) {
//					System.out.println(id[i]);
//					System.out.println(pass[i]);
//					System.out.println(balance[i]);					
//				}

//				System.out.println();
//
//				System.out.printf("ID는 %d, PASS는 %d, 잔액은, %d 입니다.\n", id, pass, balance);
//				System.out.println();

				// ========================================================================

			} else if (menu >= 2 && menu <= 5) {
//			 	2-1. 사용자가 맞는지 여부
				String tempid = "", temppass = "";
				System.out.print("ID 입력 > \n");
				tempid = scanner.next();
				System.out.print("PASS 입력 > \n");
				temppass = scanner.next();

				// id[0]이 입력받은 tempid랑 다르거나 pass[0]이 입력받은 temppass랑 다르면 정보확인해주세요 출력후 한번 skip 함
				// if(id[0]이 입력받은 tempid랑 다르거나 pass[0]이 입력받은 temppass랑 다르면){ 정보확인해주세요 출력}후 한번
				// skip 함
				// if( !(id[0]이 입력받은 tempid랑 같아야하고 pass[0]이 입력받은 temppass랑 같으면) ){ 정보확인해주세요 출력}후
				// 한번 skip 함
				// if( !(id[0]이 입력받은 tempid랑 같아야하고 pass[0]이 입력받은 temppass랑 같으면) ){ 정보확인해주세요 출력}후
				// 한번 skip 함

//				for(int i=0; i<id.length; i++) {
				if (!(id[find].equals(tempid) && pass[find].equals(temppass))) {
//						if (!id[find].equals(tempid) || !pass[find].equals(temppass) ) {
					System.out.println("정보확인해주세요.");
					continue;
				} // 아이디 다르거나 비번이 다르다면

//					2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제

				switch (menu) {
				case 2:
					System.out.printf("ID : %s\nPASS: %s\nBALANCE: %f\n", id[find], pass[find], balance[find]);
					break;
				case 3:
					System.out.print("입금할 금액 > ");
					balance[find] += scanner.nextInt();
					break;
				case 4:
					System.out.print("출금할 금액 > ");
					int tempbalance = scanner.nextInt();
					System.out.print(tempbalance > balance[find] ? "잔액부족! 출금불가"
							: "출금완료! 현재잔액 : " + (balance[find] -= tempbalance));
					break;
				case 5:
					System.out.print("계좌삭제 (Y/N) > ");
					char again = scanner.next().charAt(0);
					if (again == 'Y' || again == 'y') {
						id[find] = "";
						pass[find] = "";
						balance[find] = -1;
					}
					break;
				} // end switch
//				} // end for 
			} // end else if
		} // end while
	}
}