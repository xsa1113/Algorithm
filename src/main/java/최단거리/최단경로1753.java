package 최단거리;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

//  일반 큐를 사용하면 시간초과가난다
// 우선순위 큐를 통해서 값을 비교해주기
public class 최단경로1753 {
    static int v,e;
    static int start;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static StringBuilder sb;
    static int result[];
    static int INF = 999999;
    static class Node implements Comparable<Node>{
        int value;

        int to ;

        public Node(int to, int value){
            this.value = value;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {

            return this.value - o.value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt(); // 정점
        e = sc.nextInt(); // 간선


        result = new int[v+1];
        Arrays.fill(result, INF);
        sb = new StringBuilder();
        start = sc.nextInt();

        for(int i=0; i<v+1; i++){
            list.add(new ArrayList<>());
        }
        //  가중치까지 가지고 가기기
        for(int i=1; i<=e; i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            int val = sc.nextInt();

            list.get(to).add(new Node(from,val));
        }

        bfs(start);

        for(int i=1; i<result.length; i++){
            if(result[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(result[i]);
            }
        }


    }

    private static void bfs(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //1 시작
        result[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            //1
            Node cur = pq.poll();

            // 도착지를 찾는 거였으면 도착지 찾고 break
            // 하지만 최단 경로를 찾는 문제
            // 더큰 가중치일경우 패스
            if(cur.value > result[cur.to]) continue;
            // 현재 연결된 간선 탐색
            for(Node x : list.get(cur.to)){
                if(result[x.to] > cur.value + x.value){
                    result[x.to] = cur.value + x.value;
                    pq.add(new Node(x.to, result[x.to]));
                }
            }
        }
    }
}
