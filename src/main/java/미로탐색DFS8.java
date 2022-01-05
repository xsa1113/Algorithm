import java.util.Scanner;

public class 미로탐색DFS8 {
    static int [] dr = {-1,0,1,0};
    static int [] dc = {0,1,0,-1};
    static int answer = 0;
    static int map[][] = new int[7][7];

    public void DFS(int r, int c){
        if(r == 6 && c == 6){
            answer ++;
        }else{
                for(int i=0; i<4; i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(nr>=0 && nc>=0 && nr<7 && nc<7){
                        if(map[nr][nc] == 0){
                            map[nr][nc] = 1;
                            DFS(nr,nc);
                            map[nr][nc] =0;
                        }
                    }
                }
        }
    }
    public static void main(String[] args) {
        미로탐색DFS8 T = new 미로탐색DFS8();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                map[i][j] = sc.nextInt();
            }
        }
        //출발지점도 꼭체크하기..
        map[0][0] = 1;
        T.DFS(0,0);
        System.out.println(answer);
    }
}
