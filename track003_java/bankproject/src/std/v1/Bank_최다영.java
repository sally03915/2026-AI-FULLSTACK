package std.v1;
import java.util.Scanner;


public class Bank_최다영 {  // 1. 클래스명은 대문자   - class bank
	public static void main(String[] args) {
		
		int num=0,age=0,money=0;
		char id=0, pw=0,answer;
		Scanner sc = new Scanner(System.in);

		                 
		 for(;;){
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
			System.out.print("[1] ➕ 계좌 추가"+"\n"+"[2] 🔍 계좌 조회" +"\n"+ "[3] 💵 입금하기" + "\n"+"[4] 💸 출금하기" +
				              "\n"+ "[5] 🗑️ 계좌 삭제   "+ "\n"+"[9] 🖤 종료"+ "\n"); 
			num = sc.nextInt();
					 if(num ==1 ) { 
					         System.out.println("아이디 입력"); id = sc.next().charAt(0);
					         System.out.println("비밀번호 입력"); pw = sc.next().charAt(0);
					         System.out.println("나이 입력"); age = sc.nextInt();
					         System.out.println("잔액 입력"); money = sc.nextInt();
					}else if (num == 2) { 
						////////////////////////////
						System.out.println("아이디 입력");
						id = sc.next().charAt(0);
						System.out.println("비밀번호 입력");
						pw = sc.next().charAt(0);
						{
							if (id == pw && age > 0) {
						////////////////////////////
								System.out.println("==계좌조회");
								System.out.println("아이디:" + id);
								System.out.println("비번:" + pw);
								System.out.println("나이:" + age);
								System.out.println("잔액:" + money);
							} else {
								System.out.println("다시 확인해주세요");
							}
						}
					} else if (num == 3) { 
						////////////////////////////
						System.out.println("아이디 입력");
						id = sc.next().charAt(0);
						System.out.println("비밀번호 입력");
						pw = sc.next().charAt(0);
						if (id == pw && age > 0) {
						////////////////////////////
							System.out.println("입금:");
							money += sc.nextInt();
						} else {
							System.out.println("다시 확인해주세요");
						}
					} else if (num == 4) { 
						////////////////////////////
						System.out.println("아이디 입력");
						id = sc.next().charAt(0);
						System.out.println("비밀번호 입력");
						pw = sc.next().charAt(0);
						if (id == pw && age > 0) {
						////////////////////////////	
							System.out.println("출금:");
							money -= sc.nextInt();
						} else {
							System.out.println("다시 확인해주세요");
						}
					} else if (num == 5) { 
						////////////////////////////
						System.out.println("아이디 입력");
						id = sc.next().charAt(0);
						System.out.println("비밀번호 입력");
						pw = sc.next().charAt(0);
						if (id == pw && age > 0) {
						////////////////////////////	
							System.out.println("계좌를 삭제하시겠습니까? (Y/N)");
							answer = sc.next().charAt(0);
							if (answer == 'Y') {
								id = 0;
								pw = 0;
								money = 0;
								age = 0;
							}
						} else {
							System.out.println("다시 확인해주세요");
						}
					} else if (num == 9) {
						System.out.println("종료합니다");
						break;
					}
				}
			}
}

//Q1.Bank_최다영  클래스명 대문자
//Q2.2~5 사이에 공통되는 부분 줄이기
 