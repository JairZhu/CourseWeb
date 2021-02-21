package org.jairzhu.coursewebserver.controller;

import org.jairzhu.coursewebserver.domain.*;
import org.jairzhu.coursewebserver.mapper.CourseWebMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableAutoConfiguration
public class CourseWebController {

    private final Logger logger = LoggerFactory.getLogger(CourseWebController.class);

    @Autowired
    private CourseWebMapper courseWebMapper;

    @RequestMapping(value = "getNews")
    @ResponseBody
    public List<News> findAllNews() {
        return courseWebMapper.findAllNews();
    }

    @RequestMapping(value = "getNotifications")
    @ResponseBody
    public List<Notification> findAllNotifications() {
        return courseWebMapper.findAllNotifications();
    }

    @RequestMapping(value = "getPPTs")
    @ResponseBody
    public List<PPT> findAllPPTs() {
        return courseWebMapper.findAllPPTs();
    }

    @RequestMapping(value = "getAssignments")
    @ResponseBody
    public List<Assignment> findAllAssignment() {
        return courseWebMapper.findAllAssignment();
    }

    @RequestMapping(value = "getHomeworks")
    @ResponseBody
    public List<Homework> findAllHomeworks() { return courseWebMapper.findAllHomeworks();}

    @RequestMapping(value = "getCourseInformation")
    @ResponseBody
    public List<CourseInformation> findCourseInformation() { return courseWebMapper.findCourseInformation();}

    @RequestMapping(value = "getCommentTitles")
    @ResponseBody
    public List<String> findCommentTitles() { return courseWebMapper.findAllCommentTitle(); }

    @RequestMapping(value = "getCommentByTitle")
    @ResponseBody
    public List<Comment> findCommentByTitle(@RequestParam String title) {
        logger.info(title);
        return courseWebMapper.findAllCommentByTitle(title);
    }

    @PostMapping(value = "postUser")
    @ResponseBody
    public boolean userLogin(@RequestBody User user) {
        logger.info(user.toString());
        List<User> userList = courseWebMapper.findAllUsers();
        return userList.contains(user);
    }

    @PostMapping(value = "saveComment")
    @ResponseBody
    public boolean saveComment(@RequestBody Comment comment) {
        logger.info(comment.toString());
        try {
            courseWebMapper.saveComment(comment);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveUser")
    @ResponseBody
    public boolean saveUser(@RequestBody User user) {
        logger.info(user.toString());
        try {
            courseWebMapper.saveUser(user);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "savePPT")
    @ResponseBody
    public boolean savePPT(@RequestBody PPT ppt) {
        logger.info(ppt.toString());
        try {
            courseWebMapper.savePPT(ppt);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveNews")
    @ResponseBody
    public boolean saveNews(@RequestBody News news) {
        logger.info(news.toString());
        try {
            courseWebMapper.saveNews(news);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveNotification")
    @ResponseBody
    public boolean saveNotification(@RequestBody Notification notification) {
        logger.info(notification.toString());
        try {
            courseWebMapper.saveNotification(notification);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveAssignment")
    @ResponseBody
    public boolean saveAssignment(@RequestBody Assignment assignment) {
        logger.info(assignment.toString());
        try {
            courseWebMapper.saveAssignment(assignment);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveCourseInformation")
    @ResponseBody
    public boolean saveCourseInformation(@RequestBody CourseInformation courseInformation) {
        logger.info(courseInformation.toString());
        try {
            courseWebMapper.saveCourseInformation(courseInformation);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "saveHomework")
    @ResponseBody
    public boolean saveHomework(@RequestBody Homework homework) {
        logger.info(homework.toString());
        try {
            courseWebMapper.saveHomework(homework);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "deleteCommentByTitle")
    @ResponseBody
    public boolean deleteCommentByTitle(@RequestBody List<String> titles) {
        logger.info(titles.toString());
        courseWebMapper.deleteCommentByTitle(titles.get(0));
        return true;
    }

    @PostMapping(value = "deleteComment")
    @ResponseBody
    public boolean deleteComment(@RequestBody Comment comment) {
        logger.info(comment.toString());
        courseWebMapper.deleteComment(comment);
        return true;
    }

    @PostMapping(value = "deleteNews")
    @ResponseBody
    public boolean deleteNews(@RequestBody List<String> titles) {
        logger.info(titles.toString());
        for (String title: titles)
            courseWebMapper.deleteNews(title);
        return true;
    }

    @PostMapping(value = "deletePPT")
    @ResponseBody
    public boolean deletePPT(@RequestBody List<String> titles) {
        logger.info(titles.toString());
        for (String title: titles)
            courseWebMapper.deletePPT(title);
        return true;
    }

    @PostMapping(value = "deleteNotification")
    @ResponseBody
    public boolean deleteNotification(@RequestBody List<String> titles) {
        logger.info(titles.toString());
        for (String title: titles)
            courseWebMapper.deleteNotifications(title);
        return true;
    }

    @PostMapping(value = "deleteAssignment")
    @ResponseBody
    public boolean deleteAssignment(@RequestBody List<String> titles) {
        logger.info(titles.toString());
        for (String title: titles)
            courseWebMapper.deleteAssignment(title);
        return true;
    }

    @PostMapping(value = "deleteCourseInformation")
    @ResponseBody
    public boolean deleteCourseInformation(@RequestBody List<String> title) {
        logger.info(title.toString());
        courseWebMapper.deleteCourseInformation(title.get(0));
        return true;
    }

    @PostMapping(value = "updateScore")
    @ResponseBody
    public boolean updateScore(@RequestBody Homework homework) {
        logger.info(homework.toString());
        courseWebMapper.updateScore(homework);
        return true;
    }

    @PostMapping(value = "uploadHomeworkFile")
    @ResponseBody
    public boolean uploadHomeworkFile(@RequestParam("file") MultipartFile file) {
        logger.info(System.getProperty("user.dir"));
        String originName = file.getOriginalFilename();
        try {
            file.transferTo(new File(System.getProperty("user.dir")+"/src/main/resources/static/homework", originName));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "uploadPPTFile")
    @ResponseBody
    public boolean uploadPPTFile(@RequestParam("file") MultipartFile file) {
        logger.info(System.getProperty("user.dir"));
        String originName = file.getOriginalFilename();
        try {
            file.transferTo(new File(System.getProperty("user.dir")+"/src/main/resources/static/ppt", originName));
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "downloadFile/{type}/{fileName}")
    @ResponseBody
    public ResponseEntity<Object> downloadFile(@PathVariable(name = "fileName") String fileName, @PathVariable(name = "type") String type) throws FileNotFoundException {
        logger.info("download type: " + type + "  file: " + fileName);
        String path = "src/main/resources/static/" + type;
        File file = new File(path, fileName);
        InputStreamResource resource = new InputStreamResource ( new FileInputStream( file ) );

        byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
        fileName = new String(fileNameBytes, 0, fileNameBytes.length, StandardCharsets.ISO_8859_1);

        HttpHeaders headers = new HttpHeaders();
        headers.add ( "Content-Disposition",String.format("attachment;filename=\"%s",fileName));
        headers.add ( "Cache-Control","no-cache,no-store,must-revalidate" );
        headers.add ( "Pragma","no-cache" );
        headers.add ( "Expires","0" );

        return ResponseEntity.ok()
                .headers ( headers )
                .contentLength ( file.length ())
                .contentType(MediaType.parseMediaType ( "application/txt" ))
                .body(resource);
    }
}
