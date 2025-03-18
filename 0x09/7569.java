import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] arr;
    static boolean[][][] vis;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        vis = new boolean[H][N][M];
        Queue<Coor> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.add(new Coor(i, j, k));
                        vis[i][j][k] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Coor coor = queue.poll();
            int x = coor.x;
            int y = coor.y;
            int z = coor.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                Coor nextCoor = new Coor(nx, ny, nz);

                if (nextCoor.isValid() && nextCoor.isNew()) {
                    queue.add(nextCoor);
                    vis[nx][ny][nz] = true;
                    arr[nx][ny][nz] = arr[x][y][z] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (arr[i][j][k] > max) {
                        max = arr[i][j][k];
                    }
                }
            }
        }
        System.out.println(max - 1);
    }

    public static class Coor {
        private final int x;
        private final int y;
        private final int z;

        public Coor(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean isValid() {
            if (0 > x || x > H - 1) {
                return false;
            }
            if (0 > y || y > N - 1) {
                return false;
            }
            if (0 > z || z > M - 1) {
                return false;
            }
            return true;
        }

        public boolean isNew() {
            return arr[x][y][z] != -1 && !vis[x][y][z];
        }
    }
}
