import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Flower[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Flower[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sM = Integer.parseInt(st.nextToken());
            int sD = Integer.parseInt(st.nextToken());
            int eM = Integer.parseInt(st.nextToken());
            int eD = Integer.parseInt(st.nextToken());
            arr[i] = new Flower(sM * 100 + sD, eM * 100 + eD);
        }
        Arrays.sort(arr); // 빨리 피는 순서, 동시에 피면 늦게 지는 순서로 정렬

        int count = 0; // 사용한 꽃의 개수
        int curr = 301; // 기준날짜
        int max = 0; // 기준날짜에 피어있는 꽃 중에서 가장 늦게 지는 날짜

        for (Flower flower : arr) {
            if (curr < flower.start) { // 기준 날짜에 아직 피지 않는 꽃인 경우
                if (curr < max) { // 기준날짜보다 더 늦게 지는 꽃을 찾은 경우
                    curr = max; // 기준날짜를 가장 마지막에 꽃이 지는 날짜로 갱신
                    count++;
                }
            }
            if (flower.start <= curr && curr <= flower.end) { // 기준 날짜에 피어 있는 꽃인 경우
                max = Math.max(max, flower.end); // 최대한 늦게 지는 꽃을 찾기
                if (1130 < max) { // 1130 이후까지 피어있는 꽃이 나온 경우
                    count++;
                    System.out.println(count);
                    return; // 종료
                }
            }
        }
        System.out.println(0); // 꽃이 계속 핀 상태로 1130에 도달하지 못한 경우
    }

    public static class Flower implements Comparable<Flower> {
        private final int start;
        private final int end;

        private Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower f) {
            if (this.start == f.start) {
                return f.end - this.end;
            }
            return this.start - f.start;
        }
    }
}
