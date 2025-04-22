import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Job>[] arr; // 날짜별로 그 날 끝나는 상담의 리스트를 저장
    static int[] d; // 날짜별 받을 수 있는 최대 금액

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 6];
        for (int i = 0; i < N + 6; i++) {
            arr[i] = new ArrayList<>();
        }
        d = new int[N + 6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            arr[i + time].add(new Job(time, pay)); // (i + 1)일에 시작하는 상담은 (i + time)일에 끝남
        }

        for (int i = 1; i < N + 1; i++) { // 1 ~ N일에 벌 수 있는 최대 금액 계산
            d[i] = d[i - 1]; // 그 날 아무 일도 하지 않으면 전날까지 벌 수 있는 돈과 같음
            for (Job job : arr[i]) { // 해당 날짜에 끝나는 모든 작업에 대해서
                d[i] = Math.max(d[i], d[i - job.time] + job.pay); // 해당 작업을 했을 때, 벌 수 있는 돈으로 최댓값 갱신
            }
        }
        System.out.println(d[N]);
    }

    public static class Job {
        public int time;
        public int pay;

        public Job(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }
    }
}
