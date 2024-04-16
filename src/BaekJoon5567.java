import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon5567 {

    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[n + 1][n + 1];
        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        BFS(1, arr, ch);
        System.out.println(answer);
    }

    private static void BFS(int v, int[][] arr, int[] ch) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        ch[v] = 1;
        int L = 0;
        while (true) {
            if (L > 1) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 1; j < arr.length; j++) {
                    if (ch[j] == 0 && arr[x][j] == 1) {
                        ch[j] = 1;
                        q.offer(j);
                        answer++;
                    }
                }
            }
            L++;
        }

    }
}
