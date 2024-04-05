import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int idx = 1;
        while (true) {
            String str = br.readLine();
            if (str.indexOf("-") > -1) break;
            int answer = 0;

            Stack<String> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if (stack.size() != 0) {
                    String b = stack.pop();

                    if (!(b.intern() == "{" && s.intern() == "}")) {
                        stack.push(b);
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            }

            while (stack.size() > 0) {
                String b1 = stack.pop();
                String b2 = stack.pop();

                if (b2.intern() == "}" && b1.intern() != b2.intern()) answer += 2;
                else answer += 1;
            }


            sb.append(idx + ". " + answer + "\n");
            idx++;
        }

        System.out.println(sb.toString());


    }

}
