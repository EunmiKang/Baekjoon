package greedy_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 동전 0
 *
 */
public class Main11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 입력 */
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);	//동전 종류 개수
		int K = Integer.parseInt(line[1]);	//만들려는 합
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine().trim());
		} //동전 가치 배열 초기화	
		br.close();
		
		/* 문제 풀이 */
		int result = getResult(K, A);
		
		/* 출력 */
		System.out.println(result);
	}
	
	private static int getResult(int K, int[] A) {
		int result = 0;
		
		/*
		 * A: 오름차순으로 정렬되어 있음
		 * -> 합 K를 만드는데 필요한 동전 개수를 최소로 하기 위해서는
		 *    가치가 큰 동전부터 처리해야겠죠?
		 */
		for(int i=A.length-1; i>=0; i--) {
			result += K / A[i];
			K %= A[i];
		}
		
		return result;
	}
	
	private static int getResult2(int K, int[] A) {
		int result = 0;
		
		for(int i=A.length-1; i>=0; ) {	// 가치가 큰 동전부터 확인
			if(A[i] <= K) {
				result++;	// 동전 갯수 추가
				K = K-A[i];
			} else {
				i--;
			}
		}
		
		return result;
	}
}
