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

  @Select("SELECT * FROM matches WHERE user_1 = #{user_1} AND user_2 = #{user_2}")
  List<Match> getMatchesByUsers(int user_1, int user_2);

  @Insert("INSERT INTO matches (user_1, user_2, user_1_hand, user_2_hand, is_active) VALUES (#{user_1}, #{user_2}, #{user_1_hand}, #{user_2_hand}, #{is_active})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertResult(Match match);
}
