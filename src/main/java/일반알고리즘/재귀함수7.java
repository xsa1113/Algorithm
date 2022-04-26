package 일반알고리즘;

import java.util.Scanner;

public class 재귀함수7 {
    // 재귀함수를 이용해서 1~N까지 출력
    public void DFS(int n){
        if(n==0)return;
        else{
            DFS(n-1);
            System.out.println(n + " ");
        }

    }
    public static void main(String[] args) {
        재귀함수7 T = new 재귀함수7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        T.DFS(n);
    }
}
