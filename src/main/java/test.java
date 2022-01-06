import java.util.*;

public class test {

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
    static int[] combi;
    static int n,m,len, answer = Integer.MAX_VALUE;
    static ArrayList<Node> pz, hs;

    // 그니까 전체 집개수에서
    // 뽑힌 피자 집이 있을 거아니야
    // 전체 집을 돌면서 피자집이랑 그냥 가까운거리를 업데이트 시키고
    // 업뎃된 최소거리를 sum에다가 더하면서 가기
    // 또 그 4개의 조합중에서 가장 짧은 거리를 answer 에 담기

    public void DFS(int L , int s){
        if(L == m){
            // 조합당 sum
            for(int x : combi) System.out.print(x + " ");
            System.out.println();


//            int sum =0;
//
//            // 거리 계산을 해보자
//            for(Node h : hs){
//                int dis = Integer.MAX_VALUE; // 거리의 최소값을 구하고 싶으니까
//                for(int i : combi){
//                    // 이미 뽑아뒀잖아 combi라고 피자집 경우의 수를
//                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
//                }
//                sum += dis;
//            }
//            answer = Math.min(answer, sum);
        }else{
            // 조합 때려야지
            // combi에 피자집 6개중 4개 뽑은게 다들어가 있음
            for(int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }


    public static void main(String[] args) {
        test T = new test();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 맵 크기
        m = sc.nextInt(); // 뽑을 피자집 개수
        hs = new ArrayList<>();
        pz = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = sc.nextInt();
                if(tmp == 1){
                    // 1이 집
                    hs.add(new Node(i,j));
                }else if(tmp ==2){
                    pz.add(new Node(i,j));
                }
            }
        }
        len = pz.size(); // 피자집 개수
        combi = new int[m]; // 조합 몇개 뽑을지
        T.DFS(0,0);
        System.out.println(answer);
    }

}