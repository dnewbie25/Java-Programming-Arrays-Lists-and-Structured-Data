import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import edu.duke.FileResource;

public class CaesarCipher {
  private String alphabet;
  private String shiftedAlphabet;
  private int mainKey;
  public CaesarCipher(int key){
    mainKey = key;
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
  }

  public String encrypt(String input){
    input = input.toUpperCase();
    String encryptedStr = "";
    for(int i=0;i<input.length();i++){
      int charIndex = alphabet.indexOf(input.charAt(i));
      if(charIndex != -1){
        encryptedStr += shiftedAlphabet.charAt(charIndex);
      }else{
        encryptedStr += input.charAt(i);
      }
    }
    return encryptedStr;
  }
  
  public String decrypt(String input){
      // creates an instance of the caesar cipher with the reversed key to decrypt
     CaesarCipher decryptCipher = new CaesarCipher(26 - mainKey);
     return decryptCipher.encrypt(input);
  }
}