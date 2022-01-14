import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자해독_백준 {
    private static boolean same(int[] w, int [] s){
        for(int i=0; i<52; i++)
            if(w[i]!=s[i]) return false;
            return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //4 11
        //cAda
        //AbrAcadAbRa

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] w = br.readLine().toCharArray(); // cAda
        char[] s = br.readLine().toCharArray(); // AbrAcadAbRa

        int[] wAlpha = new int[52]; // 대문자 소문자 다 담겠다 이마인드
        for(int i=0; i<n; i++){
            if(w[i] < 'a') wAlpha[w[i]-'A']++; // 대문자이면
            else wAlpha[w[i]-'a'+26]++; // 소문자이면
        }

        int[] sAlpha = new int[52];
        int next , len = 0, answer = 0, from=0;
        for(int i=0; i<m; i++){
            if(s[i] < 'a') next = s[i] - 'A'; //대문자이면
            else next = s[i] -'a' + 26;
            len++;
            sAlpha[next]++;
            if(len==n){
                if(same(wAlpha,sAlpha)) answer++;

                if(s[from] < 'a') sAlpha[s[from] -'A']--;
                else sAlpha[s[from]-'a'+26]--;
                from ++; len--;
            }
        }
        System.out.println(answer);

    }

}
