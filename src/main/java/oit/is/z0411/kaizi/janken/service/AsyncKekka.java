package oit.is.z0411.kaizi.janken.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0411.kaizi.janken.model.Match;
import oit.is.z0411.kaizi.janken.model.MatchMapper;

@Service
public class AsyncKekka {
  @Autowired
  private MatchMapper matchMapper;

  private int userId;
  private int cpuId;

  private final Logger logger = LoggerFactory.getLogger(AsyncKekka.class);

  @Transactional
  public Match syncGetLatestMatch() {
    // matchesテーブルのうちis_activeがtrueの行を取得
    List<Match> matchList = matchMapper.getMatchesByUsers(this.userId, this.cpuId);
    if (matchList.size() == 0) {
      return null;
    }

    Match match = matchList.get(matchList.size() - 1);

    return match;
  }

  @Async
  public void asyncResult(SseEmitter emitter, int userId, int cpuId) {
    this.userId = userId;
    this.cpuId = cpuId;
    Match match = null;

    while (true) {
      // 結果取得
      match = this.syncGetLatestMatch();

      if (match == null) {
        continue;
      }

      if (!match.getIs_active()) {
        continue;
      }

      try {
        // 取得内容を送信する
        emitter.send(match);
      } catch (Exception e) {
        logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
        emitter.complete();
        break;
      }
    }
  }
}
