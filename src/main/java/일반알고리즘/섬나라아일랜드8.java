package 일반알고리즘;

import java.util.Scanner;

public class 섬나라아일랜드8 {
    static int n,answer;
    static int dr[] = {-1,-1,0,1,1,1,0,-1};
    static int dc[] = {0,1,1,1,0,-1,-1,-1};
    static int map[][] ;
    static boolean check[][];
    public void DFS(int L,int r, int c){
        check[r][c] = true;
        for(int i=0; i<8; i++){
           int nr = r+dr[i];
           int nc = c+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<n){
                if(map[nr][nc] == 1 && check[nr][nc] == false){
                    DFS(L,nr,nc);
                }
            }
        }

    }
    public static void main(String[] args) {
        섬나라아일랜드8 T = new 섬나라아일랜드8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        check = new boolean[n][n];
        answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && check[i][j] == false){
                    answer = answer + 1;
                    T.DFS(answer,i,j);
                }
            }
        }
        System.out.println(answer);

    }
}
