import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        String B = st.nextToken();

        int cnt = 0;

        while (true) {
            int tmp = Integer.parseInt(B);
            String last = String.valueOf(B.charAt(B.length() -1));
            if (tmp % 2 == 0) {
                B = String.valueOf(tmp / 2);
            } else if (last.intern() == "1") {
                B = B.substring(0, B.length() - 1);
            } else {
                cnt = 0;
                break;
            }
            cnt++;

            if (A == Integer.parseInt(B)) break;
            else if (A > Integer.parseInt(B)) {
                cnt = 0;
                break;
            }
        }

        System.out.println(cnt > 0 ? cnt + 1 : -1);

    }

}
