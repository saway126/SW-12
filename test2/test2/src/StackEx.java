import java.util.Arrays;
import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        // Integer형 스택 선언
        Stack<Integer> stackInt = new Stack<>();
        // String형 스택 선언
        Stack<String> stackStr = new Stack<>();
        // Boolean형 스택 선언
        Stack<Boolean> stackBool = new Stack<>();

        // 스택 사용 예시
        stackInt.push(10);
        stackInt.push(20);
        System.out.println("Integer Stack: " + stackInt.pop()); // 20 출력

        stackStr.push("Hello");
        stackStr.push("World");
        System.out.println("String Stack: " + stackStr.pop()); // World 출력

        StackEx ex = new StackEx();
        int[] result = ex.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(Arrays.toString(result)); // [1, 3, 0, 1]
    }

    public int[] solution(int[] arr) {
        // 입력 배열에서 중복 제거하는 예제 로직
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            // 스택이 비어 있거나 이전 값과 다를 경우에만 추가
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        // 스택을 배열로 변환
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
