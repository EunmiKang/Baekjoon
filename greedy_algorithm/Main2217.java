package greedy_algorithm;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

/**
 * 
 * @author EunmiKang
 * 로프
 * ::
 * greedy
 *
 */
public class Main2217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 입력 */
		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		for(int i=0; i<N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		/* 문제 풀이 */
		Arrays.sort(ropes);	//정렬
		int max = ropes[N-1];
		for(int i = N-2; i>=0; i--) {
			if(max < ropes[i]*(N-i))
				max = ropes[i]*(N-i);
		}
		
		/* 출력 */
		System.out.println(max);
	}
}
