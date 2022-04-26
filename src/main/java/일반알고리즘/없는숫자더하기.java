package 일반알고리즘;

import java.util.Scanner;

public class 없는숫자더하기 {
	//[1,2,3,4,6,7,8,0]
	static boolean check[] ;
	
	public int solution(int [] arr) {
		int answer = 0;
		int len = arr.length; 
		for(int i=0; i<len; i++) {
			// 1 
			if(check[arr[i]] != true) {
				check[arr[i]] = true;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(!check[i]) {
				answer += i;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		없는숫자더하기 T = new 없는숫자더하기();
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[8];
		check = new boolean[10];
		for(int i=0; i<8; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(arr));
		
	}

}
