import java.util.Arrays;

public class Array3Total {

    public static void main(String[] args) {
        String[] name = {"아이언맨","헐크","캡틴","토르","호크아이"};
        int[] kor = {100,100,90,70,35};   
        int[] eng = {100,100,95,80,35};
        int[] mat = {100,100,90,60,35};
        
        int[] aver = new int[name.length];
        String[] hap = new String[name.length];
        String[] jang = new String[name.length];
        int[] rank = new int[name.length];

        // 1. 평균, 합격여부, 장학생 여부 계산
        for(int i=0; i<name.length; i++) {
            aver[i] = (kor[i] + eng[i] + mat[i]) / 3;
            hap[i] = aver[i] >= 60 ? "합격" : "불합격";
            jang[i] = aver[i] >= 95 ? "장학생" : "----";
        }

        // 2. 등수 계산 (동점자 동일 등수, 다음은 이어서 증가)
        // 평균과 인덱스를 함께 저장
        Integer[] idx = new Integer[name.length];
        for(int i=0; i<idx.length; i++) idx[i] = i;

        // 내림차순 정렬
        Arrays.sort(idx, (a,b) -> aver[b] - aver[a]);

        int currentRank = 1;
        rank[idx[0]] = currentRank;
        for(int i=1; i<idx.length; i++) {
            if(aver[idx[i]] == aver[idx[i-1]]) {
                // 동점자 → 같은 등수
                rank[idx[i]] = currentRank;
            } else {
                // 새로운 점수 → 등수 증가
                currentRank++;
                rank[idx[i]] = currentRank;
            }
        }

        // 3. 출력
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        for(int i=0; i<name.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d등\t%s\t%s\t",
                name[i], kor[i], eng[i], mat[i], aver[i], rank[i], hap[i], jang[i]);
            for(int j=0; j<(aver[i]/10); j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }
}
