package oit.is.z0411.kaizi.janken.model;

import java.lang.IllegalArgumentException;

public enum JankenResult {
  TIE(0, "Tie Game."),
  LOSE(1, "You Lose..."),
  WIN(2, "You Win!");

  private final int resultId;         // 結果のID
  private final String resultString;  // 結果を表す文字列

  // コンストラクタ
  JankenResult(final int resultId, final String resultString) {
    this.resultId = resultId;
    this.resultString = resultString;
  }

  // resultStringのgetter(代わりにtoStringをオーバーライドして実装)
  @Override
  public String toString() {
    return this.resultString;
  }

  // resultIdからJankenResultを取得
  public static JankenResult valueOf(int resultId) {
    for(JankenResult result : values()) {
      if(result.resultId == resultId) {
        return result;
      }
    }

    // resultIdが有効な値でない場合
    throw new IllegalArgumentException("valueOf() of JankenResult: argument[resultId] is out of [0, 2]");
  }
}
