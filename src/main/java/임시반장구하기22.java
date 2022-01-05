import java.util.Scanner;

public class 임시반장구하기22 {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int max = 0;
        int cnt = 0;

        for(int i =1; i<=n; i++){
            //초기화
            cnt = 0;
            for(int j=1; j<=n; j++){
                for(int k=1; k<=5; k++){
                    if(arr[i][k] == arr[j][k]){
                        cnt ++;
                        break;
                    }
                }

            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        임시반장구하기22 T = new 임시반장구하기22();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n+1][6];

        for(int i =1; i<=n; i++){
            for(int j=1; j<=5; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}
