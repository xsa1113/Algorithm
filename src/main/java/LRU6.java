import java.util.Scanner;

public class LRU6 {
//    5 9
//    1 2 3 2 6 2 3 5 7
    public int[] solution(int s, int n , int[] arr){
        // 캐시 크기
        int [] cache = new int[s];
        for(int x : arr){
            int pos = -1; // index
            for(int i =0; i<s; i++) {
                if (cache[i] == x) {
                    pos = i;
                }
            }
                // miss 상ㅇ황, 옆으로 땡겨주기
                if(pos == -1){
                    for(int i = s-1; i>=1; i--){
                        cache[i] = cache[i-1];
                    }
                    cache[0] = x;
                }else{
                    // hit 가 난상황
                    for(int i = pos; i>=1; i--){
                        cache[i] = cache[i-1];
                    }
                    cache[0] = x;
                }


        }
            // 1 2
            // cache 1 -> arr[0]
            // cache 2 -> arr[0], 1 -> arr[1]
            // cache 3 -> arr[0], 2 -> arr[1], 1->arr[2]
        return cache;
    }
    public static void main(String[] args) {
        LRU6 T = new LRU6();
        Scanner sc = new Scanner(System.in);
        //캐시 크기
        int s = sc.nextInt();
        //작업 개수
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x : T.solution(s,n,arr)){
            System.out.print(x + " ");
        }

    }
}
