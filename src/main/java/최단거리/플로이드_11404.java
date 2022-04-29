package 최단거리;

import java.util.Scanner;

public class 플로이드_11404 {
    // n개의 도시
    // m개의 버스
    static int n,m;
    static int distance[][];
    static int check[][];
    static int INF = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        distance = new int[n+1][n+1];
        check = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }

        for(int i=1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 아 돌아오는 버스 정보는 바로 넣어주는게 아니다
            // 1차적으로 넣어줄 때
            // distance 에 a 에서 시작해서 b로 갈때 c 를 넣어주고
            // b에서 a로갈때 c를 넣어준다고 생각했지만 아니였다
            distance[a][b] = Math.min(distance[a][b], c);

        }

        // 플로이드 와샬
        // 거쳐가는곳
        for(int k=1; k<=n; k++){
            // 시작점
            for(int s=1; s<=n; s++){
                //끝점
                for(int e=1; e<=n; e++){
                    distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e]);
                }
            }
        }

        //print

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                // 비용은 100000보다 작거나 같은 자연수이다
                if(distance[i][j] >= INF){
                    sb.append("0 ");
                }else{
                    sb.append(distance[i][j]  + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }
}
