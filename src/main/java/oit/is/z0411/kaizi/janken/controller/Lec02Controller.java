package oit.is.z0411.kaizi.janken.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import oit.is.z0411.kaizi.janken.model.Janken;
import oit.is.z0411.kaizi.janken.model.Match;
import oit.is.z0411.kaizi.janken.model.MatchMapper;
import oit.is.z0411.kaizi.janken.model.User;
import oit.is.z0411.kaizi.janken.model.UserMapper;
import oit.is.z0411.kaizi.janken.model.Entry;

@Controller
public class Lec02Controller {
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @Autowired
  private Entry entry;

  private int loginUserId;
  private int matchUserId;

  /**
   * @param user_name
   * @param model
   * @return
   */
  /*
   * @PostMapping("/lec02") public String lec02(@RequestParam String user_name,
   * ModelMap model) { // Jankenクラスのインスタンス取得 this.janken = new Janken();
   *
   * model.addAttribute("user_name", user_name); return "lec02.html"; }
   */

  @GetMapping("/lec02")
  public String lec02(Principal principal, ModelMap model) {
    // ログインユーザ取得
    String loginUserName = principal.getName();
    this.loginUserId = this.userMapper.getIdByName(loginUserName);
    // ユーザを追加
    this.entry.addUser(loginUserName);

    List<User> users = this.userMapper.getAllUsers();
    List<Match> matches = this.matchMapper.getAllMatches();

    // model.addAttribute("entry", this.entry);
    model.addAttribute("user_name", loginUserName);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);

    return "lec02.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, ModelMap model) {
    this.matchUserId = id;

    model.addAttribute("player_name", this.userMapper.getUserById(this.loginUserId).getName());
    model.addAttribute("com_name", this.userMapper.getUserById(this.matchUserId).getName());

    return "match.html";
  }

  /**
   * @param my_hand
   * @param model
   * @return
   */

  @GetMapping("/result")
  public String janken(@RequestParam Integer my_hand, ModelMap model) {
    model.addAttribute("player_name", this.userMapper.getUserById(this.loginUserId).getName());
    model.addAttribute("com_name", this.userMapper.getUserById(this.matchUserId).getName());

    // じゃんけん ここから
    // 手の選択
    Janken.selectMyHand(my_hand);
    Janken.selectComHand();

    // じゃんけん対戦結果をDBに挿入
    Match result = new Match();
    result.setUser_1(this.loginUserId);
    result.setUser_2(this.matchUserId);
    result.setUser_1_hand(Janken.getMyHandName());
    result.setUser_2_hand(Janken.getComHandName());
    this.matchMapper.insertResult(result);

    // 手と結果の表示
    model.addAttribute("my_hand", Janken.getMyHandName());
    model.addAttribute("com_hand", Janken.getComHandName());
    model.addAttribute("result", Janken.getResult());

    return "match.html";
  }
}
