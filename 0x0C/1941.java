import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] arr; // 이다솜파와 임다연파의 좌석 배치 (이다솜파: true, 임다연파: false)
    static boolean[][] selected; // 칠공주의 좌석 배치
    static boolean[][] used; // bfs에서 사용할 이미 방문한 칸
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count; // 칠공주파의 좌석 배치 조합 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new boolean[5][5];
        selected = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'S') {
                    arr[i][j] = true; // 이다솜파를 true로 표시
                }
            }
        }

        count = 0;
        recursive(0, -1);
        System.out.println(count);
    }

    private static void recursive(int k, int last) {
        if (k == 7) { // 칠공주 7명의 좌석을 모두 선택한 경우
            if (bfs() && checkYCount()) { // 칠공주 자리가 모두 붙어있고, 이다솜파가 4명 이상인 경우
                count++; // 칠공주파의 좌석 배치 조합 수 + 1
            }
            return;
        }

        for (int i = last + 1; i < 25; i++) { // 좌석을 0 ~ 24번으로 처리, 중복되지 않도록 last 사용 
            int x = i / 5; // 번호에 따른 x 좌표
            int y = i % 5; // 번호에 따른 y 좌표
            selected[x][y] = true;
            recursive(k + 1, i);
            selected[x][y] = false;
        }
    }

    public static boolean bfs() { // 칠공주의 좌석이 모두 붙어있는지 확인
        Queue<Point> queue = new LinkedList<>();
        used = new boolean[5][5];
        int areaCount = 0; // 연결된 자리의 묶음 수

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                Point start = new Point(i, j);
                if (start.isNew()) {
                    queue.offer(start);
                    used[i][j] = true;
                    areaCount++;

                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            Point newPoint = new Point(nx, ny);

                            if (newPoint.isValid() && newPoint.isNew()) {
                                queue.offer(newPoint);
                                used[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return areaCount == 1; // 좌석이 1개의 묶음으로 연결되어있으면 true
    }

    public static boolean checkYCount() { // 칠공주 중, 임다연파가 3명 이하인지 확인 
        int yCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (selected[i][j] && !arr[i][j]) {
                    yCount++;
                    if (yCount > 3) { // 임다연파가 3명을 초과하면 false
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValid() {
            return 0 <= x && x <= 4 && 0 <= y && y <= 4;
        }

        public boolean isNew() {
            return selected[x][y] && !used[x][y];
        }
    }
}
