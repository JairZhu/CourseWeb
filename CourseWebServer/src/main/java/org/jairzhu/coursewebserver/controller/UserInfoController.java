package org.jairzhu.coursewebserver.controller;


import org.jairzhu.coursewebserver.domain.Comment;
import org.jairzhu.coursewebserver.domain.User;
import org.jairzhu.coursewebserver.mapper.CourseWebMapper;
import org.jairzhu.coursewebserver.redisUtils.RedisHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableAutoConfiguration
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(CourseWebController.class);

    @Autowired
    private RedisHandler courseWebMapper;

    @PostMapping(value = "updatePwd")
    @ResponseBody
    public boolean updatePwd(@RequestBody User user) {
        logger.info(user.toString());
        try {
            courseWebMapper.updatePwd(user);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }






    @PostMapping(value = "uploadHeadPhoto/{userName}")
    @ResponseBody
    public boolean uploadHeadPhoto(@PathVariable(name = "userName") String userName,@RequestParam(value = "file") MultipartFile file,HttpServletRequest req) {

        if (!file.isEmpty()) {
            String fileName = userName+".jpg";
            String filePath = System.getProperty("user.dir") + "/src/main/resources/static/headPhoto";
            System.out.println(filePath);
            try {
                String staticPath=filePath+"/"+userName+".jpg";
                filePath=ResourceUtils.getURL("classpath:").getPath()+"static/headPhoto";
                file.transferTo(new File(filePath, fileName));
                String servePath=filePath+"/"+userName+".jpg";
                InputStream input = null;
                OutputStream output = null;
                try {
                    input = new FileInputStream(servePath);
                    output = new FileOutputStream(staticPath);
                    byte[] buf = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buf)) > 0) {
                        output.write(buf, 0, bytesRead);
                    }
                } finally {
                    input.close();
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file is null");
            return false;
        }
        return true;
    }


    @RequestMapping("/getHeadPhoto")
    @ResponseBody
    public void getHeadPhoto() throws IOException {

    }



}

