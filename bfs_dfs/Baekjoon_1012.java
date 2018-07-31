package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 유기농 배추 */

public class Baekjoon_1012 {
	public static int[][] field;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	//테스트케이스 수
		
		for(int i=0; i<T; i++) {
			String[] reads = br.readLine().split(" ");
			int M = Integer.parseInt(reads[0]);			//배추밭의 가로길이
			int N = Integer.parseInt(reads[1]);			//배추밭의 세로길이
			int K = Integer.parseInt(reads[2]);			//배추 개수
			field = new int[N][M];
			int count = 0;
			for(int j=0; j<K; j++) {
				reads = br.readLine().split(" ");
				field[Integer.parseInt(reads[1])][Integer.parseInt(reads[0])] = 1;
			}
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(field[j][k] == 1) {
						count++;
						filterAdj(j, k, N, M);
					}
				}
			}
			
			System.out.println(count);
		}
		
		br.close();
	}
	
	public static void filterAdj(int i, int j, int w, int h) {
		field[i][j] = 2;	//방문
		int[] plus_i = {-1, 0, 1, 0};
		int[] plus_j = {0, 1, 0, -1};
		for(int k=0; k<4; k++) {
			if(isInBound(i+plus_i[k], j+plus_j[k], w, h) && field[i+plus_i[k]][j+plus_j[k]] == 1) {
				filterAdj(i+plus_i[k], j+plus_j[k], w, h);
			}
		}
	}
	
	public static boolean isInBound(int i, int j, int w, int h) {
		return i>=0 && i<w && j>=0 && j<h;
	}
}
