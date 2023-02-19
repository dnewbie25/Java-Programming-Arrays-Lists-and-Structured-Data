import edu.duke.FileResource;

public class CaesarCipher {
  public String encrypt(String input, int key){
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String upperAlphabet = lowerAlphabet.toUpperCase(); 
    String encryptedString = "";
    for(int i=0;i<input.length();i++){
      char currentCharacter = input.charAt(i);
      int lowerAlphIndex = lowerAlphabet.indexOf(currentCharacter);
      int upperAlphIndex = upperAlphabet.indexOf(currentCharacter);

      if(lowerAlphIndex == -1 && upperAlphIndex == -1){
        encryptedString += currentCharacter;
      }else if(lowerAlphIndex > -1){
        int newIndex = (lowerAlphIndex + key);
        if(newIndex >= lowerAlphabet.length()){
          newIndex = newIndex % lowerAlphabet.length();
        }
        encryptedString += lowerAlphabet.charAt(newIndex);
      }else if(upperAlphIndex > -1){
        int newIndex = (upperAlphIndex + key);
        if(newIndex >= upperAlphabet.length()){
          newIndex = newIndex % upperAlphabet.length();
        }
        encryptedString += upperAlphabet.charAt(newIndex);
      }
    }
    return encryptedString;
  }

  // testing methods
  public void testCaesar (){
    int key = 23;
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted = encrypt(message, key);
    System.out.println("key is " + key + "\n" + encrypted);
  }
  public static void main(String[] args) {
    CaesarCipher cc = new CaesarCipher();
    System.out.println(cc.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
    System.out.println(cc.encrypt("First Legion", 17));
    System.out.println(cc.encrypt("DEAR OWEN,", 23));
    cc.testCaesar();
  }
}
