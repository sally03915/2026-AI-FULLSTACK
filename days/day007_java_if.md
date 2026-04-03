- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - IF

---

### ■1. 복습문제  -  노트 준비 ~09:50

> 정리문제 (1) 
1. 웹페이지의 배경을 하늘색으로 바꾸고 싶다. 어떤 속성을 써야 할까?         
   background-color:skyblue;

2. 제목 글자를 초록색으로 바꾸려면?     
   color:green;

3. 본문 글자의 크기를 18px로 지정하려면?    
   font-size:18px

4. 메뉴 글자를 오른쪽으로 정렬하려면?    
   text-align:right

5. 링크에 밑줄을 없애려면?  
   text-decoration:none;

6. 글꼴을 'Times New Roman'으로 바꾸려면?   
   font-family: 'Times New Roman'

7. 강조하고 싶은 단어를 굵게 표시하려면?   
   font-weight:bold

8. 이미지를 가로 400px로 줄이고 싶다. 어떤 속성?   
   width:400px

9. 박스 바깥쪽에 20px 여백을 주려면?   
   margin:20px

10. 버튼 안쪽에 8px 여백을 주려면?   
   padding:8px

11. 카드 요소에 2px 점선 테두리를 주려면?    (dotted)
   border:2px dotted red

12. 프로필 사진 모서리를 둥글게 50%로 만들려면?    
   border-radius:50%

13. 박스에 살짝 번지는 그림자 효과를 주려면?    
   box-shadow:0 0 10px rgba(0,0,0,0.1)

14. 버튼에 마우스를 올렸을 때 부드럽게 색이 바뀌도록 하려면?    button:hover {   } 
   transition:all 2s

> 정리문제 (2)
1. css 선택자 유일한 값 ?  id
2. css 선택자 여러개 선택시? class
 
> 정리문제 (3)
1. 숫자를 한개입력받아
2. 1이면 1이다, 2이면 2이다, 3이면 3이다  if로 작성 

int num=0; 
Scanner scanner = new Scanner(System.in);
num = scanner.nextInt();

     if(num==1){  System.out.println("1이다");}
else if(num==2){  System.out.println("2이다");}
else if(num==3){  System.out.println("3이다");}



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
