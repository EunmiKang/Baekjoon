package greedy_algorithm;

/* ATM */

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		int N = sc.nextInt();	// 사람 수
		int[] P = new int[N];	// 각 사람이 돈을 인출하는데 걸리는 시간을 담을 배열
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