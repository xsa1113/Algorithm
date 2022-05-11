package 백트래킹;

public class 조합연습 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int r = 2;
        // 2개를 뽑자
        boolean check[] = new boolean[4];
        backtracking(arr,check,0,0,r);
    }
    static void backtracking(int arr[], boolean check[], int start, int depth,int r){
        if(depth == r){
            for(int i=0; i<arr.length; i++){
                if(check[i]) System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!check[i]){
                check[i] = true;
                backtracking(arr,check,start+1,depth+1,r);
                check[i] = false;
            }
        }
    }
}
