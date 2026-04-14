package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Total {
	public static void main(String[] args) {
		
	    String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    int[] rank = new int[5];
	    int count = 5;
	    int x = 0;
	    String[] pass = new String[5];
	    String[] jang = new String[5];

	    for(int i=0; i<name.length; i++) { aver[i] = (kor[i]+eng[i]+mat[i])/3; }
	    
	    for(int i=0; i<aver.length; i++) { 
	    	pass[i] = aver[i] < 60 ? "불합격" 
	      : kor[i] < 40 || eng[i] < 40 || mat[i] < 40 ? "재시험" : "합격";}
	    
	    for(int i=0; i<aver.length; i++) {jang[i] = aver[i] >= 95 ? "장학생" : "----";}
	    
	    for(int i=0; i<aver.length; i++) {
	    	count = 5;
	    	for(int j=0; j<aver.length; j++) {
	    		if(aver[i] > aver[j] && i != j) {count--;}
	    	}
	    	rank[i] = count;
	    }
	    
	    System.out.println(Arrays.toString(rank));
	    
	    System.out.printf("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹\n");
		for(int i=0; i<name.length; i++) {
			  System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t"
					  ,name[i],kor[i],eng[i],mat[i],aver[i],rank[i],pass[i],jang[i]);
			  for(int j=0; j<(aver[i]/10); j++) {
				System.out.print("*");  
			  }
			  System.out.println();
		}
	}

}
