package com.the703.basic015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream002 { 
	public static void main(String[] args) {
	    Integer[]     arr  = {1,2,5,4,3,4,5,1,2,1,1,1,1,1,1};   
	    List<Integer> list = Arrays.asList(arr);
	     
	    //1단계 stream
	    Stream<Integer> sarr  = Arrays.stream(arr);
	    Stream<Integer> slist =  list.stream();
	    
	    //2단계 중간연산
	    // (t)->{}
	    // void java.util.function.Consumer.accept( T t )
	    // (t)->{return}
	    // boolean java.util.function.Predicate.test( T t )
	    sarr.filter(  t->  t%2 !=0    )   // 홀수필터링
	    	.distinct()                   // 중복제거    153
	    	.sorted()					  // 정렬       135
	    	.limit(2)                     // 갯수 제한   13
	    	.skip(1)                      // skip      3
	    	.forEach( System.out::print );  //3단계 최종연산  
	    
	    System.out.println();
	    
	    slist.filter(  t->  t%2 !=0    )   // 홀수필터링
	    	.distinct()                   // 중복제거    153
	    	.sorted()					  // 정렬       135
	    	.limit(2)                     // 갯수 제한   13
	    	.skip(1)                      // skip      3
	    	.forEach( System.out::print );  
	  
	    
	    
	} 
}




