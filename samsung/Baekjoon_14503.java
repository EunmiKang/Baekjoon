package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 로봇 청소기
 * ::
 * 시뮬레이션, 방향 이동
 * 
 */

public class Baekjoon_14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(N_M[0]);
		int M = Integer.parseInt(N_M[1]);
		String[] robot_info = br.readLine().split(" ");
		int robot_startR = Integer.parseInt(robot_info[0]);
		int robot_startC = Integer.parseInt(robot_info[1]);
		int robot_startD = Integer.parseInt(robot_info[2]);
		int[][] map = new int[N][M];
		int result = 0;

		for (int i = 0; i < N; i++) {
			String[] read_row = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(read_row[j]);
			}
		}
		br.close();

		/* 청소 시작 */
		int r = robot_startR, c = robot_startC;
		int dir = robot_startD;
		boolean stop_flag = false;
		int count = 0;
		map[r][c] = 2; // 청소함
		result++;
		while (!stop_flag) {
			if (count < 4) {
				switch (dir) {
				case 0:
					if (map[r][c - 1] == 0) {
						dir = 3; // 회전
						c = c - 1; // 전진
						map[r][c] = 2; // 청소함
						result++;
						count = 0;
					} else {
						dir = 3; // 회전
						count++;
					}
					break;
				case 1:
					if (map[r - 1][c] == 0) {
						dir = 0; // 회전
						r = r - 1; // 전진
						map[r][c] = 2; // 청소함
						result++;
						count = 0;
					} else {
						dir = 0; // 회전
						count++;
					}
					break;
				case 2:
					if (map[r][c + 1] == 0) {
						dir = 1; // 회전
						c = c + 1; // 전진
						map[r][c] = 2; // 청소함
						result++;
						count = 0;
					} else {
						dir = 1; // 회전
						count++;
					}
					break;
				case 3:
					if (map[r + 1][c] == 0) {
						dir = 2; // 회전
						r = r + 1; // 전진
						map[r][c] = 2; // 청소함
						result++;
						count = 0;
					} else {
						dir = 2; // 회전
						count++;
					}
					break;
				}
			} else { // 네 방향 모두 청소되어있거나 벽인 경우
				count = 0;
				switch (dir) {
				case 0:
					if (map[r + 1][c] == 1) { // 뒤쪽방향이 벽인 경우 - 후진 불가 -> 작동 멈춤
						stop_flag = true;
					} else { // 후진
						r = r + 1;
					}
					break;
				case 1:
					if (map[r][c - 1] == 1) { // 뒤쪽방향이 벽인 경우 - 후진 불가 -> 작동 멈춤
						stop_flag = true;
					} else { // 후진
						c = c - 1;
					}
					break;
				case 2:
					if (map[r - 1][c] == 1) { // 뒤쪽방향이 벽인 경우 - 후진 불가 -> 작동 멈춤
						stop_flag = true;
					} else { // 후진
						r = r - 1;
					}
					break;
				case 3:
					if (map[r][c + 1] == 1) { // 뒤쪽방향이 벽인 경우 - 후진 불가 -> 작동 멈춤
						stop_flag = true;
					} else { // 후진
						c = c + 1;
					}
					break;
				}
			}
		}

		System.out.println(result);
	}
}
