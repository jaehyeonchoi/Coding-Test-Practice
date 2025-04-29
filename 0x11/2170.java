import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Line[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Line[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Line(start, end);
        }
        Arrays.sort(arr); // 빨리 시작하는 순, 시작이 같으면 늦게 끝나는 순으로 정렬

        int sum = 0;
        int start = arr[0].start; // 한 덩어리의 시작
        int end = arr[0].end; // 한 덩어리의 끋
        for (int i = 1; i < N; i++) {
            if (end < arr[i].start) { // 떨어진 선이 나온 경우
                sum += end - start; // 기존 덩어리의 길이 반영
                start = arr[i].start;
                end = arr[i].end; // 새로운 덩어리 시작
            }
            else { // 연결된 선이 나온 경우
                end = Math.max(end, arr[i].end); // 끋나는 지점을 갱신
            }
        }
        sum += end - start; // 마지막 덩어리의 길이 반영
        System.out.println(sum);
    }

    public static class Line implements Comparable<Line> {
        private final int start;
        private final int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line l) {
            if (this.start == l.start) {
                return l.end - this.end;
            }
            return this.start - l.start;
        }
    }
}
