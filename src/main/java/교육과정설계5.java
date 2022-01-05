import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 교육과정설계5 {

    //CBA 필수 이수 과목 순서대로 해야함
    //CBDAGE 이렇게 수강신청 가능한지?

    // queue  C  B  A

    // queue2 C  B  D  A  G  E

    // C A B D G E

    public String solution(String str1, String str2){
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for(char x : str1.toCharArray()) queue.offer(x);
        for(char x : str2.toCharArray()){
            if(queue.contains(x)){
                if(queue.poll() != x){
                    return "NO";
                }
            }
        }

        // 필수과목 다듣지 않았을때
      if(!queue.isEmpty())
            return "NO";


        return answer;
    }
    public static void main(String[] args) {
        교육과정설계5 T = new 교육과정설계5();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(T.solution(str1, str2));

    }
}
