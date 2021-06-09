package org.jairzhu.coursewebserver.controller;


<<<<<<< HEAD
import org.jairzhu.coursewebserver.domain.Comment;
=======
>>>>>>> 5cea3e55eabfe5a83ddda927b02f31887e850fb3
import org.jairzhu.coursewebserver.domain.NonStaticResourceHttpRequestHandler;
import org.jairzhu.coursewebserver.domain.User;
import org.jairzhu.coursewebserver.mapper.CourseWebMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
<<<<<<< HEAD

=======
>>>>>>> 5cea3e55eabfe5a83ddda927b02f31887e850fb3

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableAutoConfiguration

public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(CourseWebController.class);
<<<<<<< HEAD
    @Autowired
    private final NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;
=======
    private final NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    public UserInfoController(NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler, CourseWebMapper courseWebMapper) {
        this.nonStaticResourceHttpRequestHandler = nonStaticResourceHttpRequestHandler;
        this.courseWebMapper = courseWebMapper;
    }
>>>>>>> 5cea3e55eabfe5a83ddda927b02f31887e850fb3

    @Autowired
    private CourseWebMapper courseWebMapper;

    public UserInfoController(NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler, CourseWebMapper courseWebMapper) {
        this.nonStaticResourceHttpRequestHandler = nonStaticResourceHttpRequestHandler;
        this.courseWebMapper = courseWebMapper;
    }

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
            String fileName = userName;


            String staticPath = System.getProperty("user.dir") + "/src/main/resources/static/headPhoto";
            System.out.println(staticPath);

            File dir =new File(staticPath);
            if  (!dir.exists()  && !dir.isDirectory())
            {
                dir.mkdirs();
            }

            try {
<<<<<<< HEAD
//                filePath=this.getClass().getResource("/static/headPhoto").getPath();
//                System.out.println(filePath);
                file.transferTo(new File(staticPath, fileName));
//                String servePath=filePath+"/"+userName+".jpg";
//                InputStream input = null;
//                OutputStream output = null;
//                try {
//                    input = new FileInputStream(servePath);
//                    output = new FileOutputStream(staticPath);
//                    byte[] buf = new byte[1024];
//                    int bytesRead;
//                    while ((bytesRead = input.read(buf)) > 0) {
//                        output.write(buf, 0, bytesRead);
//                    }
//                } finally {
//                    input.close();
//                    output.close();
//                }
=======
                file.transferTo(new File(staticPath, fileName));
>>>>>>> 5cea3e55eabfe5a83ddda927b02f31887e850fb3
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file is null");
            return false;
        }
        return true;
    }



    @RequestMapping(value = "photoPlay")
    @ResponseBody
    public void videoPreview(@RequestParam(name = "userName") String userName, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = ResourceUtils.getURL("src/main/resources/static/headPhoto").getPath().substring(1);
<<<<<<< HEAD
        String realPath = path + userName;
=======
        //windows下目录
        //String realPath = path + userName;
        //linux下目录
        String realPath = "/" + path + userName;
>>>>>>> 5cea3e55eabfe5a83ddda927b02f31887e850fb3

        Path filePath = Paths.get(realPath);

        if (Files.exists(filePath)) {
            String contentType = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(contentType)) {
                response.setContentType(contentType);
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }


}
