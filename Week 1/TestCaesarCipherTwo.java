import edu.duke.*;
import java.util.Arrays;

public class TestCaesarCipherTwo {
  public String halfOfString(String message, int start){
    // returns a string formed by the even or odd characters
    // start = 0 is even, if 1 then it is odd
    String newMessage = "";
    for(int i = start; i<message.length();i+=2){          
        newMessage += message.charAt(i);
    }
    return newMessage;
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

public int getKey(String s){
  // returns the possible key based on which letter is the most repeated one
  int[] letterFrequencies = countLetters(s);
  int maxDex =  maxIndex(letterFrequencies);
  // repeating the key calculation from the decrypt method from above
  int decryptionKey = maxDex - 4;
  if(maxDex < 4){
      decryptionKey = 26 - (4-maxDex);
  }
  return decryptionKey;
}

  public void simpleTest(){
    FileResource fr = new FileResource();
    String fileStr = fr.asString();
    CaesarCipherTwo caesarTwoKeys = new CaesarCipherTwo(14,24);
    String encryptedMessage = caesarTwoKeys.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
    System.out.println("Encrypted message with 2 keys = " + encryptedMessage);
    String decryptedMessage =  caesarTwoKeys.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy.");
    System.out.println("Decrypt with 2 keys = " + decryptedMessage);
    System.out.println("=======================");
  }

  public void breakCaesarCipher(String input){
    String decryptedMessage = "";
        String evenCharacters = halfOfString(input, 0);
        int keyOfEvenChars = getKey(evenCharacters);
        String oddCharacters = halfOfString(input, 1);
        int keyOfOddChars = getKey(oddCharacters);
        //System.out.println("even characters = " + evenCharacters);
        //System.out.println("odd characters = " + oddCharacters);
        System.out.println("Key 1 = "+keyOfEvenChars+" & Key 2 = "+keyOfOddChars);
        CaesarCipherTwo cc =  new CaesarCipherTwo(26-keyOfEvenChars, 26-keyOfOddChars);
        int even = 0;
        int odd = 0;
        for(int i= 0;i<input.length();i++){
            if(even < evenCharacters.length()){
                decryptedMessage += evenCharacters.charAt(even);
                even += 1;
            }
            if(odd<oddCharacters.length()){
                decryptedMessage += oddCharacters.charAt(odd);
                odd += 1;
            }
        }
        System.out.println(cc.encrypt(decryptedMessage));
  }

  public static void main(String[] args) {
    TestCaesarCipherTwo tc2 = new TestCaesarCipherTwo();
    FileResource fr = new FileResource();
    String fileStr = fr.asString();
    tc2.breakCaesarCipher(fileStr);
    //tc2.simpleTest();
    //System.out.println("The following is a decrypted message with 2 keys using letter frequency");
    //tc2.breakCaesarCipher("UHRU RNHE, QF DDKWVU ZYDK PRL DDP YDMH KVDIG, KKVUV ZV QF TDBH LE KKV TREIVUVQTH UFRD.  KKV TDBH LJ R CLV.  GOVDJH NVHG NRINZQX FQ FFXIVVUR MLUHFV. KKRQBV, UUVZ");
    //tc2.breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
}
}
