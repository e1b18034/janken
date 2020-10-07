package oit.is.z0411.kaizi.janken.model;

import java.util.Random;

public class Janken {
  private JankenHand myHand;
  private JankenHand comHand;

  public Janken(int myHand) {
    this.myHand = JankenHand.valueOf(myHand);

    Random random = new Random();
    int comHandId = random.nextInt(3);
    this.comHand = JankenHand.valueOf(comHandId);
  }

  public String result() {
    int myhandId = this.myHand.getHandId();
    int comHandId = this.comHand.getHandId();

    int resultId = (myhandId - comHandId + 3) % 3;

    JankenResult result = JankenResult.valueOf(resultId);

    return result.toString();
  }

  public String myHandName() {
    return this.myHand.toString();
  }

  public String comHandName() {
    return this.comHand.toString();
  }
}
