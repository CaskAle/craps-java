package craps.bet;

public class PlaceFiveBet extends NumberBet {

  public PlaceFiveBet(long wager) {
    super("Place Five", wager, 5, 7, 5, true);
  }
}
