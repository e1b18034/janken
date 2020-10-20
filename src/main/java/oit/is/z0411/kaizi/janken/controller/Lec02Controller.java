package oit.is.z0411.kaizi.janken.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
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
  private Janken janken;
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @Autowired
  private Entry entry;

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

  /**
   * @param my_hand
   * @param model
   * @return
   */
  /*
   * @GetMapping("/lec02") public String lec02(@RequestParam Integer my_hand,
   * ModelMap model) { // 手の選択 this.janken.selectMyHand(my_hand);
   * this.janken.selectComHand();
   *
   * // 手と結果の表示 model.addAttribute("my_hand", this.janken.myHandName());
   * model.addAttribute("com_hand", this.janken.comHandName());
   * model.addAttribute("result", this.janken.result());
   *
   * // これまでの結果を表示 int count = this.janken.getCount(); int win =
   * this.janken.getWinCount(); int lose = this.janken.getLoseCount(); int tie =
   * this.janken.getTieCount(); model.addAttribute("count", count);
   * model.addAttribute("win_count", win); model.addAttribute("lose_count", lose);
   * model.addAttribute("tie_count", tie); if (count > 0) {
   * model.addAttribute("win_rate", (double) win / count * 100);
   * model.addAttribute("lose_rate", (double) lose / count * 100);
   * model.addAttribute("tie_rate", (double) tie / count * 100); }
   *
   * return "lec02.html"; }
   */

  @GetMapping("/lec02")
  public String lec02(Principal principal, ModelMap model) {
    // ログインユーザ取得
    String loginUserName = principal.getName();
    // ユーザを追加
    this.entry.addUser(loginUserName);

    List<User> users = userMapper.getAllUsers();
    List<Match> matches = matchMapper.getAllMatches();

    // model.addAttribute("entry", this.entry);
    model.addAttribute("user_name", loginUserName);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);

    return "lec02.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, Principal principal, ModelMap model) {
    model.addAttribute("player_name", principal.getName());
    model.addAttribute("com_name", userMapper.getAllUsers().get(id - 1).getName());

    return "match.html";
  }
}
