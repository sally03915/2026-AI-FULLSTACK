package com.the703.v1;

import java.util.Scanner;

public class BankprojectV1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int menu = -1;
		int id = -1,pass=-1,balance=-1;
		int tid=-1,tpass=-1,tbalance=-1;
		for (;;) {
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");

			System.out.println("[1] ➕ 계좌 추가");
			System.out.println("[2] 🔍 계좌 조회");
			System.out.println("[3] 💵 입금하기");
			System.out.println("[4] 💸 출금하기");
			System.out.println("[5] 🗑️ 계좌 삭제");
			System.out.println("9.종료");

			System.out.println("번호를 입력하세요");
			menu = scanner.nextInt();

			if (menu == 1) {
				System.out.println("1 추가기능입니다");
				System.out.println("ID를 입력하세요>");
				id=scanner.nextInt();
				System.out.println("pass를 입력하세요>");
				pass=scanner.nextInt();
				System.out.println("잔액:");
				balance=scanner.nextInt();
			} else if (menu == 2) {
				
				System.out.println("2 조회기능입니다");
				System.out.println("ID를 입력하세요>");
				tid=scanner.nextInt();
				System.out.println("pass를 입력하세요>");
				tpass=scanner.nextInt();
				
				if(id==tid && pass==tpass) {
					System.out.println("ID:" +tid);
					System.out.println("pass:"+tpass);
					System.out.println("잔액은:"+balance);
				}else {
					System.out.println("아이디를 다시 확인해주세요");
				}
			} else if (menu == 3) {
				System.out.println("3 입금기능입니다");
				if(id==tid && pass==tpass) {
					System.out.println("입금 할 잔액 입력: ");
					tbalance=scanner.nextInt();
					balance = balance + tbalance; 
					System.out.println("잔액은:"+balance);
					// 1. 입금잔액을 임시변수에 입력받기
					// 2. 입략받은 잔액을 balance 에 + 해주기
					
				}
			} else if (menu == 4) {
				System.out.println("4 출금기능입니다");
				System.out.println("ID를 입력하세요>");
				tid=scanner.nextInt();
				System.out.println("pass를 입력하세요>");
				tpass=scanner.nextInt();
				
				if(id==tid && pass==tpass) {
					System.out.println("출금할 금액 입력>");
					tbalance=scanner.nextInt();
					
					if(balance>=tbalance) {
						balance=balance-tbalance;
						System.out.println("출금 완료");
						System.out.println("잔액은:"+balance);
					}else {
						System.out.println("잔액 부족 >다시 입력해주세요");
					}
				}
				
			} else if (menu == 5) {
				System.out.println("5 삭제기능입니다");
				System.out.println("ID를 입력하세요>");
				tid=scanner.nextInt();
				System.out.println("pass를 입력하세요>");
				tpass=scanner.nextInt();
				if(id==tid && pass==tpass) {
					tid=-1;tpass=-1;balance=-1;id=-1;pass=-1;
					System.out.println("삭제완료>");
				}else {
					System.out.println("아이디 비번을 다시 확인해주세요");
				}
				
			} else if (menu == 9) {
				System.out.println("종료");
				break;
			}

		}
	}

}
