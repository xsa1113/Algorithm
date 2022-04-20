package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 스택 {
	//함수사용할때 return 문 신경써서 만들기 
	
	public static int a[];
	public static int size = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt(); //14
		a = new int[n];
		
		String str = "";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			str = sc.next();
			switch(str) {
			case "push" : 
				push(sc.nextInt());
				break;
			case "pop" :
				sb.append(pop()).append("\n");
				break;
			case "size" : 
				sb.append(size()).append("\n");
				break;
			case "empty" : 
				isEmpty();
				break;
			case "top" : 
				sb.append(top()).append("\n");
				break;
				
			}
		}
		System.out.println(sb);
	}
	private static void push(int num) {
		a[size] = num;
		size ++;
		
	}
	private static int pop() {
		if(isEmpty() == 1) {
			//비어있으면 
			return -1;
		}else {
			int tmp = a[size-1];
			a[size-1] = 0;
			size --;
			return tmp;
		}
	}
	private static int size() {
		return size;
	}
	private static int isEmpty() {
		if(size == 0) {
			return 1;
		}else {
			return 0;
		}
		
	}
	private static int top() {
		if(size == 0) {
			return -1;
		}
		
		
		return a[size-1];
	}

}
