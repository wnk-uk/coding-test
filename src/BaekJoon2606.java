import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2606 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        int[] visit = new int[N + 1];
        StringTokenizer st;

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        System.out.println(DFS(1, arr, visit));
    }

    private static int DFS(int L, int[][] arr, int[] visit) {
        visit[L] = 1;
        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[L][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                DFS(i, arr, visit);
                answer++;
            }
        }
        return answer;
    }
}
