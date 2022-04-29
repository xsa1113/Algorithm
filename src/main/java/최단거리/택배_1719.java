package 최단거리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 택배_1719 {

    //모든 정점과의 거리를 알기 위해서 플로이드 와샬로 활용해서 풀어야함

    static int n,m;
    static int dist[][] ;
    static int check[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //플로이드 활용

        n = sc.nextInt();
        m = sc.nextInt();

        dist = new int[n+1][n+1];
        check = new int[n+1][n+1];


        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j )
                    dist[i][j] = 0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<n; i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            int weight = sc.nextInt();

            // dist에는 거리를 대입하고
            // check에는 거쳐가는 곳을 확인한다

            dist[to][from] = weight;
            dist[from][to] = weight;
            check[to][from] = from;
            check[from][to] = to;
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(check[i][j] == 0){
                   sb.append("- ");
                }else{
                    // 최소비용으로 거쳐가는 단계에서 최초부분만 담기 때문에
                    // 거꾸로 진행해야 최초부분을 담을 수 있음
                    // 정방향으로 진행했을 경우 마지막이 담기게 됨
                    // 출력할때 진행
                    int t = j;
                    while(check[i][t] != t){
                        t = check[i][t];
                    }
                   sb.append(check[i][j] + " ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void floyd(){


        //t는 거쳐가는 단계
        for(int t = n; t>=1; t--){
            //s 시작 단계
            for(int s=1; s<=n; s++){

                // e 마지막 단계
                for(int e=1; e<=n; e++){
                    if(dist[s][e] > dist[s][t] + dist[t][e]){
                        dist[s][e] = dist[s][t] + dist[t][e];
                        check[s][e] = t;
                    }


                }
            }

        }

    }

}
