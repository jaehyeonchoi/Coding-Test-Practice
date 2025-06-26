import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 오름차순으로 정렬

        int start = 0;
        int end = (arr[N - 1] - arr[0]) / (C - 1); // 전체 거리를 간격 수로 나눈 것이 수치상 가능한 최대 간격

        while (start <= end) { // 이분탐색으로 최대 간격 찾기
            int mid = (start + end) / 2;

            if (check(mid)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }

    public static boolean check(int dist) { // 현재의 간격으로 공유기 설치가 가능한지 확인 
        int count = 1; // 현재까지 설치한 공유기 개수
        int lastIdx = 0; // 마지막으로 공유기를 설치한 집의 인덱스 (첫번째 집에는 무조건 설치하고 시작)

        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[lastIdx] >= dist) { // 마지막으로 설치한 집과 현재 집 사이 거리가 dist 이상이면
                count++; // 설치 개수 + 1
                lastIdx = i; // 마지막 인덱스 갱신
            }
            if (count == C) { // 공유기를 C개 모두 설치 완료했으면 true
                return true; 
            }
        }
        return false; // // 공유기를 C개 모두 설치하지 못하면 false
    }
}
