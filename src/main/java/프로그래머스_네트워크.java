import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 프로그래머스_네트워크 {
	static boolean[] visit;
	static List<Integer>[] list;
	static int free, group;
	
	// 깊이 탐색 우선을 가지고 끝까지 탐색 한 네트워크를 계속 찾기 
	// visit으로 확인하고
	
	public int solution(int n,int arr[][] ) {
		int answer = 0;
		list = new List[n];
		visit = new boolean[n];
	
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				if(i != j && arr[i][j] == 1) {
					list[i].add(j);
				}
				if(arr[i][j] == 1) cnt++;
			}
			if(cnt == 1) {
				visit[i] = true;
				free ++;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				dfs(i);
				group++;
			}
		}
		
		
		return free + group;
	}
	
	static void dfs(int com) {
		visit[com] = true;
		for(int i : list[com]) {
			if(!visit[i])
				dfs(i);
		}
	}
	
	public static void main(String args[]) {
		프로그래머스_네트워크 T = new 프로그래머스_네트워크();
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][3];
		int n = sc.nextInt();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(T.solution(n,arr));
		
		
	}

}
