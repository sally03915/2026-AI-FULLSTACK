package std.v3;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v3_김현미_1 {
	static String[] id = new String[3]; // one two three
	static String[] pass = new String[3]; // 1111 2222 3333
	static double[] balance = new double[3];// 0 0 0
	static int menu = -1;
	static int find = -1;
//		int id = -1, pass = -1, balance = -1;
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
	//9. 종료기능 
	////////////////////////////////////////////////////
	//            리턴값  메서드명()
	public static int menu_show() {
		System.out.println(Arrays.toString(id)); // 현재상태확인
		System.out.println(Arrays.toString(balance));
		System.out.println(  find );
		System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n" + "[1] ➕ 계좌 추가\n" + "[2] 🔍 계좌 조회\n"
				+ "[3] 💵 입금하기\n" + "[4] 💸 출금하기\n" + "[5] 🗑️ 계좌 삭제\n" + "[9] ⊙ 종료\r\n" + "👉 번호를 선택하세요: \n");
		return scanner.nextInt();
	}
	
	public static void bank_find() { 
		find = -1; //##
		for (int i = 0; i < id.length; i++) {
			if (  balance[i] == 0) {  // 빈칸이니?
				find = i;
				break;
			}
		}
		
		
	}
	
	public static void bank_aut() {
		find = -1; //##
//			 	2-1. 사용자가 맞는지 여부
		String tempid = "", temppass = "";
		System.out.print("ID 입력 > \n");
		tempid = scanner.next();
		System.out.print("PASS 입력 > \n");
		temppass = scanner.next();
		for(int i=0; i<id.length; i++) {
			if ( id[i]  != null &&  pass[i] != null && id[i].equals(tempid) && pass[i].equals(temppass) ) {
				//if (!id[find].equals(tempid) || !pass[find].equals(temppass) ) {
				find = i;
				break;
			} // 아이디 다르거나 비번이 다르다면		
		}
		
	}
	
	public static void bank_add() {
		System.out.print("ID 입력 > \n");
		id[find] = scanner.next();
		System.out.print("PASS 입력 > \n");
		pass[find] = scanner.next();
		System.out.print("금액 입력 > \n");
		balance[find] = scanner.nextDouble();		
	}
	
	public static void bank_che() {
		System.out.printf("ID : %s\nPASS: %s\nBALANCE: %f\n", id[find], pass[find], balance[find]);
	}
	
	public static void bank_dep() {
		System.out.print("입금할 금액 > ");
		balance[find] += scanner.nextInt();		
	}
	
	public static void bank_wit() {
		System.out.print("출금할 금액 > ");
		int tempbalance = scanner.nextInt();
		System.out.print(tempbalance > balance[find] ? "잔액부족! 출금불가"
				: "출금완료! 현재잔액 : " + (balance[find] -= tempbalance));		
	}
	
	public static void bank_del() {
		System.out.print("계좌삭제 (Y/N) > ");
		char again = scanner.next().charAt(0);
		if (again == 'Y' || again == 'y') {
			id[find] = "";
			pass[find] = "";
			balance[find] = -1;
		}		
	}
	
	public static void bank_end() {
		System.out.println("프로그램을 종료합니다.\n");
		System.exit(0);
	}
	


	//public static 리턴값 메서드명(재료) {해야할일}
	public static void main(String[] args) {
		// for( ;menu!=9; ) {
		while (menu != 9) {
			////////////////
			//1. 메뉴판을 기능
			menu = menu_show();  //★
			//public static 번호(1~5/ 9) menu_show() {해야할일}
			//////////////
			// 처리 + 출력

			if (menu == 9) { // [9] ⊙ 종료
				bank_end();  //★
				break;		
			} else if (menu == 1) {

				System.out.println("[1] ➕ 계좌 추가 \n");
				bank_find();  //★ 
				
			   	if (find == -1) { System.out.println("가입불가!");   continue; }
				bank_add();   //★

			} else if (menu >= 2 && menu <= 5) { 
				bank_aut();  //★
//				continue;

				if( find == -1 ) { System.out.println("아이디와 비밀번호를 확인해주세요."); continue;  }

//					2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제

				switch (menu) {
				case 2:
					bank_che();
					break;
				case 3:
					bank_dep();
					break;
				case 4:
					bank_wit();
					break;
				case 5:
					bank_del();
					break;
				} // end switch				
			} // end else if
		} // end while
	}
}