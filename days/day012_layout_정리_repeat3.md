- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - SWITCH

---

### ■1. 복습문제  -  노트 준비 ~09:40

■ 1. html + css (  java는 오후에  eclipse 로  진행합니다    )
```
■ 복습문제  - 빈칸채우기   
    1. 레이아웃을 구성하는 대표적인 방식은 무엇인가?    ( float ,  position     , display   )
    2. 박스를 화면의 왼쪽과 오른쪽에 각각 붙여서 배치하려면 어떤 방법을 사용해야 하는가?    (2)
      ① position: absolute     ② float    ③ display: inline-block       ④ margin: auto

    3. 다음li를 왼쪽으로 붙이려고한다. 코드는?    (1)
    <style>  ul { }     li { } </style>
    <ul>  <li>ONE</li><li>TWO</li><li>THREE</li>    </ul>

    ① li { float: left; }  ② li { display: block; }      ③ li { position: absolute; }    ④ li { text-align: left; }

    4. 원하는 위치에 요소를 배치하기 위해 top, right, bottom, left 속성을 활용하려고 한다.
    부모 박스에는 어떤 속성을 주어 기준을 설정하는가?  (1)
    ① position: relative      ② position: fixed     ③ display: flex    ④ margin: auto

    자식 요소에는 어떤 속성을 사용하여 위치를 지정하는가?    (1)
    ① position: absolute    ② position: sticky   ③ float    ④ inline-block

   5.  브라우저에 고정되도록 만드는 방법은?   position:fixed
   6.  a태그의 링크를 확대하려고 한다. 사용해야하는 방법은?  display:block
   7.  li태그들을 가로방향으로 배치하려고 한다.  width를 줘야하는데 사용해야하는 방법은?  display:inline-block
   8.  header 안에서 로고와 내비게이션을 양쪽 끝에 배치하고, 
       콘텐츠 간 간격을 일정하게 유지하려면 어떤 레이아웃 방식을 사용해야 하는가?
      display:flex;  justify-content: space-between
```    

■ 2. java
```


1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
   정수를 하나 입력받아 다음 조건에 따라 성적을 출력하는 프로그램을 작성하시오.
    90점 이상 → "A 학점"
    80점 이상 → "B 학점"
    70점 이상 → "C 학점"
    그 외 → "F 학점"

2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
   위의 문제를 switch 로
  
    int avg=0;
    Scanner scanner = new Scanner(System.in);
    System.out.print("평균입력 > ");  avg = scanner.nextInt();
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
    1 2 3

4. 이중 for를 이용해서 다음문제를 풀으시오.
  ★★★★
  ★★★★
  ★★★★
  ★★★★
    
  
```



---

### ■2. Todo1:  CSS기본
- flex 연습문제  

---

### ■3.   Todo2:  java  CONTROL - BANK 정리


★협업마스터 - 
 

| 이름 | 특징 | 링크 |
|------|------|------|
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |


---

### ■4.  복습문제

■ 1. html + css (  java는 오후에  eclipse 로  진행합니다    )
```
1. float 속성을 사용할 때 부모 요소의 높이가 사라지는 문제를 해결하는 방법은?  
 
2. position: absolute로 자식 요소를 배치할 때, 부모 요소에 반드시 설정해야 하는 속성은?  
 
3. 여러 요소를 가로 또는 세로로 쉽게 배치하기 위해 사용하는 레이아웃 방식은?  
 
4. float와 display의 차이점을 간단히 설명하시오.   

5. position: sticky 속성은 어떤 상황에서 유용하게 사용되는가?  

6. margin: auto를 사용하여 블록 요소를 가운데 정렬하려면 어떤 조건이 필요한가?  

7. z-index 속성은 어떤 경우에 사용되며, 값이 클수록 어떤 효과가 나타나는가?  

8. header 안에서 로고와 내비게이션을 양쪽 끝에 배치하고 간격을 일정하게 유지하려면 어떤 방법을 사용하는가?  
    
```    

■ 2. java
```
1. if 버전
정수를 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오.
1 → "월요일"
2 → "화요일"
3 → "수요일"
4 → "목요일"
5 → "금요일"
그 외 → "주말"

2. switch 버전 - 위의 문제를 switch 문으로 작성하시오.

```java
Scanner scanner = new Scanner(System.in);
System.out.print("요일 입력(1~7) > ");
int day = scanner.nextInt();
```

3. for, while, do while 버전
1 2 3 4 5 6 7 8 9 10

4. 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
 
1234
1234
1234
1234
```
