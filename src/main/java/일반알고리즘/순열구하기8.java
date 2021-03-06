package 일반알고리즘;

import java.util.Scanner;

public class 순열구하기8 {
    static int n, m;
    static int arr[];
    static int ch[];
    static int pm[];
    public void DFS(int L){

        if(L == m){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
            return;
        }
        else{
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    //L에 넣어야지;;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        //10이하 n개의 자연수
        순열구하기8 T = new 순열구하기8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];

        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0);
    }
}
