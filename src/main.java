import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new File("C:\Users\damna\Documents\GitHub\Hangman-game\dictionary words.txt"));

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
    }
}
