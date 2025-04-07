import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] arr;
    static int[][][] dist;
    static int[] mdx = {1, -1, 0, 0};
    static int[] mdy = {0, 0, 1, -1}; // 원숭이의 움직임
    static int[] hdx = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] hdy = {1, -1, 1, -1, 2, 2, -2, -2}; // 말의 움직임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        dist = new int[H][W][K + 1]; // 3차원, jump할 때마다 세 번째 차원 +1

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        dist[0][0][0] = 1; // dist가 0이면 미방분, 1 이상이면 방문 -> 실제 거리는 -1 해줘야함

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int jump = point.jump;

            if (x == H - 1 && y == W - 1) { // 맵의 우측하단에 도착하면 이동거리 출력 후 종료
                System.out.println(dist[x][y][jump] - 1);
                return;
            }

            for (int i = 0; i < 4; i++) { // 원숭이의 움직임 계산
                int nx = x + mdx[i];
                int ny = y + mdy[i];
                Point nextPoint = new Point(nx, ny, jump);

                if (nextPoint.isValid() && nextPoint.isNew()) {
                    queue.add(nextPoint);
                    dist[nx][ny][jump] = dist[x][y][jump] + 1;
                }
            }

            for (int i = 0; i < 8; i++) { // 말의 움직임 계산
                int nx = x + hdx[i];
                int ny = y + hdy[i];
                int njump = jump + 1;
                Point nextPoint = new Point(nx, ny, njump);

                if (nextPoint.isValid() && nextPoint.isNew()) {
                    queue.add(nextPoint);
                    dist[nx][ny][njump] = dist[x][y][jump] + 1;
                }
            }
        }

        System.out.println(-1); // queue가 다 빌 때까지 맵 우측하단에 도착하지 못하면 실패
    }

    public static class Point {
        private final int x;
        private final int y;
        private final int jump;

        private Point(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }

        private boolean isValid() {
            return -1 < x && x < H && -1 < y && y < W && -1 < jump && jump <= K;
        }

        private boolean isNew() {
            return arr[x][y] == 0 && dist[x][y][jump] == 0;
        }
    }
}
