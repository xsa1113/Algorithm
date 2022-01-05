import java.util.Scanner;

public class 보이는학생2 {
    public int solution(int n, int[] arr){
        int answer = 0;
        int cnt = 0;
        int maxtall = 0;

        for(int i =0; i<arr.length; i++){
            if(maxtall < arr[i]){
                maxtall = arr[i];
                cnt++;
            }
        }
        answer = cnt;

        return answer;


    }
    public static void main(String[] args) {
        보이는학생2 T = new 보이는학생2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i =0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N,arr));


    }
}
