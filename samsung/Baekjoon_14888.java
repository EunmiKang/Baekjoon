package samsung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

/**
 * 
 * @author EunmiKang
 * 연산자 끼워넣기
 * ::
 * dfs
 * 
 */

public class Baekjoon_14888 {
	public static int max = -1000000000;
	public static int min = 1000000000;

	public static void DFS(int[] num_array, int[] ops, int N, int depth, int result) {
		if (depth == N - 1) { // 계산 다 했으니까 min, max 따져야돼
			// System.out.println(result);
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		if (ops[0] > 0) { // 더하기
			ops[0]--;
			DFS(num_array, ops, N, depth + 1, result + num_array[depth + 1]);
			ops[0]++;
		}
		if (ops[1] > 0) { // 빼기
			ops[1]--;
			DFS(num_array, ops, N, depth + 1, result - num_array[depth + 1]);
			ops[1]++;
		}
		if (ops[2] > 0) { // 곱하기
			ops[2]--;
			DFS(num_array, ops, N, depth + 1, result * num_array[depth + 1]);
			ops[2]++;
		}
		if (ops[3] > 0) { // 나누기
			ops[3]--;
			if (result < 0) {
				DFS(num_array, ops, N, depth + 1, -(-result / num_array[depth + 1]));
			} else {
				DFS(num_array, ops, N, depth + 1, result / num_array[depth + 1]);
			}
			ops[3]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 숫자 개수
		String[] read_numbers = br.readLine().split(" ");
		String[] read_ops = br.readLine().split(" ");
		br.close();
		int[] numbers = new int[N];
		int[] ops = new int[4];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(read_numbers[i]);
		}
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(read_ops[i]);
		}

		/*
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		int[] ops = new int[4];
		for (int i = 0; i < 4; i++) {
			ops[i] = sc.nextInt();
		}
		sc.close();
		*/
		
		DFS(numbers, ops, N, 0, numbers[0]);
		System.out.println(max + "\n" + min);
	}
}
