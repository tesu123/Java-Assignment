import java.util.*;

public class Assignment2Problem3 {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = sc.nextLine();

        int countA = 0;
        String lowerInput = input.toLowerCase();

        for (char c : lowerInput.toCharArray()) {
            if (c == 'a')
                countA++;
        }

        int countAnd = 0;
        String[] words = lowerInput.split("\\s+");
        for (String word : words) {
            if (word.equals("and"))
                countAnd++;
        }

        boolean startsWithThe = lowerInput.startsWith("the");

        char[] charArray = input.toCharArray();

        String[] tokens = input.split("[ @.]");

        String cleaned = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        String[] cleanedWords = cleaned.split("\\s+");
        String largestPalindrome = "";

        for (String word : cleanedWords) {
            if (isPalindrome(word) && word.length() > largestPalindrome.length()) {
                largestPalindrome = word;
            }
        }

        System.out.println("Number of times 'a' appears: " + countA);
        System.out.println("Number of times \"and\" appears: " + countAnd);
        System.out.println("Starts with \"The\" or not: " + startsWithThe);
        System.out.println("Array of characters: " + Arrays.toString(charArray));
        System.out.println("Tokens in the string:");
        for (String token : tokens) {
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }
        System.out.println("Largest palindrome: " + largestPalindrome);
        sc.close();
    }
}