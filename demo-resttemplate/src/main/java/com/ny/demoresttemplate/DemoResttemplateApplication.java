package com.ny.demoresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class DemoResttemplateApplication {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate(new HttpsClientRequestFactory());
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoResttemplateApplication.class, args);
        System.out.println("nihao ");
        System.out.println("nihao ");
        System.out.println("nihao ");
        System.out.println("nihao ");
        System.out.println("nihao ");
    }


    @RequestMapping("/testURI")
    public String  testUrl(){
      //  String forObject = restTemplate().getForObject("http://localhost:8081/testURL?name=http://localhost:8081/?name=asdasd&age=11", String.class);
        String forObject = restTemplate().postForObject("http://localhost:8081/testURL?name=http://localhost:8081/?name=asdasd&age=11",null, String.class);
        return forObject;
    }

    @RequestMapping("/testuploads")
    public String  testuploads(){

        String url = "http://localhost:8081/uploads";
        String filePath = "C:\\Users\\nieye\\Pictures\\MI5000.jpg";
        String filePath1 = "C:\\Users\\nieye\\Pictures\\df3decf7-78f5-49c3-9d01-144edc4d0fd0.jpg";

        RestTemplate rest = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("files", resource);
        param.add("descriptions", "testett");
        FileSystemResource resource1 = new FileSystemResource(new File(filePath1));

        param.add("files", resource1);
        param.add("descriptions", "testett1111");


        ResponseEntity<String> srr = rest.postForEntity(url, param,String.class);
        System.out.println(srr);
        return srr.getBody();
    }











}
