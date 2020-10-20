package oit.is.z0411.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {
  // 誰がログインできるか
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // user1 pwd10190157
    auth.inMemoryAuthentication().withUser("user1")
        .password("$2y$10$n0zfyFoaO7h/2BkizZxmkuaZSmkTyHFeEohxIb3W/Wjm8ElV5Dfu2").roles("USER");

    // user2 pwd10190215
    auth.inMemoryAuthentication().withUser("user2")
        .password("$2y$10$0PP5biY8ohsN8dMbp4yKk.mB0iqNqC4pQSX2UT8UBgwZAVFcoV3ES").roles("USER");

    // こいけ pwd10202035
    auth.inMemoryAuthentication().withUser("こいけ")
        .password("$2y$10$oIizsF33WcG2Ve0Rt5G2kuf9InOQMgxOxzFxQ35h3lxqTQc0AF6DW").roles("USER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // どこにアクセスできるか
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // SpringSecurityのフォームを用いてログイン
    http.formLogin();

    // lec02へのGETリクエストをすべて認証処理必要に指定
    http.authorizeRequests().antMatchers("/lec02/**").authenticated();

    // h2コンソールを利用するための設定
    http.csrf().disable();
    http.headers().frameOptions().disable();

    // ログアウト時処理
    http.logout().logoutSuccessUrl("/");
  }
}
