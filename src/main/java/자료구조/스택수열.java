package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		// 문제에 대한 이
		for(int i=0; i<n; i++) {
			// 큰수부터 차례로 뽑는다.
			int tmp = sc.nextInt();
			
			if(tmp > flag) {
				for(int j = flag+1; j<=tmp; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				flag = tmp;
			}else {
				if(stack.peek() != tmp) {
					System.out.println("NO");
					return;
				}	
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.print(sb);
	}

}
