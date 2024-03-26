import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1766 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] indegree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // A번 문제는 B번 문제보다 먼저 푸는 것이 좋다
            graph.get(A).add(B);
            indegree[B]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int[] dy = new int[N + 1];
        for (int i = 1; i < indegree.length; i++) {
            dy[i] = i;
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder anwser = new StringBuilder();

        while (!q.isEmpty()) {
            int x = q.poll();
            anwser.append(x + " ");

            for (int y : graph.get(x)) {
                indegree[y]--;
                if (indegree[y] == 0) {
                    q.offer(y);
                }
            }
        }

        System.out.println(anwser.toString());


    }

}
