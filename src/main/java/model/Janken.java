package oit.is.z0411.kaizi.janken.model;

public class Janken {
  private JankenHand myHand;
  private JankenHand comHand;

  public Janken(int myHand) {
    this.myHand = JankenHand.valueOf(myHand);
    this.comHand = JankenHand.GU;
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
