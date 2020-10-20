package oit.is.z0411.kaizi.janken.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {
  @Select("SELECT * FROM matches")
  List<Match> getAllMatches();
}
