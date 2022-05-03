package 최단거리;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 저울_10159 {

    // 한개의 정점에서 모든 정점
    static int map[][];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map = new int[n+1][n+1];
        int INF = 999999;


        for(int i=0; i<m; i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            map[to][from] = 1;
            map[from][to] = -1;
        }
        // 저울을 검색할 수 없는 것을 확인
        // map에서 0인것을 판단

        // 짧은 거리 탐색 X
        // s > k > e
        // s > e
        // 를 확인하고 가능하면 1

        for(int k=1; k<=n; k++){
            for(int s=1; s<=n; s++){
                for(int e=1; e<=n; e++){
                    // 기존 경로를 짧은것을 계속 탐색하는ㄴ 것이 아님
                    if(map[s][k] == map[k][e] && map[s][k] != 0){
                        // 1이고 1일때 거쳐가는게 0이아니라면
                        map[s][e] = map[s][k];
                    }
                }
            }
        }
        int max;
        for(int i=1; i<=n; i++){
            max = 0;
            for(int j=1; j<=n; j++){
                if(i == j) continue;
                else
                    if(map[i][j] == 0 && map[j][i]== 0) {
                        max++;
                    }
            }
            System.out.println(max);
        }

    }
}
