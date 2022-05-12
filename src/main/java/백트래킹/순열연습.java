package 백트래킹;

public class 순열연습 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int r = 2;
        backtracking(arr,new int[r],new boolean[arr.length], 0, 0, r);
    }

    static void backtracking(int arr[],int[] out, boolean check[], int depth, int start, int r){
            if(depth == r){
                for(int num : out) System.out.print(num + " ");
                System.out.println();
                return;
            }

            // 1,2 2,1 다른 경우의 수이니까
            for(int i=0; i<arr.length; i++){
                if(!check[i]){
                    check[i] = true;
                    out[depth] = arr[i];
                    backtracking(arr,out,check,depth+1, start+1, r);
                    check[i] = false;

                }
            }

    }
}
