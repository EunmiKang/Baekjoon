package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 안녕
 * ::
 * DP
 * dfs, 백트래킹
 *
 */
public class Main1535 {
	private static int max, N;
	private static int[] L, J;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 입력 처리 */
		N = Integer.parseInt(br.readLine()); // 사람의 수
		L = new int[N + 1];
		J = new int[N + 1];

		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			L[i] = Integer.parseInt(input[i-1]);
		}

		input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			J[i] = Integer.parseInt(input[i-1]);
		}
		br.close();

		/* simulation - DP방법과 dfs 방법 중 DP 방법이 시간 더 적게 나옴 */
		int max = dpSimulate();
		//dfsSimulate(1, 100, 0);
		
		/* 출력 */
		System.out.println(max);
	}

	public static int dpSimulate() {
		int[][] dp = new int[N + 1][100]; // N명의 사람, 최대 체력 99(100은 죽어서안됨!)

		for (int i = 1; i <= N; i++) {
			for (int l = 1; l < 100; l++) {
				if(L[i] > l) {
					dp[i][l] = dp[i-1][l];
				} else {
					//선택한거랑 안한 거 중에 값 더 큰거 고르기!
					dp[i][l] = Math.max(dp[i-1][l], J[i] + dp[i-1][l-L[i]]);
				}
			}
		}

		return dp[N][99];
	}
	
	public static void dfsSimulate(int depth, int life, int joy) {
		if(depth > N) {	//종료 조건
			max = Math.max(max, joy);
			return;
		}
		
		//depth번째 선택 안한 거
		dfsSimulate(depth+1, life, joy);
		
		//depth번째 선택해볼까
		if(life - L[depth] <= 0) {	//백트래킹
			max = Math.max(max, joy);
			return;
		}
		dfsSimulate(depth+1, life - L[depth], + joy + J[depth]);
	}
}
