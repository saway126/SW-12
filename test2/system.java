import java.util.*;
class Solution {
    public class Job{
        private int idx;
        private int request;
        private int duration;
        private int returnTime;
        
        public Job (int idx, int request, int duration) {
            this.idx = idx;
            this.duration = duration;
            this.request = request;
        }
        public int getIdx() {
            return this.idx;
        }
        public int getDuration() {
            return this.duration;
        }
        public int getRequest() {return this.request;}
        public void setReturnTime(int returnTime) {
            this.returnTime = returnTime;
        }
    }
    public int solution(int[][] jobs) {
        int time = 0;
        int answer = 0;
        PriorityQueue<Job> controller = new PriorityQueue<>(
             Comparator.comparingInt(Job::getDuration)   // 1차 기준: 우선순위
                      .thenComparingInt(Job::getRequest) // 2차 기준: 소요 시간
                      .thenComparing(Job::getIdx)
        );
        PriorityQueue<Job> wait = new PriorityQueue<>(
             Comparator.comparingInt(Job::getRequest)
        );
        for(int i = 0;i < jobs.length;i++) {
                Job temp = new Job(i,jobs[i][0],jobs[i][1]);
                wait.add(temp);
        }
        while(!wait.isEmpty() || !controller.isEmpty()){
            while(!wait.isEmpty()) {  // request가 현재시간보다 작을때
                if(wait.peek().getRequest()<=time) 
                    controller.add(wait.poll());
                else 
                    break;
            }
            
            if(!controller.isEmpty()) {
                time += controller.peek().getDuration();
                answer += time - controller.poll().getRequest();

            } else {time++;}
            
        }
        return answer/jobs.length;
    }
}