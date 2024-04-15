import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2644 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int[] visit = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        BFS(a, arr, visit, b);

        System.out.println(visit[b] == 0 ? -1 : visit[b]);

    }

    private static void BFS(int a, int[][] arr, int[] visit, int b) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(a);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (b == x) break;
            for (int i = 1; i < arr.length; i++) {
                if (visit[i] == 0 && arr[x][i] == 1) {
                    visit[i] = visit[x] + 1;
                    q.offer(i);
                }
            }
        }
    }
}
