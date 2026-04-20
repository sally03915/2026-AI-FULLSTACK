package std.v3;
 

import java.util.Arrays;
import java.util.Scanner;

public class Bank_v3_최다영 {
   static String[] id = new String[3];
   static String[] pass = new String[3];
   static double[] balance = new double[3];
   static int menu = -1;
   static Scanner scanner = new Scanner(System.in);

   ////////////////////////////////////////////////////
   // 1. 메뉴판을 기능
   // 2. 유저 빈칸찾기 기능
   // 3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
   // 4. 계좌추가기능
   // 5. 조회기능
   // 6. 입금기능
   // 7. 출금기능
   // 8. 삭제기능
   ////////////////////////////////////////////////////

   // ※ 옵션
   public static void showmenu() { // 1.메뉴판
      System.out.println(Arrays.toString(id));
      System.out.println(Arrays.toString(pass));
      System.out.println(Arrays.toString(balance));
      System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
            + "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n" + "👉 번호를 선택하세요:");}
   
   public static int user() { // 2.유저 빈칸찾기
      for (int i = 0; i < id.length; i++) {
         if (id[i] == null) {
            return i;}}
              return -1;}
             
   public static int login() {// 3.사용자 인증기능
      String tempid, temppass;
      System.out.print("아이디  입력 > ");
      tempid = scanner.next();
      System.out.print("비밀번호 입력 > ");
      temppass = scanner.next();

      for (int i = 0; i < id.length; i++) {
         if (id[i] != null && id[i].equals(tempid) && pass[i].equals(temppass)) {
            return i;}}
      System.out.println("정보확인해주세요.");
              return -1;}
   
   public static void add(int find) {// 4.계좌추가기능
      System.out.print("아이디  입력 > ");
      String tempid = scanner.next();
      System.out.print("비밀번호 입력 > ");
      String temppass = scanner.next();
      System.out.print("잔액    입력 > ");
      Double tempbalance = scanner.nextDouble();
      id[find] = tempid;
      pass[find] = temppass;
      balance[find] = tempbalance;}

   public static void view(int find) { // 5.조회기능
      System.out.println("ID : " + id[find]);
      System.out.println("PASS : " + pass[find]);
      System.out.println("balance : " + balance[find]);}

   public static void addbalance(int find) {// 6.입금기능
      System.out.print("입금할 금액 > ");
      double money = scanner.nextDouble();
      balance[find] += money;}
   
   public static void Withdrawal(int find) { // 7.출금기능
      System.out.print("출금할 금액 > ");
      double tempbalance = scanner.nextDouble();
      System.out.println(tempbalance > balance[find] ? "잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (balance[find] -= tempbalance));}

   public static void delete(int find) { // 8.삭제기능
      System.out.print("계좌삭제 (Y/N) > ");
      char again = scanner.next().charAt(0);
      if (again == 'Y' || again == 'y') {
         id[find] = null;
         pass[find] = null;
         balance[find] = 0;} }
   
   public static void main(String[] args) {
      
           while (menu != 9) {
           showmenu(); //메뉴판
           menu = scanner.nextInt();
             if (menu == 9) {
            System.out.println("프로그램을 종료합니다.");}
         else if (menu == 1) 
            {int find = user(); //빈칸찾기
            if (find == -1) {
               System.out.println("가입불가");continue;}
            add(find);} //계좌추가
         else if (menu >= 2 && menu <= 5) {
            int find = login(); //사용자 인증기능
            if (find == -1) {
               System.out.println("정보확인해주세요.");continue;} 
            switch (menu) {
            case 2: view(find); break; //조회기능
            case 3: addbalance(find); break; //입금기능
            case 4: Withdrawal(find); break; //출금기능
            case 5: delete(find); break; /*삭제기능*/}/*switch*/  }/*menu2~5*/ }//while
   }

}
