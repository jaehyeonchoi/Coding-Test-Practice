import java.io.*;
import java.util.*;

public class Main {
    static int T, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int dist = y - x;
            int k = 1; // 이번 차례에 이동할 거리
            int stop = 0; // 제동에 필요한 거리
            int count = 0; // 이동횟수
            while (true) {
                dist -= k; // 이동할 거리만큼 이동
                count++; // 이동횟수 + 1
                if (dist == 0) { // 남은 거리가 0 -> 목적지에 도달한 경우
                    break; // 종료
                }
                if (dist - (k + 1) >= stop + k) { // 이동할 거리를 1 높여도 목표에서 멈출 수 있는 경우
                    stop += k; // 제동거리 갱신
                    k++; // 이동할 거리 + 1
                }
                else if (dist - k < stop) { // 이동할 거리를 유지했을 때, 목표에서 멈출 수 없는 경우
                    k--; // 이동할 거리 - 1
                    stop -= k; // 제동거리 갱신
                }
            }
            System.out.println(count);
        }
    }
}
