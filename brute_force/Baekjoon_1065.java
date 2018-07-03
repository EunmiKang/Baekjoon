package brute_force;

import java.util.Scanner;

/* 한수 */

public class Baekjoon_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		sc.close();

		if (X < 100) { // 1~99는 모두 한수
			System.out.println(X);
		} else {
			int result = 99;

			for (int i = 100; i <= X; i++) {
				if (i == 1000)
					break;
				if (isHanNum(i))
					result++;
			}

			System.out.println(result);
		}
	}

	public static boolean isHanNum(int n) {	// n:세자리수
		int hundreds = n/100;
		int tens = (n/10)%10;
		int units = n%10;
		System.out.println(hundreds + "" + tens + "" + units);
		return (units - tens) == (tens - hundreds);
	}
}
