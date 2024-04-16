import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11060 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dy = new int[1101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dy[i] = Integer.MAX_VALUE;
        }

        dy[1] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (dy[i] >= Integer.MAX_VALUE) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dy[i + j] = Math.min(dy[i + j], dy[i] + 1);
            }
        }

        System.out.println(dy[N] >= Integer.MAX_VALUE ? -1 : dy[N]);


    }

}
