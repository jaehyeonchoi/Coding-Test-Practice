import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] ocean;
    static boolean[][] vis;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            year++;
            int iceburg = 0;
            int lastx = -1;
            int lasty = -1;

            ocean = new int[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (arr[i][j] != 0) {
                        for (int k = 0; k < 4; k++) {
                            if (arr[i + dx[k]][j + dy[k]] == 0) {
                                ocean[i][j]++;
                            }
                        }
                    }
                }
            }
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (ocean[i][j] != 0) {
                        arr[i][j] = Math.max(0, arr[i][j] - ocean[i][j]);
                    }
                    if (arr[i][j] != 0) {
                        lastx = i;
                        lasty = j;
                        iceburg++;
                    }
                }
            }

            if (iceburg == 0) {
                System.out.println(0);
                return;
            }

            Queue<Coor> queue = new LinkedList<>();
            vis = new boolean[N][M];
            queue.add(new Coor(lastx, lasty));
            vis[lastx][lasty] = true;

            while (!queue.isEmpty()) {
                Coor coor = queue.poll();

                int x = coor.x;
                int y = coor.y;
                iceburg--;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    Coor nextCoor = new Coor(nx, ny);
                    if (nextCoor.isValid() && nextCoor.isNew()) {
                        queue.add(nextCoor);
                        vis[nx][ny] = true;
                    }
                }
            }

            if (iceburg != 0) {
                System.out.println(year);
                return;
            }
        }
    }

    public static class Coor {
        private final int x;
        private final int y;

        private Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean isValid() {
            if (1 > x || x > N - 2) {
                return false;
            }
            if (1 > y || y > M - 2) {
                return false;
            }
            return true;
        }

        private boolean isNew() {
            return arr[x][y] != 0 && !vis[x][y];
        }
    }
}
