package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* DFS와 BFS */

public class Baekjoon_1260 {
	public static boolean[][] graph;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = true;
			graph[y][x] = true;
		}
		sc.close();

		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];	// reset
		bfs(V);
	}

	public static void dfs(int V) {
		System.out.print(V + " ");
		visited[V] = true;
		
		for(int i=1; i<graph.length; i++) {
			if(graph[V][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.remove();
			System.out.print(tmp + " ");
			
			for(int i=1; i<graph.length; i++) {
				if(graph[tmp][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}