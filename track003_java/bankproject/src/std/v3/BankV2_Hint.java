package std.v3;

import java.util.Arrays;
import java.util.Scanner;

public class BankV2_Hint {
	public static void main(String[] args) { 
		//변수								  0   1    2
		////////////////////////////////////////////////////// 
		String []id=new String[3];       //  one two three
		String []pass = new String[3];   // 1111 2222 3333
		double []balance = new double[3];// 1100 2200 3300	
		int menu=-1;  
		Scanner sc = new Scanner(System.in);
		//////////////////////////////////////////////////////  
		while(menu!=9) {
			System.out.println(   Arrays.toString(id)   );  // 현재상태확인
			System.out.println(   Arrays.toString(balance)   ); 
			System.out.println("\n======BANK======");
			System.out.println("[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기"  + "\n[5] 🗑️ 계좌 삭제" + "\n[9] 💀 종료" + "\n👉 번호를 선택하세요: ");
			menu = sc.nextInt(); // 1 ~ 9까지 입력
			
			if (menu == 9) { System.out.println("종료합니다"); break; }
			else if (menu == 1) {
				//1. 빈칸인번호 찾기
				int find = -1; 
				// 1. 0번째가 빈칸이라면 - 빈칸인번호 찾기  find 빈칸번호 0 넣기
				// 1. 1번째가 빈칸이라면 - 빈칸인번호 찾기  find 빈칸번호 1 넣기
				// 1. 2번째가 빈칸이라면 - 빈칸인번호 찾기  find 빈칸번호 2 넣기
				// if( balance  0번째가 0이라면 ){ find 빈칸번호 0 넣기 }
				// if( balance  1번째가 0이라면 ){ find 빈칸번호 1 넣기 }
				// if( balance  2번째가 0이라면 ){ find 빈칸번호 2 넣기 } 
				if( balance[0] ==0 ){ find=0; }
				if( balance[1] ==0 ){ find=1; }
				if( balance[2] ==0 ){ find=2; } 
				if(find == -1) { System.out.println("가입불가!"); continue;  }   // find 가 -1이면 꽉찼음! 아래사용자값 입력받기하면 안됨! continue
				// 2. 0번째에 입력받기
				System.out.print("아이디  입력 > ");   id[find] = sc.next();
				System.out.print("비밀번호 입력 > ");   pass[find] = sc.next();
				System.out.print("잔액    입력 > ");   balance[find] = sc.nextInt();
				
			} else if (menu >= 2 && menu <= 5) { 
				
			}
		}
	}
}
