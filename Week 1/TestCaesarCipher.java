import edu.duke.*;
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
    public static void main(String[] args) {
      TestCaesarCipher tcc = new TestCaesarCipher();
      tcc.simpleTest();
    }
}
