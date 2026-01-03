import java.io.File;
import java.util.Scanner;

public class TagChecking {

    public static void main(String[] args) {

        try {
            StringStackImpl<String> stack = new StringStackImpl<>();
            Scanner scanner = new Scanner(new File(args[0]));
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split logic to isolate tags within <>
                String[] words = line.split("(?=<)|(?<=>)"); 

                for (String word : words) {
                    // Skip self-closing or singleton tags
                    if (word.matches("<br>|<img>") ) { 
                        continue;
                    } 
                    // Matches opening tags (alphanumeric characters)
                    else if (word.matches("<[a-zA-Z0-9]+>")) { 
                        stack.push(word);
                    } 
                    // Matches closing tags
                    else if (word.matches("</[a-zA-Z0-9]+>")) {
                        if (stack.isEmpty()) {
                            System.out.println("Error: Closing tag found without a matching opening tag.");
                            return;
                        } else {
                            String compare = stack.pop();
                            // Check if the closing tag matches the last opened tag
                            if (!word.equals("</" + compare.substring(1))) {
                                System.out.println("Error: Mismatched tags.");
                                return;
                            }
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("Success: Tags are balanced.");
            } else {
                System.out.println("Error: Some tags were not closed.");
            }
        }
        catch (Exception e) {
            System.out.println("Error: File not found or invalid input.");
        }
    }
}