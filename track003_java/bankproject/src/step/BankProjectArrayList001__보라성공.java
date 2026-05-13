package step;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import std.v4.Bank;

class BankInfo {
	private String id;
	private String pass;
	private double balance;

	public BankInfo() { super(); }
	public BankInfo(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance; }

	public String getId() { return id; }  public void setId(String id) { this.id = id; }
	public String getPass() { return pass; }  public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; }  public void setBalance(double balance) { this.balance = balance; }

	// HashCode/ equals
}

class Bank {
	Scanner sc = new Scanner(System.in);
	List<BankInfo> list = new ArrayList<>();

	public void showMenu() {
		System.out.println("WELCOME TO BANK SYSTEM");
		System.out.println("======BANK======");
		System.out.println("[1] ➕계좌추가");
		System.out.println("[2] 🔍계좌조회");
		System.out.println("[3] 💵계좌입금");
		System.out.println("[4] 💸계좌출금");
		System.out.println("[5] 🗑️계좌삭제");
		System.out.println("[9] ⛔종료");
		System.out.print("👉 번호를 선택하세요 : ");
	}

	public void addBankInfo() {
		System.out.print("ID 입력: ");
		String id = sc.next();
		System.out.print("PASS 입력: ");
		String pass = sc.next();
		System.out.print("금액 입력: ");
		double balance = sc.nextDouble();
		list.add(new BankInfo(id, pass, balance));
	}

	public BankInfo ahthUser() {
		System.out.print("ID 입력: ");
		String inputId = sc.next();
		System.out.print("PASS 입력: ");
		String inputPass = sc.next();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(inputId) && list.get(i).getPass().equals(inputPass)) {
				return (BankInfo) list.get(i);
			}
		}
		System.out.println("계좌를 찾을 수 없습니다.");
		return null;
	}

	public void showBankInfo(BankInfo bankInfo) {
//		BankInfo bankInfo = this.ahthUser();
//
//		if (bankInfo != null) {
			System.out.println("BALANCE : " + bankInfo.getBalance());
			System.out.println("BALANCE : " + bankInfo.getBalance());
			System.out.println("BALANCE : " + bankInfo.getBalance());
//		}

	}

	public void deposit(BankInfo bankInfo) {
		double inputBalance = 0;
//		BankInfo bankInfo = this.ahthUser();
//
//		if (bankInfo != null) {
			System.out.print("금액 입력 : ");
			inputBalance = sc.nextDouble();
			bankInfo.setBalance(bankInfo.getBalance() + inputBalance);
			System.out.println("잔액 : " + bankInfo.getBalance());
//		}
	}

	public void Withdrawal(BankInfo bankInfo) {
		double inputBalance = 0;

//		BankInfo bankInfo = this.ahthUser();
//		if (bankInfo != null) {
			System.out.print("금액 입력 : ");
			inputBalance = sc.nextDouble();
			bankInfo.setBalance(bankInfo.getBalance() - inputBalance);
			System.out.println("잔액 : " + bankInfo.getBalance());
//		}
	}

	public void removeBankInfo(BankInfo bankInfo) {
//		BankInfo bankInfo = this.ahthUser();
//		if (bankInfo != null) {
			list.remove(bankInfo);
			System.out.println("계좌가 삭제되었습니다.");
//		}
	}
}

public class BankProjectArrayList001__보라성공 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;

		Bank bank = new Bank();

		while (num != 9) {

			bank.showMenu();
			num = sc.nextInt();

			if (num == 9) { System.out.println("종료기능입니다."); }
			else if (num == 1) { bank.addBankInfo(); }   //## 아이디중복검사추가 
			else {
				BankInfo bankInfo = bank.ahthUser();
				if (bankInfo == null) {  System.out.println("유저정보를 확인"); continue;  }
				
				switch (num) {
				case 2:
					bank.showBankInfo(bankInfo);
					break;
				case 3:
					bank.deposit(bankInfo);
					break;
				case 4:
					bank.Withdrawal(bankInfo);
					break;
				case 5:
					bank.removeBankInfo(bankInfo);
					break;
				}

			}

		}

	}

}
