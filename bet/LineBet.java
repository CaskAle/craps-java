// LineBet is an abstract class that is the root of all Line bets.

package craps.bet;

import craps.*;

public abstract class LineBet extends Bet {

  private int target;
  private OddsBet oddsBet;
  private boolean normal;

  public LineBet(String name, long wager, boolean normal) {
    super(name, wager);
    setTarget(0);
    setOddsBet(null);
    setNormal(normal);
  }

  public void setTarget(int aTarget) {
    target = aTarget;
  }

  public int getTarget() {
    return target;
  }

  public void setOddsBet(OddsBet anOddsBet) {
    oddsBet = anOddsBet;
  }

  public OddsBet getOddsBet() {
    return oddsBet;
  }

  public void setNormal(boolean aNormal) {
    normal = aNormal;
  }

  public boolean isNormal() {
    return normal;
  }

  public boolean check(Die die1, Die die2) {
    int roll = die1.getRoll() + die2.getRoll();

    if (getTarget() == 0)
      switch (roll) {
        case 2:
        case 3:
          return isNormal() ? lose() : win();
        case 7:
        case 11:
          return isNormal() ? win() : lose();
        case 12:
          return isNormal() ? lose() : push();
        default:
          setTarget(roll);
          return false;
      }
    else if (roll == getTarget()) {
      if (oddsBet != null)
        oddsBet.check(die1, die2);
      return isNormal() ? win() : lose();
    }
    else if (roll == 7) {
      if (oddsBet != null)
        oddsBet.check(die1, die2);
      return isNormal() ? lose() : win();
    }
    else
      return false;
  }
}
