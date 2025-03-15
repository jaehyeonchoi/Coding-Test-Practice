import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        System.out.println(getCount(false) + " " + getCount(true));
    }

    public static int getCount(boolean isColorBlind) {
        vis = new boolean[N][N];
        Queue<Coor> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j]) { // 방문 안한 칸인 경우
                    queue.add(new Coor(i, j));
                    char prevColor = arr[i][j];
                    count++;

                    while (!queue.isEmpty()) {
                        Coor coor = queue.poll();
                        if (!coor.isValid() || !coor.isNew()) { // 유효하지 않거나 이미 방문한 좌표
                            continue;
                        }
                        if (!coor.isSameColor(isColorBlind, prevColor)) { // 확인 중인 색상과 다른 경우
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
        return count;
    }

    public static class Coor {
        private final int x;
        private final int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValid() {
            if (x < 0 || x > N - 1) {
                return false;
            }
            if (y < 0 || y > N - 1) {
                return false;
            }
            return true;
        }

        public boolean isNew() {
            return !vis[x][y];
        }

        public boolean isSameColor(boolean isColorBlind, char prevColor) {
            char currColor = arr[x][y];
            if (currColor == prevColor) {
                return true;
            }
            if (isColorBlind && currColor != 'B' && prevColor != 'B') {
                return true;
            }
            return false;
        }
    }
}
