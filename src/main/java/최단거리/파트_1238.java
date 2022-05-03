package 최단거리;

import java.util.*;

public class 파트_1238 {
    // 문제 요점
    // 단일 경로 이기 때문에
    // 집 -> X 경로 확인
    // X -> 집 경로 확인
    // 이 두개를 더해줘야한다.

    static int n,m,z;
    static int distance[];
    static int distance2[];
    static boolean check[];
    static int INF = 999999;
    static ArrayList<ArrayList<Node>> list;
    static ArrayList<ArrayList<Node>> revlist;
    //단방향
    static class Node implements Comparable<Node>{
        int pos;
        int weight;
        public Node(int pos, int weight){
            this.pos= pos;
            this.weight= weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) {
        //모든 간선이 있는 경우 - 다익스트라 (한 정점 → 모든 정점), 플로이드-와샬(모든 정점 → 모든 정점)
        //음수 간선이 있는 경우 - 벨만-포드

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n부터의 집
        m = sc.nextInt();
        z = sc.nextInt(); // 도착지점

        distance = new int[n+1];
        distance2 = new int[n+1];



        Arrays.fill(distance, INF);
        Arrays.fill(distance2, INF);


        list = new ArrayList<>();
        revlist = new ArrayList<>();
        for(int i=0; i<m; i++){
            list.add(new ArrayList<Node>());
            revlist.add(new ArrayList<Node>());
        }

        for(int i=1; i<=m; i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            int weight = sc.nextInt();

            list.get(to).add(new Node(from, weight));
            revlist.get(from).add(new Node(to, weight));

        }

        // 다익 2번 돌리기
        // 주어진 간선에서 x번 마을로 가는 최단거리 구하고
        dik(list,distance, z);

        // x번 마을에서 집으로 가는걸 구한다
        dik(revlist,distance2,z);

        //distance + distance2 를 더한값


        int max = -1;

        for(int i=1; i<=n; i++)
            max = Math.max(max, distance[i] + distance2[i]);
        System.out.println(max);
    }

    static void dik(ArrayList<ArrayList<Node>> list,int[] dis, int start){
        //x까지 갔을때만 체크;
        check = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dis[start] = 0;

       loop: while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(check[cur.pos]) continue;
            else check[cur.pos] = true;

            for(Node x : list.get(cur.pos)){
                if(dis[x.pos] > dis[cur.pos] + x.weight){
                    dis[x.pos] = dis[cur.pos] + x.weight;
                    pq.offer(new Node(x.pos,x.weight));
                }

            }

        }
    }

}
