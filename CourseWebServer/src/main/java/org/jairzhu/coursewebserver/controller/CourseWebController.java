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
            logger.info(exception.toString());
            return false;
        }
    }
}
