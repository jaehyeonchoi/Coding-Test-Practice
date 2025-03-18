import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] arr;
    static boolean[][][] vis;

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
                        queue.add(new Coor(i, j, k, 1));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Coor coor = queue.poll();
            if (!coor.isValid() || !coor.isNew()) {
                continue;
            }
            int x = coor.x;
            int y = coor.y;
            int z = coor.z;
            int dist = coor.dist;

            arr[x][y][z] = dist;
            vis[x][y][z] = true;

            queue.add(new Coor(x - 1, y, z, dist + 1));
            queue.add(new Coor(x + 1, y, z, dist + 1));
            queue.add(new Coor(x, y - 1, z, dist + 1));
            queue.add(new Coor(x, y + 1, z, dist + 1));
            queue.add(new Coor(x, y, z - 1, dist + 1));
            queue.add(new Coor(x, y, z + 1, dist + 1));
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
        private final int dist;

        public Coor(int x, int y, int z, int dist) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
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
