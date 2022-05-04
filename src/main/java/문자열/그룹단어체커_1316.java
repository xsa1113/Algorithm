package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class 그룹단어체커_1316 {
    /*
    * 5
ab
aa
aca
ba
bb
    * */
    public static void main(String[] args) {
        //happy
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 0;
        boolean flag;
        boolean check[] = new boolean[26];
        Arrays.fill(check, false);
        for(int i=0; i<n; i++){
            String str = sc.next();
            // 문자열 길이만큼 돌리기
            flag = false;

            for(int j=0; j<str.length() - 1; ){
                int cnt = 0;
                int tmp = str.charAt(j) - 'a';
                int tmp2 = str.charAt(j+1) - 'a';

                if(check[tmp]){
                    flag = true;
                    break;
                }

                if(tmp == tmp2){
                    j++;
                }else{
                    if(check[tmp2]){
                        flag = true;
                        break;
                    }else{
                        check[tmp] = true;
                        j++;
                    }
                }

            }
            if(!flag){
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
