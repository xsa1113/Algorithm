package 일반알고리즘;

import java.util.*;

public class SWEA_7701 {
    static int n;
    //HASHMAP 연습
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test=1; test<=tc; test++){
            sb.append("#" + test + "\n");
            n=Integer.parseInt(sc.next());
            // hashset은 들어간거는 자동으로 중복검사를 해준다 중복은 안됨
            HashSet<String> names = new HashSet<String>();

            //일단 자동으로 중복체크가 되었겠
            for(int i=0; i<n; i++){
                names.add(sc.next());
            }

            //입력
            ArrayList<String> nameList = new ArrayList<>(names);
            Collections.sort(nameList,new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    if(s1.length()==s2.length()){
                        //길이가 같은 경우 사전순
                        return s1.compareTo(s2);
                    }
                    return s1.length()-s2.length(); // 길이순
                }
            });

            //출력
            for(String i : nameList){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
