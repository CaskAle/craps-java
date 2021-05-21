package craps.bet;

import craps.*;

public class OddsBet extends Bet {

  private int target;
  private boolean normal;

  public OddsBet(long wager, int target, boolean normal) {
    super("Free Odds", wager);
    setTarget(target);
    setNormal(normal);
  }

  public void setTarget(int aTarget) {
    target = aTarget;
    switch (target) {
      case 4:
      case 10:
        setMultiplier (isNormal() ? 2 : 1);
        setDivisor (isNormal() ? 1 : 2);
        break;
      case 6:
      case 8:
        setMultiplier (isNormal() ? 6 : 5);
        setDivisor (isNormal() ? 5 : 6);
        break;
      case 5:
      case 9:
        setMultiplier (isNormal() ? 3 : 2);
        setDivisor (isNormal() ? 2 : 3);
        break;
      default:
        setMultiplier (1);
        setDivisor (1);
    }
  }

  public int getTarget() {
    return target;
  }

  public void setNormal(boolean aNormal) {
    normal = aNormal;
  }

  public boolean isNormal() {
    return normal;
  }

  public boolean win() {
    setPayout(getAmount() / getDivisor() * getMultiplier());
    if (isNormal())
      setPayout(getAmount() + (getAmount() % getDivisor()));
    return true;
  }

  public boolean check(Die die1, Die die2) {
    if (die1.getRoll() + die2.getRoll() == getTarget())
      return isNormal() ? win() : lose();
    else
      return isNormal() ? lose() : win();
  }
}
