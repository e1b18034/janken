package oit.is.z0411.kaizi.janken.model;

import java.util.Random;

public class Janken {
  private static JankenHand myHand;
  private static JankenHand comHand;

  public static void selectMyHand(int myHand) {
    Janken.myHand = JankenHand.valueOf(myHand);
  }

  public static void selectComHand() {
    Random random = new Random();
    int comHandId = random.nextInt(3);
    Janken.comHand = JankenHand.valueOf(comHandId);
  }

  public static String getResult() {
    int myhandId = Janken.myHand.getHandId();
    int comHandId = Janken.comHand.getHandId();

    int resultId = (myhandId - comHandId + 3) % 3;

    JankenResult result = JankenResult.valueOf(resultId);

    return result.toString();
  }

  public static String getMyHandName() {
    return Janken.myHand.toString();
  }

  public static String getComHandName() {
    return Janken.comHand.toString();
  }
}
