import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int back = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            Integer res = -1;

            switch (command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    queue.add(X);
                    back = X;
                    break;
                case "pop":
                    res = queue.poll();
                    if (res == null) {
                        res = -1;
                    }
                    System.out.println(res);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    res = 0;
                    if (queue.isEmpty()) {
                        res = 1;
                    }
                    System.out.println(res);
                    break;
                case "front":
                    res = queue.peek();
                    if (res == null) {
                        res = -1;
                    }
                    System.out.println(res);
                    break;
                case "back":
                    res = -1;
                    if (!queue.isEmpty()) {
                        res = back;
                    }
                    System.out.println(res);
                    break;
            }
        }
    }
}
