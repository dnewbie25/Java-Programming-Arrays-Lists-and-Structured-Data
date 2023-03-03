// Counts the numbers of words which same number of characters. Each position 
// in the array is the number of characters and its value the number of words
import edu.duke.*;
import java.util.Arrays;

public class WordLengths {
  public void countWordLengths (FileResource resource, int[] counts){
    for(String word: resource.words()){
      int wordLength = word.length();
      System.out.println(word);
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

  public int indexOfMax(int[] values){
    // returns the index of the word with most letter
    int max = 0;
    for(int i=0;i<values.length;i++){
      if(values[i] > values[max]){
        max = i;
      }
    }
    return max;
  }

  public void testCountWordLengths (){
    FileResource fr = new FileResource();
    int[] counts = new int[31];
    countWordLengths(fr, counts);
    System.out.println(indexOfMax(counts));
  }
}
