// Finds the most common words among the files
import edu.duke.*;

public class commonWords {
  public String[] getCommon(){
    // gets the common words and return an array with them
      FileResource resource = new FileResource("Common words data/common.txt");
      String[] common = new String[20];
      int index = 0;
      for(String word: resource.words()){
          common[index] = word;
          index += 1;
      }
      return common;
  }
  public int indexOf(String[] list, String word){
    // returns the index that matches the word
    for(int i=0; i<list.length;i++){
      if(word.equals(list[i])){
        return i;
      }
    }
    return -1;
  }

  public void countWords(FileResource resource, String[] common, int[] wordsCounts){
    // takes a file resource, a string array and an integer array. If it finds the common word on the resource given, it adds 1 to the 
    // index that corresponds to that word
    for(String word: resource.words()){
      word = word.toLowerCase();
      int index = indexOf(common, word);
      if(index != -1){
        wordsCounts[index] += 1;
      } 
    }
  }

  void countShakespeare(){
    // creates an array where each position represents a word in the same index in the common array, so the value in wordsCounts is the word count for
    // each word
    // String[] plays = {"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
    String[] plays = {"small.txt"};
    String[] common = getCommon();
    int[] wordsCounts = new int[common.length];
    for(int i=0;i<plays.length;i++){
      FileResource resource = new FileResource("Common words data/"+plays[i]);
      countWords(resource, common, wordsCounts);
      System.out.println("done with " + plays[i]);
    }
    
    for(int i = 0; i<wordsCounts.length; i++){
      System.out.println(common[i] + " = " + wordsCounts[i]);
    }
  }
}
