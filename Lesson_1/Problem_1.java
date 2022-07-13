package Lesson_1;

public class Problem_1 {
    public static void main(String[] args) {
        System.out.println("Print Pattern\n");

        String base = "..........";
        String display = "";

        System.out.println("1)");
        for(int i = 0; i < 4; i++) {
            display += "*";
            System.out.println(display);
        }
        System.out.println(base);


        System.out.println("2)");
        System.out.println(base);
        for(int i = 0; i < 4; i++) {
            System.out.println(display);
            display = display.substring(0, display.length()-1);
        }


        System.out.println("3)");
        for(int i = 0; i < 4; i++) {
            display = "*".repeat(1 + (2*i));
            display = (" ").repeat((10 - display.length())/2) + display;
            System.out.println(display);
        }
        System.out.println(base);


        System.out.println("4)");
        System.out.println(base);
        for(int i = 0; i < 4; i++) {
            display = "*".repeat(1 + (2*(3 - i)));
            display = (" ").repeat((10 - display.length())/2) + display;
            System.out.println(display);
        }
    }
}
