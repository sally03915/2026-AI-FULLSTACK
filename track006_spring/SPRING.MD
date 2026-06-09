1. SPRING?

--------------------------------
#1. SPRING?
--------------------------------
▶ Step0. jsp
1. mvc1    -  jsp( controller )역할
2. mvc2 - servlet( controller )역할

예) JSP = html + java → web


▶ Step1.  framework
1. framework  [  디자인패턴 + 라이브러리 = 프레임워크 ]
2. 소프트웨어 개발의 뼈대역할



--------------------------------
#2. DI
--------------------------------
▶ Step2.  ioc + di
1. ioc
 - inversion of control
 - 제어의 역전
 - 인스턴스의 생성~소멸까지 생명주기를 개발자가 아니라 컨테이너가 하는 것
 - pojo ( plain old java object)

  class A{}
  A a1 = new A()

  생성 → 초기화 → 서비스  → 소멸
    ↑                                      ↓
     ----------------------------------
 
   ioc가 아닌경우   - [ 개발자★  → ( Class A)  
                                    → ( Class B)
                                        → ( Class C)     ] 컨테이너

   ioc인      경우   - [ 개발자  ← ( Class A)  
                                    ← ( Class B)
                                        ← ( Class C)★     ] 컨테이너



2. di ( dependency injection : 의존성주입 )
- 각 클래스간의 의존관계를  [설정파일]을 통해 [컨테이너]가 자동으로 연결
  장점 : 코드단순화 / 결합도 제거



▶ Step3.  실습
===================
실습(1) 설치
===================
* 버젼다운그레이드
  0. java.sun.com   -  java11   / build path
	JAVA_HOME	C:\Program Files\Java\jdk-11
	path                      %JAVA_HOME%\bin             - 맨위로
              
  1. 스프링 3버젼 다운로드
  2. 다운로드 경로
      https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3
  3. 압축 - 경로짧게 / 공백, 한글,특수기호(-) 경로에있으면 빼기 
 

===================
실습(2) spring setting
===================
    1. dynamic web project - spring001
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. build path - add Libraries - JUnit 4

    구조확인
	1. pom.xml         설치 다운로드
              2. src/main/java   실제 자바파일들 위치
              3. src/test/java    실제 테스트파일위치
              4. src/main/webapp   jsp 파일들위치

   연습문제)  ex1  프로젝트만들기



===================
실습(3)  SPRING IOC + DI
===================
1.  프레임워크
   - 소프트웨어개발의 뼈대역할 [디자인패턴 + 라이브러리]
2.  IOC
   - 인스턴스 생성~소멸까지 생명주기를 스프링이 관리  
3.  DI
   - 각클래스의 의존관계를  [설정파일]을 통해서 컨테이너가 자동연결
4.  BEAN
   -  스프링이 관리하는 객체 (부품)
   - beanFactory   ← ApplicationContext

    [AnimalFarm]  (사용)→    [<<interface>>Animal]	
	↑(삽입)		                ↑(구현)	  ↑ (구현)	
    [beans.xml ]  (생성)→     [Cat     /   Dog]

    >> di? 각클래스의 의존관계를 [설정파일]을통해서 컨테이너가 자동연결


    [실습]
        https://projectlombok.org/download

        1) 버젼에 맞게 다운로드
        2) c  드라이브에 위치
        3) cmd
        ```
        java -jar  lombok-1.18.18.jar
        ```
        4) sts 설치 위치 - 이클립스 선택 - install






5. 예시)
---------------------------------
@Data
class MyA{
	private String name;
	private Animal  ani;

	public MyA(String name, Animal ani){
		this.name = name;
		this.ani = ani;
	}
}
---------------------------------

1. setter 방식
    <bean  id="myA"  class="com.company.MyA">
        <property name="name"   value="sally"/>
        <property name="ani"    ref=""/>
    </bean>

2. 생성자
    <bean  id="myA"  class="com.company.MyA">
        <constructor-arg   index="0"   value="sally"/>
        <constructor-arg   index="1"   ref="ani"/>
    </bean>

3. di-properties
    name=sally
    ani=cat

    <context:property-placeholder location="classpath:config/test.properties"/>

    <bean  id="myA"  class="com.company.MyA">
        <constructor-arg   index="0"   value="${name}"/>
        <constructor-arg   index="1"   ref="${ani}"/>
    </bean>


6. di 연습문제)

1) ex1 스프링프로젝트
2) 구성확인

[IceCreamShop]  (사용) →   [<<interface>> IceCream]   
   ↑(삽입)                     ↑(구현)         ↑(구현)   
 [beans.xml] (생성)    →   [ Vanilla / Chocolate ]

 >> di? 각 클래스의 의존관계를 [설정파일]을 통해 컨테이너가 자동연결

1) 인터페이스
com.company.ioctest

public interface IceCream {
    public String flavor();
    public String scoop();
    public String melt();
}
2) 구현클래스
com.company.ioctest

public class Vanilla implements IceCream {
    @Override public String flavor() { return "Vanilla-flavor"; }
    @Override public String scoop()  { return "Vanilla-scoop"; }
    @Override public String melt()   { return "Vanilla-melt"; }
}

public class Chocolate implements IceCream {
    @Override public String flavor() { return "Chocolate-flavor"; }
    @Override public String scoop()  { return "Chocolate-scoop"; }
    @Override public String melt()   { return "Chocolate-melt"; }
}


3) 사용클래스 - IceCreamShop

package com.company.ioc;
public class IceCreamShop {
    private String shopName;
    private IceCream iceCream;

    public IceCreamShop() { super(); }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public IceCream getIceCream() { return iceCream; }
    public void setIceCream(IceCream iceCream) { this.iceCream = iceCream; }

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }
}



QUESTION1) DI - property 를 이용하여 셋팅하고 JUnit Test를 하시오
--1-1 com.company.ioc1 [IceCreamShop, Vanilla , Chocolate]
public class IceCreamShop {
    private String shopName;
    private IceCream1 iceCream;
}

--1-2 com.company.config [test1.xml]
<!-- Vanilla vanilla = new Vanilla() -->
<!-- Chocolate chocolate = new Chocolate() -->
<!-- IceCreamShop shop = new IceCreamShop()
     shop.setShopName("SweetHouse");
     shop.setIceCream(vanilla);
-->

--1-3 JUnit Test  
public void test1() {
    IceCreamShop shop = (IceCreamShop) context.getBean("iceCreamShop");
    shop.print();
}


QUESTION2) DI - component-scan, properties 를 이용해서 셋팅하고 JUnit Test를 하시오
--1-1 com.company.config [test2.xml]
<context:component-scan base-package="com.company.ioc2"/>
<context:property-placeholder location="classpath:shop.properties"/>

--1-2 com.company.ioc2 [IceCreamShop, Vanilla , Chocolate]
 
--1-3 JUnit Test  
public void test1() {
    IceCreamShop shop = (IceCreamShop) context.getBean("iceCreamShop");
    shop.print();
}





---------------------
#3.  Bean
---------------------

1.  xml   vs  Annotation
>> xml        : 운영
>> Annotation : 개발
XML - [운영] , 모든 Bean을 명시적으로 xml에 등록
    - 여러개발자가 같은 설정파일을 공유해서 개발하면 
      수정시 충돌이 일어날 경우가 많음.

2.@Component
- @Component 일반적인 컴포넌트  <bean> 스프링이 관리하는 객체
- @Component 구체화된 형식
	@Controller  웹요청받아서 응답
	@Service     서비스 레이어, 비즈니스 로직
	@Repository  데이터베이스

3. Bean 의존관계주입
	1. @Autowired - 정밀한 의존관계 
		- 프로퍼티, setter, 생성자,, 적용
	2. @Qualifier - 동일한타입의 bean 구분
	3. @Value  단순값
	4. @Resource - 자원연결(  .properties)	

4. component-scan
<context:component-scan  base-package="경로설정"/>



---------------------
#4.   DB  + Mybatis
---------------------
1. DataSource
+ SimpleDrdiverDataSource   - 가장단순한버젼

2. mybatis
- sql을 별도로 파일분리해서 관리
- orm (object relational mapping) 프레임워크

3. 설정내용
root-context.xml   환경정보설정
db.propertis       db정보설정
SqlSessionFacotryBean  : SqlSession 생성 및 관리
SqlSession             :  sql 실행 , 트랜잭션
mapper.xml


>1. 테이블 만들기
mysql> desc userinfo_e;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| email | varchar(100) | NO   |     | NULL    |                |
| age   | int          | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.01 sec) 

>2. crud - insert, select, update, delete
insert                : insert     into   userinfo_e  (email , age)  values (? , ?) 
select (전체)          : select  * from    userinfo_e
select (해당번호의 읽기) : select  * from    userinfo_e  where no = ? 
update (해당번호 수정)   : update    userinfo_e   set  email=? , age=?  where  no=?
delete (해당번호 삭제)   : delete    from   userinfo_e     where  no=?




[실습]
1. project 만들기
    1. dynamic web project - ex02
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. build path - add Libraries - JUnit 4
    
2. pom.xml 에  jar 파일 다운로드 받기
...............................................  오늘 project 만들고  done!
...............................................  연휴에 아래 도전하고 싶으신분들은 도전!

3. root-context 에   내용설정
   1) DataSource
   2) Mybatis
   3) Mapper
4. 각종 설정파일들설정
    com.the703.dao   - @Mapper 
    com.the703.dto    
    config       
      ㄴ db.properties
      ㄴ mybatis-config.xml
      ㄴ board-mapper.xml
5. 테스트파일설정
      
6. mvcboard
mysql> desc mvcboard2;
+----------+---------------+------+-----+-------------------+-------------------+
| Field    | Type          | Null | Key | Default           | Extra             |
+----------+---------------+------+-----+-------------------+-------------------+
| bno      | int           | NO   | PRI | NULL              | auto_increment    |
| bname    | varchar(20)   | NO   |     | NULL              |                   |
| bpass    | varchar(50)   | NO   |     | NULL              |                   |
| btitle   | varchar(1000) | NO   |     | NULL              |                   |
| bcontent | text          | NO   |     | NULL              |                   |
| bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bhit     | int           | NO   |     | 0                 |                   |
| bip      | varchar(50)   | NO   |     | NULL              |                   |
+----------+---------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)

mysql>      





-----------------------------
#5.   MVC
-----------------------------
▶STEP1. MVC
>> 서로 영향없이 쉽게 고칠수 있는 애플리케이션을 만들수 있음.
- MODEL   데이터 ( dto, dao, service )
- VIEW      화면   ( html, css, js/jquery)
- Controller 비지니스로직

▶STEP2. MVC1  vs  MVC2
1. MVC1 -   Controller 의 역할 jsp 담당
2. MVC2 -   Controller 의 역할 servlet 담당


▶STEP3. SPRING MVC
--------    FrontController
	         /list.do	           BList	        /board/list.jsp
[클라이언트] → [FrontController]  → 세부Controller → View
			                    → 세부Controller → View
			                    → 세부Controller → View
1. FrontController  공통작업수행
2. 세부Controller  View에 최종결과 생성
	
--------SPRING MVC
[클라이언트] 
↓  ① /list.do
                [FrontController] 
                <<DispatcherServlet>>  ② Handler Mapping   @Controller
                                            ↓ 위임		
                                     ★③ 세부Controller   
                                 ← ④ 
                    ⑥↑↓ ⑤	
                    View

① 클라이언트 요청  ( 코요테/ web.xml 
			- spring관련: root-context.xml,   servlet-context.xml )
② DispatcherServlet - Handler Mapping을 사용해서 처리할 Controller확인
③ 세부Controller  클라이언트 요청처리 ( service - 비지니스로직 )
④ 요청결과와 View정보를 DispatcherServlet에게 줌
⑤ DispatcherServlet는 ViewResolver로 부터 응답결과를 생성할 View객체 생성
⑥ View 응답생성 - response

[실습]
1) view.zip 다운로드
2) servlet-context.xml  확인 - /view/ 폴더 안에 압축풀기
   	<bean id="viewResolver"  
		  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix"   value="/view/"/>
		<property name="suffix"   value=".jsp"/>
	</bean> 

3) com.the703.controller
- BoardController
■RequestMapping 경로       ■ 해당view 설정
/board/list.do            /view/board/list.jsp 
/board/write.do           /view/board/write.jsp    (글쓰기폼)
/board/detail.do          /view/board/detailjsp    (상세보기)
/board/edit.do            /view/board/edit.jsp     (수정하기폼)
/board/delete.do          /view/board/delete.jsp   (삭제하기폼)




------------------------------
#6. Security  
------------------------------   
▶ 1. Security?
 - 애플리케이션의 보안(인증, 인가)을 담당
 - Filter의 흐름에 따라 처리

▶ 2. 인증  VS  인가
 - 인증  Authentication - [본인]이 맞는지 확인       : 여권갖고 비행기탑승, 로그인
 - 인가  Authorization  - 인증된사용자가 [접근가능]   : 승객은 조종실에 못들어감.

▶ 3. Security 아키텍쳐

=====================
		 ② [UsernamePasswordAuthentication Token]
 			↓
① Http Request  →     [AuthenticationFilter] ③ ...  →  [Authentication  Manager]
			↓⑩               ⑨	  ←
		    [SecurityContextHolder]
=====================

-1. 사용자가 로그인 폼태그 시도 (username + password 전달)
-2. UsernamePasswordAuthentication 요청정보  Authentication 를 생성
-3. Authentication 인증처리
★UsernamePasswordAuthentication

-10. 인증 완료가 [사용자정보]   SecurityContextHolder 담기
    - AuthenticationSuccessHandler   를 실행( 성공 )
    - AuthenticationFailureHandler   를 실행( 실패 )

=====================
 [AuthenticationFilter] ③   → [Authentication  Manager] → ④[AuthenticationProvider(s)]
			  		         						← ⑨       ↑	↓⑤	
							↑		   						 [ UserDetailsService ]	 
			  				 ProviderManager		          ↑	↓⑥
						      								 [ UserDetails ]	

=====================
-4. Authentication  Manager  인증담당
★UsernamePasswordAuthentication  Token은 Provider를 찾는데 사용
 
AuthenticationProvider
★ 로그인정보 DB정보와 비교

UserDetailsService
★ DB에 있는 [사용자정보]가져오기


1. pom.xml 
2. web.xml
3. serucity-context.xml  
4. SecurityController