package brute_force;

import java.util.Scanner;

/* �Ѽ� */

public class Baekjoon_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		sc.close();

		if (X < 100) { // 1~99�� ��� �Ѽ�
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

	public static boolean isHanNum(int n) {	// n:���ڸ���
		int hundreds = n/100;
		int tens = (n/10)%10;
		int units = n%10;
		System.out.println(hundreds + "" + tens + "" + units);
		return (units - tens) == (tens - hundreds);
	}
}
