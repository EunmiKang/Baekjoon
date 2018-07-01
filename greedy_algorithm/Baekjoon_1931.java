package greedy_algorithm;

/* ȸ�ǽǹ��� */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		int N = sc.nextInt();	// ȸ�� ��
		Meeting[] meetings = new Meeting[N];
		for(int i=0; i<N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		
		Arrays.sort(meetings, new CompareMeeting());
		
		result++;
		int lastMeeting = 0;
		for(int i=1; i<N; i++) {
			if(meetings[lastMeeting].finish <= meetings[i].start) {
				lastMeeting = i;
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	public static class Meeting {
		int start, finish;
		
		public Meeting(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
	}
	
	public static class CompareMeeting implements Comparator<Meeting> {

		@Override
		public int compare(Meeting m1, Meeting m2) {	// ������ �ð��� ���� ������ ����(������ ���� �ð��� ���� ����)
			if(m1.finish < m2.finish) {
				return -1;
			} else if(m1.finish == m2.finish) {
				if(m1.start < m2.start)
					return -1;
				else if(m1.start == m2.start)
					return 0;
			}
			return 1;
		}
		
	}
}
