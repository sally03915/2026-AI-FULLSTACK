package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적  ( 기본생성자, 필드생성자, toString, getters/setters , hashCode/equals)
class BankDto{
	private String id;
	private String pass;
	private double balance;

	@Override public int hashCode() { return Objects.hash(id); }
	@Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; BankDto other = (BankDto) obj; return Objects.equals(id, other.id); }
	
	public String getId() { return id; }           public void setId(String id) { this.id = id; }
	public String getPass() { return pass; }       public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; } public void setBalance(double balance) { this.balance = balance; }
	
	@Override public String toString() { return "BankDto [id=" + id + ", pass=" + pass + ", balance=" + balance + "]"; }
	public BankDto() { } 
	public BankDto(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance; }


}// end BankDto

//2. 기능클래스
class Bank{
	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적 
	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }
	
	// 메뉴 - 안에 내용작성
	public void menu() {
		int menu=-1; Scanner scanner = new Scanner(System.in); 
		
		while(menu != 9) {
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
					+ "👉 번호를 선택하세요:");
			menu = scanner.nextInt();
			
			if( menu == 1 ) {    add(); } 
			else if(menu ==9) {   exit();   }
			else { 
				BankDto  find = login();// 로그인확인
				if( find == null  ) {  System.out.println("정보를 확인해주세요");  continue;  }
				// 각각의 메뉴에 맞는 기능호출
				switch(menu) {
					case 2 :     show(find);  break;   
					case 3 :     deposit(find);  break;
					case 4 :     withdraw(find);  break;
					case 5 :     delete(find);  break; 
				}
			}
		}
	}   
	// 유저추가  (add)
	public void add() { 
		//변수
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("아이디  입력 > ");   String tempid = scanner.next();   // 아이디중복검사
		System.out.print("비밀번호 입력 > ");  String temppass = scanner.next();
		System.out.print("잔액    입력 > ");  double tempbalance = scanner.nextDouble();
		
		//처리  list → add, get, size, remove, contains
		users.add( new BankDto(tempid , temppass , tempbalance)); 
		//System.out.println(users);
		//출력		
	}
	// 	처리  list → add, get, size, remove, contains
	// 유저로그인      - 유저정보    BankDto login(){}
	BankDto login(){  
		//변수
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("아이디  입력 > ");   String tempid = scanner.next();   // 아이디중복검사
		System.out.print("비밀번호 입력 > ");  String temppass = scanner.next();
		//처리
		for(  BankDto u  :  users  ) {
			if(  u.getId().equals(tempid)  &&  u.getPass().equals(temppass)   ) { return u; }
		} 
		return null; 
	}
	
	void     show( BankDto  user  ){
	  System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.1f\n" ,user.getId(),user.getPass(), user.getBalance()); 
	} 
	// 입금   (get)   -           
	void     deposit( BankDto  user  ){
		Scanner scanner = new Scanner(System.in);
		System.out.print("입금할 금액    입력 > ");  double tempbalance = scanner.nextDouble();
		user.setBalance(  user.getBalance()+  tempbalance  ); 
		System.out.println("입금완료!");
	} 
	// 출금   (get)   -           
	void     withdraw( BankDto  user  ){
		Scanner scanner = new Scanner(System.in);
		System.out.print("출금할 금액    입력 > ");  double tempbalance = scanner.nextDouble();
		if(  user.getBalance() < tempbalance ) {  System.out.println("잔액이 모자랍니다.");  return; }
		user.setBalance(  user.getBalance()-  tempbalance  ); 
		System.out.println("출금완료!");
	} 
	// 유저삭제(remove)-     
	void     delete  ( BankDto  user){ System.out.println( users.remove(user)?"유저삭제완료":"관리자문의" );} 
	// 종료           -           
	void     exit(    ){  System.out.println("프로그램을 종료합니다."); }
}

public class BankCollect {
	public static void main(String[] args) {
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users); 
		controller.menu();
	}
}




