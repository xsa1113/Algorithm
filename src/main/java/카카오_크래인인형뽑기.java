import java.util.*;
public class 카카오_크래인인형뽑기 {


        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            // 크기
            int len = board.length;
            Stack<Integer> stack = new Stack<>();

            for(int x : moves){
                for(int i=0; i<len; i++){
                    if(board[i][x-1] > 0){
                        int tmp = board[i][x-1];
                        if(!stack.isEmpty()){
                            if (tmp == stack.peek()){
                                stack.pop();
                                answer+= 2;
                            }else{
                                stack.add(tmp);
                            }
                        }else{
                            stack.add(tmp);
                        }
                        board[i][x-1] = 0;
                        break;
                    }
                }
            }

            return answer;
        }

}
