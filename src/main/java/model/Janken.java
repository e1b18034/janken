package oit.is.z0411.kaizi.janken.model;

import java.util.Random;

public class Janken {
  private JankenHand myHand;
  private JankenHand comHand;
  private JankenScore score;

  public Janken() {
    this.score = new JankenScore();
  }

  public void selectMyHand(int myHand) {
    this.myHand = JankenHand.valueOf(myHand);
  }

  public void selectComHand() {
    Random random = new Random();
    int comHandId = random.nextInt(3);
    this.comHand = JankenHand.valueOf(comHandId);
  }

  private void calcJankenScore(JankenResult result) {
    score.count++;

    if(result.compare(JankenResult.TIE)) {
      score.tieCount++;

    } else if(result.compare(JankenResult.LOSE)) {
      score.loseCount++;

    } else if(result.compare(JankenResult.WIN)) {
      score.winCount++;

    }
  }

  public String result() {
    int myhandId = this.myHand.getHandId();
    int comHandId = this.comHand.getHandId();

    int resultId = (myhandId - comHandId + 3) % 3;

    JankenResult result = JankenResult.valueOf(resultId);

    calcJankenScore(result);

    return result.toString();
  }

  public String myHandName() {
    return this.myHand.toString();
  }

  public String comHandName() {
    return this.comHand.toString();
  }

  public int getCount() {
     return this.score.count;
  }

  public int getTieCount() {
    return this.score.tieCount;
  }

  public int getLoseCount() {
    return this.score.loseCount;
  }

  public int getWinCount() {
    return this.score.winCount;
  }
}
