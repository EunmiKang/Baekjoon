package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 연속합 */

public class Baekjoon_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		br.close();
		
		int[] numbers = new int[n];
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}
		
		int[] DP = new int[n];
		DP[0] = numbers[0];
		int max = DP[0];
		for(int i=1; i<n; i++) {
			DP[i] = Math.max(numbers[i], DP[i-1]+numbers[i]);
			
			max = Math.max(max, DP[i]);
		}
		System.out.println(max);
	}
}
