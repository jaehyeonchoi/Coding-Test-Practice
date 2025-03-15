import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            arr = new boolean[width][height];
            vis = new boolean[width][height];

            for (int j = 0; j < cabbage; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = true;
            }

            Queue<Coor> queue = new LinkedList<>();
            int count = 0;

            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    if (arr[j][k] && !vis[j][k]) { // 방문 안한 배추를 찾는 경우
                        count++;
                        queue.add(new Coor(j, k));

                        while (!queue.isEmpty()) {
                            Coor coor = queue.poll();
                            if (!coor.isValid(width, height) || !coor.isNew()) { // 유효하지 않거나 이미 방문한 좌표
                                continue;
                            }
                            vis[coor.x][coor.y] = true;

                            queue.add(new Coor(coor.x - 1, coor.y));
                            queue.add(new Coor(coor.x + 1, coor.y));
                            queue.add(new Coor(coor.x, coor.y - 1));
                            queue.add(new Coor(coor.x, coor.y + 1));
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static class Coor {
        private final int x;
        private final int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValid(int width, int height) {
            if (x < 0 || x > width - 1) {
                return false;
            }
            if (y < 0 || y > height - 1) {
                return false;
            }
            return true;
        }

        public boolean isNew() {
            return arr[x][y] && !vis[x][y];
        }
    }
}
