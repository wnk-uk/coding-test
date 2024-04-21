import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1240 {

    static int[][] arr;
    static int[] v;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = c;
        }

        for (int i = 0; i < M; i++) {
            v = new int[N + 1];
            dy = new int[N + 1];
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            DFS(x, y);

            System.out.println(dy[y]);
        }


    }

    private static void DFS(int x, int y) {
        v[x] = 1;
        if (x == y) return;
        for (int i = 1; i < arr[x].length; i++) {
            if (arr[x][i] > 0 && v[i] == 0) {
                v[i] = 1;
                dy[i] = dy[x] + arr[x][i];
                DFS(i, y);
            }
        }
    }
}
