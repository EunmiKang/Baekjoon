package greedy_algorithm;

/* ATM */

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		int N = sc.nextInt();	// ��� ��
		int[] P = new int[N];	// �� ����� ���� �����ϴµ� �ɸ��� �ð��� ���� �迭
		for(int i=0; i<N; i++) {
			P[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(P);
		
		for(int i=0; i<N; i++) {
			result += (N-i) * P[i];
		}

		System.out.println(result);
	}

}
