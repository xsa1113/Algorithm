package 일반알고리즘;

import java.util.Scanner;

public class 조합구하기DFS8 {
    static int[] combi;
    static int n,m;
    public void DFS(int L , int s){
        if(L==m){
            for(int x : combi) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        조합구하기DFS8 T = new 조합구하기DFS8();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        combi = new int[m];
        T.DFS(0,1);
    }
}
