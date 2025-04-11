import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int count; // 경우의 수
    static boolean[] vertical; // 세로 줄의 공격 가능 여부
    static boolean[] ascending; // 대각선 줄(/)의 공격 가능 여부
    static boolean[] descending; // 대각선 줄(\)의 공격 가능 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vertical = new boolean[N];
        ascending = new boolean[N * 2 - 1];
        descending = new boolean[N * 2 - 1];
        count = 0;

        recursive(0);

        System.out.println(count);
    }

    public static void recursive(int row) { // row: 현재 보고 있는 행의 번호 (=배치된 퀸의 개수)
        if (row == N) { // 퀸을 N개 모두 배치한 경우
            count++; // 경우의 수 + 1
            return; // 재귀함수 종료
        }

        for (int col = 0; col < N; col++) {
            if (!isOccupied(row, col)) { // 어떤 퀸으로부터도 공격받지 않는 칸인 경우
                check(row, col, true); // 해당 칸에 퀸을 놓았을 때, 공격 가능한 칸들을 모두 체크
                recursive(row + 1);
                check(row, col, false); // 해당 칸에 퀸을 놓았을 때, 공격 가능한 칸들을 모두 해제
            }
        }
    }

    public static void check(int x, int y, boolean b) {
        vertical[y] = b;
        ascending[x + y] = b;
        descending[N + x - y - 1] = b;
    }

    public static boolean isOccupied(int x, int y) {
        return vertical[y] || ascending[x + y] || descending[N + x - y - 1];
    }
}
