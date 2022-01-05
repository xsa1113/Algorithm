import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기5 {

    // 같은 이형 두개일 경우 사라진다
    // move가 주어져있고 일단 arr2 배열을 전체다 돌아보기
    // 열의 최초 발견된 arr 에서 뽑고 stack에 담는다
    static int res;
    static Stack<Integer> stack;

    public int solution(int n, int[][]arr, int move, int arr2[]){
        int answer = 0;
        stack = new Stack<>();
        res = 0;

        for(int i =0; i<move; i++){
            int tmp = arr2[i];

            for(int j=1; j<=n; j++){
                if(arr[j][tmp] != 0){

                    if(!stack.isEmpty()){
                        if(stack.peek() == arr[j][tmp]){
                            stack.pop();
                            res += 2;
                        }else{
                            stack.push(arr[j][tmp]);
                        }
                    }else{
                        stack.push(arr[j][tmp]);
                    }
                    arr[j][tmp] = 0;
                    break;
                }

            }
        }
        answer = res;

        return answer;
    }

    public static void main(String[] args) {
        크레인인형뽑기5 T = new 크레인인형뽑기5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n+1][n+1];

        for(int i =1; i<=n; i++){
            for(int j=1; j<=n; j++){
                arr[i][j] = sc.nextInt();

            }
        }

        int move = sc.nextInt();
        int arr2[] = new int[move];

        for(int i =0; i<move; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr, move, arr2));


    }
}
