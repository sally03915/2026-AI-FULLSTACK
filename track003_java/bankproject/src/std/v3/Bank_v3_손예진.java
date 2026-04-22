package std.v3;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v3_손예진 {
		// 변수 0 1 2
		static String[] id = new String[3]; // one two three
		static String[] pass = new String[3]; // 1111 2222 3333
		static double[] balance = new double[3];// 1100 2200 3300
		
		static Scanner sc = new Scanner(System.in);
		static char deletid = '\u0000';
		static String id2 = " ";
		static String pw2 = " ";
		static int tempbalance = -1;
		
		//		   1. 메뉴 선택
		public static int menu() {
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
		               + "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
		               + "👉 번호를 선택하세요:");
		         menu = sc.nextInt();
		         return menu;
		}
		//		   2. 기능 
		// 유저 빈칸찾기 기능, 3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
		public static int fd() {
			find=-1;
            for (int i = 0; i < id.length; i++) {
            	if(menu==1) {
            		if (id[i] == null)  
            			return find = i;  
            	}
            	else if(menu >= 2 && menu <= 6) {
            	//   2-1. 사용자가 맞는지 여부
		            String id2="-1", pw2="-1"; 
		            System.out.print("아이디  입력 > ");   id2 = sc.next();
		            System.out.print("비밀번호 입력 > ");   pw2 = sc.next(); 
            		if (id[i].equals(id2) && pass[i].equals(pw2))   find = i; 
            		
            		return find;
            	}
               
            }
            return find;
		}
		//4. 계좌추가기능
		public static String id(int f) {
			System.out.print("아이디: ");
            id[f] = sc.next();
            return id[f];
		}
		public static String pw(int f) {
			System.out.print("비밀번호: ");
	        pass[f] = sc.next();
            return pass[f];
		}
		public static double bal(int f) {
			do {
	            System.out.print("잔액: ");
	            balance[f] = sc.nextInt();
	         } while (balance[f] < 0);
            return balance[f];
		}
		//
		//		   → idx != -1이면 기능 실행
		//		      - 조회
		//		      - 입금
		//		      - 출금
		//		      - 삭제
		//		      - 비번변경
		public static void upmu(int i) {
			if(i!=-1) {
				switch( menu ){
	            case 2 : System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.2f\n" ,id[find] ,pass[find] , balance[find]);     break;
	            case 3 : System.out.print("입금할 금액 > ");  tempbalance = sc.nextInt();       
	                     System.out.println("입금완료! 현재잔액 : " + (balance[find] += tempbalance));
	            
	            break;
	            case 4 :  
	               System.out.print("출금할 금액 > ");   tempbalance = sc.nextInt();  
	               System.out.println( tempbalance > balance[find] ?"잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (balance[find] -= tempbalance));
	            break;
	            case 5 : System.out.print("계좌삭제 (Y/N) > "); char again = sc.next().charAt(0);
	               if(again == 'Y' || again == 'y') { id[find] = null; pass[find] = null; balance[find] = -1;
	               									System.out.println("계좌가 삭제되었습니다.");}
	            break;
				}
			}
		}
	   public static void main(String[] args) {
		   	int menu = -1;
			int find = -1;
		   
		   //for(   ;menu!=9;   ) {
		      while(menu!=9) {
		    	  System.out.println(Arrays.toString(id));
		          System.out.println(Arrays.toString(pass));
		          System.out.println(Arrays.toString(balance));
//		            System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
		          menu  = menu();
		         
		         if (menu == 9) {
		            System.out.println("프로그램을 종료합니다.");
		         } else if (menu == 1) {
		            find = -1;

		            find = fd();
		            // 꽉찼을경우 
		            if(find == -1) { System.out.println("가입불가!"); continue;  } 

		          //기능2 - 빈칸이 있다면 입력받기
		            id(find);
		            pw(find);
		            bal(find);
		            
		         }else if (menu >= 2 && menu <= 5) { 
		            
		            
		            fd();
		   
		            if(  find==-1 ) { 
		               System.out.println("정보확인해주세요.");  continue; 
		            }
		            
		            upmu(find);
		            
		         }
		      }// end while       
	   }

}