import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 응급실5 {
    //5 2
    //60 50 70 80 90
    //새로운 클래스 생성
    class person{
        int id;
        int priority;
        public person(int id, int priority){
            this.id = id ;
            this.priority = priority;
        }
    }
    public int solution(int n, int m, int[] arr){
        // m 번째 사람 0 부터 시작하는데
        int answer = 0;
        // 우선순위 큐 -> 클래스를 만들어서 id, prioirty를 같이 가지고 가기
        Queue<person> queue = new LinkedList<>();
        // 돌면서 큐에 넣기
        for(int i =0; i<n; i++){
            queue.offer(new person(i,arr[i]));
        }

        while (!queue.isEmpty()) {
            // 한개 뽑고
            person tmp = queue.poll();
            // 일단 순환?
            for(person x : queue){
                if(x.priority > tmp.priority){
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(m == tmp.id) return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        응급실5 T = new 응급실5();
        Scanner sc = new Scanner(System.in);
        //N
        //M
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n,m,arr));


    }
}
