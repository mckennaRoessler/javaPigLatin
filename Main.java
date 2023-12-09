import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Write something, and I will convert it to Pig Latin: ");
        String userInput = inputScanner.nextLine();

        String convertedWords = toPigLatin(userInput); //Run userInput through toPigLatin method and store result as new String
        System.out.println(convertedWords);
    }

    //Method to take user input, split it into individual words separated by spaces,
    //checking whether the first letter is a vowel, and performing the appropriate conversion
    private static String toPigLatin(String string) {
        String result = "";
        String[] words = string.split("\\s+"); //Creating an array of strings in which items are split apart by any number of spaces

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char p = word.charAt(word.length() - 1);
            String punctuation = "";

            //Check if the last character is anything other than a letter or digit.
            //If it is, assign it to the String punctuation, which will be removed
            // from the word and added to the end in the next step
            if (!Character.isLetterOrDigit(p)) {
                punctuation = String.valueOf(p);
                word = word.substring(0, word.length() - 1);
            }
            if (isVowel(word.charAt(0))) {
                result += word + "way" + punctuation + " ";
            } else {
                result += word.substring(1) + word.substring(0, 1) + "ay" + punctuation + " ";
            }
        }

        //capitalize first letter of result, make rest lowercase.
        return result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
    }

    //Method to check if first letter of each word is vowel
    private static boolean isVowel(char letter) {
        letter = Character.toLowerCase(letter); //convert initial character to lowercase (so "A" is seen the same as "a")
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'; //If the letter is any of these, return true (because this is a boolean method)
    }
}
