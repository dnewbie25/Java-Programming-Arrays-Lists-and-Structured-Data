// Counts the numbers of times and the % of times a particular numbers appears after rolling a dice
import java.util.Random;
public class diceRolling {
  public int diceRoll(){
    Random rand =  new Random();
    int diceNumber = rand.nextInt(6)+1;
    return diceNumber;
  }
  public void diceProbability(int rolls){
    // Arrays length is always 1 ahead of the index; by having 13 elements we make sure indexes 1 and 12 are usable, although rolling 2 dices will always get values between 2 and 12, but this way we make sure we have enough space on the array
    int[] numbers = new int[13]; // 13 slots, from 0 to 12
    for(int i = 0;i<rolls;i++){
      int dice1 = diceRoll();
      int dice2= diceRoll();
      numbers[dice1 + dice2] += 1;
    }

    for(int i = 2; i<numbers.length;i++){
      System.out.println("Total " + i + "'s" + " which is " + (100.0*numbers[i]/rolls) + "% of the total");
    }
  }
  //public static void main(String[] args) {
    //diceRolling dr =  new diceRolling();
    //dr.diceProbability(1000);
  //}
}
