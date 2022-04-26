package 일반알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준최단경로_1753 {
    static int n, m, start;
    static int dis[];
    static ArrayList<ArrayList<Node>> graph;

    public static class Node implements Comparable<Node>{
        int vex;
        int cost;
        public Node(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return o.cost - this.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        graph = new ArrayList<ArrayList<Node>>();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<m; i++){
            int fir = sc.nextInt();
            int sec = sc.nextInt();
            int cost =sc.nextInt();
            graph.get(fir).add(new Node(sec, cost));
        }
        solution(start);
        for(int i=1; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(dis[i]);
            }else{
                System.out.println("INF");
            }

        }

    }

    private static void solution(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 시작을 넣어준다
        dis[start] = 0; // dis 최소비용 시작은 0 으로 만들어주고

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int nowVex = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost > dis[nowVex]) continue;
            for(Node ob : graph.get(nowVex)){
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Node(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }
}
