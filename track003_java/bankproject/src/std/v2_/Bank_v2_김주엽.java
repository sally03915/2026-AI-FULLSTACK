package std.v2_;

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v2_김주엽 {

	public static void main(String[] args) {
		
		String [] id = new String[3];
		String [] pass = new String[3];
		double [] balance = new double[3];
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		int id_count = 0;
		int count = 0;
		boolean login = false;
		String id_ck = "";
		String pass_ck = "";
		char ch = '\u0000';
		
		
		
		while(true) {
			
			System.out.println();
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(pass));
			System.out.println(Arrays.toString(balance));
			menu = Menu_김주엽.mainMenu();
			
			if(menu == 1) {
				id_count = -1;
				for(int i=0; i<balance.length; i++) {
					if(balance[i] == 0 ) { id_count = i; break;}
				}
				if(id_count == -1) {System.out.println("생성불가"); continue;}
				
				System.out.println("아이디를 입력해주세요 > ");
				id[id_count] = sc.next();
				
				System.out.println("비밀번호를 입력해주세요 > ");
				pass[id_count] = sc.next();
				
				System.out.println("잔액 입력 > ");
				balance[id_count] = sc.nextInt();
				
				
			}
			else if (login == false && menu != 9 ) {
				
				System.out.println("아이디를 입력해주세요 > ");
				id_ck = sc.next();
				
				System.out.println("비밀번호를 입력해주세요 > ");
				pass_ck = sc.next();
				
				for(int i=0; i<id.length; i++) {
					if(id[i] != null && pass[i] != null && id[i].equals(id_ck) && pass[i].equals(pass_ck)) {
						System.out.println(id[i]+"님 로그인 확인");
						count = i;
						login = true;
						break;
					}
					else if(i>=2) {
						System.out.println("아이디 혹은 비밀번호를 확인해주세요");
					}
				}
			}
			else if (menu == 2) { 
				System.out.println("\n아이디	 : " + id[count]
							      +"\n비밀번호	 : " + pass[count]
								  +"\n잔액 	 : " + balance[count] + " 원 \n");
			}
			else if (menu == 3) { 
				
				System.out.println("\n입금하실 금액 > ");
				menu = sc.nextInt();
				
				balance[count] += menu;
				
				System.out.println(balance[count] + " 원 입금\n"
								  +"==========================\n"
					              +"현재 잔액 : " + balance[count] + " 원\n" );
			}
			else if (menu == 4) {
				
				System.out.println("\n출금하실 금액 > ");
				menu = sc.nextInt();
			
				if(menu<balance[count]) {
					balance[count] -= menu;
				
				System.out.println(menu + " 원 출금\n"
								  +"==========================\n"
					              +"현재 잔액 : " + balance[count] + " 원\n" );}
				
				else {System.out.println("잔액이 부족합니다.");}
			}
			else if (menu == 5) {
				
				System.out.println("계좌를 삭제하시겠습니까?\n" + " Y/N ");
				ch = sc.next().charAt(0);
				
				if(ch == 'Y' || ch == 'y') {
					id[count] = null;
					pass[count] = null;
					balance[count] = 0;
					count = -1;
					login = false;
					System.out.println("계좌를 삭제합니다.");
				}
				else if (ch == 'N' || ch == 'n') {
					System.out.println("취소 합니다.");
				}
				else {System.out.println("정확한 값을 적어주세요.\n");}
			}
			else if (menu == 6) { 
				
				System.out.println("로그아웃 하시겠습니까?\n" + " Y/N ");
				ch = sc.next().charAt(0);
				
				if(ch == 'Y' || ch == 'y') {
					login = false;
					System.out.println("로그아웃 완료");
				}
				else if (ch == 'N' || ch == 'n') {
					System.out.println("취소 합니다.");
				}
				else {System.out.println("정확한 값을 적어주세요.\n");}
			}
			else if(menu == 9) {
				System.out.println("종료");
				break;
				} // 종료 문단 끝
			
			else { System.out.println("정상적인 값을 입력하세요."); }
		}

	}

}
