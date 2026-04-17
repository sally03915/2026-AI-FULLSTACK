package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_김보라 {

	public static void main(String[] args) {
	      String []id = new String[3];       //  one two three	      
	      String []pass = new String[3];   // 1111 2222 3333
	      
	      double []balance = new double[3];// 1100 2200 3300   
	      int menu=-1;  
	      Scanner scanner = new Scanner(System.in);
	      int num = -1;
	      int tempbalance = -1;
	      
		//입력 //처리 //출력
		//for(   ;menu!=9;   ) {
		while(menu!=9) {
//				System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
					+ "👉 번호를 선택하세요:");
			menu = scanner.nextInt();
			if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
			} else if (menu == 1) {
				num = -1;
				for(int i=0;i<balance.length;i++) {
					if(balance[i]==0){num=i; break;}
				}		
				// 꽉찼을경우 
				if(num == -1) { System.out.println("가입불가!"); continue;  } 

				System.out.print("ID 입력: ");
				id[num] = scanner.next();
				System.out.print("PASS 입력: ");
				pass[num] = scanner.next();
				System.out.print("금액 입력: ");
				balance[num] = scanner.nextInt();
				
			}else if (menu >= 2 && menu <= 5) { 
				//	2-1. 사용자가 맞는지 여부
				String tempid="-1", temppass="-1"; 
				System.out.print("아이디  입력 > ");   tempid = scanner.next();
				System.out.print("비밀번호 입력 > ");   temppass = scanner.next(); 
				
				for(int i=0;i<balance.length;i++) {
					if(tempid.equals(id[i]) && temppass.equals(pass[i])){
						num=i;	
						break;				
					}
				}
	
				if(  !(tempid.equals(id[num])  ||  temppass.equals(pass[num]) )) { 
					System.out.println("정보확인해주세요.");  continue; 
				}

				//2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금 , 계좌삭제라면 y,n입력받아서 계좌삭제
				switch( menu ){
					case 2 : System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.2f\n" ,id[num] ,pass[num] , balance[num]);     break;
					case 3 : System.out.print("입금할 금액 > ");  tempbalance = scanner.nextInt();       
								System.out.println("입금완료! 현재잔액 : " + (balance[num] += tempbalance));
					
					break;
					case 4 :  
						System.out.print("출금할 금액 > ");   tempbalance = scanner.nextInt();  
						System.out.println( tempbalance > balance[num] ?"잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (balance[num] -= tempbalance));
					break;
					case 5 : System.out.print("계좌삭제 (Y/N) > "); char again = scanner.next().charAt(0);
						if(again == 'Y' || again == 'y') { id[num] = "-1"; pass[num] = "-1";; balance[num] = -1;  }
					break;
				}
			}
		}// end while		 
	}
}

//Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
//1을 입력하면 추가기능입니다. 출력구문까지만
//2를 입력하면 조회기능입니다. 출력구문까지만
//3을 입력하면 입금기능입니다. 출력구문까지만
//4를 입력하면 출금기능입니다. 출력구문까지만
//5를 입력하면 삭제기능입니다. 출력구문까지만
//9를 입력하면 종료합니다.    출력구문까지만
//
//Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
//■ 힌트
//for(;;) { 
//System.out.println("숫자1을 입력하세요.");
//int a = scanner.nextInt();
//if(a == 1) { break;}
//}