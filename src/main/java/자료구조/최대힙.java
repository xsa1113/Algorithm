package 자료구조;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 0 이면 최대값 출력
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if (!pq.isEmpty()) 
				System.out.println(pq.poll());
			
				else 
				System.out.println(0);
				continue;
			}
			pq.add(num);
		}
	}

}
