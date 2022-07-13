package Lesson_3;
import java.io.File;
import java.util.Arrays;

public class Problem_1 {
    static public void main(String[] args) {
        String path = "/home/geoscow/work/server/setup";

        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File files[] = dir.listFiles();
            String display = recursiveFormatDirectoryString(files, 0);

            System.out.println("Files from directory: " + path + "\n" + display);
        }
    }

    static public String recursiveFormatDirectoryString(File[] files, int level) {
        String display = "";
        for (File f : files) {
            display += "\t".repeat(level) + f.getName() + "\n";
            if (f.isDirectory())
                display += recursiveFormatDirectoryString(f.listFiles(), (level + 1));
        }

        return display;
    }
}
