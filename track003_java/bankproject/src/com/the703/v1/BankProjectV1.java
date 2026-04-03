package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1 {
	public static void main(String[] args) {
		// 변수
		int num = -1;
		int id  = -1, pass=-1 , balance=-1;
		Scanner scanner = new Scanner(System.in);
		// 입력
		for (;;) {
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n" + "[1] ➕ 계좌 추가\n" + "[2] 🔍 계좌 조회\n"
					+ "[3] 💵 입금하기\n" + "[4] 💸 출금하기\n" + "[5] 🗑️ 계좌 삭제\n" + "👉 번호를 선택하세요:");
			num = scanner.nextInt();

			// 처리 + 출력
			if (num == 1) {
				System.out.println("추가기능입니다."); 
				//입력    id  = -1, pass=-1 , balance;
				//				[1]ID   입력 > std111
				//				[2]PASS 입력 > 11
				//				[3]금액  입력 > 1b   
			} else if (num == 2) {
				System.out.println("조회기능입니다.");
				// 변수 
				int tid=-1, tpass=-1;
				// 입력 ( 임시공간에 아이디와 비번입력받기) 
				//				[1]ID   입력 > std111
				//				[2]PASS 입력 > 11
				// 처리 +  출력 
				//   9번째 줄에 있는 아이디와 임시아이다가 같고, 9번째 줄에 있는 비번과 임시 비번이 같으면 정보출력
				//   아니라면  비밀번호를 확인해주세요!
			} else if (num == 3) {
				System.out.println("입금기능입니다.");
			} else if (num == 4) {
				System.out.println("출금기능입니다.");
			} else if (num == 5) {
				System.out.println("삭제기능입니다.");
			} else if (num == 9) {
				System.out.println("종료기능입니다.");
				break;
			}
		}
	}
}
/*
 * Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시 1을 입력하면 추가기능입니다. 출력구문까지만 2를 입력하면 조회기능입니다. 출력구문까지만
 * 3을 입력하면 입금기능입니다. 출력구문까지만 4를 입력하면 출금기능입니다. 출력구문까지만 5를 입력하면 삭제기능입니다. 출력구문까지만 9를
 * 입력하면 종료합니다. 출력구문까지만
 * 
 * 
 * 🌟💰 WELCOME TO BANK SYSTEM 💰🌟
 * 
 * [1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제
 * 
 * 👉 번호를 선택하세요:1 1. 추가
 * 
 * 
 * 🌟💰 WELCOME TO BANK SYSTEM 💰🌟
 * 
 * [1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제
 * 
 * 👉 번호를 선택하세요:2 2. 조회
 * 
 * 
 * 
 * Q2. 무한반복으로 메뉴나오게, 9 나오면 종료 ■ 힌트 for(;;) { System.out.println("숫자1을 입력하세요.");
 * int a = scanner.nextInt(); if(a == 1) { break;} } //////////////////////
 * 
 * Q3. 추가 아이디입력 > _입력받기 비밀번호입력 > _입력받기 잔액입력 > _입력받기
 * 
 * Q4. 조회 System.out.println("2.조회기능입니다."); //변수 //입력 2-1. 사용자에게 임시아이디와 임시비밀번호
 * 입력받기 //처리+출력 // 2-2. if( 아이디와 임시아이디가 같아야하고 비번과 임시비밀번호가 같다면 ){ 사용자정보출력 } //
 * else {다르면 정보를 확인해주세요.}
 */