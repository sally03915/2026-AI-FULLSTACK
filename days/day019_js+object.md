- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   

■1. 자바스크립트 빈칸채우기 (09:45)
1. 자바스크립트의 출력   ( document.write("하고 싶은말") , console.log()   )
2. 변수    ( var , let  , const  )
3. 변수차이   (  var - 전역   ,  let - 지역 (중복선언 x)    ,  const (상수) )
4. 변수는 모든자료형을 담을수 있다.  자료형확인은 ( typeof   )
5. 알림창 종류  - (  alert   ,  prompt  ,  confirm  )
6. 이벤트  - 이벤트대상(div),    이벤트(click),  이벤트 핸들러(alert('haha'))
   다음 div 태그를 클릭했을때 알림창 haha를 출력하는 코드를 작성하시오.
    <div onclick = "alert('haha')">test</div>
7. 다음에 해당하는하는 스크립트 코드를 작성하시오.    
    0. 스크립트가 document어느위치에서든지 동작가능하게   >  window.addEventListener
    1. 아이디가 test인것을  getElementById 이용해 선택    > document.getElementById
    2. 클릭시 prompt이용해서 당신이 좋아하는 1~5사이의 숫자 물어보고  >  prompt
    3. alert이용해서 알림창띄우기     > alert
   <input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
   <script>  
    window.addEvenetListener("load" , function(){
        document.getElementById("test").onclick = function(){
            let num = prompt("1~5사이 > ");
            alert(num);
        }; 
    });
   </script>  


■2. 자바
1. 	OOP?
2.  OOP특징 
3.  클래스는  (        )와  (       )를 갖는다 
4.  클래스와 인스턴스 구분
- 클래스는  (      )
- 인스턴스는  (          )


 
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
■ Javascript
1. js 선택자 
1-1. id 선택자 사용시 
1-2. 태그 선택자 사용시
1-3. css 표현 선택자 사용시

2. 다음에 해당하는 코드를 한줄한줄  적으시오.
2-1. 스크립트가 document어느위치에서든지 동작가능하게     window.
2-2. 아이디가 test인것을  querySelector 이용해 선택   
2-3. 클릭시 prompt이용해서 당신의 이름묻기
2-4. alert이용해서 이름 알림창띄우기   
2-5. 아래 스크립트를 채우세요.
<input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
<script>   
//////////
</script>  



■ OOP
1.  생성자   - new 연산자에 의해 호출 [       ] 담당

2. 기본생성자( 디폴트생성자 )
- 모든클래스에 생성자가 반드시 존재
- 생성자선언을 생략시 컴파일러가 자동으로 기본생성자를 추가
- 개발자가 선언시 컴파일러가 자동생성  (        )

3. 생성자형식
class A{
   public    A(                 ){}   //기본생성자(디폴트생성자)
   public    A(String name){}   //파라미터, 알규먼트가 있는 생성자.
}
1)  리턴값  (       )
2)  클래스명과  (      ) 

.......................................................................
1. js 선택자 
1-1. id 선택자 사용시    document.getElementById
1-2. 태그 선택자 사용시    document.getElementsByTagName
1-3. css 표현 선택자 사용시   document.querySelector

2. 다음에 해당하는 코드를 한줄한줄  적으시오.
2-1. 스크립트가 document어느위치에서든지 동작가능하게     window.addEventListener("load" , function(){})
2-2. 아이디가 test인것을  querySelector 이용해 선택    let test = document.querySelector("#test");
2-3. 클릭시 prompt이용해서 당신의 이름묻기              test.onclick = function(){   let name = prompt("이름?");   alert(name);    };
2-4. alert이용해서 이름 알림창띄우기   
2-5. 아래 스크립트를 채우세요.
<input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
<script>   
//////////
window.addEventListener("load" , function(){
    let test = document.querySelector("#test");
    test.onclick =  function(){   
        let name = prompt("이름?");   
        alert(name);    
    };
})
</script>  