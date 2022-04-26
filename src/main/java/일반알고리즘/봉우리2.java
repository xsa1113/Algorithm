package 일반알고리즘;

import java.util.Scanner;

public class 봉우리2 {
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};

    public int solution(int n, int[][] arr){
        int answer = 0;
        int res = 0;
        int flag = 0;

        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;

                   if(nr>=0 && nc>=0 && nr<n && nc<n){
                       if(arr[i][j] > arr[nr][nc]){
                           flag ++;
                       }else{
                           continue;
                       }
                   }else{
                       if(arr[i][j] > 0){
                           flag++;
                       }
                   }
                }
                if(flag == 4){
                    answer++;
                    flag = 0;
                }
                flag = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        봉우리2 T = new 봉우리2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();

            }
        }
        System.out.println(T.solution(n,arr));

    }
}
