package com.the703.basic008;

import java.util.Arrays;

public class Arr002 {
	public static void main(String[] args) {
		// 배열
		// [같은타입]의 데이터 [연속된 공간에] 저장하는 자료구조
		// arr(1000번지) =   1000번지{1,2,3}  ★만드는거와 동시에 값넣기
		int [] arr= {1,2,3};  //arr 주소담을수 있어!
		int [] arr2 = new int[3];  // new 공간빌리기  int 형태의 자료형 몇개 ★ new
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));
		 
		// for  +  length 대입
		// ver-1  arr2[0] = 0;  		arr2[1] = 10;  		arr2[2] = 20;
		// ver-2
		//		int data = 0;
		// 		arr2[0] = data;  /* 0넣고  */		data+=10;  /* 10증가 */
		// 		arr2[1] = data;  /* 10넣고 */		data+=10;  /* 10증가 */
		// 		arr2[2] = data;  /* 20넣고 */        data+=10;  /* 10증가 */
 		// ver-3
				int data = 0;
		for(int i=0; i<arr2.length; i++){arr2[i] = data;       data+=10;}
		
		for(int i=0; i<arr2.length; i++) { System.out.print( arr2[i] + "\t" );  }
	}
}
