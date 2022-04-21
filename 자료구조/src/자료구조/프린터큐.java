package 자료구조;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐 {
	// 다시 보기 
	 public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i =0; i<tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int result = 0;
			Queue<int[]> queue = new LinkedList<>();
			
			
			for(int j=0; j<n; j++) {
				queue.add(new int[] {j,sc.nextInt()});
			}
			while(true) {
				//remove 반환후 삭제 
				int now[] = queue.remove();
				boolean flag = true;
				
				for(int q[] : queue) {
					if(q[1] > now[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					result ++;
					if(now[0] == m)
						break;
				}else {
					queue.add(now);
				}
				
			}
			System.out.println(result);
		}
		
		
	}

}
