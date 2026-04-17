package std.v3;

import java.util.Arrays;
import java.util.Scanner;

public class BankV3_Hint {
   // 변수 0 1 2
   ////////////////////////////////////////////////////
   static String []id = new String[3];       //  one two three	      
   static String []pass = new String[3];   // 1111 2222 3333
   
   static double []balance = new double[3];// 1100 2200 3300   
   static int menu=-1;  
   static Scanner scanner = new Scanner(System.in);
   static int num = -1;
   static int tempbalance = -1;
	////////////////////////////////////////////////////
	//1. 메뉴판을 기능
    //2. 유저 빈칸찾기 기능
    //3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
    //4. 계좌추가기능
    //5. 조회기능
    //6. 입금기능
    //7. 출금기능
    //8. 삭제기능
	////////////////////////////////////////////////////
      
	public static void main(String[] args) {

	      
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
