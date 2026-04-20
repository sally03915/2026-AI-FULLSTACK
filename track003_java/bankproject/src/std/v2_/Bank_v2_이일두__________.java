package std.v2_;

import java.util.Scanner;

import java.util.Arrays;

public class Bank_v2_이일두__________ {

   public static void main(String[] args) {
        
         //변수                                   0   1    2
        ///////////////////////////////////////////////////////
         String[] id = new String[3];        //  one two three
         String[] pass = new String[3];      // 1111 2222 3333
         double[] balance = new double[3];   // 1100 2200 3300   
         int menu=-1;  
         Scanner scanner = new Scanner(System.in);
         //////////////////////////////////////////////////////////
         
         
         
         while( menu != 9 ) {
            System.out.println(Arrays.toString(id));
            System.out.println(Arrays.toString(balance));
            
            System.out.println(
             "🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" 
                   + "[1] ➕ 계좌 추가\n"
                   + "[2] 🔍 계좌 조회\n"
                   + "[3] 💵 입금하기\n"
                   + "[4] 💸 출금하기\n"
                   + "[5] 🗑️ 계좌 삭제\n"
                   + "[9] ※ 서비스 종료\n"
                   + "\n"
                   + "👉 번호를 선택하세요:");
        
                   menu = scanner.nextInt();
                   
                   
                   if(menu == 1) {
                      int j = -1;
                
                       for(int i = 0; i < id.length; i++) {
                           if(id[i] == null){ j = i;break;}
                       }//for
                       if(j == -1){System.out.println("가입불가");continue;}
                                            
                      
                      System.out.println("가입하실 ID와 PW를 입력하세요");
                      System.out.print("ID: ");  id[j] = scanner.next();
                      System.out.print("PW: ");  pass[j] = scanner.next();
                      System.out.print("금액: "); balance[j] = scanner.nextDouble();
                      System.out.println("가입되셨습니다. " + balance[j] + "원이 입급되었습니다!");
                      
                   } // if m1
                   
                   else if(menu >= 2 && menu <= 5) {
                	    double us = -1;
                	    String tid =""; 
                	    String tpass = "";
                	    
                	    System.out.println("조회하실 ID와 PW를 입력하세요");
                	    System.out.print("ID: "); tid = scanner.next();
                	    System.out.print("PW: "); tpass = scanner.next();
                	    
                	    int j;

                	    for(j = 0; j < id.length; j++) {   // <= → <

                	        if(id[j] != null && id[j].equals(tid) && pass[j].equals(tpass)) {  // .equals 사용

                	            switch(menu) {
                	                case 2 : 
                	                    System.out.println("잔액:"+ balance[j] + "원입니다"); 
                	                    break;

                	                case 3 : 
                	                    System.out.print("입금할 금액을 입력하세요"); 
                	                    us = scanner.nextDouble();
                	                    balance[j] = balance[j] + us;  
                	                    System.out.println("잔액:"+ balance[j] + "원입니다"); 
                	                    break;

                	                case 4 : 
                	                    System.out.print("출금할 금액을 입력하세요"); 
                	                    us = scanner.nextDouble();
                	                    balance[j] = balance[j] - us; 
                	                    System.out.println("잔액:"+ balance[j] + "원입니다"); 
                	                    break;

                	                case 5 : 
                	                    id[j] = null;
                	                    pass[j] = null;
                	                    balance[j] = 0;
                	                    System.out.println("계좌 삭제되었습니다"); 
                	                    break;
                	            }//switch
                	            break; // 찾으면 종료 if문 밖으로
                	        }//if
                	    }//for

                	    // 반복문 끝났는데 못찾았을 때만 출력
                	    if(j == id.length) { // j >= id.length 가능
                	        System.out.println("없는 정보이니, 다시 입력해주세요");
                	    }
                	}//else if
         }//while
         System.out.print("은행 서비스가 종료되었습니다");
   }//main
   
}//class
			             
			             
			             
			             
	      