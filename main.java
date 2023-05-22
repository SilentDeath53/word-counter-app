import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        String filePath = getFilePathFromUser();
        
        String text = readTextFromFile(filePath);
        
        Map<String, Integer> wordCounts = countWords(text);
        
        printWordCounts(wordCounts);
    }
    
    public static String getFilePathFromUser() {
        // Ask user to select file and return file path
        // You can edit this part to suit your interface or console input
    }
    
    public static String readTextFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append(" ");
            }
            
            scanner.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();
        
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        
        return wordCounts;
    }
    
    public static void printWordCounts(Map<String, Integer> wordCounts) {
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            System.out.println(word + ": " + count);
        }
    }
}
