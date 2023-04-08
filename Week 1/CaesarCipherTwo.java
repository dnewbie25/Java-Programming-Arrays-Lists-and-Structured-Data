public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }

    public String encrypt(String input){
        // creates two instances of CaesarCipher so each one can encrypt odd and even characters
        String encryptedString = "";
        CaesarCipher cc1 =  new CaesarCipher(mainKey1);
        CaesarCipher cc2 =  new CaesarCipher(mainKey2);
        for(int i = 0;i<input.length();i++){
            char currentChar = input.charAt(i);
            if(i%2 == 0){
            encryptedString += cc1.encrypt(Character.toString(currentChar));
            }else{
                encryptedString += cc2.encrypt(Character.toString(currentChar));
            }
        }
        return encryptedString;
    }
    
    public String decrypt(String input){
        // creates two instances of CaesarCipher so each one can decrypt odd and even characters
        String encryptedString = "";
        CaesarCipher cc1 =  new CaesarCipher(26 - mainKey1);
        CaesarCipher cc2 =  new CaesarCipher(26 - mainKey2);
        for(int i = 0;i<input.length();i++){
            char currentChar = input.charAt(i);
            if(i%2 == 0){
            encryptedString += cc1.encrypt(Character.toString(currentChar));
            }else{
                encryptedString += cc2.encrypt(Character.toString(currentChar));
            }
        }
        return encryptedString;
    }
}
