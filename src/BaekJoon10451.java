import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10451 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[][] arr = new int[N + 1][N + 1];
            int[] visit = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j][Integer.parseInt(st.nextToken())] = 1;
            }

            int answer = 0;
            for (int k = 1; k < N + 1; k++) {
                if (visit[k] == 0) {
                    DFS(k, arr, visit, N);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void DFS(int L, int[][] arr, int[] visit, int N) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[L][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                DFS(i, arr , visit, N);
            }
        }
    }

}
