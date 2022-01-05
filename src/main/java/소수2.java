import java.util.Scanner;

public class 소수2 {
    public int solution(int N){
        //에라토스테네스 체
        //2의 배수들은 배제
        int answer = 0;
        int[] ch = new int[N+1];
        for(int i =2; i<=N; i++){
            if(ch[i] ==0 ){
                answer++;
                //여기서 배수니까
                for(int j = i; j<=N; j=j+i){
                    ch[j] = 1;
                }
            }
        }
        return answer ;
    }

    public static void main(String[] args) {
        소수2 T = new 소수2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));

    }
}
