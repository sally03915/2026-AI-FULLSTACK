package com.the703.basic018_ex;

import javax.swing.JOptionPane;

class  QuestionCount  extends Thread{ 
	@Override public void run() { 
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	} 
}

public class ThreadEx001 {
	public static void main(String[] args) { 
		Thread cnt = new  QuestionCount();    cnt.start();
		
		String answer= JOptionPane.showInputDialog("사과 알파벳을 입력하세요.");
		System.out.println(  answer.toLowerCase().equals("apple") ?  "정답":"오답"  );
		//                          다 소문자로      apple 맞아?
	}

}
/**
연습문제1)  Thread
패키지명 : com.the703.basic018_ex
클래스명 : ThreadEx001
1.  QuestionCount  - 10부터 1까지 (콘솔창)
      카운트 1초에 10 ,
           2초에 9, 
           3초에  8.....

2. 사과알파벳을 입력하세요.  JOptionPane.showInputDialog("사과 알파벳을 입력하세요.");
   사과를 입력을받으면 정답입니다 / 정답이 아닙니다. (콘솔창)
*/