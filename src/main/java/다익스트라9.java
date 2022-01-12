import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라9 {
    // 최소비용을 간많프, 간적크
    // 정점의 수 n, 간선의 수 m 연결정보와 거리 비용
    // 다익스트라는 arraylist 안에 정점을 연결한 arraylist 객체를 계속 생성하기
    // 현재 정점 다음 정점 확인하면서 현재 비용 다음 비용이 작다고 한다면
    // dis 라는 배열에 계속 갱신해주기
    // 1번에서 각 정점으로 가는 최소 비용을 출력
    static int n, m;
    static int dis[];
    //ArrayList를 만들어서 거기에 넣기
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node>{
        //정점
        int vex;
        //비용
        int cost;
        public Node(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }

    }

    public void solution(int vex){
        // dis 배열이 있으니까 일단 정점을 전체 다 돌아보자
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(vex,0)); // 코스트는 영으로 시작하고
        dis[vex] = 0;

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            int nowCost = tmp.cost;
            int nowVex =  tmp.vex;

            // 현재 비용보다 dis배열에 있는 코스트가 더 적으면 굳이 볼필요도 없다
            if(nowCost > dis[nowVex]) continue;
            for(Node ob : graph.get(nowVex)){
                if(dis[ob.vex]>nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    // 다음 ob정점을 넣어주고, 비용은 현재 비용 + ob젝트 코스트 비용을 더한다
                    pq.offer(new Node(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        다익스트라9 T = new 다익스트라9();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Node>>();

        for(int i=0; i<=n; i++){
            // 어레이리스트 객체안에 또 어레이리스트 담기
            graph.add(new ArrayList<Node>());
        }
        dis = new int[n+1];
        // 큰수로 다 채워주고
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<m; i++){
            int fir = sc.nextInt();
            int sec = sc.nextInt();
            int cost = sc.nextInt();
            //  ex ) 1번 정점에서 2번정점으로 가는 cost 비용을 넣는다
            graph.get(fir).add(new Node(sec, cost));
        }

        T.solution(1); // 1번정점에서 부터 시작한다
        for(int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE){
                System.out.print( i + " : " + dis[i]);
                System.out.println();
            }else{
                System.out.print(i + " : " + "impossible");
                System.out.println();
            }
        }
    }
}
