package 일반알고리즘;

public class 재귀함수를이용한이진수7 {

    public void DFS (int n ){
        if( n== 0){
            return;

        }else{
            int m = n/2;
            int k = n%2;
            DFS(m);
            System.out.print(k + "");

        }

    }
    public static void main(String[] args) {
        재귀함수를이용한이진수7 T = new 재귀함수를이용한이진수7();
        T.DFS(11);
    }
}
