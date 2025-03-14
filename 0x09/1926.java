import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        vis = new boolean[n][m];
        Queue<Coor> queue = new LinkedList<>();
        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                vis[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Coor coor = new Coor(i, j);
                if (coor.isNew()) { // 방문 안한 그림 발견하는 경우
                    vis[i][j] = true;
                    queue.add(coor);
                    count++;
                    int area = 0;

                    while (!queue.isEmpty()) { // 전체 그림 탐색
                        coor = queue.poll();
                        area++;

                        Coor nextCoor = new Coor(coor.x - 1, coor.y);
                        if (nextCoor.isValid(n, m) && nextCoor.isNew()) {
                            vis[nextCoor.x][nextCoor.y] = true;
                            queue.add(nextCoor);
                        }
                        nextCoor = new Coor(coor.x + 1, coor.y);
                        if (nextCoor.isValid(n, m) && nextCoor.isNew()) {
                            vis[nextCoor.x][nextCoor.y] = true;
                            queue.add(nextCoor);
                        }
                        nextCoor = new Coor(coor.x, coor.y - 1);
                        if (nextCoor.isValid(n, m) && nextCoor.isNew()) {
                            vis[nextCoor.x][nextCoor.y] = true;
                            queue.add(nextCoor);
                        }
                        nextCoor = new Coor(coor.x, coor.y + 1);
                        if (nextCoor.isValid(n, m) && nextCoor.isNew()) {
                            vis[nextCoor.x][nextCoor.y] = true;
                            queue.add(nextCoor);
                        }
                    }
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    public static class Coor {
        private final int x;
        private final int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean isValid(int n, int m) {
            if (x < 0 || x > n - 1) {
                return false;
            }
            if (y < 0 || y > m - 1) {
                return false;
            }
            return true;
        }

        public boolean isNew() {
            return arr[x][y] == 1 && !vis[x][y];
        }
    }
}
