import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(i + 1);
        }

        int totalCount = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Integer x = Integer.parseInt(st.nextToken());
            int count = 0;
            while (true) {
                if (x.equals(deque.getFirst())) {
                    deque.removeFirst();
                    break;
                }
                deque.addLast(deque.removeFirst());
                count++;
            }
            if (count > (deque.size() + 1) / 2) {
                count = (deque.size() + 1) - count;
            }
            totalCount += count;
        }
        System.out.println(totalCount);
    }
}
