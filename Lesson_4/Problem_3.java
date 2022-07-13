package Lesson_4;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Problem_3 {
    public static void main(String[] args) {
        final LinkedList<Integer> nums = new LinkedList<Integer>();

        Thread producer = new Thread() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                    produce(nums);
                    try { Thread.sleep(30); } catch (Exception e) { }
                }
            }

            private void produce(LinkedList<Integer> list) {
                Random rand = new Random();
                synchronized (list) {
                    int num = rand.nextInt(100);
                    System.out.println("Producer: adding " + num);
                    list.push(num);
                }
            }
        };

        Thread consumer = new Thread() {
            public void run() {
                int i = 0;
                while(i < 5) {
                    if(consume(nums))
                        i++;
                    try { Thread.sleep(100); } catch (Exception e) { }
                }
            }

            private boolean consume(LinkedList<Integer> list) {
                if(list.size() == 0) return false;
                synchronized (list) {
                    System.out.println("Consumer: consumed " + list.pop());
                    return true;
                }
            }
        };

        producer.start();
        consumer.start();
    }
}
