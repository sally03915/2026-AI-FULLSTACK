package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_김욱진 {
	public static void main(String[] args) {
		//변수
		String [] id = new String[3];
		String [] pass = new String[3];
		double [] balance = new double[3];
		int num = -1; 
		int menu = -1;
		
		Scanner sc = new Scanner(System.in);
		
		while(menu!=9) {
			System.out.println(Arrays.toString(id));
			
			//System.out.println(id+"\t"+pass+"\t"+balance); // 계좌 1명분 (확인용)
			System.out.println("👌WELCOME TO BANK SYSTEM👌");
			System.out.println("[1] ➕계좌 추가");
			System.out.println("[2] 🔎계좌 조회");
			System.out.println("[3] 💶입금 하기");
			System.out.println("[4] 💸출금 하기");
			System.out.println("[5] ❌계좌 삭제");
			System.out.println("[9] 🖐종료\n");
			
			System.out.print("👉번호를 입력해주세요.>"); menu = sc.nextInt();
			
			
			
			if(menu==9) { System.out.println("프로그램은 종료합니다."); break; }
			else if(menu==1) { 
				
				// 1. 0번째가 빈칸이라면 - 빈칸 번호찾기
				// if (balance 0번째가 0이라면) { find에 0 넣기 }
				// if (balance 1번째가 1이라면) { find에 1 넣기 }
				// if (balance 2번째가 2이라면) { find에 2 넣기 }
				
				// 2. 0번째에 입력받기 
				
				int find = -1;

				for (int i = 0; i < id.length; i++) {
					if (id[i] == null) { find = i;  break; }
				}
				if(find==-1) { System.out.println("등록이 불가합니다."); continue; }
				System.out.print("[1]ID   입력> ");	id[find]=sc.next();		

				System.out.print("[2]PASS 입력>");  pass[find]=sc.next();

				System.out.print("[3]금액  입력> ");  balance[find]=sc.nextInt();

					
			}
			
			else if(menu>=2 && menu<=5) { 
				String tid ="",tpass ="";
				int find=-1;
				//입력
				System.out.print("[1]ID   입력> "); tid = sc.next();
				System.out.print("[2]PASS 입력> "); tpass = sc.next();
				
				
				
				for(int i=0;i<id.length;i++) {
					if(  id[i] != null && pass[i] != null &&  id[i].equals(tid) && pass[i].equals(tpass)) { find=i; break; }
					}
					
				//find가 -1이면 유저 없음
				if(find==-1) { continue; }
				
				
//				if((id[0].equals(tid))!=true || (pass[0].equals(tpass))!=true) { System.out.println("다시 확인 해주세요."); continue; }
//				if((id[1].equals(tid))!=true || (pass[1].equals(tpass))!=true) { System.out.println("다시 확인 해주세요."); continue; }
//				if((id[2].equals(tid))!=true || (pass[2].equals(tpass))!=true) { System.out.println("다시 확인 해주세요."); continue; }
			
					switch(menu) {
					case 2: System.out.printf("ID : %s\nPASS : %s\nBALANCE : %.1f\n",id[find],pass[find],balance[find]); break;
					case 3: System.out.print("입금할 금액 > ");   balance[find] += sc.nextInt(); break;
					case 4: System.out.println("출금할 금액 > "); int tbalance = sc.nextInt(); 
							System.out.println(tbalance>balance[find]? "잔액부족! 출금불가" : "출금완료! 현재잔액"  + (balance[find] -=tbalance ) );
							break;
					case 5: System.out.println("계좌삭제(Y/N)");  char again = sc.next().charAt(0);
							if(again == 'Y' || again == 'y') { id[find]=null; pass[find]=null;}
							break;
								
					} // end switch		
				
			} // end else if(menu>=2 && menu<=5)	
			
		} // end while
		

		

	}
}

/*
 one   two  three
1111  2222  3333
1100  2200  3300

*/