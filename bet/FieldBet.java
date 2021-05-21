package craps.bet;

import craps.*;

public class FieldBet extends Bet {

  public FieldBet(long wager) {
    super("Field", wager, 1, 1);
  }

  public boolean check(Die die1, Die die2) {
    switch (die1.getRoll() + die2.getRoll()) {
      case 2:
        setMultiplier(2);
        return win();
      case 3:
      case 4:
      case 9:
      case 10:
      case 11:
        return win();
      case 12:
        setMultiplier (3);
        return win();
      default:
        return lose();
    }
  }
}