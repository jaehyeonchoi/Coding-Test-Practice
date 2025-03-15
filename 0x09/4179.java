import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        vis = new boolean[n][m];

        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'J') {
                    x = i;
                    y = j;
                }
                vis[i][j] = false;
            }
        }

        Queue<Coor> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'F') { // 불을 발견한 경우
                    queue.add(new Coor(i, j, -1)); // 불의 시작점 queue에 넣기
                }
            }
        }
        queue.add(new Coor(x, y, 0)); // 지훈이의 시작점 queue에 넣기

        while (!queue.isEmpty()) {
            Coor coor = queue.poll();
            if (!coor.isValid(n, m)) { // 유효하지 않은 좌표
                if (coor.newDist != -1) { // 지훈이에 대한 탐색인 경우
                    System.out.println(coor.newDist); // 거리 출력
                    return;
                }
                continue;

            }
            if (!coor.isNew()) { // 이미 확인한 좌표인 경우
                continue;
            }

            vis[coor.x][coor.y] = true;

            int newDist = coor.newDist + 1;
            if (coor.newDist == -1) { // 불에 대한 탐색인 경우
                newDist = -1;
            }

            queue.add(new Coor(coor.x - 1, coor.y, newDist));
            queue.add(new Coor(coor.x + 1, coor.y, newDist));
            queue.add(new Coor(coor.x, coor.y - 1, newDist));
            queue.add(new Coor(coor.x, coor.y + 1, newDist));
        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Coor {
        private final int x;
        private final int y;
        private final int newDist;

        public Coor(int x, int y, int newDist) {
            this.x = x;
            this.y = y;
            this.newDist = newDist;
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
            return arr[x][y] != '#' && !vis[x][y];
        }
    }
}
