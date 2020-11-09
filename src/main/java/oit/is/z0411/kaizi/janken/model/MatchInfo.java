package oit.is.z0411.kaizi.janken.model;

public class MatchInfo {
  private int id;
  private int user_1;
  private int user_2;
  private boolean is_active;

  public int getId() {
    return id;
  }

  public int getUser_1() {
    return user_1;
  }

  public int getUser_2() {
    return user_2;
  }

  public boolean getIs_active() {
    return is_active;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUser_1(int user_1) {
    this.user_1 = user_1;
  }

  public void setUser_2(int user_2) {
    this.user_2 = user_2;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }
}
