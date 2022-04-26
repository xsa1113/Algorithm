package 일반알고리즘;

public class 카카오_숫자와문자열 {


        public int solution(String s) {
            int answer = 0;
            // 문자열 길이

            s = s.replaceAll("zero","0");
            s = s.replaceAll("one","1");
            s = s.replaceAll("two","2");
            s = s.replaceAll("three","3");
            s = s.replaceAll("four","4");
            s = s.replaceAll("five","5");
            s = s.replaceAll("six","6");
            s = s.replaceAll("seven","7");
            s = s.replaceAll("eight","8");
            s = s.replaceAll("nine","9");

            answer = Integer.parseInt(s);

            return answer;
        }

}
