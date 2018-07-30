package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 경로 찾기 */

public class Baekjoon_11403 {
	public static int[][] G;
	public static int[][] isPath;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점의 개수
		G = new int[N][N]; // 그래프
		isPath = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] rows = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(rows[j]);
				isPath[i][j] = Integer.parseInt(rows[j]);
			}
		}
		br.close();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (isPath[i][j] == 0)
					if (isPath(i, j))
						isPath[i][j] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(isPath[i][j] + " ");
			System.out.println();
		}
	}

	public static boolean isPath(int row, int col) {
		Queue<Integer> queue = new LinkedList<>();
		int checkRow;
		boolean[] visited = new boolean[G.length];
		queue.add(row);
		visited[row] = true;
		while (!queue.isEmpty()) {
			checkRow = queue.poll();
			for (int i = 0; i < G.length; i++) {
				if(G[checkRow][i] == 1) {
					if(i == col)
						return true;
					if (i != checkRow && !visited[i]) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}
			if (queue.contains(col))
				return true;
		}
		return false;
	}

}
