package 일반알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 씨름선수9 {

    static class Body implements Comparable<Body>{
        int h;
        int w;
        Body(int h, int w){
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(Body o){
            return o.h - this.h;
            // 내림차순
        }
    }

    public int solution(int n, ArrayList<Body> arrayList){
        int cnt =0;
        Collections.sort(arrayList);
        int max = Integer.MIN_VALUE;
        for(Body o : arrayList){
            // 내림 차순 정렬된것에서 몸무게만 비교하자
            if(o.w > max){
                max = o.w;
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        씨름선수9 T = new 씨름선수9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int heigth = sc.nextInt();
            int weigth = sc.nextInt();
            arrayList.add(new Body(heigth, weigth));
        }
        System.out.println(T.solution(n, arrayList));

    }
}
