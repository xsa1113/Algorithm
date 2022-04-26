package 일반알고리즘;

public class 부분집합구하기DFS7 {
    // 이거 중요 ******
    static int n;
    static int[] ch;
    public void DFS(int L){
        // 종착점일때
        if (L == n+1){
            String tmp = "";
            for(int i=1; i<=n; i++){
                if(ch[i] == 1) tmp+=(i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp);

        }
        // 종착점이 아닐때
        // 이진트리 순회 비슷한 느낌으로다가
        else{
            ch[L] = 1; // 사용한다.
            DFS(L+1); // 왼쪽
            ch[L] = 0; // 사용안한다.
            DFS(L+1); // 오른쪽이라고 생각
        }

    }


    public static void main(String[] args) {
        부분집합구하기DFS7 T = new 부분집합구하기DFS7();
        n=3;
        ch = new int[n+1];// index 번호로
        T.DFS(1);
    }
}
