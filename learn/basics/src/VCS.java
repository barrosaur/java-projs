import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VCS {
    public VCS() {

        // Declare variables
        Scanner scanner = new Scanner(System.in);
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        List<Character> vowelInString = new ArrayList<>();
        List<Character> consonantsInString = new ArrayList<>();

        // Ask user input
        System.out.print("Enter string: ");
        String string = scanner.nextLine();

        // Iterate through each character of the string
        for(int i = 0; i < string.length(); i++) {

            // convert to lower case and individualize each character
            char c = Character.toLowerCase(string.charAt(i));

            if(Character.isLetter(c)) {
                // isVowel boolean
                boolean isVowel = false;

                // look for vowels in the string
                for(char v: vowels) {
                    if(c == v) {
                        isVowel = true;
                        break;
                    }
                }

                // store vowels in list
                if(isVowel) {
                    vowelInString.add(c);
                } else {
                    consonantsInString.add(c);
                }
            }
        }

        printVowel(vowelInString);
        printConsonant(consonantsInString);
    }

    private void printVowel(List<Character> vowels) {
        System.out.print("Vowels: ");
        for(char v: vowels) {
            System.out.print(v);
        }
        System.out.println();
    }

    private void printConsonant(List<Character> consonants) {
        System.out.print("Consonants: ");
        for(char c: consonants) {
            System.out.print(c);
        }
        System.out.println();
    }
}

