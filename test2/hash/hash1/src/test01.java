import java.util.ArrayList;

class Solution {
    public String[] solution(long[] numbers) {
        // 이진수를 저장할 문자열 배열 생성
        String[] answer = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 각 숫자를 이진수로 변환하여 배열에 저장
            answer[i] = Long.toBinaryString(numbers[i]);
        }

        return answer;
    }
}

public class test01 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 입력 예제
        long[] numbers = {5, 10, 15};
        String[] result = sol.solution(numbers);

        // 결과 출력
        for (String binary : result) {
            System.out.println(binary);
        }
    }
}
