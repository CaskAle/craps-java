// NumberBet is an abstract class that is the root of all number bets.  A
// number bet is one in which the goal is to roll a target number.  In a
// multi roll number bet, the goal is to roll the target number before rolling
// a 7.  If the 7 is rolled first, the bet is lost.  In a single roll number
// bet, the goal is to roll the target number on the next roll of the dice.  If
// the target number is not rolled on the next roll of the dice, the bet is
// lost.

package craps.bet;
import craps.*;

public abstract class NumberBet extends Bet {

  private int target;
  private boolean multiRoll;

  public NumberBet(String name, long wager, int target, int multiplier,
                   int divisor, boolean multiRoll) {
    super(name, wager, multiplier, divisor);
    setTarget(target);
    setMultiRoll(multiRoll);
  }

  public void setTarget(int aTarget) {
    target = aTarget;
  }

  public int getTarget() {
    return target;
  }

  public void setMultiRoll(boolean aMultiRoll){
    multiRoll = aMultiRoll;
  }

  public boolean isMultiRoll() {
    return multiRoll;
  }

  public boolean check(Die die1, Die die2) {
    if (die1.getRoll() + die2.getRoll() == getTarget())
      return win();
    else if (isMultiRoll() && (die1.getRoll() + die2.getRoll() != 7))
      return false;
    else
      return lose();
  }
}
