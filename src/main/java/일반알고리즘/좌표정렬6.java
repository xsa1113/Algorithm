package 일반알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 좌표정렬6 {
    //5
    //2 7
    //1 3
    //1 2
    //2 5
    //3 6
    // point 클래스의 객체를 정렬
    static class Point implements Comparable<Point>{
        public int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o){
            // 오름 내림
            // this가 앞이고 o 객체를 뒤라고 생각 this -> o객체
            // 오름차순이라면 음수값( this - o객체)
            // 내림차순이라면 양수값( o객체 - this)
            if(this.x == o.x) return this.y-o.y;
            else return this.x - o.x;
        }
    }


    public static void main(String[] args) {
        좌표정렬6 T = new 좌표정렬6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr= new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        for(Point o : arr){
            System.out.println(o.x + " " + o.y);
        }
    }
}
