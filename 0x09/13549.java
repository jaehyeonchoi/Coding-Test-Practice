import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr = new int[100001];
    static boolean[] vis = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        vis[N] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int time = point.time;

            if (x == K) {
                System.out.println(time);
                return;
            }

            Point[] nextPoints = {
                    new Point(x * 2, time),
                    new Point(x - 1, time + 1),
                    new Point(x + 1, time + 1)
            };

            for (Point nextPoint : nextPoints) {
                if (nextPoint.isValid() && nextPoint.isNew()) {
                    queue.add(nextPoint);
                    vis[nextPoint.x] = true;
                }
            }
        }
    }

    public static class Point {
        private final int x;
        private final int time;

        private Point(int x, int time) {
            this.x = x;
            this.time = time;
        }

        private boolean isValid() {
            return -1 < x && x < 100001;
        }

        private boolean isNew() {
            return !vis[x];
        }
    }
}
