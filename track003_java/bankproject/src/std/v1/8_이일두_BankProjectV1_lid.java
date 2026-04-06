package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1 {

	public static void main(String[] args) {
       
		//변수
		
		Scanner scanner = new Scanner(System.in);
		int no = -1, id = -1, pass = -1, balance = -1, tid = -1, tpass = -1;
		//tid = -1, tpass = -1; // 위에서 고정된 아이디와 비번과 비교하여 일치하는지 알아볼 정보
		
				
		for(;;){
		    System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n"
			                 + "[1] ➕ 계좌 추가\n" // 가입개념, 또 1번하면 다시 ID와 PASS를 새로 생성하는 개념
			                 + "[2] 🔍 계좌 조회\n"
			                 + "[3] 💵 입금하기\n"
			                 + "[4] 💸 출금하기\n"
			                 + "[5] 🗑️ 계좌삭제\n");
			
			
		    
			// 기본 번호 입력	
			
		    System.out.print("👉 번호를 선택하세요:");
			no = scanner.nextInt();		
			
			System.out.println();
			   
			// 입력 + 처리 + 출력
			// 계좌 추가 (가입)
	            if(no == 1) {
	            System.out.println("가입기능입니다");
	            
	            //입력 id = -1, pass = -1, balance = -1; 위에
	            System.out.print("ID: ");
	       	    id = scanner.nextInt();
	     			 
	     	    System.out.print("PASS: ");
	     	    pass = scanner.nextInt();
	     			 
	     	    System.out.print("balace: ");
	     	    balance = scanner.nextInt();
	     			 
	            // [1]ID   입력 > 111
	            // [2]PASS 입력 > 11
	            // [3]balance > 16000 : 잔액    아이디 비번 잔액을 넣고 시작하는 단순 시스템
	        }
	        
	        
	                
            
	        // 계좌 조회 ( 임시공간에 아이디와 비번입력받기)
	        else if(no == 2) {
	            // int tid = -1, tpass = -1; // 위에서 고정된 아이디와 비번과 비교하여 일치하는지 알아볼 정보
	        	// 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력
	        	// 아니라면 비밀번호를 확인해주세요.
	        	
	        	System.out.println("조회기능입니다");
	        	
	            System.out.print("ID: ");
	     		tid = scanner.nextInt();
	     			 
	     		System.out.print("PASS: ");
	     		tpass = scanner.nextInt();
	     		
	     		// [1]ID   입력 > 111
	     		// [2]PASS 입력 > 11  
	     			
	     		System.out.println();
	     	    
	     		// 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력 	
	     		if( tid == id && tpass == pass ) {System.out.println("조회 성공!\n" + "잔액: " + balance);}
	     		else                             {System.out.println("아이디 또는 비일번호를 다시 입력해주세요");}
	     			 
              	// 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력
	     		// 아니라면 비밀번호를 확인해주세요.
	                	
	        }
	       	
	        // 입금
	        else if(no == 3) {int dep = -1; 
	        	    
	            System.out.println("입금기능입니다");
	        	System.out.print("ID: ");
	     		tid = scanner.nextInt();
	     			 
	     		System.out.print("PASS: ");
	     		tpass = scanner.nextInt();
	     		
	     		// [1]ID   입력 > 111
	     		// [2]PASS 입력 > 11  
	     			
	     		System.out.println();
	     	    
	     		// 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력 	
	     		if( tid == id && tpass == pass ) {
	     			System.out.println("로그인 성공!\n" + "잔액: " + balance);
	     			System.out.println("입금할 금액을 입력해주세요" );
	     			System.out.println("금액: ");
	     			dep = scanner.nextInt();
	     			balance += dep;
	     			System.out.println("잔액: " + balance);
	     		}
	     		else                             {System.out.println("아이디 또는 비일번호를 다시 입력해주세요");}
	     			 
              	// 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력
	     		// 아니라면 비밀번호를 확인해주세요.
	                	
	        }
			
	        // 출금    
	        else if(no == 4) {int wit = -1;
    	    
            System.out.println("출금기능입니다");
        	System.out.print("ID: ");
     		tid = scanner.nextInt();
     			 
     		System.out.print("PASS: ");
     		tpass = scanner.nextInt();
     		
     		// [1]ID   입력 > 111
     		// [2]PASS 입력 > 11  
     			
     		System.out.println();
     	    
     		// 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력 	
     		if( tid == id && tpass == pass ) {
     			System.out.println("로그인 성공!\n" + "잔액: " + balance);
     			System.out.println("출금할 금액을 입력해주세요" );
     			System.out.println("금액: ");
     			wit = scanner.nextInt();
     			balance -= wit;
     			System.out.println("잔액: " + balance);
     		}
     		else                             {System.out.println("아이디 또는 비일번호를 다시 입력해주세요");}
     			 
        }    
            // 계좌삭제
	        else if(no == 5) {
    	    
                System.out.println("계좌삭제기능입니다");
        	    System.out.print("ID: ");
     		    tid = scanner.nextInt();
     			 
     		    System.out.print("PASS: ");
     		    tpass = scanner.nextInt();
     		
     		    // [1]ID   입력 > 111
     		    // [2]PASS 입력 > 11  
     			
     		    System.out.println();
     	    
     		    // 11번째 줄에 있는 아이디와 임시아이디가 같고, 11번째 줄에 있는 비번과 임시 비번이 같으면 정보출력 	
     		    if( tid == id && tpass == pass ) {
     			    System.out.println("로그인 성공!\n");
     			    
     			    id = -1;
     		        pass = -1;
     		        balance = -1;
     			    System.out.println("계좌가 삭제되었습니다");
     		}
     		else                             {System.out.println("아이디 또는 비일번호를 다시 입력해주세요");}
     			 
        }  
	            
	           
	         // 종료
	        else if(no == 9) {System.out.println("종료합니다."); break;}
    	          
	            
	            
	        //     if(no == 1) {System.out.println("추가기능입니다.");}
	 	    //else if(no == 2) {System.out.println("조회기능입니다.");}
	 	    //else if(no == 3) {System.out.println("입금기능입니다.");}
	 	    //else if(no == 4) {System.out.println("출금기능입니다.");}
	 	    //else if(no == 5) {System.out.println("삭제기능입니다.");}
	 	    //else if(no == 9) {System.out.println("종료합니다."); break;}     
			
			System.out.println();
				
		}
		
	}

}

/*
Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
1을 입력하면 추가기능입니다. 출력구문까지만
2를 입력하면 조회기능입니다. 출력구문까지만
3을 입력하면 입금기능입니다. 출력구문까지만
4를 입력하면 출금기능입니다. 출력구문까지만
5를 입력하면 삭제기능입니다. 출력구문까지만
9를 입력하면 종료합니다.    출력구문까지만

Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
■ 힌트
for(;;) { 
System.out.println("숫자1을 입력하세요.");
int a = scanner.nextInt();
if(a == 1) { break;}
}

🌟💰 WELCOME TO BANK SYSTEM 💰🌟

[1] ➕ 계좌 추가
[2] 🔍 계좌 조회
[3] 💵 입금하기
[4] 💸 출금하기
[5] 🗑️ 계좌 삭제  

👉 번호를 선택하세요:



*/