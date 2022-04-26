package 일반알고리즘;

import java.util.Scanner;

public class 계단오르기10 {
    static int n, answer;
    static int dp[];

    private static void solution(){
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-2] + +dp[i-1];
        }
    }

    public static void main(String[] args) {
        계단오르기10 T = new 계단오르기10();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer =0;
        dp = new int[n+1];
        T.solution();
        answer = dp[n];
        System.out.println(answer);
    }
}
