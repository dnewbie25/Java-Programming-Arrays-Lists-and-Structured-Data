// this class decrypts a message based on the statistical occurence of each word of the English alphabet
import java.util.Arrays;
import edu.duke.*;

public class CaesarBreaker {

    public int[] countLetters(String message){
        // counts the frequency of each letter
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i =0; i<message.length();i++){
            char currentCharacter = message.toLowerCase().charAt(i);
            if(Character.isLetter(currentCharacter)){
                counts[alphabet.indexOf(currentCharacter)] += 1;
            }
        }
        return counts;
    }


    public int maxIndex(int[] lettersFrequency){
        // gets the index (letter) with more repetitions
        int maxDex = 0;
        for(int i =0; i<lettersFrequency.length;i++){
            if(lettersFrequency[i] > lettersFrequency[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }

    public String decrypt(String encrypted){
        // decrypots the message having the E as the most common word of the English language
        CaesarCipher cc = new CaesarCipher();
        int[] frequentLetters = countLetters(encrypted);
        // the index of the letter with maximum repetitions on the encrypted message
        int maxDex = maxIndex(frequentLetters);
        // find the distance from the maxDex to the letter E (the most common word in English) to get a possible key to decipher the message
        int decryptionKey = maxDex - 4;
        // if less than 4, it means that it should go backwards on the alphabet
        if(maxDex < 4){
            decryptionKey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - decryptionKey);
    }

    public String halfOfString(String message, int start){
        // returns a string formed by the even or odd characters
        // start = 0 is even, if 1 then it is odd
        String newMessage = "";
        for(int i = start; i<message.length();i+=2){          
            newMessage += message.charAt(i);
        }
        return newMessage;
    }

    // testing methods
    public String testCountLetters(){
        return Arrays.toString(countLetters("Abedae"));
    }

    public void testDecrypt(){
        FileResource fr = new FileResource();
        String phrase = fr.asString();
        System.out.println("Message to encrypt: \n\t"+phrase);
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(phrase, 13);
        System.out.println("Encrypted message: \n\t"+message);
        System.out.println("Decrypted message: \n\t"+ decrypt(message));
    }
}
