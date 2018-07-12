package dp;

import java.util.Scanner;

/* 피보나치 함수 */

public class Baekjoon_1003 {
	public static int[][] D = new int[3][41];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* Top-down 방식
		D[0][0] = 1;
		D[1][1] = 1;
		fibonacci(40);
		*/
		
		/* Bottom-up 방식 */
		D[0][0] = 1;
		D[1][1] = 1;
		D[2][1] = 1;
		for(int i=2; i<41; i++) {
			D[0][i] = D[0][i-1] + D[0][i-2];
			D[1][i] = D[1][i-1] + D[1][i-2];
			D[2][i] = D[2][i-1] + D[2][i-2];
		}
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			System.out.println(D[0][N] + " " + D[1][N]);
		}
		
		sc.close();
	}
	
	/* Top-down 방식 */
	/*
	public static int fibonacci(int N) {
		if(N==0) {
			return 0;
		} else if(N==1) {
			return 1;
		} else {
			int result = fibonacci(N-1) + fibonacci(N-2);
			D[0][N] = D[0][N-1] + D[0][N-2];
			D[1][N] = D[1][N-1] + D[1][N-2];
			return result;
		}
	}
	*/
}
