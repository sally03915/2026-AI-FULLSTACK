package std.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// DTO
class CafeDto {

    private String menuName;
    private int price;
    private int stock;
    private int soldCount;

    public CafeDto() { super(); }

    
    
    public CafeDto(String menuName) { super(); this.menuName = menuName; }



	public CafeDto(String menuName, int price, int stock, int soldCount) {
        super();
        this.menuName = menuName;
        this.price = price;
        this.stock = stock;
        this.soldCount = soldCount;
    }

    @Override
    public String toString() {
        return "[ menuName=" + menuName +
                ", price=" + price +
                ", stock=" + stock +
                ", soldCount=" + soldCount + " ]";
    }

    public String getMenuName() { return menuName; }
    public void setMenuName(String menuName) { this.menuName = menuName; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getSoldCount() { return soldCount; }
    public void setSoldCount(int soldCount) { this.soldCount = soldCount; }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CafeDto other = (CafeDto) obj;
        
        return Objects.equals(menuName, other.menuName);
    }
}

// Controller
class Cafe {
    List<CafeDto> menus;

    public Cafe() { super(); }
    public Cafe(List<CafeDto> menus) { super(); this.menus = menus; }

    Scanner sc = new Scanner(System.in);

    // 메뉴 출력
    public void menu() {
        System.out.print(
                "\n -- cafe menu --\n\n"
                        + "1. 메뉴 등록\r\n"
                        + "2. 전체 메뉴 확인\r\n"
                        + "3. 재고 확인 / 입고\r\n"
                        + "4. 메뉴 주문\r\n"
                        + "5. 메뉴 삭제\r\n"
                        + "6. 인기 음료 조회\r\n"
                        + "7. 관리자 로그인\r\n"
                        + "9. 종료"
                        + "\r\n>> 번호를 선택하세요: "
        );
    }

    // 메뉴 등록
    public void add() {
        String menuName; int price; int stock; int check = -1;
        System.out.print("메뉴명 : ");
        menuName = sc.next();

		//        for(int i=0; i<menus.size(); i++) {
		//            if(menuName.equals(menus.get(i).getMenuName())) {
		//                check = 1;
		//                break;
		//            }
		//        }

        if( menus.contains(new CafeDto(menuName))  ) {  System.out.println("메뉴가 확인해주세요");  return;  }
        
        if(check == -1) {
            System.out.print("가격 : ");
            price = sc.nextInt();
            do {
                System.out.print("재고 수량 : ");
                stock = sc.nextInt();
            } while(stock < 0);

            menus.add(new CafeDto(menuName, price, stock, 0));

            System.out.println("메뉴 등록 완료!");
        } else {
            System.out.println("이미 존재하는 메뉴입니다.");
        }
    }

    // 전체 메뉴 출력
    public void menuAll() {
        System.out.println("\n===== MENU =====");

        for(int i=0; i<menus.size(); i++) {
            CafeDto m = menus.get(i);

            System.out.print((i+1) + ". " + m.getMenuName() + " - " + m.getPrice() + "원");

            if(m.getStock() == 0) { System.out.print(" [품절]"); }
            System.out.println();
        }
    }

    // 메뉴 찾기
    public CafeDto findMenu(String name) {
        CafeDto find = null;

        for(int i=0; i<menus.size(); i++) {
            if(menus.get(i).getMenuName().equals(name)) {
                find = menus.get(i);
                break;
            }
        }
        return find;
    }

    // 재고 확인/입고
    public void stock() {
        System.out.print("메뉴명 : ");
        String name = sc.next();

        CafeDto find = findMenu(name);

        if(find == null) {
            System.out.println("메뉴가 없습니다.");
            return;
        }
        System.out.println( "현재 재고 : " + find.getStock());
        System.out.print( "입고하시겠습니까? (y/n) : ");
        char answer = sc.next().charAt(0);

        if(answer == 'y') {
            System.out.print("입고 수량 : ");
            int amount = sc.nextInt();

            find.setStock( find.getStock() + amount);
            System.out.println("입고 완료!");
            System.out.println( "현재 재고 : " + find.getStock());
        } else {
            System.out.println( "메뉴로 돌아갑니다.");
        }
    }

    // 주문
    public void order() {
        int total = 0;

        String orderList = "";

        while(true) {
            menuAll();

            System.out.print("\n주문 메뉴 : ");
            String name = sc.next();

            CafeDto find = findMenu(name);

            if(find == null) {
                System.out.println("존재하지 않는 메뉴입니다.");
                continue;
            }

            if(find.getStock() == 0) {
                System.out.println(find.getMenuName() + " - 품절입니다. 다른 메뉴를 선택해주세요.");

                continue;
            }

            System.out.print("수량 : ");
            int amount = sc.nextInt();

            if(amount > find.getStock()) {
                System.out.println("재고 부족");
                continue;
            }

            // 재고 감소
            find.setStock(find.getStock() - amount);
            // 판매량 증가
            find.setSoldCount(find.getSoldCount() + amount);
            // 총 가격 누적
            total += (find.getPrice() * amount);
            // 주문 내역 저장
            orderList += find.getMenuName() + " " + amount + "잔\n";

            System.out.print( "추가 주문 하시겠습니까? (y-주문계속/n-결제/e-주문취소) : ");
            char answer = sc.next().charAt(0);

            if(answer == 'y') {
                continue;

            } else if(answer == 'e') {
                System.out.println("주문 취소");
                return;

            } else if(answer == 'n') {
                break;
            }
        }

        System.out.println("\n===== 주문 내역 =====");
        System.out.println(orderList);

        System.out.println("총 결제 금액 : " + total + "원");
    }

    // 메뉴 삭제
    public void delete() {
        System.out.print("삭제 메뉴명 : ");
        String name = sc.next();

        CafeDto find = findMenu(name);

        if(find == null) {
            System.out.println("메뉴가 없습니다.");
            return;
        }
        System.out.print( "메뉴를 삭제하시겠습니까? (y/n) : ");
        char answer = sc.next().charAt(0);

        if(answer == 'y') {
            menus.remove(find);
            System.out.println( "메뉴 삭제 완료!");
        } else {
            System.out.println( "삭제 취소");
        }
    }

    // 인기 음료
    public void bestdrink() {
        if(menus.size() == 0) {
            System.out.println("등록된 메뉴가 없습니다.");
            return;
        }
        CafeDto best = menus.get(0);

        for(int i=1; i<menus.size(); i++) {
            if(best.getSoldCount() < menus.get(i).getSoldCount()) {
                best = menus.get(i);
            }
        }
        // 전부 판매량 0일 경우
        if(best.getSoldCount() == 0) {
            System.out.println( "\n현재 판매된 음료가 없습니다.");
            return;
        }
        System.out.println("\n🔥 인기 음료\n" + best.getMenuName() + "\n판매량 : " + best.getSoldCount() + "잔");
    }

    // 관리자 회원가입
    public String[] admin() {
        String[] admin = new String[2];
        
        System.out.println("\n회원가입---");
        System.out.print("관리자 아이디 : ");
        admin[0] = sc.next();

        System.out.print("관리자 비밀번호 : ");
        admin[1] = sc.next();

        System.out.println("관리자 회원가입 완료!");

        return admin;
    }

    // 관리자 로그인
    public boolean mlogin(String adminId, String adminPw) {
        String id;
        String pw;

        System.out.println("\n로그인---");
        System.out.print("아이디 : ");
        id = sc.next();

        System.out.print("비밀번호 : ");
        pw = sc.next();

        if(id.equals(adminId) && pw.equals(adminPw)) {
            System.out.println("로그인 성공!");
            return true;
        }
        System.out.println("로그인 실패");

        return false;
    }
    
    public boolean adminCheck(String[] adminInfo) {
        // 회원가입 안된 경우
        if(adminInfo[0] == null || adminInfo[1] == null) {
            System.out.println("회원가입이 필요합니다.");

            String[] admin = admin();

            adminInfo[0] = admin[0];
            adminInfo[1] = admin[1];
        }
        // 로그인 진행
        return mlogin(
                adminInfo[0],
                adminInfo[1]);
    }
}

// Main
public class Cafe_Manage_ver3 {
    public static void main(String[] args) {
        List<CafeDto> menus = new ArrayList<>();
        Cafe controller = new Cafe(menus);
        Scanner sc = new Scanner(System.in);

        int menu = -1;   boolean login = false;
        String[] adminInfo = new String[2];

        System.out.println( "\n 🌟☕ Welcome To Cafe ☕🌟\n");
        while(menu != 9) {
            controller.menu();
            menu = sc.nextInt();

            // 종료
            if(menu == 9) {
                System.out.println("프로그램 종료");
            }
			// 로그인 체크 
            else if (menu == 1 || menu == 3 || menu == 5) {
				if (!login) {
					System.out.println("관리자 로그인이 필요합니다.");
					login = controller.adminCheck(adminInfo);
					continue;
				}
				if(login) {
					switch(menu) {  
			        case 1: controller.add(); break;	// 메뉴 등록
			        case 3: controller.stock(); break;  // 재고 확인 / 입고
			        case 5: controller.delete(); break; // 메뉴 삭제
					}
				}
			}
          
            // 전체 메뉴 확인
            else if(menu == 2) {
                controller.menuAll();
            }
            // 주문
            else if(menu == 4) {
                controller.order();
            }
            // 인기 음료
            else if(menu == 6) {
                controller.bestdrink();
            }
            // 관리자 로그인
            else if(menu == 7) {
            	if(login) {
                    System.out.println( "이미 로그인하셨습니다.");
                } else {
                    login = controller.adminCheck(adminInfo);
                }
            }
            else {
            	System.out.println("잘못된 번호 입력");
            }
        }
    }
}