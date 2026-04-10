- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - SWITCH

---

### ■1. 복습문제  -  노트 준비 ~09:40

-1. 

    1. 레이아웃잡는방법은? (  float  ,  display   ,   position     )
    2. box를 왼쪽, 오른쪽에 붙이는 방법은? float    
    3. 다음박스를 왼쪽 오른쪽에 배치하려고 한다. 들어가야하는 코드는?
    <style>
      .left{  float:left; }     .right{  float:right;   }    .clear{clear:both; }
    </style>
    <div class="box">
      <div class="left">LEFT</div>  <div class="right">RIGHT</div> <div class="clear">안따라갈려고</div>
    </div>

    4. 다음li를 왼쪽으로 붙이려고한다. 코드는?  ※ list-style:none   : 불릿기호 없애기
    <style> ul{ overflow:hidden;     }    li{  float:left; }  </style>
    <ul> <li>ONE </li><li>TWO</li><li>THREE</li>  </ul>

    5. 내가 원하는 위치에 top, right, bottom, left 속성을 줘서 원하는 위치에 배치하는 방법은?
     - 부모박스에    (      position:relative  )코드를 사용해   기준점을 잡고
     - 자식콘텐츠로   (       position:absolute  )를 사용해 배치한다.

    6.  스크롤할 때 상단에 계속 붙어 있도록 만드는 방법은?  
      position:sticky;   top:0;

-2. eclipse 열어서 
클래스명 : Day011

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

■ 1. html + css (  java는 오후에  eclipse 로  진행합니다    )
```
■ 복습문제  - 빈칸채우기   
    1. 레이아웃을 구성하는 대표적인 방식은 무엇인가?    (      ,       ,      )
    2. 박스를 화면의 왼쪽과 오른쪽에 각각 붙여서 배치하려면 어떤 방법을 사용해야 하는가?
      ① position: absolute
      ② float
      ③ display: inline-block
      ④ margin: auto

    3. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    <style>
      ul { }
      li { }
    </style>
    <ul>
      <li>ONE</li><li>TWO</li><li>THREE</li>
    </ul>

    ① li { float: left; }       
    ② li { display: block; }
    ③ li { position: absolute; }
    ④ li { text-align: left; }


    4. 원하는 위치에 요소를 배치하기 위해 top, right, bottom, left 속성을 활용하려고 한다.
    부모 박스에는 어떤 속성을 주어 기준을 설정하는가?
    ① position: relative
    ② position: fixed
    ③ display: flex
    ④ margin: auto

    자식 요소에는 어떤 속성을 사용하여 위치를 지정하는가?
    ① position: absolute
    ② position: sticky
    ③ float
    ④ inline-block

   5.  브라우저에 고정되도록 만드는 방법은?   
   6.  a태그의 링크를 확대하려고 한다. 사용해야하는 방법은?
   7.  li태그들을 가로방향으로 배치하려고 한다.  width를 줘야하는데 사용해야하는 방법은?
   8.  header 안에서 로고와 내비게이션을 양쪽 끝에 배치하고, 콘텐츠 간 간격을 일정하게 유지하려면 어떤 레이아웃 방식을 사용해야 하는가?

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



