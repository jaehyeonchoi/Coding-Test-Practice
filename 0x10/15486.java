import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T; // 상담별 소요시간
    static int[] P; // 상담별 보상
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 51];
        P = new int[N + 51];
        d = new int[N + 51];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = N; i > 0; i--) { // 상담들에 대해서 시간 역순으로
            d[i] = d[i + 1]; // 해당 상담을 안하면 그 후에 있는 상담에 대해 계산한 결과와 같음 
            if (i + T[i] <= N + 1) { // (N + 1)일 전까지 끝낼 수 있는 상담인 경우 
                d[i] = Math.max(d[i + T[i]] + P[i], d[i + 1]); // 해당 상담을 한 경우와 안 한 경우를 비교
            }
            if (max < d[i]) { // 최댓값 갱신
                max = d[i];
            }
        }
        System.out.println(max);
    }
}
