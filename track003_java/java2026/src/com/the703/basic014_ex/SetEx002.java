package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class SetEx002 {

	public static void main(String[] args) {
		//변수
         Scanner sc = new Scanner(System.in);
		 HashSet<Integer>  lotto = new  HashSet<>();
		 Random  rand = new Random();
		//입력
		 while(lotto.size() < 6) {
			 lotto.add(rand.nextInt(45) + 1);
		 }
		//처리
		 System.out.println("=== 이번주 로또 번호 ===");
         for (int n : lotto) { System.out.println(n); }
         
         // 사용자 입력받아 포함 여부 확인
         System.out.print("> 확인할 번호 입력 : ");
         int find = sc.nextInt();
         System.out.println(lotto.contains(find) ? ("포함됨 → " + find) : ("포함되지 않음 → " + find));
       
	}

}


/*

연습문제2) Collection Framework  
패키지명 : com.the703.basic014_ex
클래스명 : LottoSetEx002

### 문제 요구사항
1. HashSet<Integer> 를 이용해서 로또 번호를 생성한다.  
2. 1~45 사이의 난수 6개를 넣는다. (중복 제거)        int num = rand.nextInt(45) + 1; // 1~45
3. 향상된 for문을 이용해서 로또 번호 6개를 출력한다.  
4. 사용자로부터 번호를 입력받아, 해당 번호가 로또 번호에 포함되어 있는지 확인한다.  

 
### 🖥️ 실행 결과 예시

=== 이번주 로또 번호 ===
7
12
23
34
41
45
> 확인할 번호 입력 : 
23
포함됨 → 23 

 
*/