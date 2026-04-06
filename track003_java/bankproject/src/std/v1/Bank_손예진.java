package std.v1;

import java.util.Scanner;

public class Bank_손예진 {

	public static void main(String[] args) {
		//wellcom! (주)syjbank
		//=====bank=====
		//아이디 id, 비번 pw, 잔액 balance 입금금액 im 출금금액 om 종료 
		//* 1.추가 /아이디 id, 비번 pw, 잔액 balance
		//2.조회 /아이디, 비번입력> 불일치-다시확인 >일치-계좌조회: 잔액
		//3.입금 /아이디, 비번 입금금액 입력>>입금완료(잔액
		//4.출금 /아이디, 비번 출금금액 입력>>출금완료(잔액
		//5.삭제 /아이디, 비번 삭제확인(y/n)
		//9.종료 >>종료기능입니다.
		//입력>>>
		
		int  menu=-1, balance=-1, inputm=-1, outputm=-1; 
		char deletid= '\u0000';
		//String id = " ", pw = " ", id2 = " ", pw2 = " ";
		int id=-1,pw=-1,id2=-1,pw2=-1;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n 🌟💰 welcome to bank 💰🌟\r\n");
		
		for( ; menu < 9;) {
			System.out.print("\n -- bank menu --\r\n"
					 + "\r\n"
					 + "1.➕계좌 추가\r\n" 
					 + "2.🔍계좌 조회\r\n" 
					 + "3.💵입금\r\n" 
					 + "4.💸 출금\r\n" 
					 + "5.🗑️삭제\r\n" 
					 + "9.종료\r\n"
					 + "\r\n"+"👉 번호를 선택하세요: ");
			menu = sc.nextInt();
			
			if (menu==1) { //1.추가 - 아이디 id, 비번 pw, 잔액 balance
				System.out.print("아이디: ");
				//id = sc.next();
				id=sc.nextInt();
				System.out.print("비밀번호: ");
				//pw = sc.next();
				pw=sc.nextInt();
				System.out.print("잔액: ");
				balance = sc.nextInt();
			} 
			
			else if (menu==2) {  //2.조회 - 아이디, 비번입력> 불일치-다시확인 >일치-계좌조회: 잔액
				//////////////////////////////////////////
				System.out.print("아이디: ");
				//id2 = sc.next();
				id2 = sc.nextInt();
				System.out.print("비밀번호: ");
				//pw2 = sc.next();
				pw2 = sc.nextInt();
				
				if( id == id2 && pw == pw2) {
					//////////////////////////////////////////
					System.out.println("잔액: "+ balance + "원");
				} else {
					System.out.println("다시 확인해보세요");
				}
			}
			
			else if(menu==3) {  //3.입금 - 아이디, 비번 입금금액 입력>>입금완료(잔액
				//////////////////////////////////////////
				System.out.print("아이디: ");
				//id2 = sc.next();
				id2 = sc.nextInt();
				System.out.print("비밀번호: ");
				//pw2 = sc.next();
				pw2 = sc.nextInt();
				if( id == id2 && pw == pw2) {
					//////////////////////////////////////////
					System.out.print("입금금액: ");
					inputm = sc.nextInt();
					balance = balance + inputm;
					System.out.println("잔액: "+ balance + "원");
				} else {
					System.out.println("다시 확인해보세요");
				}
			} 
			
			else if(menu==4) {  //4.출금 - 아이디, 비번 출금금액 입력>>출금완료(잔액
				//////////////////////////////////////////
				System.out.print("아이디: ");
				//id2 = sc.next();
				id2 = sc.nextInt();
				System.out.print("비밀번호: ");
				//pw2 = sc.next();
				pw2 = sc.nextInt();
				
				if( id == id2 && pw == pw2) {
					//////////////////////////////////////////
					System.out.print("출금금액: ");
					outputm = sc.nextInt();
					balance = balance - outputm;
					System.out.println("잔액: "+ balance + "원");
				} else {
					System.out.println("다시 확인해보세요");
				}
			} 
			
			else if(menu==5) {  //5.삭제 - 아이디, 비번 삭제확인(y/n)
				//////////////////////////////////////////
				System.out.print("아이디: ");
				//id2 = sc.next();
				id2 = sc.nextInt();
				System.out.print("비밀번호: ");
				//pw2 = sc.next();
				pw2 = sc.nextInt();
				
				if( id == id2 && pw == pw2 ) {
					//////////////////////////////////////////
					System.out.print("계좌를 삭제하시겠습니까?: ( y / n ) ");
					deletid = sc.next().charAt(0);
					if(deletid == 'y') {
						System.out.println("계좍가 삭제되었습니다.");
						id = 0;
						pw = 0;
					}else if(deletid == 'n') {
						System.out.println("계좌 삭제를 취소하셨습니다.");
					}
				} else {
					System.out.println("다시 확인해보세요");
				}
			} 
			
			else if(menu==9) {  //9.종료 >> 종료합니다.
				System.out.println("종료합니다.");
				break;
			}
		}

	}

}
//Q2~5 번까 지 반복되는 부분 줄이기~!
