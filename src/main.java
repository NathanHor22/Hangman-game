import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new File("C:\\Users\\damna\\Documents\\GitHub\\Hangman-game\\dictionary words.txt"));
        Scanner kinput = new Scanner(System.in);
        //input the words in the text file into the arraylist
        List<String> words = new ArrayList<>();

        //scans through word text
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        //Randomise the words in the dictionary
        Random rand = new Random();

        //Picking a word from the list to be used for the game
        String word = words.get(rand.nextInt(words.size()));

        //Testing
        System.out.println(word);
        //Create a list to store the guessed letters
        List<Character> guessedLetters = new ArrayList<>();

        int wrongCount = 0;
        //loops the guessing process until the word is guessed
        while(true) {
            //Print the hangman figure based on the number of incorrect guesses
            //figure out a more efficient way to do this
          

            printCurrentWordList(word, guessedLetters);
           if(!getLetterGuess(kinput, word, guessedLetters)) {
                wrongCount++;
           }
            //Win condition, the player has guessed all the letters in the word
            if(printCurrentWordList(word, guessedLetters)) {
                System.out.println("You win! Done now bossman");
                break;
            }
            //Player in process of guessing the word
            System.out.println("Enter your guess bossman");
            if(kinput.nextLine().toLowerCase().equals(word)) {
                System.out.println("You guessed the word! Bombaclat");
                break;
            }
            else {
                //Player has guessed the word incorrectly
                System.out.println("Wrong guess, try again!");
            }
        }
    


    private static boolean getLetterGuess(Scanner kinput, String word, List<Character> guessedLetters) {
        System.out.println("Skibidi enter a letter tung tung tung sahur:");
        String letterGuess = kinput.nextLine().toLowerCase();
        //Check if the letter is in the word
        guessedLetters.add(letterGuess.charAt(0));

        return word.contains(letterGuess);

    }

    private static boolean printCurrentWordList(String word, List<Character> guessedLetters) {
        //Create a variable to keep track of the number of incorrect guesses
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if(guessedLetters.contains(word.charAt(i))) {
                System.out.print(word.charAt(i) + " ");
                correctCount++;
            } else {
                System.out.print("_ ");
            }
        }
        //System.out.println();

        return (word.length() == correctCount);

    }
}
