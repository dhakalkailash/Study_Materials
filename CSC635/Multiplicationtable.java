import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Multiplicationtable {

    private static final String CSS_FILE = "multiplication-table.css";
    private static final String[] COLOR_SCALE = {
        "#FFFFFF", "#F5F5F5", "#EBEBEB", "#E0E0E0", "#D6D6D6", "#CCCCCC", "#C2C2C2", "#B8B8B8",
        "#ADADAD", "#A3A3A3", "#999999", "#8F8F8F", "#858585", "#7A7A7A", "#707070", "#666666",
        "#5C5C5C", "#515151", "#474747", "#3D3D3D", "#333333", "#282828", "#1E1E1E", "#141414",
        "#0A0A0A", "#000000"
    };

    public static void main(String[] args) throws IOException {
        // check for valid input
        if (args.length != 1) {
            System.err.println("Usage: java MultiplicationTable <integer>");
            System.exit(1);
        }

        int i = Integer.parseInt(args[0]);
        if (i < 5 || i > 12) {
            System.err.println("Error: integer must be between 5 and 12");
            System.exit(1);
        }

        // create top border
        System.out.print("+------+");
        for (int j = 1; j <= i; j++) {
            System.out.print("-------+");
        }
        System.out.println();

        // create column labels
        System.out.print("|      |");
        for (int j = 1; j <= i; j++) {
            System.out.printf("%6d |", j);
        }
        System.out.println();

        // create separator line
        System.out.print("+------+");
        for (int j = 1; j <= i; j++) {
            System.out.print("-------+");
        }
        System.out.println();

        // create table rows
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j = 1; j <= i; j++) {
            // create row label
            System.out.printf("|%5d |", j);
            for (int k = 1; k <= i; k++) {
                int result = j * k;
                if (result < min) {
                    min = result;
                }
                if (result > max) {
                    max = result;
                }
                System.out.printf(" %5d |", result);
            }
            System.out.println();

            // create separator line
            System.out.print("+------+");
            for (int k = 1; k <= i; k++) {
                System.out.print("-------+");
            }
            System.out.println();
        }

        // create CSS file
        Path cssPath = Paths.get(CSS_FILE);
        List<String> lines = new ArrayList<>();
        for (int j = min; j <= max; j++) {
            int index = (j - min) * (COLOR_SCALE.length - 1) / (max - min);
            String color = COLOR_SCALE[index];
            lines.add(".cell-" + j + " { background-color: " + color + "; }");
        }
        Files.write(cssPath, lines);
    }
}
