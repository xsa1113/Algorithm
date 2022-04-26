package 일반알고리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최단거리구하기BFS8 {
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static int map[][],dis[][];
    static int answer;
    static int min = Integer.MIN_VALUE;

    public class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    // 계속 기록하면서 가야지

    public void BFS(int r, int c){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c));
        map[r][c] = 1;

        while(!queue.isEmpty()){
            Node tmp = queue.poll();

            for(int i=0; i<4; i++){
                int nr = tmp.x + dr[i];
                int nc = tmp.y + dc[i];
                if(nr>=0 && nc>=0 && nr<7 && nc<7){
                    if(map[nr][nc] == 0){
                        map[nr][nc] = 1;
                        queue.offer(new Node(nr,nc));
                        dis[nr][nc] = dis[tmp.x][tmp.y] + 1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        최단거리구하기BFS8 T = new 최단거리구하기BFS8();
        Scanner sc = new Scanner(System.in);
        map = new int[7][7];
        dis = new int[7][7];
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                map[i][j] = sc.nextInt();
            }
        }
        map[0][0] = 1;
        T.BFS(0,0);
        if(dis[6][6] == 0) System.out.println(-1);
        else System.out.println(dis[6][6]);
    }
}
