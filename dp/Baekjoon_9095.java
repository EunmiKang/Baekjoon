package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1,2,3 더하기 */

public class Baekjoon_9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int D[] = new int[11];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for(int i=4; i<11;i++) {
			D[i] = D[i-3] + D[i-2] + D[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(D[N]);
		}
		br.close();
 	}
}
