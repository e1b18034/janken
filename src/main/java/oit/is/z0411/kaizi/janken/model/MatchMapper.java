package oit.is.z0411.kaizi.janken.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {
  @Select("SELECT * FROM matches")
  List<Match> getAllMatches();

  @Insert("INSERT INTO matches (user_1, user_2, user_1_hand, user_2_hand) VALUES (#{user_1}, #{user_2}, #{user_1_hand}, #{user_2_hand})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertResult(Match match);
}
