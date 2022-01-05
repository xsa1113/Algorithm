

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토BFS8 {
    static int n,m,answer;
    static int map[][],dis[][];
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static Queue<Node> queue = new LinkedList<>(); ;

    //익은거 1 , 익지 않은거 0 , 벽 -1

     static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void BFS(){
        while(!queue.isEmpty()){

            Node tmp = queue.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = 1;
                        queue.offer(new Node(nx,ny));
                        dis[nx][ny] = dis[tmp.x][tmp.y] +1;
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        //M 세로 N 가로
        토마토BFS8 T = new 토마토BFS8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[m][n];
        dis = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) queue.offer(new Node(i,j));
            }
        }

        T.BFS();
        boolean flag = true;
        answer = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0) flag = false;
            }
        }
        if(flag){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

    }
}
