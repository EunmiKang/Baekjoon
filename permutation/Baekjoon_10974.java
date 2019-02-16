package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 모든 순열
 * ::
 * 순열
 * 
 */

public class Baekjoon_10974 {
	public static void DFS(int[] array, int N, int depth, String result) {
		if(depth == N) {	// 마지막 차례까지 다 봄
			System.out.println(result);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(array[i] == 1)
				continue;
			array[i] = 1;	// 방문
			DFS(array, N, depth+1, result + i + " ");
			array[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int[] array = new int[N+1];
		DFS(array, N, 0, "");
	}
}
