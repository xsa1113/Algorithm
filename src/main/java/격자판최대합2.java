import java.util.Scanner;

public class 격자판최대합2 {
    public int solution(int n, int[][]arr){
        int answer = 0;
        int garo, sero ;
        int tmp = arr.length;
        //가로
        for(int i =0; i<tmp; i++){
            garo = 0;
            sero = 0;
            for(int j=0; j<tmp; j++){
                garo += arr[i][j];
                sero += arr[j][i];

            }
            answer=Math.max(answer,sero);
            answer=Math.max(answer,garo);
        }

        garo = 0;
        sero = 0;
        for(int i =0; i<n; i++){
            garo += arr[i][i];
            sero += arr[i][n-i-1];
        }
        answer=Math.max(answer,sero);
        answer=Math.max(answer,garo);

        return answer;
    }
    public static void main(String[] args) {
        격자판최대합2 T = new 격자판최대합2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
