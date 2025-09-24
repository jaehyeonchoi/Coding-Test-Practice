import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Coor> queue = new LinkedList<>();
        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                Coor coor = new Coor(i, j);

                if (coor.isNew()) {

                    queue.add(coor);
                    int currArea = 0;
                    count++;

                    while (!queue.isEmpty()) {

                        Coor curr = queue.poll();
                        int x = curr.x;
                        int y = curr.y;

                        if (!curr.isNew()) {
                            continue;
                        }
                        currArea++;
                        visit[x][y] = true;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            Coor newCoor = new Coor(nx, ny);

                            if (newCoor.isValid() && newCoor.isNew()) {
                                visit[nx][ny] = true;
                                queue.add(newCoor);
                            }
                        }

                    }
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    public static class Coor {

        private int x;
        private int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValid() {
            if (0 > x || x > N - 1) {
                return false;
            }
            if (0 > y || y > M - 1) {
                return false;
            }
            return true;
        }

        public boolean isNew() {
            return arr[x][y] == 1 && !visit[x][y];
        }
    }
}
