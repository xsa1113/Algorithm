package 자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 6
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			queue.add(i+ 1);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		
		System.out.print(queue.poll());
	}

}
