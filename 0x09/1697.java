import java.io.*;
import java.util.*;

public class Main {
    static boolean[] vis = new boolean[200000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (!point.isValid() || !point.isNew()) { // 범위를 벗어나거나 이미 방문한 위치인 경우
                continue; // 넘어가기
            }
            if (point.x == K) { // 동생을 찾은 경우
                System.out.println(point.dist); // 이동 횟수 출력
            }
            vis[point.x] = true;

            queue.add(new Point(point.x - 1, point.dist + 1));
            queue.add(new Point(point.x + 1, point.dist + 1));
            queue.add(new Point(point.x * 2, point.dist + 1));
        }
    }

    public static class Point {
        private final int x;
        private final int dist;

        public Point(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }

        public boolean isValid() {
            return x > -1 && x < 200000;
        }

        public boolean isNew() {
            return !vis[x];
        }
    }
}
