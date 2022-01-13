import java.util.Arrays;
import java.util.Scanner;

public class 백준_문자판 {
    static int n, m, k, answer;
    static char map[][];
    static int dp[][][];
    static int dr [] = {1,0,-1,0};
    static int dc [] = {0,-1,0,1};
    static char[] check;
//test

    private static int dfs(int i, int j, int index){
        if(index == check.length-1) return dp[i][j][index] = 1; //1은종료
        if(dp[i][j][index] != -1) return dp[i][j][index];
        dp[i][j][index] =0; // 방문한곳
        for(int z=0; z<4; z++){
            // k만큼 이동가능
            for(int c=1; c<=k; c++){
                int nx = i + dr[z]*c;
                int ny = j + dc[z]*c;
                if(nx<0 | ny<0 | nx>=n | ny>=m) continue; // 넘어갔으면
                if(map[nx][ny] == check[index+1]){
                    // 다음갈곳이 check배열에 있는 다음 인덱스와 같으면 가자가잣
                    dp[i][j][index] += dfs(nx,ny,index+1);
                }

            }
        }
        return dp[i][j][index];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt(); // k개 칸까지만 이동할수 있0
        map = new char[n][m];
        // map 만들기
        for(int i=0; i<n; i++){
            map[i] = sc.next().toCharArray();
        }
        check = sc.next().toCharArray();
        dp = new int[n][m][check.length];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1); // -1로 초기화
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == check[0]){
                    ans += dfs(i,j,0);
                }
            }
        }
        System.out.println(ans);
    }
}
