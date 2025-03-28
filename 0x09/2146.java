import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dist = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Coor> landQueue = new LinkedList<>();
        Queue<Coor> bridgeQueue = new LinkedList<>();

        int landNum = 1; // 2번부터 시작해서 섬들마다 다른 번호로 arr 값을 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) { // 육지에 대해 BFS
                    landNum++;
                    landQueue.add(new Coor(i, j));
                    arr[i][j] = landNum;

                    while (!landQueue.isEmpty()) {
                        Coor coor = landQueue.poll();

                        int x = coor.x;
                        int y = coor.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            Coor nextCoor = new Coor(nx, ny);
                            if (nextCoor.isValid()) {
                                if (nextCoor.isNewLand()) { // 새로운 육지를 발견한 경우
                                    landQueue.add(nextCoor);
                                    arr[nx][ny] = landNum; // 번호 붙여주기
                                }
                                else if (nextCoor.isNewOcean()) { // 육지에 접한 바다를 만난 경우
                                    bridgeQueue.add(nextCoor); // 다리 건설의 시작점으로 Queue에 넣기
                                    arr[nx][ny] = landNum; // 육지와 같은 번호로 확장
                                    dist[nx][ny] = 1; // 육지까지의 거리
                                }
                            }
                        }
                    }
                }
            }
        }

        int min = 1000; // 다리 길이의 최솟값
        while (!bridgeQueue.isEmpty()) {
            Coor coor = bridgeQueue.poll();

            int x = coor.x;
            int y = coor.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                Coor nextCoor = new Coor(nx, ny);
                if (nextCoor.isValid()) {
                    if (nextCoor.isNewOcean()) { // 새로운 바다를 만난 경우
                        bridgeQueue.add(nextCoor); // Queue에 추가
                        arr[nx][ny] = arr[x][y]; // 육지와 같은 번호로 확장
                        dist[nx][ny] = dist[x][y] + 1; // 육지까지의 거리
                    }
                    else if (arr[nx][ny] > 1 && arr[nx][ny] != arr[x][y]) { // 다른 육지로부터 시작된 다리를 만난 경우
                        min = Math.min(min, dist[nx][ny] + dist[x][y]); // 두 다리의 거리를 더해서 최솟값 갱신
                    }
                }
            }
        }
        System.out.println(min);
    }

    public static class Coor {
        private final int x;
        private final int y;

        private Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean isValid() {
            if (0 > x || x > N - 1) {
                return false;
            }
            if (0 > y || y > N - 1) {
                return false;
            }
            return true;
        }

        private boolean isNewLand() {
            return arr[x][y] == 1;
        }

        private boolean isNewOcean() {
            return arr[x][y] == 0;
        }
    }
}
