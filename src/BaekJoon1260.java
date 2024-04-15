import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        int[] visit = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        StringBuffer sb = new StringBuffer();
        DFS(V, arr, visit, sb);
        System.out.println(sb.toString());

        sb = new StringBuffer();
        visit = new int[N + 1];
        BFS(V, arr, visit, sb);
        System.out.println(sb.toString());

    }

    private static void BFS(int v, int[][] arr, int[] visit, StringBuffer sb) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            int x = q.poll();
            visit[x] = 1;
            sb.append(x + " ");
            for (int i = 0; i < arr.length; i++) {
                if (visit[i] == 0 && arr[x][i] == 1) {
                    visit[i] = 1;
                    q.offer(i);
                }
            }
            L++;
        }
    }

    private static void DFS(int v, int[][] arr, int[] visit, StringBuffer sb) {
        visit[v] = 1;
        sb.append(v + " ");
        for (int i = 1; i < arr.length; i++) {
            if (visit[i] == 0 && arr[v][i] == 1) {
                visit[i] = 1;
                DFS(i, arr, visit, sb);
            }
        }
    }

}
