public class 피보나치메모이제이션 {
    static int[] fibo;
    public int solution(int n ){
        // 메모이제이션 굳이 다돌 필요없이 어차피 넣어뒀잖아 그걸 활용해보자
        if(fibo[n]>0) return fibo[n];

        // fibo에 넣어서 for 문돌려서 ㄴㄴㄴ stack 프레임때문에 재귀가 for문보다
        // 느리다
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else return fibo[n] = solution(n-2)+solution(n-1);

    }
    public static void main(String[] args) {
        피보나치메모이제이션 T = new 피보나치메모이제이션();
        int n = 10;
        fibo = new int[n+1];
        T.solution(n);

        for(int i=1; i<=n; i++){
            System.out.print(fibo[i] + " ");
        }



    }
}
