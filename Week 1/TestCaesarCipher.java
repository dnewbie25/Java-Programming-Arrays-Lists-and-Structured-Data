import edu.duke.*;
import java.util.Arrays;
public class TestCaesarCipher {
  public void simpleTest(){
    FileResource fr = new FileResource();
    String fileStr = fr.asString();
    CaesarCipher cc = new CaesarCipher(18);
    String encryptedStr = cc.encrypt(fileStr);
    System.out.println("Encrypted message = " + encryptedStr);
    String decryptString = cc.decrypt(encryptedStr);
    System.out.println("Decrypted message = "+decryptString);
  }
  
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
  
  public void breakCaesarCipher(String input){
       // decrypts the message having the E as the most common word of the English language
        int[] frequentLetters = countLetters(input);
        // the index of the letter with maximum repetitions on the encrypted message
        int maxDex = maxIndex(frequentLetters);
        // find the distance from the maxDex to the letter E (the most common word in English) to get a possible key to decipher the message
        int decryptionKey = maxDex - 4;
        // if less than 4, it means that it should go backwards on the alphabet
        if(maxDex < 4){
            decryptionKey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26-decryptionKey);
        System.out.println("Decrypted message using the letter frequency = " +cc.encrypt(input));
  }
  
    public static void main(String[] args) {
      TestCaesarCipher tcc = new TestCaesarCipher();
      tcc.simpleTest();
      tcc.breakCaesarCipher("VWSJ GOWF, FG ESLLWJ OZSL QGM ESQ ZSNW ZWSJV, LZWJW AK FG USCW AF LZW UGFXWJWFUW JGGE.  LZW USCW AK S DAW.  HDWSKW CWWH OGJCAFY GF UGMJKWJS NAVWGK. LZSFCK, VJWO");
    }
}
