import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String command = br.readLine();

            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            StringTokenizer st = new StringTokenizer(arr.substring(1, arr.length() - 1));

            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken(","))); // comma로 tokenize
            }

            boolean front = true; // 앞뒤 방향
            boolean error = false; // 에러 여부

            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    front = !front; // 앞뒤 뒤집기
                }
                else {
                    if (deque.isEmpty()) { // deque이 비어있으면 바로 error
                        error = true;
                        break;
                    }
                    if (front) { // 방향에 따라 끝에 있는 숫자 제거
                        deque.removeFirst();
                    }
                    else {
                        deque.removeLast();
                    }
                }
            }

            if (error) {
                sb.append("error").append("\n");
            }
            else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(front ? deque.removeFirst() : deque.removeLast());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
