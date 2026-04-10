package std.v1;

import java.util.Scanner;

public class Bank_최윤정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 변수
		int menu = -1;
		String result = "";
		int id = -1, pass = -1, balance = -1;
		
		while(menu != 9){
			System.out.println("=== 🌟💰 WELCOME TO BANK SYSTEM 💰🌟 ===\n\n"
		                       +"[1] ➕ 계좌 추가\n"
					           +"[2] 🔍 계좌 조회\n"
		                       +"[3] 💵 입금하기\n"
					           +"[4] 💸 출금하기\n"
		                       +"[5] 🗑️ 계좌 삭제\n"
					           +"[9] ❎ 종료\n\n"
		                       +"=======================================\n\n"
					           +"👉 번호를 선택하세요: ");
			menu = sc.nextInt();
			
			if(menu == 9) System.out.println("종료합니다.😥");
			else if(menu == 1) {
				System.out.print("[1]ID   입력> ");
				id = sc.nextInt();
				System.out.print("[2]PASS 입력> ");
				pass = sc.nextInt();
				System.out.print("[3]금액  입력> ");
				balance = sc.nextInt();
			} else if (2 <= menu && menu <= 5) {
				//2-1. 사용자가 맞는지 여부
				int tid = -1, tpass = -1;
				System.out.print("[1]임시 ID   입력> ");
				tid = sc.nextInt();
				System.out.print("[2]임시 PASS 입력> ");
				tpass = sc.nextInt();
				
				if(id != tid || pass != tpass) {
					System.out.println("존재하지 않는 ID와 PASS 입니다.");
					continue;
				}
				
				switch( menu ){
					case 2: // 조회처리
						System.out.printf("id: %d \npass: %d \nbalance: %d\n",id,pass,balance);
						break;
					case 3: // 입금 받기 / 잔액에 입금받은 돈 추가
						System.out.print("[3]금액  입력> ");
						int tbalance = sc.nextInt();
						balance += tbalance; 
						System.out.printf("계좌 잔액: %d\n",balance);
						break;
					case 4: //출금 받기 / 잔액에 출금받은 돈 빼기 (마이너스 통장x, 잔액 없으면 출금x)
						System.out.print("[3]금액  입력> ");
						tbalance = sc.nextInt();
						if(tbalance > balance) {
							System.out.println("잔액이 없어 출금이 불가합니다.");
							break;
						}
						balance -= tbalance; 
						System.out.printf("계좌 잔액: %d\n",balance);
						break;
					case 5: // 계좌 삭제여부, Y,y 입력 받으면 계좌삭제 | 아니면 메뉴로 돌아가기
						System.out.print("정말로 계좌를 삭제하시겠습니까?😥(y/n) > ");
						String isYn = sc.next();
						if(isYn.equals("Y")||isYn.equals("y")) {
							id = -1;
							pass = -1;
							balance = -1;
						}
						break;
				}
			}
		}
	}
}

/*
 * ver-1
 - 조건문 : if, switch
 - 반복문 : for(시작;종료;변화), while(조건), do while(한번은 무조건 실행 맨끝에 조건)

무한 반복(종료 9){
	0. 메뉴판 입력
	=== 🌟💰 WELCOME TO BANK SYSTEM 💰🌟 ===  
	[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제 [9] ❎ 종료
	👉 번호를 선택하세요:
	
	1. [1] ➕ 계좌 추가
	2. [2~5]
		2-1. 사용자가 맞는지 여부
		2-2. 조회면 조회기능, 입력이면 사용자에게 입력 받아서 입금, 출금금액받아서 출금
		     계좌 삭제라면 y/n 입력 받아서 계좌 삭제
	3. [9] 종료
} 

while( menu != 9 ){
	0. 메뉴판 입력
	=== 🌟💰 WELCOME TO BANK SYSTEM 💰🌟 ===  
	[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제 [9] ❎ 종료
	👉 번호를 선택하세요:
	
	if(menu == 9) { [9] 종료문구 }
	else if(menu == 1) { [1] ➕ 계좌 추가 }
	else {
		2. [2~5] 메뉴
		2-1. 사용자가 맞는지 여부
		임시 아이디 입력 받기 >
		임시 비밀번호 입력 받기 >
		
		저장되어있는 아이디와 임시아이디가 같고, 저장되어 있는 비밀번호와 임시비밀번호가 같으면 아래 내용 처리
		2-2. 조회면 조회기능, 입력이면 사용자에게 입력 받아서 입금, 출금금액받아서 출금
		     계좌 삭제라면 y/n 입력 받아서 계좌 삭제
			switch( menu ){
				case 2: 조회처리 break;
				case 3: 입금 받기 / 잔액에 입금받은 돈 추가 break;
				case 4: 출금 받기 / 잔액에 출금받은 돈 빼기 (마이너스 통장x, 잔액 없으면 출금x) break;
				case 5: 계좌 삭제여부, Y,y 입력 받으면 계좌삭제 | 아니면 메뉴로 돌아가기 break;
			} 
	}
}
 */
