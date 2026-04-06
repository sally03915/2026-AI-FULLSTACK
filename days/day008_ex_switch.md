- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - SWITCH

---

### ■1. 복습문제  -  노트 준비 ~09:40

> 정리문제 (1) 

1. 마크업
1-1.  이미지태그를 이용해서 001.png 파일을 마크업하시오.
     <img src="001.png"  alt="이미지 태그설명" />

1-2.  naver로 링크하는 a태그를 적으시오.
      <a href="http://www.naver.com" title="네이버새창열기">  naver </a>

2. css
1. 배경을 노란색으로 설정하는 속성은?       background-color:yellow 
2. 글자색상을 초록색으로 지정하는 속성은?    color:green 
3. 글자 크기를 30px로 지정하는 속성은?      font-size:30px
4. 글자를 오른쪽으로 정렬하는 속성은?     text-align:right
5. 글자에 취소선을 추가하는 속성은?      text-decoration:line-through  
6. 글꼴을 'Times New Roman'으로 지정하는 속성은?   font-family:'Times New Roman'
7. 글자를 굵은표시를 기본으로 표시하는 속성은?    font-weight:normal 
8. 요소의 세로 길이를 400px로 지정하는 속성은?   height:400px
9. 요소의 바깥쪽 여백을 20px로 지정하는 속성은?   margin:20px
10. 요소의 안쪽 여백을 5px로 지정하는 속성은?  padding:5px
11. 요소에 2px 점선 테두리를 추가하는 속성은?  border:2px dotted red
12. 모서리를 둥글게 50%로 만드는 속성은?    border-radius:50%
13. 그림자 효과를 빨간색으로 추가하는 속성은?   box-shadow:0 0 10px  rgba(0,0,0,0.5)
14. 빠르게 움직이는 장면전환효과를 주는 속성은?  transition:all 0.2s; 

 
> ★협업마스터 - 윤정, 혜원, 영탁
 
3. 필수조건
q1-1 int형 변수 x가 60이상일때 조건식  
q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식     
q1-3 char형 변수 ch가 숫자('0'~'9')일때   조건식      
q1-4 char형 변수 ch가 영문자(대문자) 일때    조건식 

4.  eclipse 열어서 작성해주세요! [20분]
   패키지명 : com.the703.days
   클래스명 :  Day008
   출력내용 :  성적처리 프로그램입니다.
   1. 총점 구하기
   2. 평균 구하기
   3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
   4. 평균이 95점이상이면 장학생
   5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

   학번 입력 > std111
   국어점수 입력 > 100   
   수학점수 입력 > 100
   영어점수 입력 > 99
   ======================================================== 
   학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
   ======================================================== 
   std111   100   100   99   299   99.67   합격   수   장학생







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

......
1. BANK 지난시간에 작성내용
2. 
   국어점수는 0~100 사이만 입력받게  
   수학점수는 0~100 사이만 입력받게 
   영어점수는 0~100 사이만 입력받게 
   
   학번 입력 > std111
   국어점수 입력 > 100   
   수학점수 입력 > 100
   영어점수 입력 > 99







★협업마스터 - 


| 이름 | 특징 | 링크 |
|------|------|------|
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |


---

### ■4.  복습문제

■1. html + css

  1. css 선택자 - 태그선택자, 아이디선택자, 클래스선택자 , (         : 예  :hover, :first-child)
  2. 내부적용을 이용해서 다음 css를 적으시오. 
      h1 중앙정렬, 글자색상 : #34495e, 아래쪽여백 : 40px 
          h1{ text-align: center; color: #34495e ;    margin-bottom : 40px }
  
  3. 여러개의 div태그에 .portfolio라는 클래스를 적용하고  
    각각의 배경을다르게 설정하려고 한다.  .p1은 배경 red,    .p2는 gold 
    html 설정에 css를 적용하는 코드를 적으시오
    ```
      <div></div>
      <div></div>
    ```
  
  4.    .portfolio마우스를 올렸을때    확대 + 회전 + 밝기 + 그림자 강조  css를 적으시오.
  5.   가상선택자의 종류는? 
    5-1.   마우스를 올렸을때 
    5-2.   부모안에서 첫번째 자식요소
    5-3.   부모안에서 마지막 자식요소

  6.   .portfolio ul태그의 첫번째 li를 선택해서 좋아하는 배경색으로 넣기 
  

■2.  java

1. if 버젼
    1을 입력받으면 1이다   / 2를 입력받으면 2이다 / 3을 입력받으면 3이다.
2. switch 버젼
    위의 내용을 switch 버젼으로 
3. 다음 무한반복을 빠져나오는 코드를 적으시오
		int a = -1;
		
		for(;;){ 
			System.out.println("빠져나오실래요?  0이면 종료");
			a = scanner.nextInt();
			if(a==0) {        }
		}



