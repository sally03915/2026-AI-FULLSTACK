
-----------------------------------------------------
-----------------------------------------------------
#1. 프레임워크
   - 소프트웨어 개발의    [  #1.      ] 역할
   - 실행흐름 담당
#2. IOC
   -  인스턴스 생성~ 소멸까지 [#2.       ]를  [#3.         ]이 관리
#3. DI
   각 클래스의 의존관계를 [#4.        ]을통해서 컨테이너가 자동연결
#4. BEAN
   -  [#5.        ]

#5.  예시
---------------------------------
1) 롬복사용하려고함. 생성자, getter/setter까지 자동 생성되게

 [     ] #6
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
<bean    ="myA"       ="com.company.MyA">     #7-1
   <property  ="name"    ="sally"/>   #7-2
   <property  ="ani"       ="cat"/>   #7-3
</bean>

2.  생성자
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA("sally" , "cat" );

<bean  id=""  class="com.company.MyA">    #8-1
   <constructor-arg    ="0"    ="sally"/>   #8-2
   <constructor-arg    ="1"    ="ani"/>    #8-3
</bean>

3. di-properties
다음과 같이 셋팅설정파일- config/test.properties
name=sally
ani=cat
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.

<context:                    location="classpath:config/test.properties"/>   #9-1
<bean  id="myA"  class="com.company.MyA">     #9-2
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