import java.util.Arrays;
import java.util.Scanner;

public class 백준_문자판다른코드 {
    static int n,m,k;
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static char map[][];
    static int dp[][][];
    static char check[];
    private static int dfs(int x, int y, int index){
        if(index == check.length-1) return dp[x][y][index] = 1; // 체크
        if(dp[x][y][index] != -1) return dp[x][y][index];
        dp[x][y][index] = 0;
        for(int z=0; z<4; z++){
            for(int c=1; c<=k; c++){
                int nx = x + dr[z] * c;
                int ny = y + dc[z] * c;
                if(nx<0 | ny<0 | nx>=n | ny>=m) continue;
                if(map[nx][ny] == check[index+1]){
                    //다음 문자 배턴이 check에 있는 문자판과 같은지 봐
                    dp[x][y][index] += dfs(nx,ny,index+1);
                }
            }
        }
        return dp[x][y][index];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new char[n][m];
        for(int i=0; i<n; i++){
            map[i] = sc.next().toCharArray();
        }

        String str = sc.next();
        check = str.toCharArray();
        dp = new int[n][m][check.length];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
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
