package com.lw.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("com.lw.demo.dao")
@Slf4j
public class SpringDemoApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringDemoApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String port = environment.getProperty("server.port");
        String address = Inet4Address.getLocalHost().getHostAddress();
        String successMessage="启动成功：地址："+address+"，端口号："+port+"\r\n"+
                "swagger地址："+"http://"+address+":"+port+"/doc.html";
        System.out.println(successMessage);
        //第一次修改 提交到本地和远程

        //第二次修改

        //dev分支的代码

        //我开启了分支并提交了代码到分支上 然后我要把分支代码合并到主干
    }
}
