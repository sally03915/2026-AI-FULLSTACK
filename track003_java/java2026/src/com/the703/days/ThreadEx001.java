package com.the703.days;

import javax.swing.JOptionPane;

//■ Todo2 카운트기능  - 실행클래스1
class Count extends Thread{//#1. 수행클래스 Thread 상속
	@Override public void run() {//#2. run 구현 - 10부터 거꾸로 카운트
		 for(int i=10; i>0; i--) {
			 System.out.println(i);
			 try { Thread.sleep(1000); } 
			 catch (InterruptedException e) { e.printStackTrace(); }
		 }
	}   
}
//■ Todo1 질문정답인지 확인기능  - 실행클래스2
class Question  extends Thread{ //#1. 수행클래스 Thread 상속
	@Override public void run() { //#2. 해야할일
		String answer=JOptionPane.showInputDialog("사과 알파벳을 입력하세요.");
		System.out.println( answer.toLowerCase().equals("apple")? "정답" : "오답"  );
	}
}
public class ThreadEx001 {
	public static void main(String[] args) {  // 실행클래스0
		//#3. start 로 수행클래스 시작
		Thread question = new Question();  question.start();
		Thread count    = new Count();     count.start();
	}
}

/**
연습문제1)  Thread
패키지명 : com.company.java016_ex
클래스명 : ThreadEx001
1.  QuestionCount  - 10부터 1까지 
      카운트 1초에 10 ,
                2초에 9, 
                3초에  8.....

2. 사과알파벳을 입력하세요.
   사과를 입력을받으면 정답입니다 / 정답이 아닙니다.
*/