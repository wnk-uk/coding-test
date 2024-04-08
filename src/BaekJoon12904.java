import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        StringBuffer tmp = new StringBuffer();
        tmp.append(T);

        for (int i = 0; i < T.length(); i++) {
            char x = tmp.charAt(tmp.length() - 1);
            tmp.deleteCharAt(tmp.length() - 1);

            if (x == 'B') {
                tmp.reverse();
            }

            if (tmp.toString().intern() == S.intern()) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

}
