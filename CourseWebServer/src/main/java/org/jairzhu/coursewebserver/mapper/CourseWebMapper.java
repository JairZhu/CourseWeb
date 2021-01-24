package org.jairzhu.coursewebserver.mapper;

import org.apache.ibatis.annotations.*;
import org.jairzhu.coursewebserver.domain.*;

import java.util.List;

@Mapper
public interface CourseWebMapper {
    @Select("select title, content, writer, time from notification")
    public List<Notification> findAllNotifications();

    @Select("select title, content, writer, time from news")
    public List<News> findAllNews();

    @Select("select title, writer, time from ppt")
    public List<PPT> findAllPPTs();

    @Select("select title, content, writer, time from assignment")
    public List<Assignment> findAllAssignment();

    @Select("select name, password, type from user")
    public List<User> findAllUsers();

    @Insert("insert into user(name, password, type) values(#{name}, #{password}, #{type})")
    public void saveUser(User user);
}
