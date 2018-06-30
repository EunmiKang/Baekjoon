package dp;

import java.util.Scanner;

/* 1로 만들기 */

public class Baekjoon_1463 {
	public static int[] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		D = new int[X + 1];

		sc.close();
		
		/* bottom-up 방식 (훨씬 빠름!!)*/
		for(int i=2; i<=X; i++) {
			D[i] = D[i-1] + 1;
			if((i % 2 == 0) && ((D[i/2]+1) < D[i]))
				D[i] = D[i/2] + 1;
			if((i % 3 == 0) && ((D[i/3]+1) < D[i]))
				D[i] = D[i/3] + 1;
		}
		System.out.println(D[X]);	//bottom-up 방식
		//System.out.println(make_1(X));	//top-down방식
	}

	/* top-down 방식 */
	/*
	public static int make_1(int X) {
		if(X <= 1 || D[X] > 0)
			return D[X];
		
		int min = make_1(X - 1);
		if (X % 2 == 0)
			min = Math.min(min, make_1(X/2));
		if (X % 3 == 0)
			min = Math.min(min, make_1(X/3));
		
		return D[X] = min + 1;
	}
	*/
}
