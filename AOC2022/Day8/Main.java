import java.util.*;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Set input to the contents of the input file
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        List<String> input = reader.lines().collect(Collectors.toList());
        
            int[][] trees = input   .stream()
                                    .map(s -> s.chars()
                                    .map(c -> c - '0')
                                    .toArray())
                                    .toArray(int[][]::new);
            
            int[][] visible = new int[trees.length][trees[0].length];
            
            int[][] scores = new int[trees.length][trees[0].length];

        // Set all scores to 1
        for (int[] row : scores) {
            Arrays.fill(row, 1);
        }

        for (int i = 0; i < 4; i++) {
            for (int row = 0; row < trees.length; row++) {
                int tallest = -1;
                int[] visDistForHeight = new int[10];
                for (int col = 0; col < trees[row].length; col++) {
                    int height = trees[row][col];
                    // Part 1
                    if (height > tallest) {
                        visible[row][col] = 1;
                        tallest = height;
                    }
                    // Part 2
                    scores[row][col] *= visDistForHeight[height];
                    // Set distances for all heights <= current height to 1
                    Arrays.fill(visDistForHeight, 0, height + 1, 1);
                    // Increment distances for all heights > current height
                    for (int j = height + 1; j < 10; j++) {
                        visDistForHeight[j]++;
                    }
                }
            }
            trees = rotate90(trees);
            visible = rotate90(visible);
            scores = rotate90(scores);
        }
        // Part 1
        int visibleCount = Arrays   .stream(visible)
                                    .mapToInt(row -> Arrays.stream(row)
                                                            .sum())
                                    .sum();
        System.out.println(visibleCount + " trees are visible from outside the grid");
        // Part 2
        int maxScore = Arrays.stream(scores)
                                .mapToInt(row -> Arrays.stream(row)
                                                        .max()
                                                        .getAsInt())
                                .max()
                                .getAsInt();
        System.out.println("The highest possible score is " + maxScore);
    }

    private static int[][] rotate90(int[][] matrix) {
        int[][] rotated = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int limit = matrix[i].length - 1;
            for (int j = 0; j <= limit; j++) {
                rotated[limit - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }
}