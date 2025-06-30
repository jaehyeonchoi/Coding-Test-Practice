import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] AB, CD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[4][N]; // A, B, C, D 4개의 배열
        AB = new int[N * N]; // A, B의 가능한 모든 합들
        CD = new int[N * N]; // C, D의 가능한 모든 합들

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                arr[i][n] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = arr[0][i] + arr[1][j]; // A, B의 가능한 모든 합들
                CD[idx] = arr[2][i] + arr[3][j]; // C, D의 가능한 모든 합들
                idx++;
            }
        }
        Arrays.sort(AB); // 크기 순으로 정렬
        Arrays.sort(CD); // 크기 순으로 정렬

        long count = 0; // 최대 4000의 4제곱까지 가능하므로 long 타입으로 선언
        int start = 0;
        int end = N * N - 1;

        while (start <= N * N - 1 && end >= 0) { // AB의 시작, CD의 끝에서부터 두 수를 더함
            int curr = AB[start] + CD[end];
            if (curr < 0) { // 합이 0보다 작으면 AB를 키우기
                start++;
            }
            else if (curr > 0) { // 합이 0보다 크면 CD를 줄이기
                end--;
            }
            else { // 합이 0인 경우 -> AB, CD의 중복되는 값들을 전부 세기
                int currAB = AB[start];
                int countAB = 1;
                while (true) { // AB에서 같은 값의 개수를 확인
                    if (++start < N * N && AB[start] == currAB) {
                        countAB++;
                    }
                    else {
                        break;
                    }
                }
                int currCD = CD[end];
                int countCD = 1;
                while (true) { // CD에서 같은 값의 개수를 확인
                    if (--end > -1 && CD[end] == currCD) {
                        countCD++;
                    }
                    else {
                        break;
                    }
                }
                count += (long) countAB * countCD; // 같은 수들로 만들 수 있는 조합의 개수를 더하기
            }
        }
        System.out.println(count);
    }
}
