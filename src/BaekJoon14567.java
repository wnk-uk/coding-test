import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14567 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] indegree = new int[N + 1];
        indegree[0] = 0;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        //1 -> 2, 3
        //2 -> 3, 5
        //3 -> 1, 5


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            indegree[y]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        int[] dy = new int[N + 1];

        for (int i = 1; i < indegree.length; i++) {
            dy[i] = 1;
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y : graph.get(x)) {
                dy[y] = Math.max(dy[y], dy[x] + 1);
                indegree[y]--;
                if (indegree[y] == 0) {
                    q.offer(y);
                }
            }
        }

        for (int i = 1; i < dy.length; i++) {
            System.out.println(dy[i]);
        }


    }

}
