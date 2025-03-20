import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][][] arr;
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[2][N][M];
        dist = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[0][i][j] = str.charAt(j) - '0';
                arr[1][i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Coor> queue = new LinkedList<>();
        queue.add(new Coor(0, 0, 0));
        dist[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Coor coor = queue.poll();

            int z = coor.z;
            int x = coor.x;
            int y = coor.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z;
                if (arr[z][x][y] == 1) {
                    nz++;
                }

                Coor nextCoor = new Coor(nz, nx, ny);
                if (nextCoor.isValid() && nextCoor.isNew()) {
                    queue.add(nextCoor);
                    dist[nz][x][y] = dist[z][x][y];
                    dist[nz][nx][ny] = dist[z][x][y] + 1;
                }
            }
        }
        if (dist[0][N - 1][M - 1] == 0 && dist[1][N - 1][M - 1] == 0) {
            System.out.println(-1);
        }
        else if (dist[0][N - 1][M - 1] != 0 && dist[1][N - 1][M - 1] != 0) {
            System.out.println(Math.min(dist[0][N - 1][M - 1], dist[1][N - 1][M - 1]));
        }
        else {
            System.out.println(Math.max(dist[0][N - 1][M - 1], dist[1][N - 1][M - 1]));
        }
    }

    private static class Coor {
        private final int x;
        private final int y;
        private final int z;

        private Coor(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }

        private boolean isValid() {
            if (0 > z || z > 1) {
                return false;
            }
            if (0 > x || x > N - 1) {
                return false;
            }
            if (0 > y || y > M - 1) {
                return false;
            }
            return true;
        }

        private boolean isNew() {
            return dist[z][x][y] == 0;
        }
    }
}
