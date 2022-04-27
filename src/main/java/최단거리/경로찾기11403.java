package 최단거리;

import 일반알고리즘.최대수입스케줄PQ9;

import java.util.Scanner;

public class 경로찾기11403 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][];
        int result[][];

        n = sc.nextInt();

        result = new int[n][n];
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //플로이드 와샬 i -> k -> j
        // k 거쳐가는 정점
        // 모든정점을 검사한다

        for(int k=0; k<n; k++)
            //시작정점
            for(int i=0; i<n; i++)
                // 도착 정점
                for(int j=0; j<n; j++)
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] =1;
                    }


        //print
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
