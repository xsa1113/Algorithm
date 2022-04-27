package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class 특정거리의도시찾기 {
    static int N; // 도시의 개수
    static int M; //도로의 개수
    static int K; //거리 정보
    static int X; // 출발 도시의 번호
    static int arr[][];
    static int result[];
    static int flag;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    static int INF = 9999999;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        //인접 행렬
        arr= new int[N+1][N+1];
        result = new int[N+1];

        flag = 0;
        // arraylist를 활용해서
        for(int i=0; i<N+1; i++){
            adjList.add(new ArrayList<>());
            // 큰틀안에 작은틀 arraylist를 계속 생성
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList.get(a).add(b);
        }
        Arrays.fill(result,INF);
        //거리가 K이인거
        bfs(X);

//        for(int i=0; i<result.length; i++){
//            if(result[i] !=0){
//                System.out.println(result[i]);
//            }
//        }

        int flag = 0;

        for(int i=0; i<result.length; i++){
            if(result[i] == K){
                System.out.println(i);
                flag ++;
            }
        }
        if(flag == 0){
            System.out.println(-1);
        }


    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        result[start] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            // 현재 값 얻어오기
            for(int i: adjList.get(cur)){
                if(result[i] == INF){
                    // 거리를 찍으면서 이동
                    result[i] = result[cur] + 1;
                    // 다음 가지로 이동
                    queue.offer(i);
                }
            }
        }

    }
}
