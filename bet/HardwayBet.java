// HardwayBet is an abstract class that is the root of all Hardways bets.

package craps.bet;

import craps.*;

public abstract class HardwayBet extends Bet {

  private int target;

  public HardwayBet(String name, long wager, int target, int multiplier,
                    int divisor) {
    super(name, wager, multiplier, divisor);
    setTarget(target);
  }

  public void setTarget(int aTarget) {
    target = aTarget;
  }

  public int getTarget() {
    return target;
  }

  public boolean check(Die die1, Die die2) {
    int hardNumber = getTarget() / 2;
    int roll  = die1.getRoll() + die2.getRoll();

    if (die1.getRoll() == hardNumber && die2.getRoll() == hardNumber)
      return win();
    else if (roll == 7 || roll == getTarget())
      return lose();
    else
      return false;
  }
}
