package 일반알고리즘;

import java.util.Scanner;

public class 피보나치수열2 {


    public int[] solution(int N ){
        int[] answer = new int[N];
        answer[0] =1;
        answer[1] =1;
        for(int i =2; i<N; i++){
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        피보나치수열2 T = new 피보나치수열2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int x : T.solution(N)){
            System.out.println(x+" ");
        }

    }
}
