import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] arr;
    static List<Integer>[] list; // 좌표압축을 위해 행성의 크기를 정렬할 list

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        list = new ArrayList[M];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>(); // 크기가 중복되지 않도록 set에 저장
            for (int n = 0; n < N; n++) {
                int num = Integer.parseInt(st.nextToken());
                arr[m][n] = num;
                set.add(num);
            }
            list[m] = new ArrayList<>(set); // set으로 list를 만들기
            Collections.sort(list[m]); // 중복값 없이 행성의 크기를 정렬
        }

        // 좌표압축
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                // list에서 행성의 크기를 이분탐색하면, 해당 우주에서 행성의 크기가 몇 번째로 작은지 알 수 있음
                // 행성의 크기 대신, 몇 번째로 작은지로 저장
                arr[m][n] = Collections.binarySearch(list[m], arr[m][n]);
            }
        }

        int count = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(arr[i], arr[j])) { // arr[i]. arr[j] 배열 자체를 비교
                    count++; // 서로 다른 두 우주의 행성들의 크기 등수 배치가 같은 경우, +1
                }
            }
        }
        System.out.println(count);
    }
}
