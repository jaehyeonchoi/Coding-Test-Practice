import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            boolean failed = false;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            failed = true;
                        }
                        break;
                    case '[':
                        stack.push(c);
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            failed = true;
                        }
                        break;
                }
                if (failed) {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                failed = true;
            }
            sb.append(failed ? "no" : "yes").append("\n");
        }
        System.out.println(sb);
    }
}
