package com.the703.basic015;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004_api { 
	public static void main(String[] args) {
		//(t)->{}   accept   받는용도
		// void java.util.function.Consumer.accept( T t )
		//Consumer<String> consumer=(t)->{ System.out.println("Hello:) "  + t);  };   
		//Consumer<String> consumer= t ->  System.out.println("Hello:) "  + t);     //ver-1 람다식 정리
		Consumer<String>   consumer=       System.out::println;                     //ver-2 참조형 가능
		consumer.accept("lambda");
		consumer.accept("뚜비");
		
		//()->{return}   get 주는용도
		//T java.util.function.Supplier.get()
		//Supplier<String>  supplier =  ()->{ return "Hello"; }; 
		Supplier<String>  supplier =  ()->  "Hello:) ";  //ver-1 람다식 정리
		System.out.println(  supplier.get()  );
		
		// (t)->{  return  true;  }   test   판단용도
		// boolean java.util.function.Predicate.test( T t )
		//Predicate<Integer> predicate = (t)->{ return  t<0; };
		Predicate<Integer>   predicate =  t ->  t<0;     //ver-1 람다식 정리
		System.out.println(predicate.test( 10));  //false
		System.out.println(predicate.test(-10));  //true
		
		//(t)->{  return }  처리
		// R java.util.function.Function.apply( T t )
		//Function<String,Integer>  function = (t)->{  return Integer.parseInt(t); };
		//Function<String,Integer>  function =  t ->   Integer.parseInt(t);  //ver-1 람다식 
		Function<String,Integer>    function =   Integer::parseInt;//ver-2 참조형 
		System.out.println( function.apply("10") + 3 );  //13
		
		
		//( left, right)->{ return  }
		//int java.util.function.IntBinaryOperator.applyAsInt( int left, int right )
		//IntBinaryOperator  operator =  (left, right)->{ return  left>right? left:right; };
		IntBinaryOperator  operator =  (left, right)-> left>right? left:right;
		//ver-1 람다식 
		System.out.println(operator.applyAsInt(10, 3));  // 누가 큰지 판단  (연산)
		System.out.println(operator.applyAsInt(3, 10));  // 누가 큰지 판단
		
		
	} 
}

/*****
자바의 api 함수형인터페이스
1.   Consumer  받는용도 
2.   Supplier  제공용도   
3.   Predicate 판단용도
4.   Function  처리용도
5.   Operator  연산용도

*/