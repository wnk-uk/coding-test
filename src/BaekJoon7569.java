import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon7569 {

    static int[][][] arr;
    static Queue<Point> q = new LinkedList<>();
    static int N, M, H;

    static int[][] d = {{0, 0 ,1}, {0, -1, 0}, {0, 0, -1}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        arr = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    int x = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = x;
                    if (x == 1) q.offer(new Point(i, j, k));
                }
            }
        }
        System.out.println(BFS());
    }

    private static int BFS() {

        while (!q.isEmpty()) {
            int len = q.size();
            for (int qi = 0; qi < len; qi++) {
                Point curr = q.poll();

                int cz = curr.z;
                int cx = curr.x;
                int cy = curr.y;

                for (int i = 0; i < d.length; i++) {
                    int dz = cz + d[i][0];
                    int dx = cx + d[i][1];
                    int dy = cy + d[i][2];

                    if (isLen(dz, dx, dy) && arr[dz][dx][dy] == 0) {
                        arr[dz][dx][dy] = arr[cz][cx][cy] + 1;
                        q.offer(new Point(dz, dx, dy));
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) return -1;
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }

        return result == 1 ? 0 : result - 1;
    }

    private static boolean isLen(int dz, int dx, int dy) {
        if (dz >= 0 && dx >= 0 && dy >= 0 && dz < H && dx < N && dy < M) return true;
        else return false;
    }

    public static class Point {
        int x, y, z;
        public Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
