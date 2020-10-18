package oit.is.z0411.kaizi.janken.model;

import java.lang.IllegalArgumentException;

public enum JankenHand {
  GU(0, "ぐー"),
  CHOKI(1, "ちょき"),
  PA(2, "ぱー");

  private final int handId;       // 手のID
  private final String handName;  // 手の名前

  // コンストラクタ
  JankenHand(final int handId, final String handName) {
    this.handId = handId;
    this.handName = handName;
  }

  // handIdのgetter
  public int getHandId() {
    return this.handId;
  }

  // handNameのgetter(代わりにtoStringをオーバーライドして実装)
  @Override
  public String toString() {
    return this.handName;
  }

  // handIdからJankenHandオブジェクトを取得
  public static JankenHand valueOf(int handId) {
    for(JankenHand hand : values()) {
      if(hand.handId == handId) {
        return hand;
      }
    }

    // handIdが有効な値でない場合
    throw new IllegalArgumentException("valueOf() of JankenHand: argument[handId] is out of [0, 2]");
  }
}
