package 최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 끝나지않는파티11265 {
    static int n,m;
    static int map[][];
    static String eop= "Enjoy other party";
    static String sh = "Stay here";
    public static void main(String[] args) {
        // n 크기의 map
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map= new int[n][n];
        // m 열명
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        //플로이드 와샬 사용해보괴
        //전체 경로를 탐색하면서 바로 정보 적기
        // 중간 거치는 단계
        for(int k=0; k<n; k++){
            // 시작단계
            for(int i=0; i<n; i++){
                //도착 단계
                for(int j=0; j<n; j++){
                    map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int to = sc.nextInt() ;
            int from = sc.nextInt() ;
            int time = sc.nextInt() ;
            if(map[to-1][from-1] <= time){
                sb.append("Enjoy other party").append("\n");
            }else {
                sb.append("Stay here").append("\n");
            }
        }
        System.out.println(sb);
    }

}
