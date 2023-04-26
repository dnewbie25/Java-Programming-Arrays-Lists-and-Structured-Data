import java.util.ArrayList;
import edu.duke.FileResource;

public class CharactersInPlay {
  private ArrayList<String> characters;
  private ArrayList<Integer> freqs;
  public CharactersInPlay(){
    characters = new ArrayList<String>();
    freqs = new ArrayList<Integer>();
  }

  public void update(String person){
    if(characters.indexOf(person) == -1){
      characters.add(person);
      freqs.add(1);
    }else{
      freqs.set(characters.indexOf(person), freqs.get(characters.indexOf(person))+1);
    }
  }

  public void findAllCharacters(){
    characters.clear();
    freqs.clear();
    FileResource fr = new FileResource();
    for(String line: fr.lines()){
      if(line.indexOf(".") != -1){
          String possibleChar = line.substring(0,line.indexOf("."));
          update(possibleChar);
      }
    }
  }
  
  public void tester(){
      findAllCharacters();
      System.out.println("\n\n===Characters====\n\n");
      for(int i=0;i<characters.size();i++){
          System.out.println(characters.get(i) + " - " + freqs.get(i));
      }
  }
    
  public void charactersWithNumParts(int num1, int num2){
    System.out.println("\n\n========Characters with exact num parts============\n\n");
    for(int i=0; i<characters.size();i++){
      if(freqs.get(i) >= num1 && freqs.get(i) <= num2){
        System.out.println(characters.get(i) + " - " + freqs.get(i));
      }
    }
  }
  
  public void findIndexOfMax(){
    int index = 0;
    for(int i=0;i<freqs.size();i++){
      if(freqs.get(i) > freqs.get(index)){
        index = i;
      }
    }
    System.out.println("the character with most lines is = " + characters.get(index) + " - " + freqs.get(index));
  }
  public static void main(String[] args) {
    CharactersInPlay cip = new CharactersInPlay();
    cip.tester();
    cip.charactersWithNumParts(10, 15);
    //cip.findIndexOfMax();
  }
}
