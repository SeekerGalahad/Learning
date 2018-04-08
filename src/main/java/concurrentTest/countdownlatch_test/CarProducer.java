package concurrentTest.countdownlatch_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarProducer {
    
    public static void main(String[] args) {

        CountDownLatch carAssembly = new CountDownLatch(1);

        CountDownLatch carStep = new CountDownLatch(3);

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            pool.submit(new CarWork(carAssembly, carStep));
        }

        doPrepare();
        carAssembly.countDown();
        while (carStep.getCount() != 0) {
            waiting();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end....");

    }

    private static void waiting() {
        System.out.println("waiting for all step....");
    }

    private static void doPrepare() {
        System.out.println("prepare for produce car");
    }

    static class CarWork implements Runnable {

        private CountDownLatch carAssembly;

        private CountDownLatch carStep;

        CarWork(CountDownLatch carAssembly, CountDownLatch carStep) {
            this.carAssembly = carAssembly;
            this.carStep = carStep;
        }

        @Override
        public void run() {

            try {
                carAssembly.await();
                doStep();
                carStep.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void doStep() {
            System.out.println("do step for car");
        }
    }

}
