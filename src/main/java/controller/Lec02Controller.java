package oit.is.z0411.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import oit.is.z0411.kaizi.janken.model.Janken;

@Controller
public class Lec02Controller {
  /**
   * @param user_name
   * @param model
   * @return
  */
  @PostMapping("/lec02")
  public String lec02(@RequestParam String user_name, ModelMap model) {
    model.addAttribute("user_name", user_name);
    return "lec02.html";
  }

  /**
   * @param my_hand
   * @param model
   * @return
   */
  @GetMapping("/lec02")
  public String lec02(@RequestParam Integer my_hand, ModelMap model) {
    Janken janken = new Janken(my_hand);

    model.addAttribute("my_hand", janken.myHandName());
    model.addAttribute("com_hand", janken.comHandName());
    model.addAttribute("result", janken.result());

    return "lec02.html";
  }
}
