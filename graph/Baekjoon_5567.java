package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 결혼식 */

public class Baekjoon_5567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	//상근이의 동기 수
		int m = Integer.parseInt(br.readLine());	//리스트의 길이
		boolean[][] relation = new boolean[n+1][n+1];
		boolean[] selected = new boolean[n+1];
		for(int i=0; i<m; i++) {
			String[] input = br.readLine().split(" ");
			relation[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
		}
		br.close();
		
		int count = 0;
		for(int i=2; i<n+1; i++) {
			if(relation[1][i] || relation[i][1]) {
				if(!selected[i]) {
					count++;
					selected[i] = true;
				}
				for(int j=2; j<n+1; j++) {
					if((i != j) && (relation[i][j] || relation[j][i]) && !selected[j]) {
						count++;
						selected[j] = true;
					}
				}
			}
		}
		System.out.println(count);
	}
}
