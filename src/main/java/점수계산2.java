import java.util.Scanner;

public class 점수계산2 {
    public int solution(int N , int arr[]){
        // 답이 맞은 경우 1, 아닌경우 0
        // 연속되면 답 정답이 올라감
        int answer = 0;
        int score = 0;
        boolean flag = true;

        for(int i =0; i<N; i++){
            if(arr[i] ==1){
                answer += 1;
                answer += score;
                score++;

            }else{
                score = 0;
            }
        }

        return answer;


    }
    public static void main(String[] args) {
        점수계산2 T = new 점수계산2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N,arr));

    }
}
