import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSort {

    // 이진 탐색 메서드 (재귀 방식)
    public static int binarySearch1(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (key == arr[mid]) { // 탐색 성공
                return mid;
            } else if (key < arr[mid]) {
                // 왼쪽 부분 탐색
                return binarySearch1(arr, key, low, mid - 1);
            } else {
                // 오른쪽 부분 탐색
                return binarySearch1(arr, key, mid + 1, high);
            }
        }
        return -1; // 탐색 실패
    }

    // 선형 탐색 메서드
    public static String linearSearch(int[] arr, int target) {
        // arr을 처음부터 돌면서 해당 값이 있으면 "1", 없으면 "0" 반환
        for (int value : arr) {
            if (value > target) break; // 정렬된 배열을 이용한 최적화
            if (value == target) return "1";
        }
        return "0";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열 크기 입력
        System.out.print("배열 크기 입력: ");
        int n = scanner.nextInt();

        int[] arr = new int[n]; // 크기 N의 배열 생성

        // 배열 값 입력
        System.out.println("배열 값 입력:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 정렬된 배열 출력
        System.out.println("정렬된 배열:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();


        //찾을값 갯수 입력력





        // 찾을 값 입력
        System.out.print("찾을 값 입력: ");
        int target = scanner.nextInt();

        // 선형 탐색 호출 및 결과 출력
        for(int i=0; i<n; i++){
            System.out.println("선형 탐색 결과: " + linearSearch(arr, target));
        }
        

        scanner.close();
    }
}
