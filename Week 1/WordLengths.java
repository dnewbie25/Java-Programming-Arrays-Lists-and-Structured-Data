// Counts the numbers of words which same number of characters. Each position 
// in the array is the number of characters and its value the number of words
import edu.duke.*;
import java.util.Arrays;

public class WordLengths {
  public void countWordLengths (FileResource resource, int[] counts){
    for(String word: resource.words()){
      int wordLength = word.length();
      if(Character.isLetter(word.charAt(0)) == false){
        wordLength -= 1;
      }
      if(Character.isLetter(word.charAt(wordLength-1)) == false){
        wordLength -= 1;
      }
      counts[wordLength] += 1;
    }
    System.out.println(Arrays.toString(counts));
  }

  public void testCountWordLengths (){
    FileResource fr = new FileResource();
    int[] counts = new int[31];
    countWordLengths(fr, counts);
  }
}
