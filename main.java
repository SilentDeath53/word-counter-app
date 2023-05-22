import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        // Kullanıcıdan metin belgesini seçmesini isteyin
        String filePath = getFilePathFromUser();
        
        // Metin belgesini okuyun
        String text = readTextFromFile(filePath);
        
        // Kelimeleri say ve frekansını hesapla
        Map<String, Integer> wordCounts = countWords(text);
        
        // Sonuçları ekrana yazdır
        printWordCounts(wordCounts);
    }
    
    public static String getFilePathFromUser() {
        // Kullanıcıdan dosya seçmesini isteyin ve dosya yolunu döndürün
        // Bu kısmı arayüzünüze veya konsol girişine uygun şekilde düzenleyebilirsiniz
    }
    
    public static String readTextFromFile(String filePath) {
        try {
            // Dosyayı okuyun ve içeriği bir String'e aktarın
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
        
        // Metni kelimelere ayır ve kelime sayısını hesapla
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        
        return wordCounts;
    }
    
    public static void printWordCounts(Map<String, Integer> wordCounts) {
        // Kelime sayısını ve frekansını ekrana yazdır
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            System.out.println(word + ": " + count);
        }
    }
}
