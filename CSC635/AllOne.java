// Name Kailash Dhakal
// CSC 635 Lab 4 Assignment
// Description :  Below code will generate the HTML and CSS file which include the Three different Multiplication tables
// Simple (No color), GreyScale and Rainbow Colorful Table

import java.io.*;

public class AllOne {
    public static void main(String[] args) {

        // It will verify the given number while running the program in the terminal

        if (args.length == 0) {
            System.out.println("Please enter an integer between 5 and 12 as an argument.");
            return;
        }

        // If the given number is not valid or between 5-12 program will stop

        int givenNumber = Integer.parseInt(args[0]);
        if (givenNumber < 5 || givenNumber > 12) {
            System.out.println("Please enter an integer between 5 and 12 as an argument.");
            return;
        }

        // Generate HTML all the table will be written inside the table tag
        // with the href tag table_style.css is linked in html file
        String html = "<html>\n<head>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"table_style.css\">\n" +
                "<h1>Multiplication Tables</h1><br> <h2> Name : Kailash Dhakal <br> CSC 635 Lab 4 </br></h2> \n"
                +
                "<table>\n<tr><th colspan=\"" + givenNumber + "\">Simple Table</th></tr>\n" +
                "<tr>";

        // This below code will generate the table for the simple Table (without color)

        for (int i = 1; i <= givenNumber; i++) {
            html += "<tr>";
            for (int j = 1; j <= givenNumber; j++) {
                int product = i * j;
                html += "<td class=\"simple\">" + product + "</td>";
            }
            html += "</tr>\n";
        }
        html += "</table>\n" +
                "<table>\n<tr><th colspan=\"" + givenNumber + "\">GreyScale Table</th></tr>\n" +
                "<tr>";

        // Create the Different Table GreyScale
        for (int i = 1; i <= givenNumber; i++) {
            html += "<tr>";
            for (int j = 1; j <= givenNumber; j++) {
                int product = i * j;
                // String color = "rgb(" + product + ", " + product + ", " + product + ")";
                String color = "rgb(" + product + ", " + product + ", " + product + ")";
                html += "<td class=\"grayscale\">" + product + "</td>";
            }
            html += "</tr>\n";
        }

        // Write the second table (rainbow-colored multiplication table) to the HTML

        html += "</table>\n" +
                "<table>\n<tr><th colspan=\"" + givenNumber + "\">Rainbow Table</th></tr>\n" +
                "<tr>";
        for (int i = 1; i <= givenNumber; i++) {
            html += "<tr>\n";
            for (int j = 1; j <= givenNumber; j++) {
                int product = i * j;
                html += "<td class=\"rainbow" + (product % 32) + "\">" + product + "</td>\n";
            }
            html += "</tr>\n";
        }
        html += "</table>\n";

        html += "</table>\n</body>\n</html>";

        // Generate CSS for the GreyScale Table
        String css = "table, th, td { border: 1px solid black; border-collapse: collapse; }\n" +
                "th, td { padding: 5px; text-align: center; }\n" +
                ".grayscale { background-color: #CCCCCC; margin-left:auto; margin-right:auto;}\n";

        try {
            // Write HTML file in the same path with the file name
            // "multiplication_tables.html"
            FileWriter htmlWriter = new FileWriter("multiplication_tables.html");
            htmlWriter.write(
                    "<span>Click Here for </span> <a href=\"https://www.example.com\"> CSS </a> <span> and </span><a href=\"https://www.example.com\"> JAVA Program</a>");
            htmlWriter.write(html);
            htmlWriter.close();
            System.out.println("HTML file written successfully.");

            // Write the CSS for the rainbow-colored multiplication table to the CSS file

            css += ".rainbow {\nborder-collapse: collapse; margin-left:auto; margin-right:auto;\n}\n";
            for (int i = 0; i < 32; i++) {
                css += ".rainbow" + i + " {\nbackground-color: hsl(" + (i * 11.25)
                        + ", 100%, 75%); margin-left:auto; margin-right:auto;\n}\n";
            }

            // Write CSS file int the same working file path as name "table_style.css"
            FileWriter cssWriter = new FileWriter("table_style.css");
            cssWriter.write(css);
            cssWriter.close();
            System.out.println("CSS file written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the files.");
            e.printStackTrace();
        }
    }
}
