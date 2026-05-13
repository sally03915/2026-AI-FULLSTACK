package com.the703.basic018_ex;


class Candy {  
    String name;  
    public void sell() { System.out.println(name + "가 1개 팔렸습니다."); }
}
class MentolSeller extends Candy implements Runnable {
	// - run() 메서드에서 1초마다 sell()을 호출하여 총 5번 판매합니다.
	@Override public void run() { 
		for(int i=0; i<5; i++) {
			sell();
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		} 
	} 
}

public class ThreadEx002 {  
    public static void main(String[] args) {  
        MentolSeller seller = new MentolSeller();   seller.name = "멘톨캔디";  
        Thread t = new Thread(seller);  t.start();  

        for (int i = 0; i < 5; i++) {  
            System.out.println("  손님 기다리는 중.....");  
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }  
        }  
    }  
}
/*
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....


패키지명: com.the703.basic018_ex  
클래스명: ThreadEx002  

문제 설명:  
Runnable을 활용하여 멘톨캔디를 1초마다 1개씩 판매하는 스레드를 구현하세요.  
Candy 클래스를 기반으로 MentolSeller 클래스를 만들고, Thread를 직접 상속하지 않고 Runnable 인터페이스를 통해 멀티스레드를 구성합니다.

■ 요구사항:
1. Candy 클래스를 정의하세요. 
   - String name 필드를 가집니다.
   - sell() 메서드는 name + "가 1개 팔렸습니다."를 출력합니다.

2. MentolSeller 클래스를 정의하세요. 
   - Candy 클래스를 상속받습니다.
   - Runnable 인터페이스를 구현합니다.
   - run() 메서드에서 1초마다 sell()을 호출하여 총 5번 판매합니다.

3. ThreadEx002 실행 클래스를 작성하세요.

   - MentolSeller 객체를 생성하고 name을 "멘톨캔디"로 설정합니다.
   - Thread 객체에 MentolSeller를 전달하여 start()로 실행합니다.
   - 동시에 main()에서는 1초마다 "손님 기다리는 중....."을 출력합니다 (총 5번).

■ 힌트:
- Thread.sleep(1000)은 1초 대기입니다.
- Thread는 Runnable 구현체를 생성자에 전달받아 실행할 수 있습니다.
- MentolSeller는 Thread를 상속할 수 없으므로 반드시 Runnable을 구현해야 합니다.

■ 출력 예시:
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....  
멘톨캔디가 1개 팔렸습니다.  
  손님 기다리는 중.....

■ 예시 코드 참고:
class Candy {  
    String name;  
    public void sell() {  
        System.out.println(name + "가 1개 팔렸습니다.");  
    }  
}

class MentolSeller extends Candy implements Runnable {  
  
}

public class ThreadEx002 {  
    public static void main(String[] args) {  
        MentolSeller seller = new MentolSeller();  
        seller.name = "멘톨캔디";  
        Thread t = new Thread(seller);  
        t.start();  

        for (int i = 0; i < 5; i++) {  
            System.out.println("  손님 기다리는 중.....");  
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }  
        }  
    }  
}

*/