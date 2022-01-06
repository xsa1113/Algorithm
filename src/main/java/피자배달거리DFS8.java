import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리DFS8 {
    // nxn
    // 0빈칸, 1집, 2피자집
    // 피자 배달거리 좌표의 절대값으로 표시
    // arrayList 접근은 좋았다
    // 조합
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,len,answer =Integer.MAX_VALUE;
    static int combi[];
    static ArrayList<Node> pz,hs;

    public void DFS(int L, int s){
        if(L==m){
            int sum =0;
            // 0 1 2 3
            // combi 피자집이 들어가있고
            for(Node h : hs){
                int dis = Integer.MAX_VALUE;
                for(int i : combi){
                    // 조합의 인덱스 번호 하나씩 대응
                    // 살아남은 피자집 인덱스 번호
                    // i 인덱스에 살아남은 피자 집이 잇으니까
                    // arraylist pz 에서 해당하는 인덱스 i 번째에서 뽑아오자
                    dis = Math.min(dis,Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
                }
                sum+=dis;
            }
            answer = Math.min(answer, sum);
        }else{
            // 피자집의 개수  6Cm
            for(int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }
    public static void main(String[] args) {
        피자배달거리DFS8 T = new 피자배달거리DFS8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        // 한번 다 넣고
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = sc.nextInt();
                if(tmp == 1){
                    hs.add(new Node(i,j));
                }else if(tmp == 2){
                    pz.add(new Node(i,j));
                }
            }
        }
        //
        len = pz.size(); // 피자 집의 개수
        combi = new int[m]; // m개를 뽑자
        T.DFS(0,0);
        System.out.println(answer);
    }
}
