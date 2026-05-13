package com.the703.basic018;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 구성 - 자원(데이터, 메모리) + Thread(실제 작업수행) 
//ctrl + alt + del
public class Thread001 {
	public static void main(String[] args) {
		System.out.println("001. Thread");
		//1. 코어(일꾼수)
		int core=Runtime.getRuntime().availableProcessors();
		System.out.println("1. 일꾼수 : " + core);
		
		//2.   ˙Ꙫ˙ ˙Ꙫ˙ ˙Ꙫ˙ ˙Ꙫ˙ ˙Ꙫ˙ 
		for(int i=0; i<5; i++) {
			System.out.print("˙Ꙫ˙");
		}
		//3.     꿀  꿀   꿀   꿀   꿀
		for(int i=0; i<5; i++) {
			System.out.print("꿀");
		}
	}
} 
/*  
1 Thread

1. 프로세스    : 실행 중인 하나의 프로그램
2. 멀티프로세스 : 동시에 여러 프로세스 실행 
3. 구성
  - 자원(Resource) + Thread(자원으로 실제 작업 수행)
  - 모든 프로세스는 최소한 하나의 스레드(main)
  - 같은 프로세스 내의 스레드들은 서로 자원을 공유

*/





