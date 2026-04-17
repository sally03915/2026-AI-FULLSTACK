package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Menu_김주엽 {

	
	public static int mainMenu() {
		System.out.print("💲💲  WELCOME TO BANK SYSTEM  💲💲\n"
						+"==============================\n"
						+"[1] ➕ 계좌 추가\n"
						+"[2] 🔍 계좌 조회\n"
						+"[3] 📈 입금하기\n"
						+"[4] 📉 출금하기\n"
						+"[5] ❌ 계좌 삭제\n"
						+"[6] 로그아웃\n"
						+"[9] ‼ 종료 ‼\n"
						+"=============================\n"
						+"번호 입력 > ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt(); 
		return i;
	}
	
//	public static int menu_1() {
//		
//		
//		String id = "";
//		String pass = "";
//		double balance = 0;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("아이디를 입력해주세요 > ");
//		id = sc.next();
//		
//		System.out.println("비밀번호를 입력해주세요 > ");
//		pass = sc.next();
//		
//		System.out.println("잔액 입력 > ");
//		balance = sc.nextInt();
//		
//		User user = new User(id,pass,balance);
//		
//		manager.user_Info(user);
//		
//		return mainMenu();
//	}
//	
//	public static void menu_Login() {
//		
//		String id, id_ck = "";
//		String pass, pass_ck = "";
//		Scanner sc = new Scanner(System.in);
//		
//		User u = manager.userList[0];
//		id_ck = u.user_Id;
//		pass_ck = u.user_Pass;
//		
//		System.out.println("아이디를 입력해주세요 > ");
//		id = sc.next();
//		
//		System.out.println("비밀번호를 입력해주세요 > ");
//		pass = sc.next();
//		
//		if(id == id_ck && pass == pass_ck) {
//			System.out.println(u.user_Id + "님 로그인 확인");
//			
//		}
//		else { System.out.println("아이디 혹은 비밀번호를 확인해주세요.");}
//		
//	}

	
}
