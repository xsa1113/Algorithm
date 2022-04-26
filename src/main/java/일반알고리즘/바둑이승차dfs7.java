package 일반알고리즘;

import java.util.Scanner;

public class 바둑이승차dfs7 {
    static int c,n,w,L=0;
    static int arr[];
    static int ch[];
    static int answer = 0;
    boolean flag =false;
    public void DFS(int L,int sum,int [] arr){

        if(sum > c) return;
        if(L == n){
            answer = Math.max(answer,sum);
            return;
        }else{
            DFS(L+1, sum+arr[L],arr);
            DFS(L+1, sum, arr);
        }
    }


    public static void main(String[] args) {
        바둑이승차dfs7 T = new 바둑이승차dfs7();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0,0,arr);
        System.out.println(answer);

    }
}
