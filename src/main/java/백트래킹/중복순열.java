package 백트래킹;

public class 중복순열 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int r = 2;
        int out[] = new int[r];
        backtracking(arr, out, 0,0,r);
    }

    static void backtracking(int arr[], int out[], int depth, int start, int r ){
        if(depth == r){
            for(int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++){
            out[depth]  = arr[i];
            backtracking(arr, out, depth+1 , start+1, r);
        }
    }
}
