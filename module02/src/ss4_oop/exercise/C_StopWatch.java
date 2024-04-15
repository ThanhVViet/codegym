package ss4_oop.exercise;

import java.time.LocalTime;

public class C_StopWatch {
    public static class StopWatch {
        private LocalTime startTime;
        private LocalTime endTime;

        public StopWatch() {

        }

        public LocalTime getStartTime(LocalTime startTime) {
            return startTime;
        }

        public LocalTime getEndTime(LocalTime endTime) {
            return endTime;
        }

        public void start() {
            this.startTime = LocalTime.now();
            getStartTime(startTime);
        }

        public void stop() {
            this.endTime = LocalTime.now();
            getEndTime(endTime);
        }

        public void getElapsedTime() {
            double ElapsedTime = (endTime.toSecondOfDay() - startTime.toSecondOfDay()) * 1000;
            System.out.println("Thời gian đẫ trôi qua theo millisecond là: " + ElapsedTime);

        }

        public static void main(String[] args) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            System.out.println("Counting time...");
            for (int i = 1; 1 <= 10000; i++) {
                stopWatch.stop();
                stopWatch.getElapsedTime();
            }
        }
    }
}


