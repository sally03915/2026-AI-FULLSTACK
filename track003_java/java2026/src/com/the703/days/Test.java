package com.the703.days;

public class Test {
	public static void main(String[] args) {
		
		int [] [] arr = new int [5] [5];
        int result1 [] [] = new int [5] [5];
        int result2 [] [] = new int [5] [5];
        int result3 [] [] = new int [5] [5];
        int num=1;
        
        for(int i=0; i<arr.length; i++) {
        for( int a=0; a<arr[i].length; a++) {
              arr[i][a]=num++;   }}//arr배열에 1~25넣기
        
     
        
        for(int i=0; i<5; i++) {
        for(int j=0; j<5; j++) {
              result1[j][4-i]=arr[i][j];//90도 회전
              result2[4-j][i]=arr[i][j];//-90도 회전
              result3[4-i][4-j]=arr[i][j];} }//180도 회전
        
        for(int i=0; i<5; i++) {
           for(int j=0; j<5; j++) {
           System.out.print(result1[i][j]+"\t");//90도 회전 출력
            }System.out.println();} System.out.println();
        
        for(int i=0; i<5; i++) {
           for(int j=0; j<5; j++) {
           System.out.print(result2[i][j]+"\t");//-90도 출력
            }System.out.println();} System.out.println();
        
        for(int i=0; i<5; i++) {
           for(int j=0; j<5; j++) {
            System.out.print(result3[i][j]+"\t");//180도 회전 출력
             }System.out.println();} System.out.println();
        
     }
  }