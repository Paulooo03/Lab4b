import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        LinkedList<String> inputQueue = new LinkedList<>();

        System.out.println("Input the pseudocode file paths here then input \"done\" when finished: ");
        while (true) {
            String data = userInput.nextLine();
            if (Objects.equals(data, "done")) {
                break;
            }
            inputQueue.add(data);
        }

        while (!inputQueue.isEmpty()) {
            String filePath = inputQueue.poll();

            try {
                FileReader fr = new FileReader(filePath);
                Scanner fileScanner = new Scanner(fr);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);

                    if (line.matches(".*\\b(int|float|String|char|boolean|double|integer|Integer)\\b.*")) {
                        System.out.println("assign/declare - 1 ci");
                    }
                    if (line.matches(".*\\b(Print|Display|Output)\\b.*")) {
                        System.out.println("Display - 1 ci");
                    }
                    if (line.matches(".*\\b(for|For)\\b.*")) {
                        System.out.println("for loop - 2ci*n + 1ci");
                    }
                    if (line.matches(".*\\b(while|While)\\b.*")) {
                        System.out.println("While loop - (n-1)*ci");
                    }
                    if (line.matches(".*\\b(case|switch|Case|Switch)\\b.*")) {
                        System.out.println("switch - 1 ci");
                    }
                    if (line.matches(".*\\b(input|Input)\\b.*")) {
                        System.out.println("input - 1 ci");
                    }
                    if (line.matches(".*\\b(else|if|else if|Else|If|Else if)\\b.*")) {
                        System.out.println("if/elseif/else - 1 ci");
                    }
                }

                fileScanner.close();
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }

        userInput.close();
    }
}
