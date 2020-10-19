package oit.is.z0411.kaizi.janken.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Entry {
  private List<String> users = new ArrayList<>();

  // ユーザ追加
  public boolean addUser(String userName) {
    // 同名ユーザが居るか
    for (String user : this.users) {
      if (userName.equals(user)) {
        // 追加失敗
        return false;
      }
    }

    // ユーザ追加
    this.users.add(userName);

    // 追加成功
    return true;
  }

  public List<String> getUsers() {
    return this.users;
  }

  public void setUsers(List<String> users) {
    this.users = users;
  }
}
