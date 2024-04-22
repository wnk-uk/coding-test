import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2589 {

    static int[][] arr;
    static int[][] v;
    static int[][] dy;
    static int x, y, max, answer;
    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[x][y];
        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == 1) {
                    v = new int[x][y];
                    dy = new int[x][y];
                    max = 0;
                    BFS(new Node(i, j));
                    answer = Math.max(answer, max);
                }
            }
        }
        System.out.println(answer);
    }

    private static void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        v[node.x][node.y] = 1;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int k = 0; k < d.length; k++) {
                int cx = curr.x + d[k][0];
                int cy = curr.y + d[k][1];

                if (cx >= 0 && cy >= 0 && cx < x && cy < y) {
                    if (v[cx][cy] == 0 && arr[cx][cy] == 1) {
                        v[cx][cy] = 1;
                        dy[cx][cy] = dy[curr.x][curr.y] + 1;
                        max = Math.max(max, dy[cx][cy]);
                        q.offer(new Node(cx, cy));
                    }
                }
            }
        }
    }

    public static class Node {
        int x,y;
        public Node (int... arr) {
            x = arr[0];
            y = arr[1];
        }
    }


}
