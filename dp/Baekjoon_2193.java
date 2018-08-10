package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 이친수 */

public class Baekjoon_2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//N자리
		br.close();
		
		/* 틀렸다고 뜨는데 이유를 모르겠음(정답으로 채점된 코드와 비교했을 때 출력 모두 같음)
		long[][] D = new long[N+1][2];	// 각각 끝자리 0의 개수와 1의 개수 저장
		D[1][1] = 1;          
		for(int i=2; i<=N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];	//끝자리 0의 개수
			D[i][1] = D[i-1][0];				//끝자리 1의 개수
		}
		System.out.println(D[N][0] + D[N][1]);
		*/
		
		long dp[] = new long[N+1]; 
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<dp.length; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[N]);    
	}
}