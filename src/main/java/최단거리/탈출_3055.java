package 최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출_3055 {
    // 탈출 다시 해보기
    static int[] zr = {-1,0,1,0};
    static int[] zc = {0,1,0,-1};
    static int er,ec;
    static int start_r, start_c;
    static int map[][];
    static boolean check[][];
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Node> water;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start_r = sc.nextInt();
        start_c = sc.nextInt();

        map = new int[start_r][start_c];
        check = new boolean[start_r][start_c];
        water = new LinkedList<>();

        // 1번이 -> 3번으로 가야함
        // 0번은 돌멩이
        // 2번 물
        for(int i=0; i<start_r; i++){
            String str = sc.next();
            // A 65, Z 90 , S 83, D 68
            // . 46 * 42
            for(int j=0; j<str.length(); j++){
                // S 라면  17
                if(str.charAt(j) - 'A' == -17 ){
                    // 시작
                    map[i][j] = 1;
                }
                // D라면
                else if (str.charAt(j) - 'A' == -3){
                    map[i][j] = 3;
                }
                // .라면
                else if (str.charAt(j) - 'A' == -19){
                    map[i][j] = 0;
                }else if(str.charAt(j) - 'A' == -23){
                    map[i][j] = 2;
                }
            }
        }
        for(int i=0; i<start_r; i++){
            for(int j=0; j<start_c; j++){
                if(map[i][j] == 3){
                    // 도착지
                    er = i;
                    ec = j;
                }
                else if(map[i][j] == 1){
                    bfs(i, j);
                }
            }
        }
    }
    static void bfs(int r, int c){
        Queue<Node> run = new LinkedList<>();
        run.offer(new Node(r,c));

        while(!run.isEmpty()){
            Node cur= run.poll();

            for(int i=0; i<4; i++){
                int nr = cur.x + zr[i];
                int nc = cur.y + zc[i];

                // 다음이 도착이라면
                if(map[nr][nc] == 3){

                }

                if(map[nr][nc] == 0 && nr >= 0 && nc >= 0 && nr < start_r && nc < start_c){
                    // 만약 안에 있다면
                    run.offer(new Node(nr, nc));
                }
            }

        }

    }
}
