import java.util.Scanner;

public class 프로그래머스_문자열압축 {
    public int solution(String s){
        int answer =Integer.MAX_VALUE;
        // 1. r 길이만큼 patteren을 구해준다 substring
        // 2. pattern 다음 문자열부터 순차적으로 탐색
        // 3. 이렇게 모든 문자열들의 압축 정보를 구해 최솟값을 출력해준다.
        // 문자열의 길이를 먼저 출력
        int len = s.length();
        // 처음 길이가 1 로 시작하면 1로 리턴하기
        if(len == 1) return 1;
        for(int r=1; r<=len/2; r++){
            String pattern = s.substring(0,r);
            int compLen = 0;
            int cnt =1;
            String reStr = ""; // 끊기는 문자열을 여기에다가 다시 담기
            for(int i=r; i<=s.length()-r; i+=r){
                if(pattern.equals(s.substring(i,i+r))){
                    cnt ++;
                }else{
                    // 문자열 묶은 개수를 적어준다
                    if(cnt>1){
                        reStr += cnt+"";
                    }
                    reStr += pattern;
                    pattern = s.substring(i,i+r);
                    cnt = 1;
                }
            }
            if(cnt > 1){
                reStr += "" + cnt;
            }
            reStr += pattern;

            int div = s.length() % r; // 나머지
            answer = Math.min(answer, reStr.length() + div);
        }
        return answer;

    }
    public static void main(String[] args) {
        프로그래머스_문자열압축 T = new 프로그래머스_문자열압축();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));

    }
}
