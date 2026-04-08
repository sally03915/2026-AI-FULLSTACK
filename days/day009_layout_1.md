- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - SWITCH

---

### ■1. 복습문제  -  노트 준비 ~09:40


■1. html + css
  1. css 선택자 - 태그선택자(p), 아이디선택(#id), 클래스선택자(.class) , ( 가상선택자    : 예  :hover, :first-child)
  2. 내부적용을 이용해서 다음 css를 적으시오. 
      h1 중앙정렬, 글자색상 : #34495e, 아래쪽여백 : 40px  
    ```
      <style> h1{ text-alicn:center;  color:#34495e;  margin-bottom:40px;  }  </style>
    ```
  3. 여러개의 div태그에 .portfolio라는 클래스를 적용하고  
    각각의 배경을다르게 설정하려고 한다.  .p1은 배경 red,    .p2는 gold 
    html 설정에 css를 적용하는 코드를 적으시오
    ``` 
      <style> .p1{ background-color:red; }    .p2{ background-color:gold; } </style>
      <div  class="portfolio p1"></div>
      <div  class="portfolio p2"></div>
    ``` 
  4.    .portfolio마우스를 올렸을때    확대 + 회전 + 밝기 + 그림자 강조  css를 적으시오.
  ```
      .portfolio:hover{  
          trasform: scale(1.05)  rotate(-1deg);  
          filter:brightness(1.05);       
          box-shadow:0 0 10px rgba(0,0,0,0.5);
      }
  ```

  5.   가상선택자의 종류는? 
    5-1.   마우스를 올렸을때               :hover
    5-2.   부모안에서 첫번째 자식요소        :first-child 
    5-3.   부모안에서 마지막 자식요소        :last-child

  6.   .portfolio ul태그의 첫번째 li를 선택해서 좋아하는 배경색으로 넣기  
  .portfolio ul  li:first-child{ background-color:red;  }

■2.  java
    Scanner sc = new Scanner(Systesm.in);
    int a=scanner.nextInt();

1. if 버젼
       1을 입력받으면 1이다   / 2를 입력받으면 2이다 / 3을 입력받으면 3이다.
         if(a==1){System.out.println("1출력");}
    else if(a==2){System.out.println("2출력");}
    else if(a==3){System.out.println("3출력");}

2. switch 버젼
    위의 내용을 switch 버젼으로 
      switch(a){
        case 1 : System.out.println("1출력"); break;
        case 2 : System.out.println("2출력"); break;
        case 3 : System.out.println("3출력"); break;
      }

3. 다음 무한반복을 빠져나오는 코드를 적으시오    break
		int a = -1; 
		for(;;){ 
			System.out.println("빠져나오실래요?  0이면 종료");
			a = scanner.nextInt();
			if(a==0) {   break;     }
		}





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

- [ ] 1. css 정리파일확인 
★협업마스터 - 


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
    
3. for를 이용하여 문제를 풀으시오!  
     1 2 3  
```
     