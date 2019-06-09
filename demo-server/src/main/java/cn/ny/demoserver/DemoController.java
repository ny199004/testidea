package cn.ny.demoserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author nieye
 * @create 2019-06-03 21:16
 */
@RestController
public class DemoController {


    @RequestMapping("/test")
    public String testMvc(HttpServletRequest request) throws IOException, ServletException {
        Collection<Part> parts = request.getParts();
        Iterator<Part> iterator = parts.iterator();
        while (iterator.hasNext()){
            Part part=iterator.next();

            System.out.println(part.getName()+","+part.getContentType()+","+part.getSize());
        }
        return "hrello";
    }

    @RequestMapping("/test1")
    public String testMvc1(HttpServletRequest request) throws IOException, ServletException {
        //System.out.println( request.getParameter("name"));
        String[] names = request.getParameterValues("name");
        System.out.println(Arrays.toString(names));
        return "hrello";
    }

    @RequestMapping("/test2")
    public String testMvc2(HttpServletRequest request) throws IOException, ServletException {
        //System.out.println( request.getParameter("name"));
       // String[] names = request.getParameterValues("name");
      //  System.out.println(Arrays.toString(names));
        BufferedReader reader = request.getReader();
        StringBuffer sf = new StringBuffer();
        String temp;
     //   ServletInputStream inputStream = request.getInputStream();
        while ((temp=reader.readLine())!=null){
            sf.append(temp);
        }
        return sf.toString();
    }


    @RequestMapping("/testURL")
    public String test1(String name, String age) {
        return "name=" + name + ",age=" + age;
    }


    @RequestMapping("/upload")
    public String test2(String[] names, Integer[] ages, MultipartFile[] files) throws IOException {
        // if(lists!=null&&lists.size()>=1){

        //}
        for (MultipartFile file : files) {
            file.transferTo(new File("E:/" + file.getOriginalFilename()));
        }
        return "上传成功";
    }


    @RequestMapping("/uploads")
    public String test3(@RequestParam("descriptions") String[] descriptions,
                        @RequestParam("files") MultipartFile[] files) throws IOException {
        // List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        // if(lists!=null&&lists.size()>=1){
        System.out.println("nigao");
        //}
        System.out.println(files.length);
        for (MultipartFile file : files) {
            file.transferTo(new File("E:/test_upload/" + file.getOriginalFilename()));
        }
        return "上传成功";
    }

}
