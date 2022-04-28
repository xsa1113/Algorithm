package 최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3_13549 {
    // 가장빠르게
    static int min = Integer.MAX_VALUE;
    static int n,k;
    static boolean[] visited; // 방문 배열
    static int max = 100000;
    public static void main(String[] args) {
        // n
        // k
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 수빈이
        k = sc.nextInt(); // 동생

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    private static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.x] = true; // 방문체크
            // 최소 시간을 계속 찾는다
            if(node.x == k) min = Math.min(min, node.time);

            if(node.x * 2 <= max && visited[node.x * 2] == false)
                queue.offer(new Node(node.x * 2 , node.time));
            if(node.x + 1 <= max && visited[node.x + 1] == false)
                queue.offer(new Node(node.x + 1, node.time +1));
            if(node.x - 1 >= 0 && visited[node.x - 1] == false)
                queue.offer(new Node(node.x - 1, node.time + 1));

        }
    }

    static class Node{
        int x;
        int time;
        public Node(int x, int time){
            this.x = x;
            this.time =time;
        }
    }
}
