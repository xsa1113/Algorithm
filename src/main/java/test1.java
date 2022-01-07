import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test1 {
    static class Body implements Comparable<Body>{
        int h;
        int w;
        public Body(int h, int w){
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(Body o){
            return o.h - this.h;
            // 내림차순으로 정의
        }
    }

    public int solution(int n, ArrayList<Body> arr){
        int cnt = 0;
        // 오름차순으로 바꿔주고
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        //for each문으로 해도됨
        int len = arr.size();
        for(int i=0; i<len; i++){
            if(arr.get(i).w > max){
                max = arr.get(i).w;
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        test1 T = new test1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h,w));
        }
        //오케이

        System.out.println(T.solution(n, arr));

    }
}

