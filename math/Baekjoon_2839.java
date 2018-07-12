package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 설탕 배달 */

public class Baekjoon_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		br.close();

		switch (N % 5) {
		case 0:
			System.out.println(N / 5);
			break;
		case 1:
		case 3:
			System.out.println(N / 5 + 1); // 1일 때는 ( N/5 - 1 ) + 2
			break;
		case 2:
		case 4:
			if ((N == 4) || (N == 7))
				System.out.println("-1");
			else
				System.out.println(N / 5 + 2); // 2일 때는 ( N/5 - 2 ) + 4 , 4일 때는 ( N/5 - 1 ) + 3
			break;
		}
	}
}
