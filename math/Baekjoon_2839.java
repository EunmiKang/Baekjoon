package math;

import java.util.Scanner;

/* ���� ��� */

public class Baekjoon_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();

		switch(N%5) {
		case 0:
			System.out.println(N/5);
			break;
		case 1:
		case 3:
			System.out.println(N/5 + 1);	// 1�� ���� ( N/5 - 1 ) + 2
			break;
		case 2:
		case 4:
			if((N == 4) || (N == 7))
				System.out.println("-1");
			else 
				System.out.println(N/5 + 2);	// 2�� ���� ( N/5 - 2 ) + 4 , 4�� ���� ( N/5 - 1 ) + 3
			break;
		}
	}
}
