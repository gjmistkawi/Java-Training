package Lesson_4;

public class Problem_2 {
    public static void main(String[] args) {
        final String lock1 = "lock1";
        final String lock2 = "lock2";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1: locked lock1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    System.out.println("Thread 1: try to lock lock2");
                    synchronized (lock2) {
                        System.out.println("Thread 1: locked lock2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread 2: locked lock1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    System.out.println("Thread 2: try to lock lock2");
                    synchronized (lock1) {
                        System.out.println("Thread 2: locked lock2");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
