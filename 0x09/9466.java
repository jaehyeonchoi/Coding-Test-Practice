import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            vis = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;

            for (int j = 1; j <= n; j++) {
                if (!vis[j]) {
                    Queue<Integer> queue = new LinkedList<>();

                    int next = j;
                    while (true) {
                        queue.add(next);
                        vis[next] = true;
                        next = arr[next];

                        if (vis[next]) { // 이미 본 사람이 또 나움
                            if (queue.contains(next)) { // 사이클이 생기는 경우
                                while (queue.poll() != next) { // 사이클 등장 이전까지는 모두 실패 처리
                                    count++;
                                }
                                break;
                            }
                            // 사이클이 없는 경우
                            count += queue.size();
                            break;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
