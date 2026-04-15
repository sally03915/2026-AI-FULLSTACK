package com.the703.days;

public class Test {
	public static void main(String[] args) {
		// 변수 + 입력
		int arr [] = new int[5];
		String name [] = { "아이언맨", "헐크", "캡틴", "토르", "호크아이" };
		int kor [] = { 100, 20, 90, 70, 35 };
		int eng [] = { 100, 50, 95, 80, 100 };
		int math [] = { 100, 30, 90, 60, 100 };
		int avg [] = new int[5];
		int top [] = new int[5]; // 등수
		String pnp [] = new String[5]; // 합격여부
		String j [] = new String[5]; // 장학생
		String rank [] = new String[] {"" , "", "", "", ""}; // 랭킹 (String : *)
		
		int data = 0;

		// 처리
		for (int i = 0; i < arr.length; i++) {
			avg[i] = (kor[i] + eng[i] + math[i]) / 3;
			pnp[i] = avg[i] < 60 ? "불합격" : "합격";
	    	j[i]   = avg[i] >= 95 ? "장학생" : "";
		}
		
		for (int i = 0; i < arr.length; i++) {	
//	    	rank[i] = (avg[i] / 10); // 랭킹
			//  1)   avg[i] / 10 갯수만큼    * 누적
			//  2)   for( 시작; avg[i] / 10 갯수만큼; 변화   ) {* 누적}
			for (int a = 0; a < 10; a++) {
				rank[i] += "*";
			}
			
			//	    	switch (avg[i]/10) { 
			//	            case 10: rank[i] = "**********"; break; 
			//	            case 9: rank[i] = "*********"; break; 
			//	            case 8: rank[i] = "********"; break; 
			//	            case 7: rank[i] = "*******"; break; 
			//	            case 6: rank[i] = "******"; break; 
			//	            case 5: rank[i] = "*****"; break; 
			//	            case 4: rank[i] = "****"; break; 
			//	            case 3: rank[i] = "***"; break; 
			//	            case 2: rank[i] = "**"; break; 
			//	            case 1: rank[i] = "*"; break;
			//	    	}
	    	
		}
		
		for (int i = 0; i < arr.length; i++) {		    	
	    	// 등수가 다른 등수보다 크면 n등
	        // 아이언맨100 헐크33 캡틴91 토르70 호크아이78
	        // 만약 (아이언맨 평균이 i보다 크면) { top은 n등 }
//	        if (avg[0] > avg[i]) { // 아이언맨
//	        	top[0] = n;
//	        	}
//	        if (avg[1] > avg[i]) { // 헐크
//                top[1] = n;
//	           }
//	        if (avg[2] > avg[i]) { // 캡틴
//	            top[2] = n;
//	           }
//	        if (avg[3] > avg[i]) { // 토르
//	            top[3] = n;
//	           }
//	        if (avg[4] > avg[i]) { // 호크아이
//	           top[4] = n;
//	           }
	           
	        for (int k = 0; k < arr.length; k++) {
	           //top[k] =
	           }
	    	
	    	arr[i] = data;
	    	data += 1;
	    	System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", name[i], kor[i], eng[i], math[i], avg[i], top[i], pnp[i], j[i], rank[i]);
		}

		System.out.println("이름\t국어\t영어\t수힉\t평균\t등수\t합격여부\t장학생\t랭킹");
		
	} 
}
