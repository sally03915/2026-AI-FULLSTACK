package com.the703.basic018;


class Candy {  
    String name;  
    public void sell() { System.out.println(name + "가 1개 팔렸습니다."); }
}

/*******  ver-1
class MentolSeller extends Candy implements Runnable {
	// - run() 메서드에서 1초마다 sell()을 호출하여 총 5번 판매합니다.
	@Override public void run() { 
		//### 스레드 중단요청2) 
		for(int i=0; i<100; i++) {
			sell();
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) { 
				System.out.println("판매 중 인터럽트(방해)발생");
				break;
			}
		} 
		//////////////////////////////////////////////////////////////
	} 
} ****/
class MentolSeller extends Candy implements Runnable {
	// - run() 메서드에서 1초마다 sell()을 호출하여 총 5번 판매합니다.
	@Override public void run() { 
		//### 스레드 중단요청2) 
		for(int i=0; i<1000000000; i++) {
			////1) 중단요청 확인
			if(  Thread.currentThread().isInterrupted() ) {  //####중단요청확인2)
				System.out.println("판매중단됨.");
				break;
			}
			sell();
		} 
		//////////////////////////////////////////////////////////////
	} 
} 
public class Thread004{  
    public static void main(String[] args) {
    	
        MentolSeller seller = new MentolSeller();   seller.name = "멘톨캔디";  
        Thread t = new Thread(seller);  t.start();  

        for (int i = 0; i < 5; i++) {  
            System.out.println("  손님 기다리는 중.....");  
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }  
        }
        System.out.println("......... 손님이 없어서 판매를 중단합니다."); 
        t.interrupt();   //### 스레드 중단요청1) 
    }  
}