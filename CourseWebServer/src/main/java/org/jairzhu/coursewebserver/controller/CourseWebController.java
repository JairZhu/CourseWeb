package org.jairzhu.coursewebserver.controller;

import org.jairzhu.coursewebserver.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableAutoConfiguration
public class CourseWebController {

    private final Logger logger = LoggerFactory.getLogger(CourseWebController.class);

    @RequestMapping(value = "getNews")
    @ResponseBody
    public List<News> findAllNews() {
        return Common.courseWebMapper.findAllNews();
    }

    @RequestMapping(value = "getNotifications")
    @ResponseBody
    public List<Notification> findAllNotifications() {
        return Common.courseWebMapper.findAllNotifications();
    }

    @RequestMapping(value = "getPPTs")
    @ResponseBody
    public List<PPT> findAllPPTs() {
        return Common.courseWebMapper.findAllPPTs();
    }

    @RequestMapping(value = "getAssignments")
    @ResponseBody
    public List<Assignment> findAllAssignment() {
        return Common.courseWebMapper.findAllAssignment();
    }

    @PostMapping(value = "postUser")
    @ResponseBody
    public boolean userLogin(@RequestBody User user) {
        List<User> userList = Common.courseWebMapper.findAllUsers();
        return userList.contains(user);
    }

    @PostMapping(value = "saveUser")
    @ResponseBody
    public boolean saveUser(@RequestBody User user) {
        try {
            Common.courseWebMapper.saveUser(user);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "savePPT")
    @ResponseBody
    public boolean savePPT(@RequestBody PPT ppt) {
        try {
            Common.courseWebMapper.savePPT(ppt);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveNews")
    @ResponseBody
    public boolean saveNews(@RequestBody News news) {
        try {
            Common.courseWebMapper.saveNews(news);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveNotification")
    @ResponseBody
    public boolean saveNotification(@RequestBody Notification notification) {
        try {
            Common.courseWebMapper.saveNotification(notification);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveAssignment")
    @ResponseBody
    public boolean saveAssignment(@RequestBody Assignment assignment) {
        try {
            Common.courseWebMapper.saveAssignment(assignment);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveCourseInformation")
    @ResponseBody
    public boolean saveCourseInformation(@RequestBody CourseInformation courseInformation) {
        try {
            Common.courseWebMapper.saveCourseInformation(courseInformation);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "deleteNews")
    @ResponseBody
    public boolean deleteNews(@RequestBody List<String> titles) {
        for (String title: titles)
            Common.courseWebMapper.deleteNews(title);
        return true;
    }

    @PostMapping(value = "deletePPT")
    @ResponseBody
    public boolean deletePPT(@RequestBody List<String> titles) {
        for (String title: titles)
            Common.courseWebMapper.deletePPT(title);
        return true;
    }

    @PostMapping(value = "deleteNotification")
    @ResponseBody
    public boolean deleteNotification(@RequestBody List<String> titles) {
        for (String title: titles)
            Common.courseWebMapper.deleteNotifications(title);
        return true;
    }

    @PostMapping(value = "deleteAssignment")
    @ResponseBody
    public boolean deleteAssignment(@RequestBody List<String> titles) {
        for (String title: titles)
            Common.courseWebMapper.deleteAssignment(title);
        return true;
    }

    @PostMapping(value = "deleteCourseInformation")
    @ResponseBody
    public boolean deleteCourseInformation(@RequestBody String title) {
        Common.courseWebMapper.deleteCourseInformation(title);
        return true;
    }
}
