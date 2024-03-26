import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1516 {

    public static void main(String[] args) throws IOException {

        //일단 모든 웹사이트에 1점을 준다.
        //웹사이트 A에 웹사이트 B로 가는 링크가 있다면, 웹사이트 B의 점수에 웹사이트 A의 점수를 더한다.
        //A의 점수를 B에 더할 때는, B에서 A로의 링크가 직접적으로 또는 간접적으로 없을 때이다.

        //첫째 줄에 링크 정보의 개수 N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] time = new int[N + 1];
        int[] indegree = new int[N + 1];


        //각 건물을 짓는데 걸리는 시간과 그 건물을 짓기 위해 먼저 지어져야 하는 건물들의 번호
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            graph.add(new ArrayList<>());
            for (int x = Integer.parseInt(st.nextToken()); x != -1; x = Integer.parseInt(st.nextToken())) {
                graph.get(x).add(i);
                indegree[i]++;
            }
        }

        int[] dp = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dp[i] = time[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int x = q.poll();

            for (int y : graph.get(x)) {
                dp[y] = Math.max(dp[y], dp[x] + time[y]);

                indegree[y]--;
                if (indegree[y] == 0) {
                    q.offer(y);
                }
            }
        }

       for (int i = 1; i < dp.length; i++) {
           System.out.println(dp[i]);
       }



    }
}
