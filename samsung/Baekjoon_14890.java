package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 경사로
 * ::
 * 시뮬레이션
 *
 */
public class Baekjoon_14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read_line = br.readLine().split(" ");
		int N = Integer.parseInt(read_line[0]);
		int L = Integer.parseInt(read_line[1]);
		int[][] map = new int[N][N];
		int possible_road = 0;

		for (int i = 0; i < N; i++) {
			read_line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(read_line[j]);
			}
		}
		br.close();

		/* 지나갈 수 있는 길 체크 */
		for (int i = 0; i < N; i++) {
			int pre_count_row = 0, pre_count_col = 0;
			int post_count_row = 0, post_count_col = 0;
			boolean flag_row = true, flag_col = true;
			boolean post_check_row = false, post_check_col = false;

			for (int j = 0; j < N; j++) {
				/* 가로 길 */
				if (flag_row && j < N - 1) {
					if (!post_check_row) {
						if (map[i][j + 1] == (map[i][j])) {
							pre_count_row++;
						} else if (map[i][j + 1] == (map[i][j] + 1)) { // 앞에 경사로 세울 수 있나 확인
							if ((pre_count_row + 1) >= L) { // 경사로 세울 수 있음
								pre_count_row = 0;
							} else { // 없음 -> 걸어갈 수 없는 길
								flag_row = false;
							}
						} else if (map[i][j + 1] == (map[i][j] - 1)) { // 뒤에 경사로 세울 수 있나 확인해야 됨
							if (N - (j + 1) < L) { // 세울수없음
								flag_row = false;
							} else { // 다음부터 체크
								post_check_row = true;
							}
						} else { // 앞,뒤 높이 차 1 초과이므로 지나갈 수 없는 길
							flag_row = false;
						}
					} else {
						if (map[i][j + 1] == map[i][j]) {
							post_count_row++;
						} else if ((post_count_row + 1) >= L) {
							if (map[i][j + 1] == (map[i][j] + 1)) {
								post_check_row = false;
								pre_count_row = post_count_row - L;
								if ((pre_count_row + 1) >= L) { // 경사로 세울 수 있음
									pre_count_row = 0;
								} else { // 없음 -> 걸어갈 수 없는 길
									flag_row = false;
								}
							} else if (map[i][j + 1] == (map[i][j] - 1)) {
								post_check_row = true;
							} else {
								flag_row = false;
							}
							post_count_row = 0;
						} else {
							flag_row = false;
						}
					}
				}

				/* 세로 길 */
				if (flag_col && j < N - 1) {
					if (!post_check_col) {
						if (map[j + 1][i] == (map[j][i])) {
							pre_count_col++;
						} else if (map[j + 1][i] == (map[j][i] + 1)) { // 앞에 경사로 세울 수 있나 확인
							if ((pre_count_col + 1) >= L) { // 경사로 세울 수 있음
								pre_count_col = 0;
							} else { // 없음 -> 걸어갈 수 없는 길
								flag_col = false;
							}
						} else if (map[j + 1][i] == (map[j][i] - 1)) { // 뒤에 경사로 세울 수 있나 확인해야 됨
							if (N - (j + 1) < L) { // 세울수없음
								flag_col = false;
							} else { // 다음부터 체크
								post_check_col = true;
							}
						} else { // 앞,뒤 높이 차 1 초과이므로 지나갈 수 없는 길
							flag_col = false;
						}
					} else {
						if (map[j + 1][i] == map[j][i]) {
							post_count_col++;
						} else if ((post_count_col + 1) >= L) {
							if (map[j + 1][i] == (map[j][i] + 1)) {
								post_check_col = false;
								pre_count_col = post_count_col - L;
								if ((pre_count_col + 1) >= L) { // 경사로 세울 수 있음
									pre_count_col = 0;
								} else { // 없음 -> 걸어갈 수 없는 길
									flag_col = false;
								}
							} else if (map[j + 1][i] == (map[j][i] - 1)) {
								post_check_col = true;
							} else {
								flag_col = false;
							}
							post_count_col = 0;
						} else {
							flag_col = false;
						}
					}
				}
			}
			if (flag_row) {
				possible_road++;
			}
			if (flag_col) {
				possible_road++;
			}
		}
		System.out.println(possible_road);
	}
}
