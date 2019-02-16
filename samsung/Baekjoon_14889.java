package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 스타트와 링크
 * ::
 * 완전탐색(브루트포스), dfs
 * 
 */

public class Baekjoon_14889 {
	public static int[][] s;
	public static int N, min = Integer.MAX_VALUE;
	public static boolean[] selected;

	public static void DFS(int v, int depth) {
		if (depth == N / 2) {
			calc();
			return;
		}

		for (int i = v; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				DFS(i + 1, depth + 1);
				selected[i] = false;
			}
		}
	}
	
	public static void calc() {
		int[] start = new int[N / 2];
		int[] link = new int[N / 2];
		int start_idx = 0, link_idx = 0;
		int s_start = 0, s_link = 0;

		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				start[start_idx++] = i;
			} else {
				link[link_idx++] = i;
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				s_start += s[start[i]][start[j]];
				s_start += s[start[j]][start[i]];
				s_link += s[link[i]][link[j]];
				s_link += s[link[j]][link[i]];
			}
		}

		min = Math.min(min, Math.abs(s_start - s_link));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new int[N][N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] read_line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				s[i][j] = Integer.parseInt(read_line[j]);
			}
		}
		br.close();

		DFS(0, 0);

		System.out.println(min);
	}
}
