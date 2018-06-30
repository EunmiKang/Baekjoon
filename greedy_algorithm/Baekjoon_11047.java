package greedy_algorithm;

import java.util.Scanner;

/* 동전 0 */

public class Baekjoon_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;	//K원을 만드는 데 필요한 동전 개수의 최소값
	
		int N = sc.nextInt();	// 동전 종류 수 ( 1 <= N <= 10 )
		int K = sc.nextInt();	// 동전들을 이용해 만들 합 ( 1 <= K <= 100,000,000 )
		int[] A = new int[N];	// 동전들의 가치를 담을 배열
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=N-1; i>=0; ) {	// 가치가 큰 동전부터 확인
			if(A[i] <= K) {
				result++;	// 동전 갯수 추가
				K = K-A[i];
			} else {
				i--;
			}
		}
		
		System.out.println(result);
	}
}
