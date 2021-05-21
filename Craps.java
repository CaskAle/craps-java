package craps;

import java.util.*;
import craps.bet.*;

public class Craps {
  boolean packFrame = false;
  private Die die1;
  private Die die2;
  private Bet bet;
  private Player player;
  private List betList;
  boolean action;

  public Craps() {
    super();
    die1 = new Die();
    die2 = new Die();
    Die.newDice();   // called when a player wants new dice.
    player = new Player("Troy");
    betList = new ArrayList();
    betList.add(new AnySevenBet(player.getDefaultWager()));
    betList.add(new AnyCrapsBet(50));
    betList.add(new PlaceFourBet(50));
    betList.add(new PlaceFiveBet(50));
    betList.add(new PlaceSixBet(50));
    betList.add(new PlaceEightBet(50));
    betList.add(new PlaceNineBet(50));
    betList.add(new PlaceTenBet(50));
    betList.add(new ElevenBet(50));
    betList.add(new HardFourBet(50));
    betList.add(new HardSixBet(50));
    betList.add(new HardEightBet(50));
    betList.add(new HardTenBet(50));
    betList.add(new BigSixBet(50));
    betList.add(new BigEightBet(50));
    betList.add(new CrapTwoBet(50));
    betList.add(new CrapThreeBet(50));
    betList.add(new CrapTwelveBet(50));
    betList.add(new FieldBet(50));
    betList.add(new PassLineBet(50));
    betList.add(new ComeLineBet(50));
    betList.add(new DontPassBet(50));
    betList.add(new DontComeBet(50));
    betList.add(new OddsBet(50, 4, true));
    while (!betList.isEmpty()) {
      die1.setRoll();
      die2.setRoll();
      System.out.println("\nRoll: " + die1.getRoll() + ", " +
                         die2.getRoll() + ": " +
                         (die1.getRoll() + die2.getRoll()));
      ListIterator betIterator = betList.listIterator();
      while (betIterator.hasNext()) {
        bet = (Bet) betIterator.next();
        action = bet.check(die1, die2);
        System.out.println("\nThe " + bet.getName() + " bet of $" +
                           bet.getAmount() + ", pays $" + bet.getPayout());
        betIterator.remove();
        if (action)
          bet.setPayout(0);
      }
    }
  }

  public static void main(String[] args) {
    new Craps();
  }
}