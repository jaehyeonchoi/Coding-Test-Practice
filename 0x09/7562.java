import java.io.*;
import java.util.*;

public class Main {
    static int I;
    static boolean[][] vis;
    static int[][] dist;
    static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            vis = new boolean[I][I];
            dist = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            Queue<Coor> queue = new LinkedList<>();
            queue.add(new Coor(x1, y1));
            vis[x1][y1] = true;

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            while (!queue.isEmpty()) {
                Coor coor = queue.poll();
                int x = coor.x;
                int y = coor.y;

                if (x == x2 && y == y2) {
                    System.out.println(dist[x][y]);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    Coor nextCoor = new Coor(nx, ny);
                    if (nextCoor.isValid() && nextCoor.isNew()) {
                        queue.add(nextCoor);
                        dist[nx][ny] = dist[x][y] + 1;
                        vis[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static class Coor {
        private final int x;
        private final int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean isValid() {
            if (0 > x || x > I - 1) {
                return false;
            }
            if (0 > y || y > I - 1) {
                return false;
            }
            return true;
        }

        private boolean isNew() {
            return !vis[x][y];
        }
    }
}
