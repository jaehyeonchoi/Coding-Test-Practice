import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.getFirst()).append("\n");
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
