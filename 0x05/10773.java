import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                stack.push(x);
            }
            else {
                stack.pop();
            }
        }

        int sum = 0;
        for (int x : stack) {
            sum += x;
        }
        System.out.println(sum);
    }
}
