package std.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1. Dto 데이터전송목적
class BankDto{
	private String id;
	private String pass;
	private double balance;
	
	public BankDto(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	} 
	
}

class Bank{
	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	
	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }
	
	// 메뉴 - 안에 내용작성
	public void menu() {
		int menu = -1; String id   = "", pass=""; double balance=-1;
		Scanner scanner = new Scanner(System.in);
		//입력 //처리 //출력
		//for(   ;menu!=9;   ) {
		while(menu!=9) {
			System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
					+ "👉 번호를 선택하세요:");
			menu = scanner.nextInt();
			if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
			} else if (menu == 1) {
				add();
			}
		}
	}   
	// 유저추가  (add)
	public void add() {
		//변수
		//입력 - 사용자에게 정보입력받기
		//처리 
		users.add( new BankDto("aaa" , "pass" , 1 ) );
		//출력
	}
	// 입금   (get)
	// 출금   (get)
	// 유저삭제(remove)
	// 종료   
}
public class BankCollect {
	public static void main(String[] args) {
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users);
		controller.menu();
		
		//테스트용
		//		controller.add();
		//		System.out.println(controller.users);
	}
}




