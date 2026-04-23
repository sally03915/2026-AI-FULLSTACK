package std.v3;

import java.util.Arrays;
import java.util.Scanner;

class Steel {

	// 변수 0 1 2
	 String[] id = new String[3]; // one two three   - 인스턴스변수, heap, 각 this
	 String[] pass = new String[3]; // 1111 2222 3333
	 double[] balance = new double[3];// 1100 2200 3300
	
	 Scanner sc = new Scanner(System.in);
	 char deletid = '\u0000';
	 String id2 = " ";
	 String pw2 = " ";
	 int tempbalance = -1;
	 
	 
	//		   1. 메뉴 선택
	public  int menu() {
		System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
	               + "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
	               + "👉 번호를 선택하세요:");
	         int menu = sc.nextInt();
	         return menu;
	}
	//		   2. 기능 
	// 유저 빈칸찾기 기능, 3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
	public  int fd(int m) {
		int find = -1;
        for (int i = 0; i < id.length; i++) {
        	if(m==1) {
        		if (id[i] == null)  
        			return find = i;  
        	}
        	else if(m >= 2 && m <= 6) {
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
	public  String id(int f) {
		System.out.print("아이디: ");
        id[f] = sc.next();
        return id[f];
	}
	public  String pw(int f) {
		System.out.print("비밀번호: ");
        pass[f] = sc.next();
        return pass[f];
	}
	public  double bal(int f) {
		do {
            System.out.print("잔액: ");
            balance[f] = sc.nextInt();
         } while (balance[f] < 0);
        return balance[f];
	} 
	//입금 
}
public class Bank_v3_손예진2 {
	   public static void main(String[] args) {
		   	int menu = -1;
			int find = -1;
			Steel s = new Steel();  // static을 빼고 받아와서 사용
			 
		   //for(   ;menu!=9;   ) {
		      while(menu!=9) {
		    	  System.out.println(Arrays.toString(s.id));
		          System.out.println(Arrays.toString(s.pass));
		          System.out.println(Arrays.toString(s.balance));
//		            System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
		          menu  = s.menu();
		         
		         if (menu == 9) {
		            System.out.println("프로그램을 종료합니다.");
		         } else if (menu == 1) {

		            find = s.fd(menu);
		            // 꽉찼을경우 
		            if(find == -1) { System.out.println("가입불가!"); continue;  } 

		          //기능2 - 빈칸이 있다면 입력받기
		            s.id(find);
		            s.pw(find);
		            s.bal(find);
		            
		         }else if (menu >= 2 && menu <= 5) { 
		            
		            
		        	 find = s.fd(menu);
		   
		            if(  find==-1 ) { 
		               System.out.println("정보확인해주세요.");  continue; 
		            }
		            
		            Scanner sc = new Scanner(System.in);
					switch( menu ){
		            case 2 : System.out.printf("ID : %s\nPASS: %s\nBALANCE: %.2f\n" ,s.id[find] ,s.pass[find] , s.balance[find]);     break;
		            case 3 : System.out.print("입금할 금액 > ");  s.tempbalance = sc.nextInt();       
		                     System.out.println("입금완료! 현재잔액 : " + (s.balance[find] += s.tempbalance));
		            
		            break;
		            case 4 :  
		               System.out.print("출금할 금액 > ");   s.tempbalance = sc.nextInt();  
		               System.out.println( s.tempbalance > s.balance[find] ?"잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (s.balance[find] -= s.tempbalance));
		            break;
		            case 5 : System.out.print("계좌삭제 (Y/N) > "); char again = sc.next().charAt(0);
		               if(again == 'Y' || again == 'y') { s.id[find] = null; s.pass[find] = null; s.balance[find] = -1;
		               									System.out.println("계좌가 삭제되었습니다.");}
		            break;
					}
		            
		         }
		      }// end while       
	   }

}