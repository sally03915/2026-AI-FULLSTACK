package com.the703.basic010_ex;

class LunchTray {
	  String owner;        // 인스턴스 변수 - heap - new - 생성자 - this
	  int rice = 90;       // 인스턴스 변수 
	  int soup = 85;       // 인스턴스 변수
	  static int trayCount = 0;      		// 클래스 변수 - method - new x - 공용
	  int totalFood = rice + soup;			// 클래스 변수 → 인스턴스 변수
	  static int maxRice = 100;       		// 클래스 변수

	  
	  
	  public LunchTray() {
		  this.owner ="std-" + ++trayCount;
	}

	  public int getFoodAmount() {			// 인스턴스 메서드
	      return totalFood;         		// return rice + soup은 인스턴스 변수
	  }

	  public static void showTrayCount() {	// 클래스 메서드
		  trayCount += 1; 					// trayCount = trayCount + 1;
	      System.out.println("전체 급식판 수: " + trayCount);   
	  }

	  public void showOwner() { 		// 클래스 메서드
	     System.out.println(owner); 		// ★ 클래스 메서드 안에 owner는 인스턴스 변수
	  }

	  public void showTray() {				// 인스턴스 메서드
	      System.out.println("\n\n:: 주인 이름: " + owner);                
	      System.out.println("총 음식량: " + getFoodAmount());     
	  }
}


public class MemberVarEx003 {
	public static void main(String[] args) {
		LunchTray tray1 = new LunchTray();   
	    tray1.showTray();                    
	    LunchTray.showTrayCount();         

	      LunchTray tray2 = new LunchTray();   
	      tray2.showTray();                   
	      LunchTray.showTrayCount();      
	}
}


/////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------
[METHOD:정보] LunchTray.class, MemberVarEx003.class #1
------------------------------------------------------------
[HEAP:동적]           						 |  [STACK:지역]

2번지 { owner="null", rice=90, soup=85 }		←	tray2[2번지]
1번지 { owner="null", rice=90, soup=85 }		←	tray1[1번지]
												main #2
------------------------------------------------------------
*/
/////////////////////////////////////////////////////////////////



//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.

//:: 주인 이름: std-1
//총 음식량: 175
//전체 급식판 수: 1
//
//
//:: 주인 이름: std-2
//총 음식량: 175
//전체 급식판 수: 2

//class LunchTray {
//    String owner;        
//    int rice = 90;               
//    int soup = 85;               
//
//    static int trayCount = 0;      
//
//    static int totalFood = rice + soup;
//
//    static int maxRice = 100;       
//
//    public int getFoodAmount() {
//        return rice + soup;         
//    }
//
//    public static void showTrayCount() {
//        System.out.println("전체 급식판 수: " + trayCount);   
//    }
//
//    public static void showOwner() { 
//       System.out.println(owner);
//    }
//
//    public void showTray() {
//        System.out.println("\n\n:: 주인 이름: " + owner);                
//        System.out.println("총 음식량: " + getFoodAmount());     
//    }
//}
//
//
//public class MemberVarEx003 {
//   public static void main(String[] args) {
//        LunchTray tray1 = new LunchTray();   
//        tray1.showTray();                    
//        LunchTray.showTrayCount();         
//
//        LunchTray tray2 = new LunchTray();   
//        tray2.showTray();                   
//        LunchTray.showTrayCount();         
//   }
//} 
