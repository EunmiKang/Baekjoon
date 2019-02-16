package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 드래곤커브
 * ::
 * 시뮬레이션
 *
 */

public class Baekjoon_15685 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 드래곤커브 개수
		boolean[][] map = new boolean[101][101];
		int count = 0;

		for (int i = 0; i < N; i++) {
			String[] dragoncurve_info = br.readLine().split(" ");
			int start_x = Integer.parseInt(dragoncurve_info[0]);
			int start_y = Integer.parseInt(dragoncurve_info[1]);
			int start_direction = Integer.parseInt(dragoncurve_info[2]);
			int[][] direction = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
			int generation = Integer.parseInt(dragoncurve_info[3]);
			int[] dir_array = new int[(int) Math.pow(2, generation)];

			/* 드래곤커브 그리기 */
			// 0세대
			map[start_x][start_y] = true; // 시작점
			int curr_x = start_x + direction[start_direction][0];
			int curr_y = start_y + direction[start_direction][1];
			map[curr_x][curr_y] = true; // 끝점
			int dir_idx = 0;
			dir_array[dir_idx++] = start_direction;

			// 1세대~
			for (int g = 0; g < generation; g++) {
				for (int k = (int) Math.pow(2, g) - 1; k >= 0; k--) {
					switch (dir_array[k]) {
					case 0:	// x증가 -> y감소
						curr_x += direction[1][0];
						curr_y += direction[1][1];
						dir_array[dir_idx++] = 1;
						break;
					case 1:	// y감소 -> x감소
						curr_x += direction[2][0];
						curr_y += direction[2][1];
						dir_array[dir_idx++] = 2;
						break;
					case 2:	// x감소 -> y증가
						curr_x += direction[3][0];
						curr_y += direction[3][1];
						dir_array[dir_idx++] = 3;
						break;
					case 3:	// y증가 -> x증가
						curr_x += direction[0][0];
						curr_y += direction[0][1];
						dir_array[dir_idx++] = 0;
						break;
					}
					map[curr_x][curr_y] = true; // 점 방문
				}
			}
		}
		br.close();

		/* 정사각형 개수 확인 */
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
