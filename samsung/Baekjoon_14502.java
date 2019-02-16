package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author EunmiKang
 * 연구소
 * ::
 * dfs, 방향 이동
 *
 */

public class Baekjoon_14502 {
	static int max_area = 0;
	
	public static void add_wall(int[][] map, ArrayList<EmptyArea> emptyArea_list) {
		for(int i=0; i<emptyArea_list.size()-2; i++) {
			for(int j=i+1; j<emptyArea_list.size()-1; j++) {
				for(int k=j+1; k<emptyArea_list.size(); k++) {
					int[][] copy_map = new int[map.length][map[0].length];
					for(int r=0; r<map.length; r++) {
						for(int c=0; c<map[0].length; c++) {
							copy_map[r][c] = map[r][c];
						}
					}
					copy_map[emptyArea_list.get(i).r][emptyArea_list.get(i).c] = 1;
					copy_map[emptyArea_list.get(j).r][emptyArea_list.get(j).c] = 1;
					copy_map[emptyArea_list.get(k).r][emptyArea_list.get(k).c] = 1;
					check_area(copy_map);
					copy_map[emptyArea_list.get(i).r][emptyArea_list.get(i).c] = 0;
					copy_map[emptyArea_list.get(j).r][emptyArea_list.get(j).c] = 0;
					copy_map[emptyArea_list.get(k).r][emptyArea_list.get(k).c] = 0;
				}
			}
		}
	}
	
	public static void check_area(int[][] map) {
		int result = 0;
		
		/* 바이러스 확산 */
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map[0].length; c++) {
				if(map[r][c] == 2) {
					map = process_virus(map, map.length, map[0].length, r, c);
				}
			}
		}
		
		/* 안전구역 카운트 */
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map[0].length; c++) {
				if(map[r][c] == 0) {
					result++;
				}
			}
		}
		
		max_area = Math.max(max_area, result);
	}
	
	public static int[][] process_virus(int[][] map, int N, int M, int r, int c) {
		int[] plus_r = {-1, 0, 1, 0};
		int[] plus_c = {0, 1, 0, -1};
		
		map[r][c] = 3;	// 바이러스 확산됨
		
		for(int i=0; i<4; i++) {
			if(is_inBoundary(N, M, r+plus_r[i], c+plus_c[i])) {
				if(map[r+plus_r[i]][c+plus_c[i]] == 0) {
					process_virus(map, N, M, r+plus_r[i], c+plus_c[i]);
				}
			}
		}
		return map;
	}
	
	public static boolean is_inBoundary(int N, int M, int r, int c) {
		return (r>=0) && (r<N) && (c>=0) && (c<M);
	}
	
	public static class EmptyArea {
		int r, c;
		boolean visited = false;
		
		public EmptyArea() {
			
		}
		
		public EmptyArea(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(N_M[0]);
		int M = Integer.parseInt(N_M[1]);
		int[][] map = new int[N][M];
		ArrayList<EmptyArea> emptyArea_list = new ArrayList<>();
		for(int r=0; r<N; r++) {
			String[] read_row = br.readLine().split(" ");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(read_row[c]);
				if(map[r][c] == 0) {
					emptyArea_list.add(new EmptyArea(r, c));
				}
			}
		}
		br.close();
		
		add_wall(map, emptyArea_list);
		
		System.out.println(max_area);
	}
}
