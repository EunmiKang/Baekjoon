package greedy_algorithm;

import java.util.Scanner;

/* ���� 0 */

public class Baekjoon_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;	//K���� ����� �� �ʿ��� ���� ������ �ּҰ�
	
		int N = sc.nextInt();	// ���� ���� �� ( 1 <= N <= 10 )
		int K = sc.nextInt();	// �������� �̿��� ���� �� ( 1 <= K <= 100,000,000 )
		int[] A = new int[N];	// �������� ��ġ�� ���� �迭
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=N-1; i>=0; ) {	// ��ġ�� ū �������� Ȯ��
			if(A[i] <= K) {
				result++;	// ���� ���� �߰�
				K = K-A[i];
			} else {
				i--;
			}
		}
		
		System.out.println(result);
	}
}
