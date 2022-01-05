import java.util.Scanner;

public class 회문문자열 {
    public String soution(String str){
        String answer = "YES";
        // 0 1 1 0

        String tmp = new StringBuilder(str).reverse().toString();
        if(!str.equals(tmp)){
            return "NO";
        }

//        String tmp = str.toUpperCase();
//        int len = str.length();

//        for(int i =0; i<len/2; i++){
////            System.out.println(str.charAt(i) + " " + i +  "  " + str.indexOf(str.charAt(i)));
//            if(tmp.charAt(i) != tmp.charAt(len-i-1)) return "NO";
//        }
        return answer;
    }

    public static void main(String args[]){
        회문문자열 T = new 회문문자열();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.soution(str));


    }
}
