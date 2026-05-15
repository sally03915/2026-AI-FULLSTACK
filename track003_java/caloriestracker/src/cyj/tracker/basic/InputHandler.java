package cyj.tracker.basic;

import java.util.Scanner;

class TooManyIterationsException extends RuntimeException {
	public TooManyIterationsException(String message) {
        super(message);
    }
}

public class InputHandler {
	private static int MAX_NUM = 10;
	private static Scanner scan = new Scanner(System.in);

	public int getInt(String inputMsg) {
		int num = 0;
		while (true) {
			try {
				System.out.print(inputMsg);
				String input = scan.nextLine();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
			if(num >= MAX_NUM) {
				throw new TooManyIterationsException("너무 많은 잘못된 시도로 인해 중단합니다.");
			}
			num++;
		}
	}

	public long getLong(String inputMsg) {
		int num = 0;
		while (true) {
			try {
				System.out.print(inputMsg);
				String input = scan.nextLine();
				return Long.parseLong(input);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
			if(num >= MAX_NUM) {
				throw new TooManyIterationsException("너무 많은 잘못된 시도로 인해 중단합니다.");
			}
			num++;
		}
	}
	
	public double getDouble(String inputMsg) {
		int num = 0;
		while (true) {
			try {
				System.out.print(inputMsg);
				String input = scan.nextLine();
				return Double.parseDouble(input);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
			if(num >= MAX_NUM) {
				throw new TooManyIterationsException("너무 많은 잘못된 시도로 인해 중단합니다.");
			}
			num++;
		}
	}

	public String getString(String inputMsg) {
		System.out.print(inputMsg);
		return scan.nextLine();
	}
}
