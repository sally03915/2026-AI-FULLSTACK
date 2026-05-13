package std.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class BankDto {
	private String id;
	private String pw;
	private double balance;
	//★ good!
	public BankDto(String id, String pw, double balance) { super(); this.id = id; this.pw = pw; this.balance = balance; }
	public BankDto() { super();  }
	
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }
	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }
	@Override public String toString() { return "BankDto [id=" + id + ", pw=" + pw + ", balance=" + balance + "]"; }

	//★ good!
	@Override public int hashCode() { return Objects.hash(balance, id, pw); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDto other = (BankDto) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}
	
	
}

class Bank{
	List<BankDto> users = new ArrayList<>();

	public Bank(List<BankDto> users) { super(); this.users = users; }
	public Bank() { super();  }
	
	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n💲💲  WELCOME TO BANK SYSTEM  💲💲\n"
				+"==============================\n"
				+"[1] ➕ 계좌 추가\n"
				+"[2] 🔍 계좌 조회\n"
				+"[3] 📈 입금하기\n"
				+"[4] 📉 출금하기\n"
				+"[5] ❌ 계좌 삭제\n"
				+"[9] ‼ 종료 ‼\n"
				+"=============================\n"
				+"번호 입력 > ");
		return sc.nextInt();
	}
	// 계좌추가
	public void addUser() {
		// 아이디중복검사- hashcode/ equals
		String newId = "";
		String newPw = "";
		double newBalance = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력해주세요 > "); newId = sc.next(); 
		System.out.print("\n비밀번호를 입력해주세요 > "); newPw = sc.next(); 
		System.out.print("\n잔액을 입력해주세요 > "); newBalance = sc.nextDouble();
		
		users.add(new BankDto(newId,newPw,newBalance));
		
		System.out.println("\nID = " + newId
						  +"\nPW = " + newPw
						  +"\n잔액 = " + newBalance);	
	}// 계좌 추가 메서드 끝
	
	// 유저 로그인 
	public BankDto userCheak() {
		// 배열에서 몇번째 배열값으로 작동할건지 변수하나 지정해서 뱉어주고 그거로 작동 -> index 변수 하나 만들어서 그걸로 처리
		Scanner sc = new Scanner(System.in);
		System.out.println("--- 로그인 필요 ---");
		System.out.print("\n아이디를 입력해주세요 > ");
		String uid = sc.next();
		System.out.print("\n비밀번호를 입력해주세요 > ");
		String upw = sc.next();
		int index = -1;
		
		for(BankDto u : users) {
			++index;
			if(uid.equals(u.getId()) && upw.equals(u.getPw())) {
				System.out.println(uid + " 님 확인"); 
				return u;
			}
		}
		System.out.println("입력하신 정보와 일치하는 계좌가 없습니다.");
		return null;
	}// 로그인 메서드 끝
	
	// 유저 계좌 정보
	public void userInfo(BankDto user) { 
		System.out.println(user.getId() + " 님의 정보");
		System.out.println("\nID = " + user.getId()
				  +"\nPW = " + user.getPw()
				  +"\n잔액 = " + user.getBalance());
	}// 계좌 정보 메서드 끝
	
	// 입금
	public void deposit(int index) {
		BankDto user = users.get(index);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입금하실 금액을 입력해주세요 > ");
		int input = sc.nextInt();
		user.setBalance(input + user.getBalance());
		
		System.out.println(user.getId() + "님의");
		System.out.println("입금 하신 금액 : " + input);
		System.out.println("총 잔고 : " + user.getBalance());
	}// 입금 메서드 끝
	
	// 출금
	public void withdrawal(int index) {
		BankDto user = users.get(index);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("출금 가능 잔액 : " + user.getBalance());
		System.out.print("출금하실 금액을 입력해주세요 > ");
		int input = sc.nextInt();
		
		if(user.getBalance() < input) {
			System.out.println("출금 가능한 잔액이 모자랍니다");
		}
		else {
			user.setBalance(user.getBalance() - input);
			System.out.println(user.getId() + "님의");
			System.out.println("출금 하신 금액 : " + input);
			System.out.println("총 잔고 : " + user.getBalance());
		}
	}// 출금 메서드 끝
	
	// 계좌 삭제
	public boolean deleteUser() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 하시려는 계좌 정보를 입력해주세요.");
		System.out.println("아이디 > ");
		String id = sc.next();
		System.out.println("비밀번호 > ");
		String pw = sc.next();
		int index = -1;
		
		for(BankDto b : users) {
			++index;
			if(b.getId().equals(id) && b.getPw().equals(pw)) {
				System.out.println(id + "님의 계좌를 삭제하시겠습니까?");
				System.out.println("Y -> 종료 / 외 다른 입력 취소");
				char temp = sc.next().charAt(0);
				if(temp == 'Y' || temp == 'y') {
					System.out.println(id + "님의 계좌 삭제완료");
					users.remove(index);
					return true;
				}
				else { System.out.println("취소합니다. 메인으로 돌아갑니다."); return false; }
			}
		}
		System.out.println("일치하는 계좌 정보가 없습니다");
		return false;
	}// 계좌 삭제 메서드 끝
	
	// 종료
	public void exit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("종료하시겠습니까?");
		System.out.println("Y -> 종료 / 외 다른 입력 취소");
		char temp = sc.next().charAt(0);
		if(temp == 'Y' || temp == 'y') {
			System.out.println("종료합니다.");
			System.exit(0);
		}
		else{
			System.out.println("메인으로 돌아갑니다.");
		}
		
	}// 종료 메서드 끝
}
	
public class BankV2_주엽 {
	public static void main(String[] args) {
		boolean login = false;
		boolean delete = false;
		int index = -1;
		int num = -1;
		Bank b = new Bank();
		BankDto find = null;
		
		while(num != 0) {
			//System.out.println("index " + index + "/login " + login + "/num" + num + "/delete" + delete);
			num = b.menu();
			
			if(num == 1) { b.addUser();}
			else if(   (find = b.userCheak()) != null) {login = true; }
			else if(login && num == 2) {b.userInfo(find);}
			else if(login && num == 3) {b.deposit(find);}
			else if(login && num == 4) {b.withdrawal(find);}
			else if(login && num == 5) {
				delete = b.deleteUser(find);
				if (delete) {login = false;}
			}
			else if(login && num == 9) {b.exit(index); }
			else {System.out.println("값을 다시 입력해주세요");}
			
		}
	}
}
