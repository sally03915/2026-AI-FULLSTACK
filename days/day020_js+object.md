- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   
■ Javascript

 
---

### ■2. Todo1:  js
 


---

### ■3.   Todo2:  java  method
 
 

★협업마스터 - 
 

| 이름 | 특징 | 링크 |
|------|------|------|
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |


---

### ■4.  복습문제
 

1. js 선택자 
1.  document.querySelector("css표현방법")과 document.querySelectorAll("css표현방법")의 차이?
2. 아래 요구사항에 맞게 코드를 작성하세요.

2-1. HTML 문서가 모두 로드된 후 실행되도록 이벤트를 등록하세요.
2-2. 아이디가 test인 요소를 querySelector로 선택하여 변수에 저장하세요.
2-3. 해당 요소를 클릭했을 때 prompt를 이용해 좋아하는 색상을 입력받도록 하세요.
2-4. 입력받은 색상을 배경으로 버튼색상에 적용되도록 하세요.
2-5. 위 요구사항을 모두 만족하는 전체 스크립트를 작성하세요.

<input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
  <script>
  </script>


■ OOP

1. 초기화순서
	기본값			명시적초기화		초기화블록		생성자
	
    4-1) 기본값      : String ,객체 - null /  int - 0 으로 초기화
    4-2) 명시적초기화 :  int a=10;    중요콘텐츠 명시적으로 알림!    
    4-3) 초기화블록   :  { a=10; b=20; }   여러개초기화시
    4-4) 생성자      : 최종은 생성자에서 사용함.  인스턴스변수 초기화


2. runtime data area
 [ method  ]  : 정보저장 , static, final
 [ heap    ]  : 동적저장 - new ,  gc( garbage collecetor)가 처리소멸
 [ stack  ]  : 임시값저장

3. static
- jvm 소스로딩시 메모리 할당받음
- new연산자보다 먼저 실행되어 메모리(method 영역:runtime)에    (     1  )    회 생성
- 클래스명.변수명  / 클래스명.메서드명   - 클래스변수/클래스메서드 
  Calc.name
- 객체생성과 관련이 (   없다  )
- 인스턴스로 접근시 권장사항이 아니므로 경고발생
