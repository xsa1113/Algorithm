import java.util.*;
public class 뒤집은소수2 {
    //소수 확인하는거
    public boolean isPrime(int num){
        if(num ==1 ) return false;
        for(int i=2; i<num; i++){
            // 나머지 0이면 약수인거니까
            if(num%i==0) return false;
        }
        return true;

    }
    public ArrayList<Integer> solution(int N, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i =0; i<N; i++){
            int tmp = arr[i];
            //숫자 뒤집는 공식 0은 제외할때
            int res = 0;
            while(tmp > 0){
                int t = tmp%10;
                res = res * 10 + t;
                tmp = tmp/10;
            }
            if(isPrime(res)){
                answer.add(res);
            }
        }

        return answer;

    }
    public static void main(String[] args) {
        뒤집은소수2 T = new 뒤집은소수2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(n, arr)){
            System.out.print(x + " ");
        }


    }
}
