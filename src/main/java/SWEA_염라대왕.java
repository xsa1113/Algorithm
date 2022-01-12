import java.util.*;

public class SWEA_염라대왕 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test = 0; test<tc; test++){
            sb.append("#" + test + "\n");
            n = Integer.parseInt(sc.next());
            HashSet<String> name = new HashSet<>();

            for(int i=0; i<n; i++){
                name.add(sc.next());
            }

            ArrayList<String> nameList = new ArrayList<>(name);
            Collections.sort(nameList,new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    if(s1.length() == s2.length()){
                        return s1.compareTo(s2);
                    }
                    return s1.length() - s2.length();
                }
            });

            for(String i : nameList){
                System.out.println(i);
            }
        }
        System.out.println(sb);
    }
}
