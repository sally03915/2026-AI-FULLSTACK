package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;


// 다른종류가 들어올수 있으니까 출력할때 반복문으로 출력하는거 구상
class CryptoDto {
	private String name;
	private String symbol;
	private double price;
	private double prevprice; // 가격 변동전 가격담아놓을 변수

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	public double getPrevprice() { return prevprice; }
	public void setPrevprice(double prevprice) { this.prevprice = prevprice; }
	
	public CryptoDto() { super();  }
	public CryptoDto(String name, String symbol, double price) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.price = price;
		this.prevprice = price;
	}

	//// hasCode / equals
}

class UserDto {
	private String id;
	private String pw;
	private double balance;
	
	// 심볼값, 수량 들어가게
	Map<String,Double> wallet = new HashMap<>();
	public UserDto(String id, String pw, double balance) {
		super();
		this.id = id;
		this.pw = pw;
		this.balance = balance;
	}
	
	public UserDto() { super();  }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }
	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }
	public Map<String, Double> getWallet() { return wallet; }
	public void setWallet(Map<String, Double> wallet) { this.wallet = wallet; }
	@Override public String toString() { return "BankDto [id=" + id + ", pw=" + pw + ", balance=" + balance + "]"; }
	@Override public int hashCode() { return Objects.hash(balance, id, pw); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}

}

// 시장 클래스 / 사고 팔고, 변동성 메서드 구현
class Market{
	Map<String,CryptoDto> coins = new HashMap<>();
	
	
	public Map<String, CryptoDto> getCoins() { return coins; }
	public void setCoins(Map<String, CryptoDto> coins) { this.coins = coins; }

	// 코인 추가
	public Market() { // name symbol price
		coins.put("AAA", new CryptoDto("A코인", "AAA", 1000000));
		coins.put("BBB", new CryptoDto("B코인", "BBB", 500000));
		coins.put("CCC", new CryptoDto("C코인", "CCC", 500000));
	}
	
	// 가격 변동
	public void updatePrice(Market market) {
		for(CryptoDto c : coins.values()) {
			c.setPrevprice(c.getPrice());
			double random = Math.random();
			double update = (random * 21 - 10) / 100;
			double result = c.getPrice()+(c.getPrice()*update);
			c.setPrice(result);
		}
		System.out.println("가격 변동");
	}
}

// 메뉴 클래스 따로 빼서 뱅크 상속?
class Bank{
	public static final String FONT_BLUE = "\u001B[34m";
	public static final String FONT_RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m"; 
	Map<String,UserDto> users = new HashMap<>();
	UserDto loginUser;	

	public Bank() { super();  }
	public Bank(Map<String, UserDto> users) { super(); this.users = users;}
	
	public int menu() { // 메인 메뉴
		Scanner sc = new Scanner(System.in);
		// 완료
		// 여기도 전체적으로 구문 수정
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("===============================================");
		System.out.println("[1] 계좌 등록 \t\t [2] 기본 정보 조회");
		System.out.println("[3] 현금 입금 \t\t [4] 현금 출금");
		System.out.println("-----------------------------------------------");
		System.out.println("[5] 거래소 \t\t [6] 내 총 자산 리포트");
		System.out.println("-----------------------------------------------");
		System.out.println("[9] 계좌 삭제 \t\t [0] 프로그램 종료");
		System.out.println("===============================================");
		System.out.print("번호 입력 > ");
		return sc.nextInt();
	} // 메인 메뉴 끝
	
	public int coinMenu() { // 거래소 메뉴
		Scanner sc = new Scanner(System.in);
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t      거래소에 오신것을 환영합니다.");
		System.out.println("===============================================");
		System.out.println("[1] 시세 조회");
		System.out.println("[2] 코인 매수 (Buy)");
		System.out.println("[3] 코인 매도 (Sell)");
		System.out.println("[9] 뒤로가기");
		System.out.println("===============================================");
		System.out.print("번호 입력 > ");
		return sc.nextInt();
		
	} // 거래소 메뉴 끝
	
	public void coinList(Market market) { // 코인 목록
		String color = "";
		//시간 되면 리스트 정렬해서 오름차 내림차순으로 정렬하는거
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t           실시간 코인 시세");
		System.out.println("===============================================");
		System.out.printf("%-10s | %-12s | %-18s\n","심볼(Symbol)","코인명(Name)","현재가(Price)");
		
		///// ####  갯수가독성있게 몇개  (5개씩)
		// printf
		// %-as >> - 왼쪽 정렬, a 칸 만큼 자리확보 
		// %,a.2f >> , 3자리마다 쉼표 찍기, a 칸만큼 자리확보
		for(CryptoDto c : market.coins.values()) {
			if(c.getPrice() > c.getPrevprice()) { color = FONT_RED; }
			else if(c.getPrice() < c.getPrevprice()) { color = FONT_BLUE; }
			else { color = RESET; }
			System.out.printf(" %-10s | %-12s | %s%,15.2f%s\n"
					,c.getSymbol(),c.getName(),color,c.getPrice(),RESET);
		}
		System.out.println("===============================================");
		

	} // 코인 목록 끝
	
	public void coinBuy(Market market, UserDto user) { // 구매 문단
		CryptoDto coin = new CryptoDto();
		Scanner sc = new Scanner(System.in);
		String sb_input = "";
		double am_input = -1;
		boolean msg = false;

		///// ####  갯수가독성있게 몇개  (5개씩)		
		// 순서 없으니까 숫자가 아니고 심볼명이나 코인이름으로 값 받아와서 찾아와야함
		// 심볼값이랑 수량만 가져가서 wallet에 처리하면될거같음
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t           실시간 코인 시세");
		System.out.println("===============================================");
		System.out.printf("%-10s | %-12s | %-18s\n","심볼(Symbol)","코인명(Name)","현재가(Price)");
		for(CryptoDto c : market.coins.values()) {
			System.out.printf(" %-10s | %-12s | %,15.2f\n"
					,c.getSymbol(),c.getName(),c.getPrice());
		}
		System.out.println("===============================================");
		// 원하는 심볼명 물어보고
		System.out.println("구매를 원하는 코인의 심볼명을 입력해주세요");
		System.out.print("> ");
		sb_input = sc.next();

		// 일치하는거 있는지 1차적으로 확인
		for(CryptoDto c : market.coins.values()) {
			if(c.getSymbol().equals(sb_input.toUpperCase())) {
//				System.out.println("테스트 문자열 확인됨");
				System.out.println("===============================================");
				System.out.println(c.getSymbol() +"의 현재 시세");
				System.out.printf(" %-10s | %-12s | %,15.2f\n"
						,c.getSymbol(),c.getName(),c.getPrice());
				coin = c;
				msg = true;
				break;
			}
		}
		if(!msg) {System.out.println("일치하는 심볼명이 존재하지 않습니다."); return;}
		System.out.println("===============================================");
		System.out.println(coin.getSymbol()+"의 현재 가격 : "  + coin.getPrice());
		System.out.printf("%s 님의 구매 가능 금액 : %,.2f" ,user.getId() , user.getBalance());
		System.out.printf("\n구매 가능한 총 수량 : %,.2f\n", (user.getBalance()/coin.getPrice()));
		
		// 몇개 구매할건지 물어보고
		System.out.print("총 수량을 입력해주세요 > ");
		am_input = sc.nextDouble();
		// 구매 할 수 있는 충분한 잔고가 있는지 확인
		if(user.getBalance() > coin.getPrice()*am_input) {
			// 전부 조건 충족하면 해당 user의 wallet에 처리
//			System.out.println("정상 수량 if문 진입 확인");
			user.wallet.put(coin.getSymbol(), am_input);
			user.setBalance(user.getBalance()-(am_input*coin.getPrice()));
//			System.out.println(user.wallet); -> 정상 입력 확인
			System.out.println("===============================================");
			System.out.println(user.getId()+"님 거래 성공");
			System.out.printf("%-10s | %-12s | %-18s\n","심볼(Symbol)","코인명(Name)","현재가(Price)");
			System.out.printf("%-11s | %-12s | %,15.2f\n"
					,coin.getSymbol(),coin.getName(),coin.getPrice());
			System.out.println("-----------------------------------------------");
			System.out.printf("%-10s | %-12s | %-18s\n","구매 수량","구매 금액","남은 잔고");
			System.out.printf(" %,-10.2f | %,-12.2f | %,15.2f\n"
					,am_input,(coin.getPrice()*am_input),user.getBalance());
		}
		else {System.out.println("잔고가 모자랍니다."); return;}
	} // 구매 문단 끝
	
	public void coinSell(UserDto user, Market market) { // 판매 문단
		CryptoDto coin = new CryptoDto();
		Scanner sc = new Scanner(System.in);
		String sb_input = "";
		double am_input = -1;
		boolean msg = false;
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t           보유하신 코인 리스트");
		System.out.println("===============================================");
		System.out.printf("%-10s | %-12s | %-18s\n","심볼(Symbol)","보유 수량","현재가(Price)");
		for(Entry<String,Double> e : user.wallet.entrySet()) {
			coin = market.coins.get(e.getKey());
			System.out.printf("%-10s | %,-12.2f | %,-18.2f\n"
					,e.getKey(),e.getValue(),coin.getPrice());
		}
		System.out.println("===============================================");
		// 원하는 심볼명 물어보고
		System.out.println("판매를 원하는 코인의 심볼명을 입력해주세요");
		System.out.print("> ");
		sb_input = sc.next();
		// 일치하는거 있는지 1차적으로 확인
		for(Entry<String,Double> e : user.wallet.entrySet()) {
			coin = market.coins.get(e.getKey());
			if(e.getKey().equals(sb_input.toUpperCase())) {
				msg = true;
				break;
			}
		}
		if(!msg) {System.out.println("일치하는 심볼명이 존재하지 않습니다."); return;}
		System.out.println("===============================================");
		System.out.printf("%s 님의 판매 가능 수량 : %,.2f" ,user.getId() , user.wallet.get(coin.getSymbol()));
		// 몇개 판매할건지 물어보고
		System.out.println("\n판매하려는 총 수량을 입력해주세요 > ");
		am_input = sc.nextDouble();
//			System.out.println("정상 수량 if문 진입 확인");
		if(user.wallet.get(coin.getSymbol()) == am_input) { // 전체 수량 매도
//			System.out.println("전량 매도 if문");
			System.out.println(user.wallet.get(coin.getSymbol()));
			user.setBalance(user.getBalance() + (coin.getPrice()*am_input));
			user.wallet.remove(coin.getSymbol());
		}
		else if(user.wallet.get(coin.getSymbol()) >= am_input){
//			System.out.println("부분 매도 if문");
			user.setBalance(user.getBalance() + (coin.getPrice()*am_input));
			user.wallet.put(coin.getSymbol(),(user.wallet.get(coin.getSymbol()) - am_input));
		}
//			System.out.println(user.wallet); -> 정상 입력 확인
		System.out.println("===============================================");
		System.out.println(user.getId()+"님 거래 성공");
		System.out.printf("%-10s | %-12s | %-18s\n","심볼(Symbol)","코인명(Name)","현재가(Price)");
		System.out.printf("%-11s | %-12s | %,15.2f\n"
				,coin.getSymbol(),coin.getName(),coin.getPrice());
		System.out.println("-----------------------------------------------");
		System.out.printf("%-10s | %-12s | %-18s\n","판매 수량","판매 금액","남은 잔고");
		System.out.printf(" %,-10.2f | %,-12.2f | %,15.2f\n"
				,am_input,(coin.getPrice()*am_input),user.getBalance());
	}
	

	public void addUser() {	// 계좌추가
		String newId = "";
		String newPw = "";
		String newName = "";
		double newBalance = 0;
		
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력해주세요 >");
		newName = sc.next();
		
		System.out.print("아이디를 입력해주세요 > ");
		newId = sc.next();
		
		// 아이디 중복 검사
		for(Entry<String,UserDto> b : users.entrySet()) {
			if(b.getValue().getId().equals(newId)) {
				System.out.println("이미 존재하는 아이디입니다.");
				return;
			}
		}
		
		System.out.print("\n비밀번호를 입력해주세요 > ");
		newPw = sc.next();
		
		System.out.print("\n잔액을 입력해주세요 > ");
		newBalance = sc.nextDouble();
		
		users.put(newName , new UserDto(newId,newPw,newBalance));
		
		System.out.printf("\nID = %s\nPW = %s\n잔액 = %,.2f\n",newId,newPw,newBalance);	
	}// 계좌 추가 메서드 끝
	
	public UserDto userCheak() {	// 유저 로그인 
		Scanner sc = new Scanner(System.in);
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t            로그인");
		System.out.println("===============================================");
		System.out.print("\n아이디를 입력해주세요 > ");
		String uid = sc.next();
		System.out.print("\n비밀번호를 입력해주세요 > ");
		String upw = sc.next();
		
		for(Entry<String,UserDto> u : users.entrySet()) {
			if(uid.equals(u.getValue().getId()) && upw.equals(u.getValue().getPw())) {
				System.out.println(uid + " 님 확인");
				this.loginUser = u.getValue();
				return u.getValue();
			}
		}
		System.out.println("입력하신 정보와 일치하는 계좌가 없습니다.");
		return null;
	}// 로그인 메서드 끝
	
	public void userInfo(UserDto user, Market market) {	// 자산 리포트
//		BankDto user = users.get(index);
		double total = 0;
		System.out.println("\n===============================================");
		System.out.println(user.getId() + " 님의 총 자산 리포트");
		System.out.println("===============================================");
		System.out.printf("%-10s | %-12s | %-18s\n","아이디","비밀번호","보유 현금");
		System.out.printf("%-10s | %-12s | %,-18.2f\n",user.getId(),user.getPw(),user.getBalance());
		System.out.println("-----------------------------------------------");
		if(!user.getWallet().isEmpty()) { // 보유 자산 없을때 처리
//			System.out.println("조건문 들어옴");
			System.out.printf("%-10s | %-12s | %-18s\n","심볼(Symbol)","코인명(Name)","보유량");
			for(Entry<String,Double> e : user.wallet.entrySet()) {
				String symbol = e.getKey();
				double amount = e.getValue();
				CryptoDto coin = market.getCoins().get(symbol);
				total += coin.getPrice()*amount;
				System.out.printf("%-10s | %-12s | %-18s\n"
						,symbol,coin.getName(),amount);
				// 총 평가 금액 추가해야함
			}
		}
		else {System.out.println("보유 하신 코인 자산이 없습니다.");}
		System.out.println("-----------------------------------------------");
		System.out.printf("총 평가 금액 : %,.2f\n",(total+user.getBalance()));
		
		
	}// 자산 리포트 끝
	
	public void userInfo_2(UserDto user) { // 기본 정보
		System.out.println("\n===============================================");
		System.out.println(user.getId() + " 님의 기본 정보");
		System.out.println("===============================================");
		System.out.printf("%-10s | %-12s | %-18s\n","아이디","비밀번호","보유 현금");
		System.out.printf("%-10s | %-12s | %,-18.2f\n",user.getId(),user.getPw(),user.getBalance());
		System.out.println("-----------------------------------------------");
		
	}// 기본정보 끝
	
	public void deposit(UserDto user) {	// 입금
//		BankDto user = users.get(index);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t           현금 입금");
		System.out.println("===============================================");
		System.out.printf("%s 님의 현재 잔액 : %,.2f\n",user.getId(),user.getBalance());
		
		System.out.print("입금하실 금액을 입력해주세요 > ");
		int input = sc.nextInt();
		user.setBalance(input + user.getBalance());
		System.out.println("-----------------------------------------------");
		System.out.printf("입금 하신 금액 : %,.2f\n",(double)input);
		System.out.printf("%s 님의 현금 잔고 : %,.2f\n",user.getId(),user.getBalance());

	}// 입금 메서드 끝
	
	public void withdrawal(UserDto user) {	// 출금
//		BankDto user = users.get(index);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n===============================================");
		System.out.println("\tCRYPTO TRADING & BANKING SYSTEM\t");
		System.out.println("\t           현금 출금");
		System.out.println("===============================================");
		System.out.printf("%s 님의 현재 잔액 : %,.2f\n",user.getId(),user.getBalance());
		System.out.printf("출금 가능 잔액 : %,.2f\n",user.getBalance());
		
		System.out.print("출금하실 금액을 입력해주세요 > ");
		int input = sc.nextInt();
		System.out.println("-----------------------------------------------");
		
		if(user.getBalance() < input) {
			System.out.println("출금 가능한 잔액이 모자랍니다");
		}
		else {
			user.setBalance(user.getBalance() - input);
			System.out.println(user.getId() + "님의");
			System.out.printf("출금 하신 금액 : %,.2f\n",(double)input);
			System.out.printf("총 잔고 : %,.2f\n",user.getBalance());
		}
	}// 출금 메서드 끝
	
	public void deleteUser() { 	// 계좌 삭제
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 하시려는 계좌 정보를 입력해주세요.");
		System.out.println("아이디 > ");
		String id = sc.next();
		
		System.out.println("비밀번호 > ");
		String pw = sc.next();
		
//		int index = -1;
		boolean msg = false;
		
		for(Entry<String,UserDto> b : users.entrySet()) {
//			++index;
			if(b.getValue().getId().equals(id) && b.getValue().getPw().equals(pw)) {
				System.out.println(id + "님의 계좌를 삭제하시겠습니까?");
				System.out.println("Y -> 종료 / 외 다른 입력 취소");
				char temp = sc.next().charAt(0);
				if(temp == 'Y' || temp == 'y') {
					System.out.println(b.getKey() + "님의 계좌 삭제완료");
					users.remove(b.getKey());
					this.loginUser = null;
					msg = true;
					break;
				}
				else { System.out.println("취소합니다. 메인으로 돌아갑니다.");}
			}
		}
		if(msg) {System.out.println("입력하신 정보와 일치하는 계좌가 없습니다.");}
		
		
	}// 계좌 삭제 메서드 끝
	
	public void exit() { // 종료
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
	
public class BankV3 {
	public static void main(String[] args) {
	
		int num = -1;
		Bank b = new Bank();
		Market m = new Market();
		
		//테스트용
//		UserDto test = new UserDto("qqq","qqq",100000000);
//		b.loginUser = test;
		while(num != 0) {
			
			// try catch?
			m.updatePrice(m);
			num = b.menu();
			
			if(b.loginUser == null && num != 1) { b.loginUser = b.userCheak(); continue; }
			
			// 메뉴 전체적으로 완성되면 해당 메뉴 메서드 수정 아래 test도 b로 바꿔야함
			switch(num) {
			case 1: b.addUser(); break;
			case 2: b.userInfo_2(b.loginUser); break;
			case 3: b.deposit(b.loginUser); break;
			case 4: b.withdrawal(b.loginUser); break;
			case 5: 
				while(num != 9) {
					num = b.coinMenu();
					switch(num) {
					case 1: b.coinList(m); break;
					case 2: b.coinBuy(m,b.loginUser); break;
					case 3: b.coinSell(b.loginUser, m); break;
					case 9: System.out.println("메인 메뉴로 돌아갑니다."); break;
					default :  System.out.println("값을 다시 입력해주세요");
					}
				} break;
			case 6: b.userInfo(b.loginUser, m); break;
			case 9: b.deleteUser(); break;
			case 0: b.exit(); break;
			default: System.out.println("값을 다시 입력해주세요");
			}
			
		}
	}
}
