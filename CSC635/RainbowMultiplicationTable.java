import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RainbowMultiplicationTable {
    public static void main(String[] args) {
        // Get the integer value from command-line argument
        int n = Integer.parseInt(args[0]);

        // Create a 2D array to store the multiplication table
        int[][] table = new int[n][n];

        // Fill in the multiplication table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        // Find the minimum and maximum values in the table
        int minValue = table[0][0];
        int maxValue = table[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] < minValue) {
                    minValue = table[i][j];
                }
                if (table[i][j] > maxValue) {
                    maxValue = table[i][j];
                }
            }
        }

        // Generate the CSS file for shading the cells
        try {
            FileWriter writer = new FileWriter("multiplication-table.css");

            // Write the table style
            writer.write("table {\n");
            writer.write("  border-collapse: collapse;\n");
            writer.write("}\n");
            writer.write("td {\n");
            writer.write("  border: 1px solid black;\n");
            writer.write("  padding: 5px;\n");
            writer.write("}\n");

            // Write the shading styles for each cell
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = table[i][j];
                    int colorIndex = (int) (((double) (value - minValue) / (double) (maxValue - minValue)) * 31);
                    String color = getRainbowColor(colorIndex);
                    writer.write("td#cell-" + i + "-" + j + " {\n");
                    writer.write("  background-color: " + color + ";\n");
                    writer.write("}\n");
                }
            }

            // Close the CSS file
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while generating the CSS file.");
            e.printStackTrace();
        }

        // Generate the HTML code for the multiplication table
        StringBuilder html = new StringBuilder();
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"multiplication-table.css\">\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("<table>\n");

        // Generate the header row
        html.append("<tr>\n");
        html.append("<td></td>\n");
        for (int j = 1; j <= n; j++) {
            html.append("<td>" + j + "</td>\n");
        }
        html.append("</tr>\n");

        // Generate the table body
        for (int i = 0; i < n; i++) {
            html.append("<tr>\n");
            html.append("<td>" + (i + 1) + "</td>\n");
            for (int j = 0; j < n
