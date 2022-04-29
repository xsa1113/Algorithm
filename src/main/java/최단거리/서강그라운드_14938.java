package 최단거리;

import java.util.*;

public class 서강그라운드_14938 {
    static int n, m, r;
    static ArrayList<ArrayList<Node>> list;
    static int max;
    static int item[];
    static int distance[];
    static boolean check[];

    static class Node implements Comparable<Node> {
        int pos; // 지역번호
        int wep; //거리

        // 지역번호와 거리만 가지고 다니다가
        // item에 아이템을 가지고 갈 수 있는 거 판단하고
        // 거리가 지정되있는 값보다 작다면
        // item에서 뽑아서 최대값을 찾자

        public Node(int pos, int wep) {
            this.pos = pos;
            this.wep = wep;

        }

        // 거리도 내림차순으로 들어가기
        public int compareTo(Node o) {
            return this.wep - o.wep;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 지역의 개수
        n = sc.nextInt();
        //수색 범위
        m = sc.nextInt();
        // 길의 개수
        r = sc.nextInt();

        item = new int[n + 1];

        distance = new int[n + 1];
        check = new boolean[n + 1];

        list = new ArrayList<>();

        // list 객체 생성
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 양방향 객체 생성
        for (int i = 1; i <= n; i++) {
            //5 가지 지역 1번은 5를 가지고 있고
            // 아이템은 일반 배열 넣자
            item[i] = sc.nextInt();
        }

        //길 양방향 인접 리스트 구현
        for (int i = 1; i <= r; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            int dis = sc.nextInt();

            list.get(to).add(new Node(from, dis));
            list.get(from).add(new Node(to, dis));
        }


        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, bfs(i));
        }
        System.out.println(ans);

    }

    static int bfs(int start) {
        //start 시작
        //range 범위
        //roadcnt 길의 개수

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            // 이번 무기가 큰 수로 정렬이 되어있다
            Node cur = pq.poll();
            int pos = cur.pos;
            //현재 위치 빼고

            if (!check[pos]) {
                // 방문하지 않았으면
                check[pos] = true;
                // list 인접리스트 행렬에서 현재위치에서 연결된 부분을 다 확인하고
                for (Node next : list.get(pos)) {
                    // 연결된 위치가 방문하지 않았고 거리가 짧다면면
                    // 다음 거리보다 현재에 있던 거리와 그 위치의 weight 더한거 보다 작다면
                    if (!check[next.pos] && distance[next.pos] > distance[pos] + next.wep) {

                        distance[next.pos] = distance[pos] + next.wep;
                        pq.add(new Node(next.pos, distance[next.pos]));
                    }
                }
            }
        }

        int res = 0;
        //수색 범위 내로 갈 수 있는 아이템 확인
        for(int i=1; i<=n; i++){
            if(distance[i] <= m){
                //전체 거리가 m보다 작다면
                res+= item[i];
            }
        }

        return res;

    }

}
