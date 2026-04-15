package com.the703.basic008;

import java.util.Arrays;

public class Arr2001 {
	public static void main(String[] args) {
		int [][] arr2 = {
				{1,2,3} , //00 01 02
				{4,5,6} , //10 11 12
		};

		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//ver-1 눈에 보이는대로
		System.out.print(arr2[0][0]+"\t");
		System.out.print(arr2[0][1]+"\t");
		System.out.print(arr2[0][2]+"\t");   System.out.println();
		
		System.out.print(arr2[1][0]+"\t");
		System.out.print(arr2[1][1]+"\t");
		System.out.print(arr2[1][2]+"\t");   System.out.println();
		
		System.out.println();
		System.out.println();
		
		//ver-2 칸정리
		for(int kan=0; kan<=2; kan++){  System.out.print(arr2[0][kan]+"\t");   }
		System.out.println();
		
		for(int kan=0; kan<=2; kan++){ System.out.print(arr2[1][kan]+"\t");    }
		System.out.println();
		
		System.out.println();
		System.out.println();
		
		//ver-3 층정리
		for(int ch=0; ch<=1; ch++){
			for(int kan=0; kan<=2; kan++){ System.out.print(arr2[ch][kan]+"\t");    }
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//ver-4 length 이용
		// 배열명(아파트).length 층  / 배열명[0](층).length
		for(int ch=0; ch<arr2.length; ch++){  // 아파트의 층수
			for(int kan=0; kan< arr2[ch].length; kan++)  // 층의 칸수
			{ System.out.print(arr2[ch][kan]+"\t");    }
			
			System.out.println();
		}
	}
}
