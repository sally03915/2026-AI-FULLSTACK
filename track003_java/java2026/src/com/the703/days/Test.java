package com.the703.days;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class IceCreamDto{
   String name;
   int price;
   public IceCreamDto() { super(); }
   public IceCreamDto(String name, int price) { super(); this.name = name; this.price = price; }
   public IceCreamDto(String name){this();  this.name = name;}
   public IceCreamDto(int price) {this(); this.price = price;  }
   @Override
   public String toString() { return " " + name + "(" + price + "원) " ; }
   public String getName() { return name; }  public void setName(String name) { this.name = name; }
   public int getPrice() { return price; }  public void setPrice(int price) { this.price = price; }
   @Override public int hashCode() { return Objects.hash(name); }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      IceCreamDto other = (IceCreamDto) obj;
      return Objects.equals(name, other.name);
   }   
}

public class Test {
   public static void main(String[] args) {
      String name="";
      int price=0,choice=-1;
      List<IceCreamDto> ice = new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      for(;;) 
      {
         System.out.println("❄️🍦 Welcome to the Magical IceCream Land 🍦❄️\n"+
           "✨ 오늘도 달콤한 하루가 시작됩니다! ✨\n"+"🛎️ 손님~ 어떤 아이스크림을 원하시나요?\n"
               +"--------------------------------------------------");
         System.out.println("🍧 IceCream Menu 🍧");
         System.out.println("1️ 아이스크림 추가");
         System.out.println("2️ 아이스크림 목록 보기");
         System.out.println("3️ 아이스크림 제거");
         System.out.println("4️ 아이스크림 존재 확인");
         System.out.println("5️ 총 아이스크림 개수");
         System.out.println("0️ 종료");
         System.out.println("👉 선택:");
         choice = sc.nextInt();
              if(choice ==1){System.out.println("🍓 아이스크림 이름:");name=sc.next();
                             System.out.println("💰 가격:"); price = sc.nextInt();
                             ice.add(new IceCreamDto(name,price));}
         else if(choice ==2){System.out.println("🍨 현재 아이스크림 목록:");
                           System.out.println(ice);}
         else if(choice ==3){System.out.println("🗑️ 제거할 아이스크림 이름:"); String name2 = sc.next();
                            if(ice.remove((new IceCreamDto(name2))))  {System.out.println("🧹제거 완료!");  ; }
                            else {System.out.println("🧹제거 실패!");}}
         else if(choice ==4){System.out.println("🔍 확인할 아이스크림 이름:"); String name3 = sc.next();
                            if(ice.contains(new IceCreamDto(name3))) {System.out.println("✅ 존재합니다!");}
                                         else {System.out.println("❌ 없습니다!");}}
         else if(choice ==5){System.out.println("📦 총 아이스크림 개수:"+ice.size());}
         else if(choice ==0){System.out.println("👋 아이스크림 가게를 닫습니다. 다음에 또 만나요!");break;}
         else {System.out.println("선택오류");}
      }

   }

}
