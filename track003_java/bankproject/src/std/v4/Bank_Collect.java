package std.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class BankDto{
	private String id;
	private String pass;
	private double balance;
	
	//###  default() / toString  / hashCode + equals
	public BankDto(){} 
	public BankDto(String id) { super(); this.id = id; }
	public BankDto(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance;} 
	
	@Override public int hashCode() { return Objects.hash( id, pass); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDto other = (BankDto) obj;
		return  Objects.equals(id, other.id)  ;
	}
	@Override
	public String toString() {
		return "BankDto [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	}
	public String getId() { return id; }  public void setId(String id) { this.id = id; }
	public String getPass() { return pass; }  public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; }  public void setBalance(double balance) { this.balance = balance; }
}
class Bank1{
	Scanner sc = new Scanner(System.in);
	List<BankDto>  users;
	public Bank1() { super(); }
	public Bank1(List<BankDto> users) { super(); this.users = users; }

	public void menu() {
		int menu=-1; 
		while(menu!=9) {
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n" + "👉 번호를 선택하세요:");
			menu = sc.nextInt();
			if (menu == 9) { System.out.println("프로그램을 종료합니다.");}
			else if (menu == 1) {add();} //계좌추가
			else if (menu >= 2 && menu <= 5) {
				BankDto user = login(); //사용자 인증기능
				if (user == null) { System.out.println("정보확인해주세요.");continue;}
				switch (menu) {
				case 2: view(user); break; //조회기능
				case 3: addbalance(user); break; //입금기능
				case 4: Withdrawal(user); break; //출금기능
				case 5: delete(user); break; /*삭제기능*/}/*switch*/  
			    }/*menu2~5*/ 
		}//while
	}    
	
	public void add() {
		System.out.println("아이디입력");String id=sc.next(); //아이디 중복검사 +
		
		//for(BankDto u : users) { if(u.getId().equals(id)) {System.out.println("중복계좌입니다");  return; }}

		if(users.contains( new BankDto( id)  ) ) {System.out.println("중복계좌입니다");  return; }
		
		System.out.println("비밀번호입력"); String pass=sc.next();
		System.out.print("잔액    입력 > "); Double balance = sc.nextDouble();
		users.add(new BankDto(id,pass,balance));
	}
	       
	BankDto  login() {// 3.사용자 인증기능
		System.out.print("아이디  입력 > "); String tempid = sc.next();
		System.out.print("비밀번호 입력 > "); String temppass = sc.next();
		for(BankDto u : users) { if(u.getId().equals(tempid) && u.getPass().equals(temppass)){return u;}}
		return null; 
	} 

	public void view(BankDto user) { // 5.조회기능
		System.out.println("ID : " + user.getId());
		System.out.println("PASS : " + user.getPass());
		System.out.println("balance : " + user.getBalance());}

	public void addbalance(BankDto user) {// 6.입금기능
		System.out.print("입금할 금액 > "); double money = sc.nextDouble();
		user.setBalance(user.getBalance()+money); System.out.println("입금완료!");}
	
	public void Withdrawal(BankDto user) { // 7.출금기능
		System.out.print("출금할 금액 > "); double tempbalance = sc.nextDouble();
		if(tempbalance> user.getBalance()){System.out.println("잔액부족! 출금불가");}
		else {user.setBalance(user.getBalance()-tempbalance);
			System.out.println("출금완료! 현재잔액 :" +user.getBalance());}
	}

	public void delete(BankDto user) { // 8.삭제기능
		System.out.print("계좌삭제 (Y/N) > "); char again = sc.next().charAt(0);
		if (again == 'Y' || again == 'y') { users.remove(user); System.out.println("계좌삭제완료"); } }
}

public class Bank_Collect {
	public static void main(String[] args) {
		List<BankDto>  users = new ArrayList<>();
		Bank1      controller = new Bank1(users);
		controller.menu();

	}
}


/*
1. 좋아하는 주제로 바꾸기
2. youtube 동영상마무리
3. 미니프로젝트이용해서 얻은점
예) https://shgil0618-glitch.github.io/fullstack_gsh/ 
*/
