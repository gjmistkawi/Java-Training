package Lesson_4.Problem_1;

import java.util.Random;

public class Singleton {
    private volatile static Singleton instance;
    private Singleton() { }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null)
                    instance = new Singleton();
            }
        }

        return instance;
    }
}
