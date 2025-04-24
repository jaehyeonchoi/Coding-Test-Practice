import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Meeting[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Meeting[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(start, end);
        }
        Arrays.sort(arr); // 회의들을 종료시간, 시작시간이 빠른 순으로 정렬

        int curr = 0; // 현재 시각
        int count = 0; // 사용할 수 있는 회의 개수
        for (Meeting m : arr) {
            if (m.start >= curr) { // 회의의 시작시간이 현재 시각 이후인 경우
                count++; // 개수 + 1
                curr = m.end; // 현재 시각을 회의의 종료시간으로 갱신
            }
        }
        System.out.println(count);
    }

    public static class Meeting implements Comparable<Meeting> {
        private final int start;
        private final int end;

        private Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.end == m.end) {
                return this.start - m.start;
            }
            else {
                return this.end - m.end;
            }
        }
    }
}
