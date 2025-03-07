import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken()); // 새로 들어온 탑의 높이

            int index = 0; // 신호를 받아줄 탑의 인덱스 (0 : 받아줄 탑이 없음)
            if (!stack.empty()) { // 스택이 빈 경우는 아래 과정 생략
                if (height > stack.peek().height) { // 직전 탑보다 높은 탑이 들어온 경우
                    while (!stack.empty()) { // 신호를 받아줄 탑이 나올 때까지 제거
                        if (height <= stack.peek().height) {
                            break;
                        }
                        stack.pop();
                    }
                    if (!stack.empty()) {
                        index = stack.peek().index; // 신호를 받아줄 탑의 인덱스 추가
                    }
                }
                else { // 직전 탑보다 낮거나 같은 탑이 들어온 경우
                    index = stack.peek().index; // 직전 탑의 인덱스
                }
            }
            sb.append(index).append(" "); // 신호를 받아줄 탑의 인덱스 추가
            stack.push(new Tower(i, height)); // 스택에 탑 추가
        }
        System.out.println(sb);
    }

    private static class Tower {
        private final int index;
        private final int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
