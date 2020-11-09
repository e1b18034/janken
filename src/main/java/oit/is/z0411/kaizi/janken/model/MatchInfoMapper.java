package oit.is.z0411.kaizi.janken.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MatchInfoMapper {
  @Insert("INSERT INTO match_info (user_1, user_2, is_active) VALUES (#{user_1}, #{user_2}, #{is_active})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo matchInfo);
}
