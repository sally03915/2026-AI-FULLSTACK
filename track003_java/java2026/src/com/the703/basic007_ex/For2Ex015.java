package com.the703.basic007_ex;

public class For2Ex015 {
    public static void main(String[] args) {
        int n = 5; // 전체 폭
        int mid = n / 2; // 중앙 기준

        for (int i = 0; i < n; i++) {
            int row = i <= mid ? i : n - 1 - i; // 위쪽은 i, 아래쪽은 대칭
            for (int j = 0; j < n; j++) {
                System.out.print((row <= j && j < n - row) ? "#" : " ");
            }
            System.out.println();
        }
    }
}

/*
#####
 ###
  #
 ###
#####
*/