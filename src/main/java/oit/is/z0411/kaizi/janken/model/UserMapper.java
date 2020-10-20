package oit.is.z0411.kaizi.janken.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM users")
  List<User> getAllUsers();

  @Select("SELECT id, name FROM users WHERE id = #{id}")
  User getUserById(int id);

  @Select("SELECT id FROM users WHERE name = #{name}")
  int getIdByName(String name);
}
