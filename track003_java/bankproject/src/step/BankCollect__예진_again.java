package step;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적
class BankDto{
	private String id;
	private String pass;
	private double balance;
	//★1. default 생성자
	public BankDto() { super(); }
	public BankDto(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}
	@Override public String toString() { return "id=" + id + ", pass=" + pass + ", balance=" + balance; }
	public String getId() { return id; } 
	public void setId(String id) { this.id = id; }
	public String getPass() { return pass; } 
	public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; } 
	public void setBalance(double balance) { this.balance = balance; }
	//★2. 객체 구분
	@Override public int hashCode() { return Objects.hash(balance, id, pass); }
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
				&& Objects.equals(id, other.id) && Objects.equals(pass, other.pass);
	}
}

class Bank{
	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	
	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }
	
	Scanner sc = new Scanner(System.in);
	//★3.
	BankDto login = null;
	double putm = -1;	double bal = -1;	char deletid ='\u0000';
	
	// 메뉴 - 안에 내용작성
	public void menu() {
		System.out.print("\n -- bank menu --\r\n"
				 + "\r\n"
				 + "1.➕계좌 추가\r\n" 
				 + "2.🔍계좌 조회\r\n" 
				 + "3.💵입금\r\n" 
				 + "4.💸 출금\r\n" 
				 + "5.🗑️삭제\r\n" 
				 + "9.종료\r\n"
				 + "\r\n"+"👉 번호를 선택하세요: ");
	}   
	// 유저추가  (add)
	public void add() {
		//변수
		String id; String pass; double balance;
		//입력 - 사용자에게 정보입력받기
		System.out.print("아이디: ");
		id = sc.next();
		System.out.print("비밀번호: ");
		pass = sc.next();
		do {
			System.out.print("잔액: ");
			balance = sc.nextInt();
		}while(balance<0);
		//처리 
		users.add( new BankDto(id , pass , balance ) );
		System.out.println("사용자 추가 완료");
		//출력
		System.out.println(users);
	}
	// 사용자 확인
	public BankDto usercheck() {
		String id2;	String pw2 ;  BankDto login = null;
		// 아이디 비교    비밀번호 비교
		System.out.print("아이디: "); id2 = sc.next();
		System.out.print("비밀번호: "); pw2 = sc.next();
		
		for(int i=0;i<users.size();i++) {
			if( users.get(i).getId().equals(id2) && users.get(i).getPass().equals(pw2)) {
				login = users.get(i);
				break;
			}
			// ..... 수정바람 데이터가 100만개라면 null값을 채워야함.
			//  if( id.equals(id2) || pw.equals(pw2)) { continue; }
			//			else if( !users.get(i).getId().equals(id2) && !users.get(i).getPass().equals(pw2)) {
			//				login = null;
			//			}
		}
		return login;
	}
	// 잔액 조회
	public void jan() {
		System.out.println("잔액: "+ login.getBalance() + "원");
	}                                                                                                                                              
	// 입금   (get)
	public void deposit() {
		System.out.print("입금금액: "); 
		putm = sc.nextInt();
		bal = login.getBalance();
		
		if(putm>=0) {
			bal = bal + (double)putm;
			System.out.println("잔액: "+ bal + "원");
		}
		else { 
				System.out.println("음수는 입력할 수 없습니다"); 
		}
	}
	// 출금   (get)
	public void withdraw() {
		System.out.print("출금금액: "); 
		putm = sc.nextInt();
		
		if(putm>=0 && bal-(double)putm>=0) {
			bal = bal - (double)putm;
			System.out.println("잔액: "+ bal + "원");
		}
		else { 
				System.out.println("잔액이 부족합니다.  현재 잔액: "+bal); 
		}
	}
	// 유저삭제(remove)
	public void delete() {
		System.out.print("계좌를 삭제하시겠습니까?: ( y / n ) "); 
		deletid = sc.next().charAt(0);
		
		if(deletid == 'y') {
			System.out.println("계좌가 삭제되었습니다.");
			users.remove(login);
		} else if(deletid == 'n') {
			System.out.println("계좌 삭제를 취소하셨습니다.");
		   }
	}
	// 종료   
}
public class BankCollect__예진_again {
	public static void main(String[] args) {
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users);
		int menu=-1;	Scanner sc = new Scanner(System.in);
		System.out.print("\n 🌟💰 welcome to bank 💰🌟\r\n");
		
		while( menu!=9 ) {
			controller.menu();
			menu = sc.nextInt();
			
			if(menu==9) {  //9.종료 >> 종료합니다.
				System.out.println("종료합니다.");
			} 
			else if (menu==1) { //1.추가 - 아이디 id, 비번 pw, 잔액 balance
				controller.add();
			} 
			
			else if (menu>=2 && menu<=6) {  
					BankDto find = controller.usercheck();
					if( find == null ) {  System.out.println("유저정보를 확인해주세요.");   continue; }
					//else {			
					switch(menu) {
					case 2: controller.jan(find); break;
						    
					
					case 3: controller.deposit(find); break;
							
					case 4: controller.withdraw(find); break;
							
					case 5: controller.delete(find); break;
					
					default: System.out.println("잘못된 숫자입력입니다."); break;
					};	 
					//} 
				}
				
			else {
				System.out.println("\n 잘못된 입력입니다.");
			}
		}
	}
}




