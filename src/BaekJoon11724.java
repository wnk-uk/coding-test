import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11724 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        int[] visit = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = arr[v][u] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i] == 0) {
                DFS(i, arr, visit);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int i, int[][] arr, int[] visit) {
        visit[i] = 1;
        for (int j = 1; j < arr.length; j++) {
           if (arr[i][j] == 1 && visit[j] == 0) {
               visit[j] = 1;
               DFS(j, arr, visit);
           }
        }
    }
}
