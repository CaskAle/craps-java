package craps.bet;

import craps.*;

public abstract class Bet {

  private String name;
  private int multiplier;
  private int divisor;
  private long amount;
  private long payout;
  private boolean working;

  public Bet(String name, long amount) {
    this (name, amount, 1, 1);
  }

  public Bet(String name, long amount, int multiplier, int divisor) {
    super();
    setName(name);
    setAmount(amount);
    setMultiplier(multiplier);
    setDivisor(divisor);
    setPayout(0);
    setWorking(true);
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getName () {
    return name;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public long getAmount() {
    return amount;
  }

  public void setMultiplier(int multiplier) {
    this.multiplier = multiplier;
  }

  public int getMultiplier() {
    return multiplier;
  }

  public void setDivisor(int divisor) {
    this.divisor = divisor;
  }

  public int getDivisor() {
    return divisor;
  }

  public void setPayout(long payout) {
    this.payout = payout;
  }

  public long getPayout() {
    return payout;
  }

  public void setWorking(boolean working) {
    this.working = working;
  }

  public boolean isWorking() {
    return working;
  }

  public boolean win() {
    setPayout(getAmount() / getDivisor() * getMultiplier() + (getAmount() % getDivisor()));
    return true;
  }

  public boolean lose() {
    setPayout(getAmount() * -1);
    return true;
  }

  public boolean push() {
    setPayout(0);
    return true;
  }

  public abstract boolean check(Die die1, Die die2);
}
