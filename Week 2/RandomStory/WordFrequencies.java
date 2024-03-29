import java.util.ArrayList;
import edu.duke.*;

public class WordFrequencies {
  private ArrayList<String> myWords;
  private ArrayList<Integer> myFreqs;
  public WordFrequencies(){
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
  }
  public void findUnique(){
    myFreqs.clear();
    myWords.clear();
    FileResource fr = new FileResource();
    for(String word: fr.words()){
        word = word.toLowerCase();
        if(myWords.indexOf(word) == -1){
            myWords.add(word);
            myFreqs.add(1);
        }else{
            myFreqs.set(myWords.indexOf(word), myFreqs.get(myWords.indexOf(word))+1);
        }
    }
  }

  public int findIndexOfMax(){
    int index = 0;
    for(int i=0;i<myFreqs.size();i++){
      if(myFreqs.get(i) > myFreqs.get(index)){
        index = i;
      }
    }
    return index;
  }

  public void tester(){
    findUnique();
    System.out.println(myWords);
    for(int i=0;i<myWords.size();i++){
      System.out.println(myWords.get(i) + " - " + myFreqs.get(i));
    }
    System.out.println("The unique words are = " + myWords.size());
    System.out.println("The word that occurs the most is = " + myWords.get(findIndexOfMax()) + " - with index " + findIndexOfMax());
  }
  public static void main(String[] args) {
    WordFrequencies wf = new WordFrequencies();
    wf.tester();
  }
}
