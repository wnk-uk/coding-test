import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class BaekJoon11722 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
               if (arr[i] < arr[j]) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
               }
            }
        }

        System.out.println(Arrays.stream(dp).max().orElseThrow(NoSuchElementException::new));

    }
}
