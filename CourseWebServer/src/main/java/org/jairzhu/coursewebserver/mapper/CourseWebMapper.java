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

    @Select("select title, content, writer, time from courseInformation")
    public List<CourseInformation> findCourseInformation();

    @Select("select title, content, fileName, writer, time, score from homework")
    public List<Homework> findAllHomeworks();

    @Insert("insert into user(name, password, type) values(#{name}, #{password}, #{type})")
    public void saveUser(User user);

    @Insert("insert into ppt values(#{title}, #{writer}, #{time})")
    public void savePPT(PPT ppt);

    @Insert("insert into news values(#{title}, #{content}, #{writer}, #{time})")
    public void saveNews(News news);

    @Insert("insert into notification values(#{title}, #{content}, #{writer}, #{time})")
    public void saveNotification(Notification notification);

    @Insert("insert into assignment values(#{title}, #{content}, #{writer}, #{time})")
    public void saveAssignment(Assignment assignment);

    @Insert("insert into courseInformation values(#{title}, #{content}, #{writer}, #{time})")
    public void saveCourseInformation(CourseInformation courseInformation);

    @Insert("insert into homework values(#{title}, #{content}, #{fileName}, #{writer}, #{time}, #{score})")
    public void saveHomework(Homework homework);

    @Delete("delete from news where title = #{title}")
    public void deleteNews(String title);

    @Delete("delete from ppt where title = #{title}")
    public void deletePPT(String title);

    @Delete("delete from notification where title = #{title}")
    public void deleteNotifications(String title);

    @Delete("delete from assignment where title = #{title}")
    public void deleteAssignment(String title);

    @Delete("delete from courseInformation where title = #{title}")
    public void deleteCourseInformation(String title);

    @Update("update homework set score = #{score} where title = #{title}")
    public void updateScore(Homework homework);
}
