package org.jairzhu.coursewebserver;

import org.jairzhu.coursewebserver.controller.CourseWebController;
import org.jairzhu.coursewebserver.domain.Common;
import org.jairzhu.coursewebserver.mapper.CourseWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoursewebserverApplication implements CommandLineRunner {

    @Autowired
    private CourseWebMapper courseWebMapper;

    @Override
    public void run(String... args) throws Exception {
        Common.courseWebMapper = courseWebMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoursewebserverApplication.class, args);
    }

}
