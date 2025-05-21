import java.io.*;
import java.util.*;

public class PalindromeFrequency10 {

    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with your file name

        Map<String, Integer> palindromeFreq = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Normalize to lowercase and extract words
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (isPalindrome(word) && word.length() > 1) {
                        palindromeFreq.put(word, palindromeFreq.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Print results
            if (palindromeFreq.isEmpty()) {
                System.out.println("No palindromes found.");
            } else {
                System.out.println("Palindrome word frequencies:");
                for (Map.Entry<String, Integer> entry : palindromeFreq.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Helper function to check for palindrome
    private static boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
