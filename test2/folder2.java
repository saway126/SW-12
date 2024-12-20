import java.util.*;

class Task implements Comparable<Task> {
    int id; //작업 번호
    int requestTime; //작업 요청 시간
    int duration;// 작업의 소요 시간

    public Task(int id, int requestTime, int duration) {//this는 현재 객체를 참조하는 키워드
        this.id = id; //객체 초기화
        this.requestTime = requestTime; //객체 초기화
        this.duration = duration; //객체 초기화
    }

    @Override
    public int compareTo(Task other) {
        // 우선순위: 1. 소요시간 -> 2. 요청 시각 -> 3. 작업 번호
        if (this.duration != other.duration) {
            return this.duration - other.duration;
        } else if (this.requestTime != other.requestTime) {
            return this.requestTime - other.requestTime;
        } else {
            return this.id - other.id;
        }
    }
}

public class folder2 {
    public static void main(String[] args) {
        // 입력 작업: {작업 번호, 요청 시각, 소요 시간}
        int[][] jobs = {
            {0, 0, 3},
            {1, 1, 9},
            {2, 3, 5}
        };

        // 요청을 요청 시각 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[1]));

        // 우선순위 큐 생성
        PriorityQueue<Task> queue = new PriorityQueue<>();

        int currentTime = 0; // 현재 시간
        int index = 0;       // 처리할 작업 인덱스
        List<Integer> schedule = new ArrayList<>(); // 작업 처리 순서 기록

        while (index < jobs.length || !queue.isEmpty()) {
            // 요청 시각에 도달한 작업들을 대기 큐에 추가
            while (index < jobs.length && jobs[index][1] <= currentTime) {
                queue.add(new Task(jobs[index][0], jobs[index][1], jobs[index][2]));
                index++;
            }

            if (!queue.isEmpty()) {
                // 대기 큐에서 우선순위가 높은 작업을 처리
                Task task = queue.poll();
                schedule.add(task.id); // 작업 번호 기록
                currentTime += task.duration; // 현재 시간 업데이트
            } else {
                // 대기 큐가 비어 있다면 다음 작업의 요청 시각으로 이동
                currentTime = jobs[index][1];
            }
        }

        // 결과 출력
        System.out.println("작업 처리 순서: " + schedule);
    }
}