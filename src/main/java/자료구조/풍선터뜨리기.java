package 자료구조;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 풍선터뜨리기 {
	// 다시한번해보기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 음수 양수 두가지 존재하면서 풍선안에 있는 숫자만큼 이동
		// dequeue를 이용한 방법 
		int n = sc.nextInt();
		Deque<int[]> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(sc.next());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt(); //배열안에 넣어주기
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 ");
		
		int in = arr[0];
		
		for(int i=1; i<n; i++) {
			q.add(new int[] {(i+1), arr[i]});// {풍선 idx, 내용}
		}
		
		// 비어있지 않을때까
		while(!q.isEmpty()) {
				if(in > 0) {
					// 양수이면 
					for(int i=1; i<in; i++) {
						q.add(q.poll());
					}
					
					int[] nxt = q.poll();
					in = nxt[1];
					sb.append(nxt[0] + " ");
				}
				else {
					for(int i=1; i<-in; i++) {
						q.addFirst(q.pollLast());
					}
					
					int [] nxt = q.pollLast();
					in = nxt[1];
					sb.append(nxt[0] + " ");
				}
		}
		
		System.out.println(sb.toString());
		
	}

}
