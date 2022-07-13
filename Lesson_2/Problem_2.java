package Lesson_2;

import java.util.Arrays;
import java.util.Random;

public class Problem_2 {
    public static void main(String[] args) {
        System.out.println("2D Array Max\n");
        int[][] matrix = generateArray();
        int[] position = getMaxPosition(matrix);

        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Max value: " + matrix[position[0]][position[1]]);
        System.out.println("Position: (" + position[0] + "," + position[1] + ")");
    }

    static int[][] generateArray() {
        Random rand = new Random();
        int max = 5;

        // generate 2d matrix with rand values
        int matrix[][] = new int[rand.nextInt(max)+1][rand.nextInt(max)+1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rand.nextInt(max);
            }
        }

        return matrix;
    }

    static int[] getMaxPosition(int[][] matrix) {
        int max = 0;
        int[] position = {0,0};
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(max < matrix[i][j]) {
                    max = matrix[i][j];
                    position[0] = i;
                    position[1] = j;
                }
            }
        }

        return position;
    }
}
