#1. 구글리모트 안내
   - https://chromewebstore.google.com/detail/chrome-remote-desktop/inomeogfingihgjfjlpeplalcfajhgai?hl=ko

   먼저 오신분들은 
   구글리모트 설치요!

#2. 복습문제

-----------------------------------------------------
-----------------------------------------------------
#1. 프레임워크
   - 소프트웨어 개발의    [  #1. 뼈대   ] 역할
   - 실행흐름 담당
#2. IOC
   -  인스턴스 생성~ 소멸까지 [#2.  생명주기   ]를  [#3. 스프링  ]이 관리

#3. DI
   각 클래스의 의존관계를 [#4.  설정파일  ]을통해서 컨테이너가 자동연결
    > xml

#4. BEAN
   -  [#5. 스프링이 관리하는 객체, 관리되는 객체   ]

#5.  예시
---------------------------------
1) 롬복사용하려고함. 생성자, getter/setter까지 자동 생성되게

[ @Data] #6
class MyA{
   private String name;
   private Animal ani;

   public MyA(String name, Animal ani){
      this.name = name;
      this.ani = ani;
   }
}
---------------------------------
1. setter 방식    #7
  다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA()  
     myA.setName("sally");
     myA.setAni("cat" );

<bean id="cat"  class="com.company.Cat"/>       
<bean id="myA"   class="com.company.MyA">     #7-1
   <property  name="name"    value="sally"/>   #7-2
   <property  name="ani"        ref="cat" />   #7-3
</bean>

2.  생성자
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA("sally" , "cat" );

<bean  id="myA"  class="com.company.MyA">    #8-1
   <constructor-arg    index="0"    value="sally"/>   #8-2
   <constructor-arg    index="1"    ref="ani"/>    #8-3
</bean>

3. di-properties
다음과 같이 셋팅설정파일- config/test.properties
name=sally
ani=cat
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.

<context:property-placeholder  location="classpath:config/test.properties"/>   #9-1
<bean  id="myA"       class="com.company.MyA">     #9-2
   <constructor-arg   index="0"   value="${name}"/>   #9-3
   <constructor-arg   index="1"   ref="${ani}"/>   #9-4
</bean>



#6.  스프링 - 실습
>  프로젝트만들기 - spring002_db_mysql

    1. dynamic web project - spring002_db_mysql
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path

-----------------------------------------------------
-----------------------------------------------------

#3. 스프링 - db 연동




#4. 포트포리오 안내 - 팀회의 (주제)





..................................................... 
1	JAVA, JSP웹프로그래밍 >  
   [spring + mysql + jsp + mybatis] board + 멤버관리  → 수업예제

2	프로젝트Ⅰ(완성된 웹서비스 플랫폼 프로젝트 리뉴얼)	> 미니프로젝트  (5일)
   1) crud 중점 :  새로운주제 - 관리자
   상품관리 
   재고관리       ....
   프로모션관리  

3	Spring & MyBatis & GPT	
   [spring boot + oracle + 타임리프 + mybatis + api]  → 수업예제	 
   
4	프로젝트ⅡBtoC 웹서비스 구축(Spring Framework 활용)		 
   2) api → 사용자측

5	Node.js & Express Server & React		    
   [node + react]  → 수업예제	 

6	프로젝트Ⅲ홍보/마케팅에 활용 가능한 SNS 사이트 제작(Node.js 와 React 활용)	
   back [spring boot +  jpa + jwt + redis + oauth2.0 + api]  
       +
   front[react + next]   → project3

7	MSA & 리눅스 & 클라우드		
    → project3

........................................................
> 이력서준비 / 진도 / 면접
8	Django & Fluter		   
9	프로젝트Ⅳ 매출 및 생산성 향상 앱개발[플러터(DART)활용 ]
    → project4
........................................................	
