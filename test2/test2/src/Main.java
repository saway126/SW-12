import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // PriorityQueue 생성
        PriorityQueue<Job> controller = new PriorityQueue<>(
            Comparator.comparingInt(Job::getDuration)
                      .thenComparingInt(Job::getRequest)
                      .thenComparing(Job::getIdx)
        );


        //- 0ms 시점에 3ms가 소요되는 0번 작업 요청
        //- 1ms 시점에 9ms가 소요되는 1번 작업 요청
        //- 3ms 시점에 5ms가 소요되는 2번 작업 요청
        // 작업 추가
        controller.add(new Job(5, 2, 1));
        controller.add(new Job(3, 1, 2));
        controller.add(new Job(5, 1, 3));
        controller.add(new Job(3, 1, 4));

        // 작업 처리
        while (!controller.isEmpty()) {
            System.out.println(controller.poll());
        }
    }
}



class Job {
    private int duration;
    private int request;
    private int idx;

    // 생성자
    public Job(int duration, int request, int idx) {
        this.duration = duration;
        this.request = request;
        this.idx = idx;
    }

    // Getter 메서드
    public int getDuration() {
        return duration;
    }

    public int getRequest() {
        return request;
    }

    public int getIdx() {
        return idx;
    }

    @Override
    public String toString() {
        return String.format("Job[duration=%d, request=%d, idx=%d]", duration, request, idx);
    }
}


