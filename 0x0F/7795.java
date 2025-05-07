import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static Creature[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new Creature[N + M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = new Creature(Integer.parseInt(st.nextToken()), true);
            }
            st = new StringTokenizer(br.readLine());
            for (int j = N ; j < N + M; j++) {
                arr[j] = new Creature(Integer.parseInt(st.nextToken()), false);
            }

            Arrays.sort(arr);
            int sum = 0; // 총 조합수의 수
            int count = 0; // 지금까지 나온 B의 수
            for (Creature creature : arr) {
                if (creature.isA) { // A인 경우
                    sum += count; // 지금까지 나온 B는 전부 잡아먹을 수 있음
                }
                else { // B인 경우
                    count++; // B의 수 + 1
                }
            }
            System.out.println(sum);
        }
    }

    public static class Creature implements Comparable<Creature> {
        private int num;
        private boolean isA;

        public Creature(int num, boolean isA) {
            this.num = num;
            this.isA = isA;
        }

        @Override
        public int compareTo(Creature creature) {
            return this.num - creature.num;
        }
    }
}
