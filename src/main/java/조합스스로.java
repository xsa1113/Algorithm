import java.util.Scanner;

public class 조합스스로 {
	static int n , m;
	static int answer = 0;
	//메모이제이션
	int [][] dy = new int[35][35];

	public int DFS(int n , int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n == r || r == 0) return 1;
		else return dy[n][r] = DFS(n-1,r-1) + DFS(n-1,r);
	}
	public static void main(String[] args) {
		조합스스로 T = new 조합스스로();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 총개 수 
		m = sc.nextInt(); // m 개 뽑은 경우의 수 
		System.out.println(T.DFS(n,m));
	}

}
