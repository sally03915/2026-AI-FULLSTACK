package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_문대원 {

	public static void main(String[] args) {

	      //변수                         	    0   1    2
	      String []id=new String[3];       //  one two three
	      String []pass = new String[3];   // 1111 2222 3333
	      double []balance = new double[3];// 1100 2200 3300   
	      int menu=-1;  
	      Scanner sc = new Scanner(System.in);
	    
		//입력 //처리 //출력
		//for(  ; menu!=9; ) {
		while( menu!=9 ) {       
			System.out.println(   Arrays.toString(id)   );  // 현재상태확인
			System.out.println(   Arrays.toString(balance)   );
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "\r\n"
					+ "[1] ➕ 계좌 추가\r\n"
					+ "[2] 🔍 계좌 조회\r\n"
					+ "[3] 💵 입금하기\r\n"
					+ "[4] 💸 출금하기\r\n"
					+ "[5] 🗑️ 계좌 삭제  \r\n"
					+ "\r\n"
					+ "👉 번호를 선택하세요:");menu=sc.nextInt();
			
			if(menu == 9) {
			System.out.println("프로그램을 종료합니다."); 
			} else if(menu == 1) {
				int find = -1;
				//변수 x
				// 1. 0번째가 빈칸이라면
				// 2. 0번째에 입력받기
				for (int k = 0; k < balance.length; k++) {
					if (balance[k] == 0) {
						find = k;
						break;
					}
				}
				if(find == -1) { System.out.println("가입불가"); continue;}
				
				System.out.print("아이디   입력 > ");	id[find]=sc.next();
				System.out.print("비밀번호 입력 > "); 	pass[find]=sc.next();
				System.out.print("잔액    입력 > "); 	balance[find]=sc.nextDouble();
			
				//처리 x 출력 x
			} else if(menu>=2 && menu<=5) {		
				//	2-1. 사용자가 맞는지 여부
				String tempid, temppass;
				System.out.print("아이디   입력 > "); tempid=sc.next();
				System.out.print("비밀번호 입력 > "); temppass=sc.next();
				//( !( id == tempid && pass == tempass) ) { continue;}
				//id.equals(id3)
				int b=-1;
				for (int v = 0; v < id.length; v++) {
					if (id[v].equals(tempid) && pass[v].equals(temppass)) {
						b = v; break;
					}
				}

				if(b == -1) { System.out.println("정보확인해주세요."); continue;}
				 	  
				switch( menu ) {
					case 2 : System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.1f\n", id[b], pass[b],balance[b]); 	  break;
					case 3 : System.out.print("입금할 금액 > "); balance[b] += sc.nextInt(); 	 		 		  break;
					case 4 : 
						System.out.print("출금할 금액 > "); int tempbalance = sc.nextInt();    			
						System.out.println( tempbalance > balance[b] ?"잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (balance[b] -= tempbalance));
					break;
					case 5 : System.out.println("계좌삭제 (Y/N) > "); char again = sc.next().charAt(b);
						if(again == 'Y' || again == 'y') {id[b]   = ""; pass[b] = ""; balance[b] =0;}
					break;
							}
			 	}
			 	  else { System.out.println("정보확인해주세요."); continue;}
			
				

		}// end while

	}
}
