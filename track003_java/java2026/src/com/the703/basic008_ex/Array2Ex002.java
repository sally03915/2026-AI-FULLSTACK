package com.the703.basic008_ex;

public class Array2Ex002 { 
	public static void main(String[] args) {
		int [][] arr = new int [2][3];
		
		//		1. new 연산자 이용하여 다차원배열만들기
		//		2. for + length 이용해서 대입   
		//		3. for + length 이용해서 출력 
		//		   101   102   103
		//		   104   105   106  
		
		//		   101   102   103
		//		   201   202   203
		
		int data = 101;
		//		arr[0][0] = data++;    arr[0][1] = data++;  arr[0][2] = data++;
		//		arr[1][0] = data++;    arr[1][1] = data++;  arr[1][2] = data++;
		
		for(int ch=0; ch<arr.length; ch++ , data=201) { //1) 아파트.length  (층)
			for(int kan=0; kan<arr[ch].length; kan++) {  //2) 아파트[층].length (칸) 
				arr[ch][kan] = data++;
			}
			//3) 각층이 끝나고 해야할일 
			//data=201;
		}
		  
		for(int ch=0; ch<arr.length; ch++) { //1) 아파트.length  (층)
			for(int kan=0; kan<arr[ch].length; kan++) {  //2) 아파트[층].length (칸)
				System.out.printf("%d\t", arr[ch][kan]);
			}
			//3) 각층이 끝나고 해야할일
			System.out.println();
		}
		
	} 
}


/*
연습문제2)  array
패키지명 : ccom.the703.basic008_ex
클래스명 :  Array2Ex002
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   101   102   103
   104   105   106  
*/