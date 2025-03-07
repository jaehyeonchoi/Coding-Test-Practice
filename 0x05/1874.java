import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int max = 0; // 현재 stack에 넣은 최댓값

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (stack.isEmpty() || stack.peek() < x) {
                // peek이 x가 될 때까지 push해야 함
                if (x < max) { // x보다 max가 큰 경우
                    System.out.println("NO"); // 이미 x가 들어가 있으므로 실패
                    return;
                }
                for (int j = max + 1; j < x + 1; j++) {
                    stack.push(j); // (max + 1)부터 x까지 push
                    sb.append("+").append("\n");
                }
                max = x;
                stack.pop(); // peek이 x가 되었으므로 pop
                sb.append("-").append("\n");
            }
            else if (stack.peek() == x) { // peek이 x인 경우
                stack.pop(); // 바로 pop하면 됨
                sb.append("-").append("\n");
            }
            else if (stack.peek() > x) { // peek이 x보다 큰 경우,
                System.out.println("NO"); // x를 꺼낼 수 없으므로 실패
                return;
            }
        }
        System.out.println(sb);
    }
}
