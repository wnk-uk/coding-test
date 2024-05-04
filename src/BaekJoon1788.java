import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1788 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //n이 짝수면 양수
        //n이 홀수면 음수

        long[] arr = new long[1000001];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= Math.abs(n); i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000000;
        }

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        else if (n < 0) {
            if (n % 2 == 0) System.out.println(-1);
            else System.out.println(1);
        } else {
            System.out.println(1);
        }


        System.out.println(arr[Math.abs(n)]);
    }

}
