- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - IF

---

### ■1. 복습문제  -  노트 준비 ~09:50

> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?      background-color: blue
2. 글자색상을 빨간색으로 지정하는 속성은?   color:red
3. 글자 크기를 20px로 지정하는 속성은?    font-size:20px 
4. 글자를 가운데 정렬하는 속성은?       text-align:center
5. 글자에 밑줄을 추가하는 속성은?       text-decoration:underline
6. 글꼴을 Arial로 지정하는 속성은?     font-family:Arial
7. 글자를 굵게 표시하는 속성은?     font-weight:bold
8. 요소의 가로 길이를 300px로 지정하는 속성은?  width:300px
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?  margin:10px
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?  padding:15px
11. 요소에 1px 실선 테두리를 추가하는 속성은?  border:1px solid red
12. 모서리를 둥글게 10px로 만드는 속성은?  border-radius:10px
13. 그림자 효과를 추가하는 속성은?  box-shadow:0 0 10px black
14. 천천히 움직이는 장면전환효과를 주는 속성은?  transition : all 2s

> 정리문제 (2)
15.  가로 사이즈 지정가능한것은  block
16.  a태그에 margin-top 줄수   x
17.  css 적용방법 3가지 (  인라인   /  내부     / 외부     )
18.  css 적용 내부적용방법은 ( head ) 태그안에 (  style ) 태그 적용해서 사용

> 정리문제 (3)
1.  연산자의 우선순위를 적으시오.
먼저   값                  비교         조건            대입
()    ++ --  + - * / %   > < == !=     &&   ||          =  +=

2.  다음오류 해결
short    sh1 = 1 , sh2=2;
short result =  (short)(sh1 + sh2);
> int 작은 자료형 byte, short 연산시 자동으로 int

3. 필수조건
q1-1 int형 변수 x가 3보다 크고 10보다 작을때 true인 조건식 
     x >3   &&  x<10 
q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식    
    ch == 'a'   ||  ch == 'A'
q1-3 char형 변수 ch가 숫자('0'~'9')일때   true인 조건식     
    ch >= '0'  &&  ch <= '9'
q1-4 char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식
    ch >= 'A'  &&  ch <='Z'  ||
    ch >= 'a'  &&  ch <='z' 


---

### ■2. Todo1:  CSS기본
 
- 7. css(2)   내부적용  / id vs class
css 적용방법
1) 인라인 스타일   - 태그안에 직접 적용  

```html
<p style="color:red" >color</p>
```

2) 내부 스타일 시트 - head 안에 style을 사용해 작성
```html
<style> p{  color:red;  }  </style>
```


3) 외부 스타일 시트

■ 자기소개페이지

| 이름 | 특징 | 링크 |
|------|------|------|
| **최지은 포트폴리오** | 감성적인 타이포그래피, 부드러운 인터랙션, 섹션별 명확한 구성 | [jieun-portfolio.vercel.app](https://jieun-portfolio.vercel.app) |
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |



---

### ■3.   Todo2:  java  CONTROL - IF
 

제어문
1. 프로그램 코드 실행흐름
- 위 → 아래, 왼쪽 → 오른쪽
- 제어문은 개발자가 원하는 방향으로 변경할 수 있도록 도와줌.

2. 종류
  조건문 : if, switch
  반복문 : for, while, do while
  제어키워드 : break, continue



---

### ■4.  복습문제

> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?    background-color:blue
2. 글자색상을 빨간색으로 지정하는 속성은?  
3. 글자 크기를 20px로 지정하는 속성은?  
4. 글자를 가운데 정렬하는 속성은?  
5. 글자에 밑줄을 추가하는 속성은?  
6. 글꼴을 Arial로 지정하는 속성은?  
7. 글자를 굵게 표시하는 속성은?  
8. 요소의 가로 길이를 300px로 지정하는 속성은?  
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?  
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?  
11. 요소에 1px 실선 테두리를 추가하는 속성은?  
12. 모서리를 둥글게 10px로 만드는 속성은?  
13. 그림자 효과를 추가하는 속성은?  
14. 천천히 움직이는 장면전환효과를 주는 속성은?  transition: all 2s;

1. id   css 안에서 선택자 - 유일한 값 , 중복 불가
2. class  - 여러요소에 class 지정 , 반복되는 스타일에 적합


