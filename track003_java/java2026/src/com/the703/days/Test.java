package com.the703.days;

public class Test {
	public static void main(String[] args) {
		int arr[] = new int[5];
		String name[] = { "아이언맨", "헐크", "캡틴", "토르", "호크아이" };
		int kor[] = { 100, 20, 90, 70, 35 };
		int eng[] = { 100, 50, 95, 80, 100 };
		int math[] = { 100, 30, 90, 60, 100 };
		int avg[] = new int[5];
		int top[] = new int[] {1,1,1,1,1}; // 등수
		String pnp[] = new String[5]; // 합격여부
		String j[] = new String[5]; // 장학생
		String rank[] = new String[] { "", "", "", "", "" }; // 랭킹 (String : *)

		int data = 0;

		for (int i = 0; i < arr.length; i++) {
			avg[i] = (kor[i] + eng[i] + math[i]) / 3;
			pnp[i] = avg[i] < 60 ? "불합격" : "합격";
			j[i] = avg[i] >= 95 ? "장학생" : "";
		}

		// 1) avg[i] / 10 갯수만큼 * 누적
		// 2) for( 시작; avg[i]/10갯수만큼; 변화 ) {* 누적}
		for (int i = 0; i < arr.length; i++) {
			for (int a = 0; a < avg[i] / 10; a++) {
				rank[i] += "*";
			}
		}

		// 등수 top ...
		// 아이언맨의 평균점수가 헐크평균점수보다 작다면 top[0] += 1;d
		 if(avg[0] < avg[0]) { top[0] += 1; }
		 if(avg[0] < avg[1]) { top[0] += 1; }
		 if(avg[0] < avg[2]) { top[0] += 1; }
		 if(avg[0] < avg[3]) { top[0] += 1; }
		 if(avg[0] < avg[4]) { top[0] += 1; }
		 
		 if(avg[1] < avg[0]) { top[1] += 1; }
		 if(avg[1] < avg[1]) { top[1] += 1; }
		 if(avg[1] < avg[2]) { top[1] += 1; }
		 if(avg[1] < avg[3]) { top[1] += 1; }
		 if(avg[1] < avg[4]) { top[1] += 1; }

		 
		 
		System.out.println("이름\t국어\t영어\t수힉\t평균\t등수\t합격여부\t장학생\t랭킹");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = data;
			data += 1;
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", name[i], kor[i], eng[i], math[i], avg[i], top[i],
					pnp[i], j[i], rank[i]);
		}

	}
}