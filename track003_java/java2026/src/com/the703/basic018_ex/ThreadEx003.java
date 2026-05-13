package com.the703.basic018_ex;
import java.util.Scanner;

import javax.swing.JOptionPane;
/*
/////////    10~1까지 카운트
class Count1 extends Thread {
    @Override  public void run() {
    	for(int i=10; i>0; i--) {
    		System.out.println(i);
    		try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
    	} 
    }
}
*/
class Count1 extends Thread {
    @Override  public void run() {
    	for(int i=10; i>0; i--) {
    		System.out.println("...." +  Thread.currentThread().isInterrupted());
    		//중단요청확인
    		if(  Thread.currentThread().isInterrupted() ) {  
    			break;  
    		}
    		
    		System.out.println(i);
    		try { Thread.sleep(1000); } 
    		catch (InterruptedException e) { 
        		System.out.println("....>>" +  Thread.currentThread().isInterrupted());  //상태변경
        		Thread.currentThread().interrupt();  //true (수동)
    		}
    	} 
    }
}
public class ThreadEx003 {
	public static void main(String[] args) { 
		String info = "계속카운트 합니다.";
		Thread count = new Count1();  count.start(); 
        
		String answer= JOptionPane.showInputDialog("COUNT STOP?  y/n");
		if(answer.toLowerCase().equals("y")) {  count.interrupt();  info = "count를 멈춥니다.";  }
      
		System.out.println(info);
        System.out.println("> main end...."); 
	}
}
/*
10
count stop?  y/n
9
8
y
count를 멈춥니다.
> main end....


패키지명: com.the703.basic018_ex  
클래스명: ThreadEx003
■문제명: Thread.interrupt()를 이용한 카운트 중단 스레드 구현
Thread를 상속받은 Count 클래스를 만들고, 10부터 1까지 1초 간격으로 숫자를 출력하는 스레드를 구현하세요.  
main()에서는 사용자 입력을 받아 "y"를 입력하면 스레드를 중단합니다.  
이때 interrupt() 메서드를 사용하여 스레드를 안전하게 종료하도록 구현하세요.

■요구사항
1. Count 클래스를 정의하세요.
   - Thread를 상속받습니다.
   - run() 메서드에서 for 반복문을 통해 10부터 1까지 1초 간격으로 출력합니다.
   - Thread.sleep(1000)을 사용하며, InterruptedException이 발생하면 break로 반복을 종료합니다.

2. ThreadEx003 실행 클래스를 작성하세요.
   - Count 객체를 생성하고 start()로 실행합니다.
   - JOptionPane.showInputDialog 를 통해 사용자 입력을 받습니다.
   - 사용자가 "y"를 입력하면 count.interrupt()를 호출하여 스레드를 중단합니다.
   - "main end...."를 출력하며 프로그램을 종료합니다.

■ 힌트
- Thread.sleep() 중 interrupt()가 호출되면 InterruptedException이 발생합니다.
- catch 블록에서 break를 사용하면 반복문을 빠져나와 스레드를 종료할 수 있습니다.
- Scanner는 java.util.Scanner를 import해야 합니다.

■ 출력 예시
10
count stop?  y/n
9
8
y
count를 멈춥니다.
> main end....

※ "y"를 입력한 시점 이후부터는 숫자 출력이 멈춥니다.

■ 예시 코드 참고

package com.company.java017_network_ex;

import java.util.Scanner;

class Count extends Thread {
    @Override  public void run() {
   #####1. ... 10~1까지 카운트
   #####2. 오류시 break
    }
}

public class ThreadEx003 {
    public static void main(String[] args) {
        Thread count = new Count();
        count.start();

        ##### 3. 입력받기

        System.out.println("> main end....");
    }
}


*/