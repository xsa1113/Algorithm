package 최단거리;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class 타임머신 {
    // -1를 만났을때 뒤로 돌릴수있따
    // 플로이드 와샬로 풀었을때 -1 값일 때 조건 처리 어려움ㅁ

    //모든 간선이 있는 경우 - 다익스트라 (한 정점 → 모든 정점), 플로이드-와샬(모든 정점 → 모든 정점)
    //음수 간선이 있는 경우 - 벨만-포드

    // 벨만 포드
    // 전체 정점을 n-1번 반복하면서 초기화해준다
    static int n,m,ans;
    static int distance[];
    static boolean check[];
    static int INF = 999999;
    static class Node{
        int to;
        int from;
        int weight;
        public Node(int to, int from, int weight){
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList<>();

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=1; i<=m; i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            int weight = sc.nextInt();
            list.get(to).add(new Node(to, from, weight));
        }


        check = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, INF);

        StringBuilder sb = new StringBuilder();

        if(bellmanford()){
            // true 이면 음수값이 있기 때문에 -1 출력
            sb.append("-1\n");
        }else{
            for(int i=2; i<=n; i++){
                if(distance[i] == INF){
                    sb.append("-1\n");
                }else{
                    sb.append(distance[i] + "\n");
                }
            }
        }
        System.out.println(sb);

    }

    static boolean bellmanford(){
        // 기존 큐를 사용해서 다익스트라를 사용하는 것이 아니다.
        // 시작점 1로 지정해주기
        distance[1] = 0;
        boolean update = false;

        // 왜 정점의 개수만큼 돌아야함?
        // 벨만 포드 모든 경우의 수를 다돌아봐야함
        // 다익스트라 그 상황에 따라 초기화함, 그리디 알고리즘 기반

        // 벨만포드 n-1번 동안 최단거리 초기화 작업을 반복
        // 전체를 계속해서 돌려줄것이다
        for(int i=1; i<n; i++){
            update = false;
            // 최단거리 초기화
            for(int j=1; j<=n; j++){
                for(Node node : list.get(j)){
                    //2
                    if(distance[j] == INF){
                        break;
                    }

                    if(distance[node.from] > distance[j] + node.weight){
                        distance[node.from] = distance[j] + node.weight;
                        update = true;
                    }
                }
            }

            if(!update){
                break;
            }
        }
        // 정점의 개수 -1 번까지 계속 업데이트 발생시
        // 정점의 개수 번 업데이트 발생하면 음수 사이클이 일어난것을 의미함

        if(update){
            for(int i=1; i<=n; i++){
                for(Node node : list.get(i)){
                    if(distance[i] == INF){
                        break;
                    }
                    if(distance[node.from]>distance[i] + node.weight){
                        return true;
                    }
                }
            }
        }
        return false;


    }

}
