public class WordPlay {
  public boolean isVowel(char ch){
    // true or false if it is a vowel
    String vowels = "aeiouAEIOU";
    for(int i =0; i<vowels.length();i++){
      if(vowels.charAt(i) == ch){
        return true;
      }
    }
    return false;
  }
  public String replaceVowels(String phrase, char ch){
    //replace vowels with ch character
    String newString = "";
    for(int i = 0; i<phrase.length();i++){
      if(!isVowel(phrase.charAt(i))){
        newString += phrase.charAt(i);
      }else{
        newString += ch;
      }
    }
    return newString;
  }
  public String emphasize(String phrase, char ch){
    // replaces the ch with * or + if it is an even position (+) or odd (*), but counting from 1 to length of phrase, not from 0 like an array
      char charLower = Character.toLowerCase(ch);
      char charUpper = Character.toUpperCase(ch);
      String newString = "";
      for(int i = 0;i<phrase.length();i++){
        int position = i+1;
        if(phrase.charAt(i)!=charLower && phrase.charAt(i)!=charUpper){
          newString += phrase.charAt(i);
        }else if(position%2==0 && (phrase.charAt(i) == charLower || phrase.charAt(i) == charUpper)){
          newString += '+';
        }else if(position%2!=0 && (phrase.charAt(i) == charLower || phrase.charAt(i) == charUpper)){
          newString += '*';
        }
      }
      return newString;
  }

  // testing methods
  public void testIsVowel(){
    System.out.println(isVowel('F'));
    System.out.println(isVowel('a'));
    System.out.println(isVowel('E'));
  }
  public void testReplaceVowels(){
    System.out.println(replaceVowels("Hello World", '*'));
    System.out.println(replaceVowels("America IS GREAT!!", '^'));
  }
  public void testEmphasize(){
    System.out.println(emphasize("dna ctgaaactga", 'a'));
    System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    System.out.println(emphasize("Anita LavA lA tIna", 'i'));
    System.out.println(emphasize("Anita LavA lA tIna", 'h'));
  }

  public static void main(String[] args) {
    WordPlay wp = new WordPlay();
    wp.testIsVowel();
    wp.testReplaceVowels();
    wp.testEmphasize();
  }
}
