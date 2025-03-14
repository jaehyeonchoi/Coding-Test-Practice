import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                    stack.push(-2);
                    break;
                case ')':
                    if (stack.isEmpty()) { // stack이 비어있는 경우
                        System.out.println(0);
                        return;
                    }

                    if (stack.peek() == -2) { // 마지막에 있던 게 '('
                        stack.pop(); // '(' 꺼내기
                        int x = 2; // () -> 2
                        if (!stack.isEmpty() && stack.peek() > 0) { // 2를 넣기 전에 마지막 값이 숫자이면
                            x += stack.pop(); // 꺼내서 더하기
                        }
                        stack.push(x); // 새로운 값 넣기
                    }
                    else if (stack.peek() > 0) { // 마지막에 있던 게 숫자
                        int x = stack.pop() * 2; // 숫자 꺼내서 2배
                        if (stack.isEmpty() || stack.peek() != -2) { // 마지막에 있는 게 '('인지 확인
                            System.out.println(0);
                            return;
                        }
                        stack.pop(); // '(' 꺼내기
                        if (!stack.isEmpty() && stack.peek() > 0) { // 새로운 숫자를 넣기 전에 마지막 값이 숫자이면
                            x += stack.pop(); // 꺼내서 더하기
                        }
                        stack.push(x); // 새로운 값 넣기
                    }
                    else { // 그 외의 경우
                        System.out.println(0);
                        return;
                    }
                    break;
                case '[':
                    stack.push(-3);
                    break;
                case ']':
                    if (stack.isEmpty()) { // stack이 비어있는 경우
                        System.out.println(0);
                        return;
                    }

                    if (stack.peek() == -3) { // 마지막에 있던 게 '['
                        stack.pop(); // '[' 꺼내기
                        int x = 3; // [] -> 3
                        if (!stack.isEmpty() && stack.peek() > 0) { // 3를 넣기 전에 마지막 값이 숫자이면
                            x += stack.pop(); // 꺼내서 더하기
                        }
                        stack.push(x); // 새로운 값 넣기
                    }
                    else if (stack.peek() > 0) { // 마지막에 있던 게 숫자
                        int x = stack.pop() * 3; // 숫자 꺼내서 3배
                        if (stack.isEmpty() || stack.peek() != -3) { // 마지막에 있는 게 '['인지 확인
                            System.out.println(0);
                            return;
                        }
                        stack.pop(); // '[' 꺼내기
                        if (!stack.isEmpty() && stack.peek() > 0) { // 새로운 숫자를 넣기 전에 마지막 값이 숫자이면
                            x += stack.pop(); // 꺼내서 더하기
                        }
                        stack.push(x); // 새로운 값 넣기
                    }
                    else { // 그 외의 경우
                        System.out.println(0);
                        return;
                    }
                    break;
            }
        }
        if (stack.size() == 1 && stack.peek() > 0) {
            System.out.println(stack.peek());
        }
        else {
            System.out.println(0);
        }
    }
}
