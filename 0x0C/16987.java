import java.io.*;
import java.util.*;

public class Main {
    static int N; // 계란 개수
    static Egg[] arr; // 계란 배열
    static int max; // 깨진 계란 개수의 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken()); // 계란의 내구도
            int atk = Integer.parseInt(st.nextToken()); // 계란의 무게
            arr[i] = new Egg(hp, atk);
        }

        max = 0;
        recursive(0);
        System.out.println(max);
    }

    private static void recursive(int k) { // k번째 계란을 들었을 때
        if (k == N) { // 모든 계란을 들어본 경우
            int count = 0;
            for (Egg egg : arr) { // 깨진 계란의 수를 계산
                if (egg.isBroken()) {
                    count++;
                }
            }
            if (count > max) { // 최댓값 갱신
                max = count;
            }
            return;
        }

        Egg curr = arr[k]; // 들고 있는 계란

        if (curr.isBroken()) { // 들고 있는 계란이 이미 깨진 경우
            recursive(k + 1); // 다음 계란으로 넘어감
        }
        else { // 들고 있는 계란이 깨지지 않은 경우
            boolean flag = false;
            for (int i = 0; i < N; i++) { // 모든 계란에 대해서
                if (k != i && !arr[i].isBroken()) { // 현재 들고 있는 계란이 아니고, 깨지지 않은 계란이라면,
                    flag = true;
                    curr.hit(arr[i]); // 들고 있는 계란으로 치기
                    recursive(k + 1); // 다음 계란으로 넘어감
                    curr.undo(arr[i]); // 들고 있는 계란으로 때리기 전으로 복구
                }
            }
            if (!flag) {
                recursive(N); // 들고 있는 계란으로 때릴 계란이 없는 경우,다음 계란으로 넘어감
            }
        }
    }

    public static class Egg {
        private int hp;
        private final int atk;

        public Egg(int hp, int atk) {
            this.hp = hp;
            this.atk = atk;
        }

        public boolean isBroken() {
            return hp <= 0;
        }

        public void hit(Egg egg) {
            this.hp -= egg.atk;
            egg.hp -= this.atk;
        }

        public void undo(Egg egg) {
            this.hp += egg.atk;
            egg.hp += this.atk;
        }
    }
}
