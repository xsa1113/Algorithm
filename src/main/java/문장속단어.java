import java.util.Scanner;

public class 문장속단어 {
    public String solution(String str){
        //가장긴 단어를 찾아라
        //띄어쓰기로 나눠짐
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos = Integer.MIN_VALUE;
        //split 띄어쓰기로 배열에 들어감
//        String[] s = str.split(" ");
//        for(String x : s){
//            int len = x.length();
//            if(len > max){
//                max = len;
//                answer = x;
//            }
//        }

        // index of 로 해보자
        // index of 는 띄어쓰기가 발견되면 곳을 리턴
        // 발견을 못하면 -1
        while((pos=str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > max){
                len = max;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        //index of 는 마지막단어를 한번 더 해줘야한다다
        if(str.length() > max) answer = str;

        return answer;
    }
    public static void main(String[] args){
        문장속단어 T = new 문장속단어();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
