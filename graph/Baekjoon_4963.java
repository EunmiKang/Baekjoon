package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 섬의 개수 */

public class Baekjoon_4963 {
	public static int w, h;
	public static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String W_H = br.readLine();
		while(!W_H.equals("0 0")) {
			String[] WandH = W_H.split(" ");
			w = Integer.parseInt(WandH[0]);
			h = Integer.parseInt(WandH[1]);
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				String row = br.readLine();
				String[] LandOrSea = row.split(" ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(LandOrSea[j]);
				}
			}
			
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						count++;
						filterSameIsland(i, j);
					}
				}
			}
			System.out.println(count);
			
			W_H = br.readLine();
		}
		br.close();
	}
	
	public static void filterSameIsland(int r, int c) {
		map[r][c] = 2;	//방문
		int[] plus_r = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] plus_c = {0, 1, 1, 1, 0, -1, -1, -1};
		for(int i=0; i<8; i++) {
			if(isInBound(r+plus_r[i], c+plus_c[i]) && map[r+plus_r[i]][c+plus_c[i]] == 1) {
				filterSameIsland(r+plus_r[i], c+plus_c[i]);
			}
		}
	}
	
	public static boolean isInBound(int r, int c) {
		return r>=0 && r<h && c>=0 && c<w; 
	}
}
