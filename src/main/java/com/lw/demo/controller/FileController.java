package com.lw.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.lw.demo.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

/**
 * 用来测试上传文件的类
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${upload.root}")
    private String uploadRoot;//上传文件的根路径

    @Value("${server.port}")
    private String port;

    /**
     * 上传图片到本地
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        String filePath=uploadRoot+ DateUtil.formatDate(new Date());
        File file1=new File(filePath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        fileName= UUID.randomUUID().toString().replace("-","")+"-"+fileName;
        String url="";
        try {
            file.transferTo(new File(filePath,fileName));
            InetAddress inetAddress=InetAddress.getLocalHost();
            String ip = inetAddress.getHostAddress();
            url="http://"+ip+":"+port+"/file/downLoad?fileName="+fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success(url);
    }

    /**
     * 下载文件 显示图片
     * @param fileName
     * @param response
     */
    @GetMapping("downLoad")
    public void downLoad(String fileName, HttpServletResponse response) throws Exception{
        String filePath=uploadRoot+DateUtil.formatDate(new Date())+"/"+fileName;
        File file1=new File(filePath);
        InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 清空response
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
        response.addHeader("Content-Length", "" + file1.length());
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }
}
