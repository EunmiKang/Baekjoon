package string_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 단어의 개수 */

public class Baekjoon_1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		String[] words = input.split(" ");
		int count = 0;
		for(int i=0; i<words.length; i++) {
			if(!words[i].equals(""))
				count++;
		}
		System.out.println(count);
	}
}
