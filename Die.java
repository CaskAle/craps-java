package craps;

import java.util.*;

public class Die {

  private static Random random;
  private int roll;

  public Die() {
    super();
    if (random == null)
      newDice();
    setRoll();
  }

  public static void newDice() {
    random = new Random();
  }

  public int getRoll() {
    return roll;
  }

// The roll() method rolls the dice by:
// 1. generating a random integer between 0 and 5
// 3. adding 1 to the result to make the value between 1 and 6
// 4. the number is stored in the value property and
//    then returned to the caller

  public int setRoll() {
    roll = random.nextInt(5) + 1;
    return roll;
  }
}
