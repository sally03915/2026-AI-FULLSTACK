package com.the703.basic018;

import java.awt.Toolkit;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 - 자원 + Thread(실제작업수행) 
//3. 작업수행클래스 - Thread(상속 - run -start) ,  Runnable
class PigSound  extends Thread{//#1	
	@Override public void run() { //#2 해야할일
		try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); } 
		for(int i=0; i<5; i++) {
			System.out.print("꿀");
			try { Thread.sleep(1000); }  //1초쉬기
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
} 
class PingCnt  extends Thread{ 
	@Override public void run() {
		try { Thread.sleep(15); } catch (InterruptedException e) { e.printStackTrace(); } 
		for(int i=0; i<5; i++) {
			System.out.print( (i+1) + "마리 ");
			try { Thread.sleep(1000); }  //1초쉬기
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	} 
}

class PigTest  extends Thread{
	@Override public void run() {
		try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); } 
		Toolkit toolkit = Toolkit.getDefaultToolkit();  //import java.awt.Toolkit;
		
		for(int i=0; i<5; i++) {
			toolkit.beep();  // 비프음
			try { Thread.sleep(1000); }  //1초쉬기
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	} 
}

public class Thread002 { 
	public static void main(String[] args) {
		Thread sound = new PigSound();    sound.start();
		Thread cnt   = new PingCnt();       cnt.start();
		Thread beep  = new PigTest();      beep.start();
		
		for(int i=0; i<5; i++) {
			System.out.print("˙Ꙫ˙");
			try { Thread.sleep(1000); }  //1초쉬기
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	} 
}



