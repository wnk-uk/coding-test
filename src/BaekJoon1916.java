import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1916 {

    static ArrayList<ArrayList<Node>> arr;
    static int[] v, dy;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //도시
        M = Integer.parseInt(br.readLine()); //버스

        arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        v = new int[N + 1];
        dy = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        BFS(s);

        System.out.println(dy[e]);
    }

    public static class Node {
        int b, c;

        public Node(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }

    private static void BFS(int s) {
        Arrays.fill(dy,Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.c - o2.c));
        q.offer(new Node(s, 0));
        dy[s] = 0;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (v[n.b] == 0) {
                v[n.b] = 1;
                for (Node node : arr.get(n.b)) {
                    int i = node.b;
                    int c = node.c;
                    if (dy[i] > dy[n.b] + c) {
                        dy[i] = dy[n.b] + c;
                        q.offer(new Node(i, dy[i]));
                    }
                }
            }

        }
    }
}
