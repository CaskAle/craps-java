package craps;

import java.util.*;

public class Player {
  private String name;
  private List betList;
  private long defaultWager;
  private long bankRoll;
  private long marker;
  private long totalBet;
  private long totalWon;
  private long totalLost;
  private boolean autoMaxOdds;

  public Player() {
    super();
  }

  public Player(String newName) {
    super();
    setName(newName);
    setDefaultWager(10);
    setAutoMaxOdds(true);
    betList = new ArrayList();
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    name = newName;
  }

  public void setDefaultWager(long newDefaultWager) {
    defaultWager = newDefaultWager;
  }

  public long getDefaultWager() {
    return defaultWager;
  }

  public void setAutoMaxOdds(boolean newAutoMaxOdds) {
    autoMaxOdds = newAutoMaxOdds;
  }

  public boolean isAutoMaxOdds() {
    return autoMaxOdds;
  }

  public void setBetList(List newBetList) {
    betList = newBetList;
  }

  public List getBetList() {
    return betList;
  }
}
