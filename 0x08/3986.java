import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() % 2 != 0) {
                continue;
            }

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
