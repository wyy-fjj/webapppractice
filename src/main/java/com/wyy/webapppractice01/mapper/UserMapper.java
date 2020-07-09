package com.wyy.webapppractice01.mapper;


import com.wyy.webapppractice01.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.http.converter.json.GsonBuilderUtils;

@Mapper
public interface UserMapper {      //在mapper接口里定义抽象方法
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(User user);
    @Select("select * from user where username=#{username}") //*为通配符，匹配时用
    User getuser(String username);
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);
}
