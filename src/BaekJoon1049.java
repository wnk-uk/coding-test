import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1049 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 M



        long[] dy = new long[101 + N];
        Arrays.fill(dy, Long.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); //기타줄 6개가 들어있는 패키지의 가격 6 = x
            int y = Integer.parseInt(st.nextToken()); //낱개가격  1 = y

            for (int n = 0; n < 2; n++) {
                int z = (n == 0) ? 1 : 6;
                int w = (n == 0) ? y : x;
                for (int j = z; j < 101 + N; j++) {
                    dy[j] = Math.min(dy[j], dy[j - z] + w);
                }
            }
        }

        long answer = Long.MAX_VALUE;
        for (int i = N; i < dy.length; i++) {
            answer = Math.min(answer, dy[i]);
        }

        System.out.println(answer);



    }
}
