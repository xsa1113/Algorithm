package 최단거리;

import java.util.Scanner;

public class 운동_1956 {
    // 일방통행 도로
    // 최적을 구하자
    // queue를 활용한 최단거리는 전체를 다 확인하지 않고 그냥
    // 단순히 최단거리만 확인하고 싶을때

    static int v,e;
    static boolean check[];
    static int distance[][];
    static int INF = 999999;
    static int result;

    // 플로이드 와샬을 활용하고
    // 그냥 최소 사이클인 도로의 합을 출력하는 문제이니까;;
    // 왜 대체 최소 사이클이면서 몇개의 도로가 있는지 확인하는 문제로 착각
    // 문제좀 잘좀 읽자;;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        // v개의 마을
        // e개의 도로

        result = 0;
        distance = new int[v+1][v+1];

        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i == j) continue;
                else distance[i][j] = INF;
            }
        }

        for(int i=0; i<e; i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            int cost = sc.nextInt();
            // 한방향으로만 가니까
            distance[to][from] = Math.min(distance[to][from], cost);
        }

        // 거쳐가는 지점
        for(int k =1; k<=v; k++){
            // 시작 지점
            for(int s=1; s<=v; s++){
                // 끝지점
                for(int e=1; e<=v; e++){
                    if(distance[s][e] > distance[s][k] + distance[k][e]){
                        distance[s][e] = distance[s][k] + distance[k][e];
                        // 더작은값을 계속 담고 가야하니까
                    }
                }
            }
        }

        // 찾는다 작은 값을 distance 에 다 갱신해두었으니
        int ans = INF;
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i == j)
                    continue;

                // 자기 자신을 제외하고
                // 서로에게 가는 경로가 있다면, 사이클 존재!!

                if(distance[i][j] != INF && distance[j][i] != INF){
                    ans = Math.min(ans, distance[i][j] + distance[j][i]);
                }
            }
        }

        // ans가 초기값이면 존재 x
        ans = (ans == INF) ? -1 : ans;

        System.out.println(ans);
    }
}
