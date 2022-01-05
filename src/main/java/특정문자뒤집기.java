import java.util.Scanner;

public class 특정문자뒤집기 {
    public String solution(String str){
        String answer = "";
//        String tmp = str.toLowerCase();
        char[] a = str.toCharArray();
        int lt = 0, rt = str.length() -1 ;
            // 만약 영어이면 , 65~90
            // 97~122
            // 아니면 특수문자인지 찾기
        while (lt < rt) {
            // 알파벳 아니면 거짓
            // Character.isAlphabetic()
            if(!Character.isAlphabetic(a[lt])) lt++;
            else if(!Character.isAlphabetic(a[rt])) rt--;
            else{
                char tmp = a[lt];
                a[lt] = a[rt];
                a[rt] = tmp;
                lt ++;
                rt --;
            }

        }

//                while(lt < rt){
//                    if(a[lt] >= 97 && a[lt] <= 122 && a[rt] >= 97 && a[rt] <= 122){
//                        char kk = a[lt];
//                        a[lt] = a[rt];
//                        a[rt] = kk;
//                        lt ++;
//                        rt --;
//                    }else{
//                        lt ++;
//                        rt --;
//                    }
//                }

        answer = String.valueOf(a);
        return answer;
    }

    public static void main(String[] args){
        특정문자뒤집기 T = new 특정문자뒤집기();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
