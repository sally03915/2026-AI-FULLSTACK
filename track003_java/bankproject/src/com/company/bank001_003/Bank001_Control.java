package com.company.bank001_003; 
import java.util.Scanner;

public class Bank001_Control {
	public static void main(String[] args) {
		//변수
		int num = -1; String id = "", pass="";  double balance=0;
		Scanner scanner = new Scanner(System.in);
		
		//입력+처리+ 출력
	    for(;;){  
		    //■기능 1. 메뉴판
	    	System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" + 
	    		"\n[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기" + "\n[5] 🗑️ 계좌 삭제  "
	    		+"\n\n👉 번호를 선택하세요:"
	    	);  
	    	num= scanner.nextInt();
		    //■기능 2. 
		 	     if(num==9){ System.out.println("종료합니다.");  break;   }
		    else if(num==1){ 
		    	System.out.print("[1]ID   입력 > "); id=scanner.next();
		    	System.out.print("[2]PASS 입력 > "); pass=scanner.next();
		    	System.out.print("[3]금액  입력 > "); balance=scanner.nextDouble();	 
		    }else if(num==2 || num==3|| num==4|| num==5){ 
				 //	■1. 사용자 인증
		    	System.out.print("[1]ID   입력 > "); String tempId=scanner.next();
		    	System.out.print("[2]PASS 입력 > "); String tempPass=scanner.next();
		    	if( !(id.equals(tempId)  && pass.equals(tempPass) )) {
		    		System.out.println("아이디와 비밀번호를 확인해주세요!");
		    		continue; // 아래꺼 진행하지마!
		    	}
				//2. 2,3,4,5 각각에 해당하는 처리
		    	switch(num){
		    		case 2 : 
		    			System.out.println("\nID >"+id + "\nPASS > "+ pass + "\n잔액 > "+ balance); 
		    		break;
		    		case 3 : 
		    			System.out.print("입금할 금액 > ");  double input = scanner.nextDouble();
		    			balance +=input;  
		    			System.out.println("입금을 완료했습니다.");
		    		break;
		    		case 4 : 
		    			System.out.print("출금할 금액 > ");  double output = scanner.nextDouble();
		    			if(output>balance) { System.out.println("잔액이 모자랍니다.");  continue; }
		    			balance -=output;  
		    			System.out.println("출금을 완료했습니다."); 
		    		break;
		    		case 5 : 
		    			System.out.println("삭제하시겠습니까?"); String answer = scanner.next();  
		    			if(!answer.toLowerCase().equals("y")) {
		    				System.out.println("삭제를 취소했습니다."); continue;
		    			}
		    			id=pass=""; balance=0;
		    			System.out.println("삭제를 완료했습니다.");
		    		break;
		    	}
			} // end else if
		     
		}// end for 
	}// end main
}//end class

/*
 for(;;){ 무한반복
    ■기능 1. 메뉴판
    ■기능 2. 
 	     if(9){ 빠져나오기   }
    else if(1){ 사용자에게 추가}
    else if(2,3,4,5){ 
    	■1. 사용자 인증
    	 2. 2,3,4,5 각각에 해당하는 처리
	    	switch(){
	    		case 2 : 정보출력 break;
	    		case 3 : 입금 break;
	    		case 4 : 출금 break;
	    		case 5 : 삭제 break;
	    	}
    } // end else if
 }// end for
 
 */






/*  하루에 하나씩 힌트나가요~~~!
	천천히 정리하면서 익히면서 도전이요~~!  이번주~ 다음해서 숙제~!

Step1. 무한반복으로 만드는 메뉴만들기	
	for(;;){ //1-1 무한반복
		//1-2 빠져나올조건 9
		//1-3 입력받은번호가   if   or  switch
		1을 입력하면 추가기능입니다. 출력구문까지만
		2를 입력하면 조회기능입니다. 출력구문까지만
		3을 입력하면 입금기능입니다. 출력구문까지만
		4를 입력하면 출금기능입니다. 출력구문까지만
		5를 입력하면 삭제기능입니다. 출력구문까지만
		9를 입력하면 종료합니다.    출력구문까지만
	}
	
	■ 힌트
	for(;;) { 
		System.out.println("숫자1을 입력하세요.");
		int a = scanner.nextInt();
		if(a == 1) { break;}
	}
	
Step 2 추가
					//아이디입력  > _입력받기
					//비밀번호입력 > _입력받기
					//잔액입력    > _입력받기			
Step 3 조회
					System.out.println("2.조회기능입니다."); 
					//변수
					String tempid, temppass;
					//입력  2-1. 사용자에게 임시아이디와 임시비밀번호 입력받기
					System.out.print("아이디입력  >");      tempid=scanner.next();
					System.out.print("비밀번호입력  >");   temppass=scanner.next();
					//처리+출력
					//     2-2. if( 아이디와 임시아이디가 같아야하고 비번과 임시비밀번호가 같다면 ){ 사용자정보출력 }
					//          else {다르면 정보를 확인해주세요.}
*/