- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - SWITCH

---

### ■1. 복습문제  -  노트 준비 ~09:40

-1. 
1) 적응할수 있는 능력
2) 

  html
  css
  js + jquery + ajax
  react

  oracle/mysql
  mybatis
  jpa

  java
  jsp
  spring
  spring boot

---

### ■2. Todo1:  CSS기본
- 7. css(3) 가상선택자
```
선택자 : 
- 일반태그 선택자  : p
- 아이디 선택자    : #id
- 클래스 선택자    : .class
- 가상선택자       :     :hover , :first-child , :last-child

```
 
- 8. layout
```
1. float      
2. position   
3. display   
``` 


---

### ■3.   Todo2:  java  CONTROL - SWITCH
 

제어문
1. 프로그램 코드 실행흐름
- 위 → 아래, 왼쪽 → 오른쪽
- 제어문은 개발자가 원하는 방향으로 변경할 수 있도록 도와줌.

2. 종류
  조건문 : if, switch
  반복문 : for, while, do while
  제어키워드 : break, continue

 




★협업마스터 - 


| 이름 | 특징 | 링크 |
|------|------|------|
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |


---

### ■4.  복습문제

■ 1. html + css
```
    1. 레이아웃잡는방법은? (     ,       ,      )
    2. box를 왼쪽, 오른쪽에 붙이는 방법은?
    3. 다음박스를 왼쪽 오른쪽에 배치하려고 한다. 들어가야하는 코드는?
    <style>
      .left{}     .right{}    .clear{}
    </style>
    <div class="box">
      <div class="left">LEFT</div>
      <div class="right">RIGHT</div>
      <div class="clear">안따라갈려고</div>
    </div>

    4. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    <style>
      ul{}    li{}
    </style>
    <ul>
      <li>ONE </li><li>TWO</li><li>THREE</li>
    </ul>

    5. 내가 원하는 위치에 top, right, bottom, left 속성을 줘서 원하는 위치에 배치하는 방법은?
     - 부모박스에  (    )코드를 사용해   기준점을 잡고
     - 자식콘텐츠로  (     )를 사용해 배치한다.

    6.  스크롤할 때 상단에 계속 붙어 있도록 만드는 방법은?  
```    

■ 2. java
```
1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut

    char ch='\u0000';
    Scanner scanner =new Scanner(System.in);

    System.out.println("a,b,c 중에 입력 > ");  
    ch = scanner.next().charAt(0);
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
     1  2  3  4  5
```



