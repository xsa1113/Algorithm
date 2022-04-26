package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 탑 {
	//for 여러개로는 어려울
	//탑의 번호를 출력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		Stack <int[]> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			
			while(!stack.isEmpty()) {
				if(stack.peek()[0] < tmp) {
					stack.pop();
				}else {
					System.out.print(stack.peek()[1] + " ");
					break;
				}
			}
			
			if(stack.isEmpty()) {
				System.out.print(0 + " ");
			}
			
			stack.push(new int[] {tmp,i+1});
			
			
		}
		
	}
}
