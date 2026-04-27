package com.the703.basic012_ex;
 
//Q1. 상속도 그리기
//Q2. 각 클래스에서 사용할 수 있는 멤버변수/멤버메서드
//Q3. 배열을 이용해 여러 로봇을 관리하는 구조를 설명하시오.

abstract class Robot {
	String name = "기본로봇";  
	public Robot() { super(); } 
	public abstract void work(); // { System.out.println("로봇일?"); }  
} // end class
class CleaningRobot extends Robot {
	 String name = "청소로봇";
	 @Override public void work() { System.out.println("청소로봇이 바닥을 청소합니다."); }
	 public void vacuum() { System.out.println("청소로봇이 먼지를 빨아들입니다."); }
} // end class 
class CookingRobot extends Robot {
	 String name = "요리로봇";
	 @Override public void work() { System.out.println("요리로봇이 음식을 만듭니다."); }
	 public void cook() { System.out.println("요리로봇이 파스타를 요리합니다."); }
} // end class
class FightingRobot extends Robot {
	 String name = "전투로봇";
	 @Override public void work() { System.out.println("전투로봇이 적을 공격합니다."); }
	 public void attack() { System.out.println("전투로봇이 레이저를 발사합니다."); }
} // end class
/*********
							Robot {name = "기본로봇" / work()}
↑							      ↑								    ↑
CleaningRobot					 CookingRobot						FightingRobot
{name="청소로봇"/@work()/vacuum()} {name="요리로봇"/@work()/cook()}     {name="전투로봇"/@work()/attack()}

1) 부모 							= 자식 (업캐스팅)
2) {name = "기본로봇" / work()}   =  1번지{name="청소로봇"/@work()/vacuum()} - {name = "기본로봇" / work()} 
							    = 2번지{name="요리로봇"/@work()/cook()}  - {name = "기본로봇" / work()} 
								= 3번지{name="전투로봇"/@work()/attack()} - {name = "기본로봇" / work()} 
*/
public class PolyEx003 {
	public static void main(String[] args) {
        // Q4. 다양한 로봇을 하나의 배열로 관리
        Robot[] robots = { new CleaningRobot(), new CookingRobot(), new FightingRobot() };

        // Q5. for문을 이용해 모든 로봇의 work() 실행
        //robots[0].work();      robots[1].work();      robots[2].work();   
        for(int i=0; i<robots.length; i++){robots[i].work(); }

        // Q6. 배열에서 두 번째 로봇을 꺼내서 "요리로봇" 이름 출력 
        System.out.println(robots[1].name ); // 기본로봇
        System.out.println( ((CookingRobot)robots[1]).name ); // 요리로봇
        
        // Q7. FightingRobot의 attack() 메서드를 호출하려면? 
        ((FightingRobot)robots[2]).attack();
	}
}


/*
연습문제3)  다형성
패키지명 : com.company.basic012_ex
클래스명 : PolyEx003 

// Q1. 상속도 그리기
// Q2. 각 클래스에서 사용할 수 있는 멤버변수/멤버메서드
// Q3. 배열을 이용해 여러 로봇을 관리하는 구조를 설명하시오.

abstract class Robot {
    String name = "기본로봇";
    public Robot() { super(); }
    public abstract void work(); // 추상 메서드
} // end class

class CleaningRobot extends Robot {
    String name = "청소로봇";
    @Override
    public void work() { System.out.println("청소로봇이 바닥을 청소합니다."); }
    public void vacuum() { System.out.println("청소로봇이 먼지를 빨아들입니다."); }
} // end class

class CookingRobot extends Robot {
    String name = "요리로봇";
    @Override
    public void work() { System.out.println("요리로봇이 음식을 만듭니다."); }
    public void cook() { System.out.println("요리로봇이 파스타를 요리합니다."); }
} // end class

class FightingRobot extends Robot {
    String name = "전투로봇";
    @Override
    public void work() { System.out.println("전투로봇이 적을 공격합니다."); }
    public void attack() { System.out.println("전투로봇이 레이저를 발사합니다."); }
} // end class

public class PolyEx003 {
    public static void main(String[] args) {
        // Q4. 다양한 로봇을 하나의 배열로 관리
        Robot[] robots = { new CleaningRobot(), new CookingRobot(), new FightingRobot() };

        // Q5. for문을 이용해 모든 로봇의 work() 실행
     

        // Q6. 배열에서 두 번째 로봇을 꺼내서 "요리로봇" 이름 출력 

        // Q7. FightingRobot의 attack() 메서드를 호출하려면? 
    }
}



*/