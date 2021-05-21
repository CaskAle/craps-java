package craps.bet;

import craps.*;

public class AnyCrapsBet extends Bet {

  public AnyCrapsBet(long wager) {
    super("Any Craps", wager, 7, 1);
  }

  public boolean check(Die die1, Die die2) {
    switch (die1.getRoll() + die2.getRoll()) {
      case 2:
      case 3:
      case 12:
        return win();
      default:
        return lose();
    }
  }
}

