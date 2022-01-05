import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기7 {
    // 현수위치 S
    // 송아지 위치 E
    // 앞1, 뒤1, 앞5
    static int answer;
    static int check[];
    static int[] dis = {1,-1,5};
    Queue<Integer> queue = new LinkedList<>();

    public int solution(int s, int e){
        check = new int[10001];
        check[s] = 1;
        queue.offer(s);
        int L = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i =0; i<len; i++){
                int x= queue.poll();
                if(x == e) return L;
                for(int j=0; j<3; j++){
                    int nx = x+dis[j];
                    if(nx>=1 && nx<10001 && check[nx] == 0){
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        송아지찾기7 T = new 송아지찾기7();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.solution(s, e));

    }
}
