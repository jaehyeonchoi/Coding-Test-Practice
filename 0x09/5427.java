package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] arr;
    static boolean[][] vis;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            int sx = -1;
            int sy = -1;

            arr = new char[w][h];
            vis = new boolean[w][h];
            dist = new int[w][h];
            Queue<Coor> queue = new LinkedList<>();

            for (int j = 0; j < w; j++) {
                String str = br.readLine();
                for (int k = 0; k < h; k++) {
                    arr[j][k] = str.charAt(k);
                    dist[j][k] = Integer.MAX_VALUE;
                    if (arr[j][k] == '*') {
                        queue.add(new Coor(j, k));
                        dist[j][k] = 0;
                    }
                    if (arr[j][k] == '@') {
                        sx = j;
                        sy = k;
                        dist[j][k] = 0;
                    }
                }
            }

            while (!queue.isEmpty()) {
                Coor coor = queue.poll();
                int x = coor.x;
                int y = coor.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int ndist = dist[x][y] + 1;
                    Coor nextCoor = new Coor(nx, ny);

                    if (nextCoor.isValid() && nextCoor.isNew(ndist)) {
                        queue.add(nextCoor);
                        dist[nx][ny] = ndist;
                    }
                }
            }

            queue.add(new Coor(sx, sy));
            boolean isFound = false;
            while (!queue.isEmpty()) {
                Coor coor = queue.poll();
                int x = coor.x;
                int y = coor.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int ndist = dist[x][y] + 1;
                    Coor nextCoor = new Coor(nx, ny);

                    if (!nextCoor.isValid()) {
                        System.out.println(ndist);
                        isFound = true;
                        break;
                    }
                    if (nextCoor.isNew(ndist)) {
                        queue.add(nextCoor);
                        dist[nx][ny] = ndist;
                    }
                }
                if (isFound) {
                    break;
                }
            }
            if (!isFound) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static class Coor {
        private final int x;
        private final int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean isValid() {
            if (0 > x || x > w - 1) {
                return false;
            }
            if (0 > y || y > h - 1) {
                return false;
            }
            return true;
        }

        private boolean isNew(int ndist) {
            return arr[x][y] == '.' && ndist < dist[x][y];
        }
    }
}
