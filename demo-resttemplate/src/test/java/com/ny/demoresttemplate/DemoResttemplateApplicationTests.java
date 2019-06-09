package com.ny.demoresttemplate;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoResttemplateApplicationTests {


    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void contextLoads() {
        String url="http://k.zol-img.com.cn/sjbbs/7692/a7691515_s.jpg";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }

}
