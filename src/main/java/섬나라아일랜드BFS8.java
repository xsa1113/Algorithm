import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드BFS8 {
    static int n,answer;
    static int dr[] = {-1,-1,0,1,1,1,0,-1};
    static int dc[] = {0,1,1,1,0,-1,-1,-1};
    static int map[][] ;
    static boolean check[][];
    static Queue<Node> queue = new LinkedList<>();

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void BFS(int x, int y){
        queue.offer(new Node(x,y));
        check[x][y] = true;


        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            for(int i=0; i<8; i++){
                int nx = tmp.x + dr[i];
                int ny = tmp.y + dc[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(map[nx][ny]==1 && check[nx][ny] == false){
                        check[nx][ny] = true;
                        queue.offer(new Node(nx,ny));
                    }
                }
            }

        }

    }
    public static void main(String[] args) {
        섬나라아일랜드BFS8 T = new 섬나라아일랜드BFS8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        check = new boolean[n][n];
        answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && check[i][j] == false){
                    answer = answer + 1;
                    T.BFS(i,j);
                }
            }
        }
        System.out.println(answer);

    }
}
