package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 이친수 */

public class Baekjoon_2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		long[][] D = new long[N+1][2];	// 각각 끝자리 0의 개수와 1의 개수 저장
		D[1][1] = 1;          
		for(int i=2; i<=N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];	//끝자리 0의 개수
			D[i][1] = D[i-1][0];				//끝자리 1의 개수
		}
		System.out.println(D[N][0] + D[N][1]);
	}
}