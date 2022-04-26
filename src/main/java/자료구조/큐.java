package 자료구조;

import java.util.Scanner;

public class 큐 {
	public static int a[];
	public static int size;
	public static int top = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n];
		size=0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String str = "";
			str = sc.next();
			switch (str) {
			case "push" : 
				int tmp = sc.nextInt();
				push(tmp);
				break;
			case "pop" : 
				sb.append(pop()).append("\n");
				break;
			case "size" : 
				sb.append(size()).append("\n");
				break;
			case "empty" : 
				sb.append(empty()).append("\n");
				break;
			case "front" : 
				sb.append(front()).append("\n");
				break;
			case "back" : 
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	static int back() {
		if(empty() == 1) {
			//비었으면
			return -1;
		}else {
			return a[size-1];
		}
	}
	static int front() {
		if(empty() == 1) {
			//비었으면
			return -1;
		}else {
			return a[top];
		}
	}
	static int empty() {
		if(size-1 == top) {
			// 만약 비었으면 
			return 1;
		}else {
			return 0;
		}
	}
	static int size() {
		return size;
	}
	
	static int pop() {
		
		if(empty() == 1) {
			// 비엇으면 
			return -1;
		}else {
			int result = a[top];
			a[top] = 0;
			a[top] = a[size-1];
			a[size-1] = 0;
			size --;
			
			return result;
		}
	}

	static void push(int tmp) {
		// 15개 14개 배열 
		a[size] = tmp;
		size ++;
	}

}
