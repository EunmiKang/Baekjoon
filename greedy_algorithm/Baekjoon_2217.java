package greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 로프 */

public class Baekjoon_2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		for(int i=0; i<ropes.length; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		Arrays.sort(ropes);
		
		int max = ropes[ropes.length-1];
		for(int i=ropes.length-2; i>=0; i--) {
			if(max < ropes[i]*(ropes.length-i))
				max = ropes[i]*(ropes.length-i);
		}
		System.out.println(max);
	}
}
